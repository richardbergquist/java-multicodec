# Java Multicodec

## About Multiformats
Multicodec is part of the Multiformats collection of protocols.
Multiformats is a collection of protocols which aim to future-proof systems, today. They do this mainly by allowing
data to be self-describable.
See:
- https://github.com/multiformats/multiformats

## About Multicodec
The Multicodec is an agreed way for encoding bytes with a prefix that specifies the type of encoding.
The format is therefore a portable and self describing way of expressing an encoding of bytes that does not assume
a specific context.
See:
- https://github.com/multiformats/multicodec

### Examples
For example, the multicodec specification is used in the specifications for Decentralised Identifiers (DIDs) in
regard to the DID Method 'key' specification.
Therefore, any work on `did:key` implementations needs to also solve for the use of multicodecs.
See:
 - https://w3c-ccg.github.io/did-method-key

### Why A Java Implementation?
It is noted that the [https://github.com/multiformats/multiformats](https://github.com/multiformats/multiformats)
lists technology implementations, however a java implementation is not available.
This library addresses that gap to provide an implementation of the multicodec specification in java.

### Dependencies
The code of a multicodec is encoded as unsigned varint as defined by
[multiformats/unsigned-varint](https://github.com/multiformats/unsigned-varint).
It is then used as a prefix to identify the data that follows. This represents some additional binary operations.

This project also solves for a java implementation of unsigned varints so may also be of use for implementors.

### Sample Usage
```
//Demonstrate the encode data as a ED25519 public key...
byte[] raw = getEd25519PublicKeyData();
byte[] multicodecEncoding = Multicodec.encode(Multicodec.Codec.ED25519_PUB, raw);

//Demonstrate decoding...
Multicodec.Codec decodedCodec = null;
byte[] decodedByteData = null;
String decodedByteDataHex = null;
Object[] output = new Object[0];
try {
    output = Multicodec.decode(multicodecEncoding);
} catch (AmbiguousCodecEncodingException exAmbiguousCodecEncoding) {
    System.err.println(exAmbiguousCodecEncoding.getMessage());
}
if (output.length == 3) {
    decodedCodec = (Multicodec.Codec) output[0];
    decodedByteData = (byte[]) output[1];
    decodedByteDataHex = (String) output[2];
}
```

## Known Problems

### Clash of Codecs - Decoding
There are two basic classes of the codecs, single bytes codes (e.g `cidv1`(0x01), `sha2_256`(0x12)) and multibyte codecs
(e.g. `upd`(0x0111), `p256_pub`(0x1200)).

The way that the codec codes are configured it is possible to encode to them, but there are situations where it is not
possible to decode.

#### Example 1:

 1. Consider the sample data as hex: `0xA1E9D3D8EC`
 2. When it is multicodec `cidv1` encoded we have : `0xA1E9D3D8EC` --(`cidv1`)--> `0x01A1E9D3D8EC`
 3. When it is multicodec `upd` encoded we have   : `0xA1E9D3D8EC` --(`upd`)----> `0x0111A1E9D3D8EC`
 4. Notice that both encoded strings for different encoding types start with `0x01`. 
 5. Therefore, when comes to decoding the `udp` value `0x0111A1E9D3D8EC` it is not possible to determine if the string is
    1. `cidv1` encoded with data: `0x11A1E9D3D8EC`
    2. `upd` encoded with data: `0xA1E9D3D8EC`

#### Example 2:

Another example also applies to `sha2_256` and `p256_pub` encoding.
 1. When it is multicodec `sha2_256` encoded we have : `0xA1E9D3D8EC` --(`sha2_256`)--> `0x12A1E9D3D8EC`
 2. When it is multicodec `p256_pub` encoded we have : `0xA1E9D3D8EC` --(`p256_pub`)--> `0x1200A1E9D3D8EC`
 4. Notice that both encoded strings for different encoding types start with `0x12`.
 5. Therefore, when comes to decoding the `p256_pub` value `0x1200A1E9D3D8EC` it is not possible to determine if the string is
    1. `sha2_256` encoded with data: `0x00A1E9D3D8EC`
    2. `p256_pub` encoded with data: `0x1200A1E9D3D8EC`

#### List of clashes
These clashes occur in a number of situations and are listed below.
<pre>
'Clash of codecs' spec problem: cannot decode between [UDP(0x0111)], and [CIDV1(0x01)] for sample data:[0111A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P2P_WEBRTC_STAR(0x0113)], and [CIDV1(0x01)] for sample data:[0113A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P2P_WEBRTC_DIRECT(0x0114)], and [CIDV1(0x01)] for sample data:[0114A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P2P_STARDUST(0x0115)], and [CIDV1(0x01)] for sample data:[0115A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [WEBRTC(0x0118)], and [CIDV1(0x01)] for sample data:[0118A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P2P_CIRCUIT(0x0122)], and [CIDV1(0x01)] for sample data:[0122A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [DAG_JSON(0x0129)], and [CIDV1(0x01)] for sample data:[0129A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [UDT(0x012D)], and [CIDV1(0x01)] for sample data:[012DA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [UTP(0x012E)], and [CIDV1(0x01)] for sample data:[012EA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [UNIX(0x0190)], and [CIDV1(0x01)] for sample data:[019001A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [THREAD(0x0196)], and [CIDV1(0x01)] for sample data:[019601A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P2P(0x01A5)], and [CIDV1(0x01)] for sample data:[01A501A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [IPFS(0x01A5)], and [CIDV1(0x01)] for sample data:[01A501A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [HTTPS(0x01BB)], and [CIDV1(0x01)] for sample data:[01BB01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [ONION(0x01BC)], and [CIDV1(0x01)] for sample data:[01BC01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [ONION3(0x01BD)], and [CIDV1(0x01)] for sample data:[01BD01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [GARLIC64(0x01BE)], and [CIDV1(0x01)] for sample data:[01BE01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [GARLIC32(0x01BF)], and [CIDV1(0x01)] for sample data:[01BF01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [TLS(0x01C0)], and [CIDV1(0x01)] for sample data:[01C001A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [NOISE(0x01C6)], and [CIDV1(0x01)] for sample data:[01C601A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [QUIC(0x01CC)], and [CIDV1(0x01)] for sample data:[01CC01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [WEBTRANSPORT(0x01D1)], and [CIDV1(0x01)] for sample data:[01D101A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [CERTHASH(0x01D2)], and [CIDV1(0x01)] for sample data:[01D201A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [WS(0x01DD)], and [CIDV1(0x01)] for sample data:[01DD01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [WSS(0x01DE)], and [CIDV1(0x01)] for sample data:[01DE01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P2P_WEBSOCKET_STAR(0x01DF)], and [CIDV1(0x01)] for sample data:[01DF01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [HTTP(0x01E0)], and [CIDV1(0x01)] for sample data:[01E001A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [SWHID_1_SNP(0x01F0)], and [CIDV1(0x01)] for sample data:[01F001A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [JSON(0x0200)], and [CIDV2(0x02)] for sample data:[0200A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [MESSAGEPACK(0x0201)], and [CIDV2(0x02)] for sample data:[0201A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [CAR(0x0202)], and [CIDV2(0x02)] for sample data:[0202A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [LIBP2P_PEER_RECORD(0x0301)], and [CIDV3(0x03)] for sample data:[0301A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [LIBP2P_RELAY_RSVP(0x0302)], and [CIDV3(0x03)] for sample data:[0302A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [CAR_INDEX_SORTED(0x0400)], and [IP4(0x04)] for sample data:[0400A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [CAR_MULTIHASH_INDEX_SORTED(0x0401)], and [IP4(0x04)] for sample data:[0401A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [X11(0x1100)], and [SHA1(0x11)] for sample data:[1100A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P256_PUB(0x1200)], and [SHA2_256(0x12)] for sample data:[1200A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P384_PUB(0x1201)], and [SHA2_256(0x12)] for sample data:[1201A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [P521_PUB(0x1202)], and [SHA2_256(0x12)] for sample data:[1202A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [ED448_PUB(0x1203)], and [SHA2_256(0x12)] for sample data:[1203A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [X448_PUB(0x1204)], and [SHA2_256(0x12)] for sample data:[1204A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [RSA_PUB(0x1205)], and [SHA2_256(0x12)] for sample data:[1205A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [SM2_PUB(0x1206)], and [SHA2_256(0x12)] for sample data:[1206A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [ED25519_PRIV(0x1300)], and [SHA2_512(0x13)] for sample data:[1300A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [SECP256K1_PRIV(0x1301)], and [SHA2_512(0x13)] for sample data:[1301A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [X25519_PRIV(0x1302)], and [SHA2_512(0x13)] for sample data:[1302A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [KANGAROOTWELVE(0x1D01)], and [KECCAK_512(0x1D)] for sample data:[1D01A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_8(0xB201)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20101A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_16(0xB202)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20102A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_24(0xB203)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20103A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_32(0xB204)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20104A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_40(0xB205)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20105A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_48(0xB206)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20106A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_56(0xB207)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20107A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_64(0xB208)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20108A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_72(0xB209)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20109A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_80(0xB20A)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2010AA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_88(0xB20B)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2010BA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_96(0xB20C)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2010CA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_104(0xB20D)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2010DA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_112(0xB20E)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2010EA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_120(0xB20F)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2010FA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_128(0xB210)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20110A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_136(0xB211)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20111A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_144(0xB212)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20112A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_152(0xB213)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20113A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_160(0xB214)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20114A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_168(0xB215)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20115A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_176(0xB216)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20116A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_184(0xB217)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20117A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_192(0xB218)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20118A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_200(0xB219)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20119A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_208(0xB21A)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2011AA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_216(0xB21B)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2011BA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_224(0xB21C)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2011CA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_232(0xB21D)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2011DA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_240(0xB21E)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2011EA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_248(0xB21F)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2011FA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_256(0xB220)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20120A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_264(0xB221)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20121A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_272(0xB222)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20122A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_280(0xB223)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20123A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_288(0xB224)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20124A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_296(0xB225)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20125A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_304(0xB226)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20126A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_312(0xB227)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20127A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_320(0xB228)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20128A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_328(0xB229)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20129A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_336(0xB22A)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2012AA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_344(0xB22B)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2012BA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_352(0xB22C)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2012CA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_360(0xB22D)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2012DA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_368(0xB22E)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2012EA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_376(0xB22F)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2012FA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_384(0xB230)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20130A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_392(0xB231)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20131A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_400(0xB232)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20132A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_408(0xB233)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20133A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_416(0xB234)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20134A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_424(0xB235)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20135A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_432(0xB236)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20136A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_440(0xB237)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20137A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_448(0xB238)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20138A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_456(0xB239)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20139A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_464(0xB23A)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2013AA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_472(0xB23B)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2013BA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_480(0xB23C)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2013CA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_488(0xB23D)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2013DA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_496(0xB23E)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2013EA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_504(0xB23F)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2013FA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2B_512(0xB240)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20140A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_8(0xB241)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20141A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_16(0xB242)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20142A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_24(0xB243)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20143A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_32(0xB244)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20144A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_40(0xB245)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20145A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_48(0xB246)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20146A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_56(0xB247)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20147A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_64(0xB248)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20148A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_72(0xB249)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20149A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_80(0xB24A)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2014AA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_88(0xB24B)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2014BA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_96(0xB24C)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2014CA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_104(0xB24D)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2014DA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_112(0xB24E)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2014EA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_120(0xB24F)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B2014FA1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_128(0xB250)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20150A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_136(0xB251)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20151A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_144(0xB252)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20152A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_152(0xB253)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20153A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_160(0xB254)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20154A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_168(0xB255)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20155A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_176(0xB256)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20156A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_184(0xB257)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20157A1E9D3D8EC] because codes start with the same values.
'Clash of codecs' spec problem: cannot decode between [BLAKE2S_192(0xB258)], and [BITCOIN_WITNESS_COMMITMENT(0xB2)] for sample data:[B20158A1E9D3D8EC] because codes start with the same values.

</pre>


#### Current Workarounds
The `Multicodec.decode()` method makes the assumption that the decoding only supports single byte codec codes, to prevent the "clash of codecs" issue from presenting itself.
This means that while `Multicodec.encode()` method can encode for any codec code, the `Multicodec.decode()` does not support decoding of multibyte codec codes. 

If `Multicodec.decode()` is used to decode a multibyte codec code then `AmbiguousCodecEncodingException` is thrown. 

#### Possible Solutions
#### Solution A : Use of a reserved character delimiter
The bytes used in the codec prefix need to be unambigious. Pick a used reserved byte (e.g. `0x00`) and use as a delimiter between the codec code bytes and the data

##### Examples

| name     | code   | delimiter | sample data  | example encoding   | decoding [codec] [data]           |
|----------|--------|-----------|--------------|--------------------|-----------------------------------|
| `cidv1`    | `0x01`   | `0x00`      | `0xA1E9D3D8EC` | `0x0100A1E9D3D8EC`   | `0x` `[0100]`   `[A1E9D3D8EC]` -> `cidv1` |
| `upd`      | `0x0111` | `0x00`      | `0xA1E9D3D8EC` | `0x011100A1E9D3D8EC` | `0x` `[011100]` `[A1E9D3D8EC]` -> `udp`   |


##### Pros
- Codec prefixes are explicit and unambiguous
- Common simple rule applied across all codecs

##### Cons
- Breaking change for the in-use single byte codecs
- Relies on no codecs ending in the reserved byte (e.g. `0x00`), which is an implicit rule that is too easily broken for new codec additions.
- Any codec that ends in the reserved byte (e.g. `0x00`) must be reassigned to a value that does not. e.g. `p256_pub`(`0x1200`) must be reassigned.

##### Recommendation:
- Not recommended.
- This will break a number of existing implementations that assume single byte codec in order to optimise to a simple rule. 
- The optimisation is in favour of the newer multibyte codecs that are in a draft over single byte codecs that are in permanent state.

#### Solution B : Careful selection of codecs that avoids clashes
The bytes used in the codec prefix need to be unambigious. The multibyte codec values that are in draft need to be re-assigned so there is no possible clashes.

##### Pros
- Codec prefixes are explicit and unambiguous
- Non-breaking change for the in-use single byte codecs

##### Cons
- Any multibyte codec that clashes with a single byte codec must be reassigned to a value that does not clash. Large reassignment exercise of multibyte codecs
- Relies on an implicit subtle rule that is embedded into the codec selections. The rule will likely be broken for new codec additions that are unaware of the clashing issue.

##### Recommendation:
- Weakly viable, but not recommended. 
- Will result in a significant refactoring and bulk reassignment process for a significant proportion of the multibyte codecs.

#### Solution C : Use of a reserved character delimiter, but only for multibyte codecs
The bytes used in the codec prefix need to be unambiguous.
1. Pick an unused reserved byte (rb) (e.g. `0x00`) 
2. Create rule that allows single byte codecs, so long as they do not start with the reserved byte (`0x00`).
3. If a multiple byte codec is adopted then it must start and end with the reserved byte (`0x00`).

##### Examples

| name       | code     | reserved byte | sample data    | example encoding       | decoding: [rb?][codec][rb?] [data]                       |
|------------|----------|---------------|----------------|------------------------|----------------------------------------------------------|
| `cidv1`    | `0x01`   | n/a           | `0xA1E9D3D8EC` | `0x01A1E9D3D8EC`       | `0x` `[01]` `[A1E9D3D8EC]` -> `cidv1`                    |
| `sha2_256` | `0x12`   | n/a           | `0xA1E9D3D8EC` | `0x12A1E9D3D8EC`       | `0x` `[12]` `[A1E9D3D8EC]` -> `sha2_256`                 |
| `upd`      | `0x0111` | `0x00`        | `0xA1E9D3D8EC` | `0x00011100A1E9D3D8EC` | `0x` `[00]` `[0111]` `[00]` `[A1E9D3D8EC]` -> `udp`      |
| `p256_pub` | `0x1200` | `0x00`        | `0xA1E9D3D8EC` | `0x00120000A1E9D3D8EC` | `0x` `[00]` `[1200]` `[00]` `[A1E9D3D8EC]` -> `p256_pub` |


##### Pros
- Codec prefixes are explicit and unambiguous.
- Non-breaking change for the in-use single byte codecs.
- Does not rely on clever implicit rules to stagger codec selections that will be easily broken.
- Does not need a large reassignment exercise of the multibyte codecs.
- The impact is limited only to multibyte codecs, which are mostly in draft status.

##### Cons
- Any existing multibyte codecs implementations must adopt the rule.

##### Recommendation:
- Recommended as most viable.
- Does not break most permanent implementations. 
- Ring fences change to the more problematic multibyte codecs that are in draft.

