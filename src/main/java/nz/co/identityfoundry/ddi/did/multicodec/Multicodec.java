package nz.co.identityfoundry.ddi.did.multicodec;


import nz.co.identityfoundry.ddi.did.util.HexUtils;
import nz.co.identityfoundry.ddi.did.util.VarInt;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Multicodec is part of the Multiformats collection of protocols.</p>
 * <br/>
 * <p>Multiformats is a collection of protocols which aim to future-proof systems, today. They do this mainly by allowing
 * data to be self-describable.</p>
 * <p>See: <a href="https://github.com/multiformats/multiformats">https://github.com/multiformats/multiformats</a></p>
 * <p>The Multicodec is an agreed way for encoding bytes with a prefix that specifies the type of encoding.
 * The format is therefore a portable and self describing way of expressing an encoding of bytes that does not assume
 * a specific context. </p>
 * <p>See: <a href="https://github.com/multiformats/multicodec">https://github.com/multiformats/multicodec</a></p>
 * <p>For example, the multicodec specification is used in the specifications for Decentralised Identifiers (DIDs) in
 * regard to the DID Method 'key' specification.
 * Therefore, any work on `did:key` implementations needs to also solve for the use of multicodecs.</p>
 * <p>See: <a href="https://w3c-ccg.github.io/did-method-key">https://w3c-ccg.github.io/did-method-key</a></p>
 * <br/>
 *
 */
public class Multicodec {

    /**
     * Refer to: <a href="https://github.com/multiformats/multicodec/blob/master/table.csv">https://github.com/multiformats/multicodec/blob/master/table.csv</a>
     */
    public enum Codec {
        IDENTITY ("0x00"),
        CIDV1 ("0x01"),
        CIDV2 ("0x02"),
        CIDV3 ("0x03"),
        IP4 ("0x04"),
        TCP ("0x06"),
        SHA1 ("0x11"),
        SHA2_256 ("0x12"),
        SHA2_512 ("0x13"),
        SHA3_512 ("0x14"),
        SHA3_384 ("0x15"),
        SHA3_256 ("0x16"),
        SHA3_224 ("0x17"),
        SHAKE_128 ("0x18"),
        SHAKE_256 ("0x19"),
        KECCAK_224 ("0x1A"),
        KECCAK_256 ("0x1B"),
        KECCAK_384 ("0x1C"),
        KECCAK_512 ("0x1D"),
        BLAKE3 ("0x1E"),
        SHA2_384 ("0x20"),
        DCCP ("0x21"),
        MURMUR3_X64_64 ("0x22"),
        MURMUR3_32 ("0x23"),
        IP6 ("0x29"),
        IP6ZONE ("0x2A"),
        PATH ("0x2F"),
        MULTICODEC ("0x30"),
        MULTIHASH ("0x31"),
        MULTIADDR ("0x32"),
        MULTIBASE ("0x33"),
        DNS ("0x35"),
        DNS4 ("0x36"),
        DNS6 ("0x37"),
        DNSADDR ("0x38"),
        PROTOBUF ("0x50"),
        CBOR ("0x51"),
        RAW ("0x55"),
        DBL_SHA2_256 ("0x56"),
        RLP ("0x60"),
        BENCODE ("0x63"),
        DAG_PB ("0x70"),
        DAG_CBOR ("0x71"),
        LIBP2P_KEY ("0x72"),
        GIT_RAW ("0x78"),
        TORRENT_INFO ("0x7B"),
        TORRENT_FILE ("0x7C"),
        LEOFCOIN_BLOCK ("0x81"),
        LEOFCOIN_TX ("0x82"),
        LEOFCOIN_PR ("0x83"),
        SCTP ("0x84"),
        DAG_JOSE ("0x85"),
        DAG_COSE ("0x86"),
        ETH_BLOCK ("0x90"),
        ETH_BLOCK_LIST ("0x91"),
        ETH_TX_TRIE ("0x92"),
        ETH_TX ("0x93"),
        ETH_TX_RECEIPT_TRIE ("0x94"),
        ETH_TX_RECEIPT ("0x95"),
        ETH_STATE_TRIE ("0x96"),
        ETH_ACCOUNT_SNAPSHOT ("0x97"),
        ETH_STORAGE_TRIE ("0x98"),
        ETH_RECEIPT_LOG_TRIE ("0x99"),
        ETH_RECIEPT_LOG ("0x9A"),
        AES_128 ("0xA0"),
        AES_192 ("0xA1"),
        AES_256 ("0xA2"),
        CHACHA_128 ("0xA3"),
        CHACHA_256 ("0xA4"),
        BITCOIN_BLOCK ("0xB0"),
        BITCOIN_TX ("0xB1"),
        BITCOIN_WITNESS_COMMITMENT ("0xB2"),
        ZCASH_BLOCK ("0xC0"),
        ZCASH_TX ("0xC1"),
        CAIP_50 ("0xCA"),
        STREAMID ("0xCE"),
        STELLAR_BLOCK ("0xD0"),
        STELLAR_TX ("0xD1"),
        MD4 ("0xD4"),
        MD5 ("0xD5"),
        DECRED_BLOCK ("0xE0"),
        DECRED_TX ("0xE1"),
        IPLD_NS ("0xE2"),
        IPFS_NS ("0xE3"),
        SWARM_NS ("0xE4"),
        IPNS_NS ("0xE5"),
        ZERONET ("0xE6"),
        SECP256K1_PUB ("0xE7"),
        DNSLINK ("0xE8"),
        BLS12_381_G1_PUB ("0xEA"),
        BLS12_381_G2_PUB ("0xEB"),
        X25519_PUB ("0xEC"),
        ED25519_PUB ("0xED"),
        BLS12_381_G1G2_PUB ("0xEE"),
        DASH_BLOCK ("0xF0"),
        DASH_TX ("0xF1"),
        SWARM_MANIFEST ("0xFA"),
        SWARM_FEED ("0xFB"),
        UDP ("0x0111"),
        P2P_WEBRTC_STAR ("0x0113"),
        P2P_WEBRTC_DIRECT ("0x0114"),
        P2P_STARDUST ("0x0115"),
        WEBRTC ("0x0118"),
        P2P_CIRCUIT ("0x0122"),
        DAG_JSON ("0x0129"),
        UDT ("0x012D"),
        UTP ("0x012E"),
        UNIX ("0x0190"),
        THREAD ("0x0196"),
        P2P ("0x01A5"),
        IPFS ("0x01A5"),
        HTTPS ("0x01BB"),
        ONION ("0x01BC"),
        ONION3 ("0x01BD"),
        GARLIC64 ("0x01BE"),
        GARLIC32 ("0x01BF"),
        TLS ("0x01C0"),
        NOISE ("0x01C6"),
        QUIC ("0x01CC"),
        WEBTRANSPORT ("0x01D1"),
        CERTHASH ("0x01D2"),
        WS ("0x01DD"),
        WSS ("0x01DE"),
        P2P_WEBSOCKET_STAR ("0x01DF"),
        HTTP ("0x01E0"),
        SWHID_1_SNP ("0x01F0"),
        JSON ("0x0200"),
        MESSAGEPACK ("0x0201"),
        CAR ("0x0202"),
        LIBP2P_PEER_RECORD ("0x0301"),
        LIBP2P_RELAY_RSVP ("0x0302"),
        CAR_INDEX_SORTED ("0x0400"),
        CAR_MULTIHASH_INDEX_SORTED ("0x0401"),
        TRANSPORT_BITSWAP ("0x0900"),
        TRANSPORT_GRAPHSYNC_FILECOINV1 ("0x0910"),
        SHA2_256_TRUNC254_PADDED ("0x1012"),
        SHA2_224 ("0x1013"),
        SHA2_512_224 ("0x1014"),
        SHA2_512_256 ("0x1015"),
        MURMUR3_X64_128 ("0x1022"),
        RIPEMD_128 ("0x1052"),
        RIPEMD_160 ("0x1053"),
        RIPEMD_256 ("0x1054"),
        RIPEMD_320 ("0x1055"),
        X11 ("0x1100"),
        P256_PUB ("0x1200"),
        P384_PUB ("0x1201"),
        P521_PUB ("0x1202"),
        ED448_PUB ("0x1203"),
        X448_PUB ("0x1204"),
        RSA_PUB ("0x1205"),
        SM2_PUB ("0x1206"),
        ED25519_PRIV ("0x1300"),
        SECP256K1_PRIV ("0x1301"),
        X25519_PRIV ("0x1302"),
        KANGAROOTWELVE ("0x1D01"),
        SM3_256 ("0x534D"),
        BLAKE2B_8 ("0xB201"),
        BLAKE2B_16 ("0xB202"),
        BLAKE2B_24 ("0xB203"),
        BLAKE2B_32 ("0xB204"),
        BLAKE2B_40 ("0xB205"),
        BLAKE2B_48 ("0xB206"),
        BLAKE2B_56 ("0xB207"),
        BLAKE2B_64 ("0xB208"),
        BLAKE2B_72 ("0xB209"),
        BLAKE2B_80 ("0xB20A"),
        BLAKE2B_88 ("0xB20B"),
        BLAKE2B_96 ("0xB20C"),
        BLAKE2B_104 ("0xB20D"),
        BLAKE2B_112 ("0xB20E"),
        BLAKE2B_120 ("0xB20F"),
        BLAKE2B_128 ("0xB210"),
        BLAKE2B_136 ("0xB211"),
        BLAKE2B_144 ("0xB212"),
        BLAKE2B_152 ("0xB213"),
        BLAKE2B_160 ("0xB214"),
        BLAKE2B_168 ("0xB215"),
        BLAKE2B_176 ("0xB216"),
        BLAKE2B_184 ("0xB217"),
        BLAKE2B_192 ("0xB218"),
        BLAKE2B_200 ("0xB219"),
        BLAKE2B_208 ("0xB21A"),
        BLAKE2B_216 ("0xB21B"),
        BLAKE2B_224 ("0xB21C"),
        BLAKE2B_232 ("0xB21D"),
        BLAKE2B_240 ("0xB21E"),
        BLAKE2B_248 ("0xB21F"),
        BLAKE2B_256 ("0xB220"),
        BLAKE2B_264 ("0xB221"),
        BLAKE2B_272 ("0xB222"),
        BLAKE2B_280 ("0xB223"),
        BLAKE2B_288 ("0xB224"),
        BLAKE2B_296 ("0xB225"),
        BLAKE2B_304 ("0xB226"),
        BLAKE2B_312 ("0xB227"),
        BLAKE2B_320 ("0xB228"),
        BLAKE2B_328 ("0xB229"),
        BLAKE2B_336 ("0xB22A"),
        BLAKE2B_344 ("0xB22B"),
        BLAKE2B_352 ("0xB22C"),
        BLAKE2B_360 ("0xB22D"),
        BLAKE2B_368 ("0xB22E"),
        BLAKE2B_376 ("0xB22F"),
        BLAKE2B_384 ("0xB230"),
        BLAKE2B_392 ("0xB231"),
        BLAKE2B_400 ("0xB232"),
        BLAKE2B_408 ("0xB233"),
        BLAKE2B_416 ("0xB234"),
        BLAKE2B_424 ("0xB235"),
        BLAKE2B_432 ("0xB236"),
        BLAKE2B_440 ("0xB237"),
        BLAKE2B_448 ("0xB238"),
        BLAKE2B_456 ("0xB239"),
        BLAKE2B_464 ("0xB23A"),
        BLAKE2B_472 ("0xB23B"),
        BLAKE2B_480 ("0xB23C"),
        BLAKE2B_488 ("0xB23D"),
        BLAKE2B_496 ("0xB23E"),
        BLAKE2B_504 ("0xB23F"),
        BLAKE2B_512 ("0xB240"),
        BLAKE2S_8 ("0xB241"),
        BLAKE2S_16 ("0xB242"),
        BLAKE2S_24 ("0xB243"),
        BLAKE2S_32 ("0xB244"),
        BLAKE2S_40 ("0xB245"),
        BLAKE2S_48 ("0xB246"),
        BLAKE2S_56 ("0xB247"),
        BLAKE2S_64 ("0xB248"),
        BLAKE2S_72 ("0xB249"),
        BLAKE2S_80 ("0xB24A"),
        BLAKE2S_88 ("0xB24B"),
        BLAKE2S_96 ("0xB24C"),
        BLAKE2S_104 ("0xB24D"),
        BLAKE2S_112 ("0xB24E"),
        BLAKE2S_120 ("0xB24F"),
        BLAKE2S_128 ("0xB250"),
        BLAKE2S_136 ("0xB251"),
        BLAKE2S_144 ("0xB252"),
        BLAKE2S_152 ("0xB253"),
        BLAKE2S_160 ("0xB254"),
        BLAKE2S_168 ("0xB255"),
        BLAKE2S_176 ("0xB256"),
        BLAKE2S_184 ("0xB257"),
        BLAKE2S_192 ("0xB258"),
        BLAKE2S_200 ("0xB259"),
        BLAKE2S_208 ("0xB25A"),
        BLAKE2S_216 ("0xB25B"),
        BLAKE2S_224 ("0xB25C"),
        BLAKE2S_232 ("0xB25D"),
        BLAKE2S_240 ("0xB25E"),
        BLAKE2S_248 ("0xB25F"),
        BLAKE2S_256 ("0xB260"),
        SKEIN256_8 ("0xB301"),
        SKEIN256_16 ("0xB302"),
        SKEIN256_24 ("0xB303"),
        SKEIN256_32 ("0xB304"),
        SKEIN256_40 ("0xB305"),
        SKEIN256_48 ("0xB306"),
        SKEIN256_56 ("0xB307"),
        SKEIN256_64 ("0xB308"),
        SKEIN256_72 ("0xB309"),
        SKEIN256_80 ("0xB30A"),
        SKEIN256_88 ("0xB30B"),
        SKEIN256_96 ("0xB30C"),
        SKEIN256_104 ("0xB30D"),
        SKEIN256_112 ("0xB30E"),
        SKEIN256_120 ("0xB30F"),
        SKEIN256_128 ("0xB310"),
        SKEIN256_136 ("0xB311"),
        SKEIN256_144 ("0xB312"),
        SKEIN256_152 ("0xB313"),
        SKEIN256_160 ("0xB314"),
        SKEIN256_168 ("0xB315"),
        SKEIN256_176 ("0xB316"),
        SKEIN256_184 ("0xB317"),
        SKEIN256_192 ("0xB318"),
        SKEIN256_200 ("0xB319"),
        SKEIN256_208 ("0xB31A"),
        SKEIN256_216 ("0xB31B"),
        SKEIN256_224 ("0xB31C"),
        SKEIN256_232 ("0xB31D"),
        SKEIN256_240 ("0xB31E"),
        SKEIN256_248 ("0xB31F"),
        SKEIN256_256 ("0xB320"),
        SKEIN512_8 ("0xB321"),
        SKEIN512_16 ("0xB322"),
        SKEIN512_24 ("0xB323"),
        SKEIN512_32 ("0xB324"),
        SKEIN512_40 ("0xB325"),
        SKEIN512_48 ("0xB326"),
        SKEIN512_56 ("0xB327"),
        SKEIN512_64 ("0xB328"),
        SKEIN512_72 ("0xB329"),
        SKEIN512_80 ("0xB32A"),
        SKEIN512_88 ("0xB32B"),
        SKEIN512_96 ("0xB32C"),
        SKEIN512_104 ("0xB32D"),
        SKEIN512_112 ("0xB32E"),
        SKEIN512_120 ("0xB32F"),
        SKEIN512_128 ("0xB330"),
        SKEIN512_136 ("0xB331"),
        SKEIN512_144 ("0xB332"),
        SKEIN512_152 ("0xB333"),
        SKEIN512_160 ("0xB334"),
        SKEIN512_168 ("0xB335"),
        SKEIN512_176 ("0xB336"),
        SKEIN512_184 ("0xB337"),
        SKEIN512_192 ("0xB338"),
        SKEIN512_200 ("0xB339"),
        SKEIN512_208 ("0xB33A"),
        SKEIN512_216 ("0xB33B"),
        SKEIN512_224 ("0xB33C"),
        SKEIN512_232 ("0xB33D"),
        SKEIN512_240 ("0xB33E"),
        SKEIN512_248 ("0xB33F"),
        SKEIN512_256 ("0xB340"),
        SKEIN512_264 ("0xB341"),
        SKEIN512_272 ("0xB342"),
        SKEIN512_280 ("0xB343"),
        SKEIN512_288 ("0xB344"),
        SKEIN512_296 ("0xB345"),
        SKEIN512_304 ("0xB346"),
        SKEIN512_312 ("0xB347"),
        SKEIN512_320 ("0xB348"),
        SKEIN512_328 ("0xB349"),
        SKEIN512_336 ("0xB34A"),
        SKEIN512_344 ("0xB34B"),
        SKEIN512_352 ("0xB34C"),
        SKEIN512_360 ("0xB34D"),
        SKEIN512_368 ("0xB34E"),
        SKEIN512_376 ("0xB34F"),
        SKEIN512_384 ("0xB350"),
        SKEIN512_392 ("0xB351"),
        SKEIN512_400 ("0xB352"),
        SKEIN512_408 ("0xB353"),
        SKEIN512_416 ("0xB354"),
        SKEIN512_424 ("0xB355"),
        SKEIN512_432 ("0xB356"),
        SKEIN512_440 ("0xB357"),
        SKEIN512_448 ("0xB358"),
        SKEIN512_456 ("0xB359"),
        SKEIN512_464 ("0xB35A"),
        SKEIN512_472 ("0xB35B"),
        SKEIN512_480 ("0xB35C"),
        SKEIN512_488 ("0xB35D"),
        SKEIN512_496 ("0xB35E"),
        SKEIN512_504 ("0xB35F"),
        SKEIN512_512 ("0xB360"),
        SKEIN1024_8 ("0xB361"),
        SKEIN1024_16 ("0xB362"),
        SKEIN1024_24 ("0xB363"),
        SKEIN1024_32 ("0xB364"),
        SKEIN1024_40 ("0xB365"),
        SKEIN1024_48 ("0xB366"),
        SKEIN1024_56 ("0xB367"),
        SKEIN1024_64 ("0xB368"),
        SKEIN1024_72 ("0xB369"),
        SKEIN1024_80 ("0xB36A"),
        SKEIN1024_88 ("0xB36B"),
        SKEIN1024_96 ("0xB36C"),
        SKEIN1024_104 ("0xB36D"),
        SKEIN1024_112 ("0xB36E"),
        SKEIN1024_120 ("0xB36F"),
        SKEIN1024_128 ("0xB370"),
        SKEIN1024_136 ("0xB371"),
        SKEIN1024_144 ("0xB372"),
        SKEIN1024_152 ("0xB373"),
        SKEIN1024_160 ("0xB374"),
        SKEIN1024_168 ("0xB375"),
        SKEIN1024_176 ("0xB376"),
        SKEIN1024_184 ("0xB377"),
        SKEIN1024_192 ("0xB378"),
        SKEIN1024_200 ("0xB379"),
        SKEIN1024_208 ("0xB37A"),
        SKEIN1024_216 ("0xB37B"),
        SKEIN1024_224 ("0xB37C"),
        SKEIN1024_232 ("0xB37D"),
        SKEIN1024_240 ("0xB37E"),
        SKEIN1024_248 ("0xB37F"),
        SKEIN1024_256 ("0xB380"),
        SKEIN1024_264 ("0xB381"),
        SKEIN1024_272 ("0xB382"),
        SKEIN1024_280 ("0xB383"),
        SKEIN1024_288 ("0xB384"),
        SKEIN1024_296 ("0xB385"),
        SKEIN1024_304 ("0xB386"),
        SKEIN1024_312 ("0xB387"),
        SKEIN1024_320 ("0xB388"),
        SKEIN1024_328 ("0xB389"),
        SKEIN1024_336 ("0xB38A"),
        SKEIN1024_344 ("0xB38B"),
        SKEIN1024_352 ("0xB38C"),
        SKEIN1024_360 ("0xB38D"),
        SKEIN1024_368 ("0xB38E"),
        SKEIN1024_376 ("0xB38F"),
        SKEIN1024_384 ("0xB390"),
        SKEIN1024_392 ("0xB391"),
        SKEIN1024_400 ("0xB392"),
        SKEIN1024_408 ("0xB393"),
        SKEIN1024_416 ("0xB394"),
        SKEIN1024_424 ("0xB395"),
        SKEIN1024_432 ("0xB396"),
        SKEIN1024_440 ("0xB397"),
        SKEIN1024_448 ("0xB398"),
        SKEIN1024_456 ("0xB399"),
        SKEIN1024_464 ("0xB39A"),
        SKEIN1024_472 ("0xB39B"),
        SKEIN1024_480 ("0xB39C"),
        SKEIN1024_488 ("0xB39D"),
        SKEIN1024_496 ("0xB39E"),
        SKEIN1024_504 ("0xB39F"),
        SKEIN1024_512 ("0xB3A0"),
        SKEIN1024_520 ("0xB3A1"),
        SKEIN1024_528 ("0xB3A2"),
        SKEIN1024_536 ("0xB3A3"),
        SKEIN1024_544 ("0xB3A4"),
        SKEIN1024_552 ("0xB3A5"),
        SKEIN1024_560 ("0xB3A6"),
        SKEIN1024_568 ("0xB3A7"),
        SKEIN1024_576 ("0xB3A8"),
        SKEIN1024_584 ("0xB3A9"),
        SKEIN1024_592 ("0xB3AA"),
        SKEIN1024_600 ("0xB3AB"),
        SKEIN1024_608 ("0xB3AC"),
        SKEIN1024_616 ("0xB3AD"),
        SKEIN1024_624 ("0xB3AE"),
        SKEIN1024_632 ("0xB3AF"),
        SKEIN1024_640 ("0xB3B0"),
        SKEIN1024_648 ("0xB3B1"),
        SKEIN1024_656 ("0xB3B2"),
        SKEIN1024_664 ("0xB3B3"),
        SKEIN1024_672 ("0xB3B4"),
        SKEIN1024_680 ("0xB3B5"),
        SKEIN1024_688 ("0xB3B6"),
        SKEIN1024_696 ("0xB3B7"),
        SKEIN1024_704 ("0xB3B8"),
        SKEIN1024_712 ("0xB3B9"),
        SKEIN1024_720 ("0xB3BA"),
        SKEIN1024_728 ("0xB3BB"),
        SKEIN1024_736 ("0xB3BC"),
        SKEIN1024_744 ("0xB3BD"),
        SKEIN1024_752 ("0xB3BE"),
        SKEIN1024_760 ("0xB3BF"),
        SKEIN1024_768 ("0xB3C0"),
        SKEIN1024_776 ("0xB3C1"),
        SKEIN1024_784 ("0xB3C2"),
        SKEIN1024_792 ("0xB3C3"),
        SKEIN1024_800 ("0xB3C4"),
        SKEIN1024_808 ("0xB3C5"),
        SKEIN1024_816 ("0xB3C6"),
        SKEIN1024_824 ("0xB3C7"),
        SKEIN1024_832 ("0xB3C8"),
        SKEIN1024_840 ("0xB3C9"),
        SKEIN1024_848 ("0xB3CA"),
        SKEIN1024_856 ("0xB3CB"),
        SKEIN1024_864 ("0xB3CC"),
        SKEIN1024_872 ("0xB3CD"),
        SKEIN1024_880 ("0xB3CE"),
        SKEIN1024_888 ("0xB3CF"),
        SKEIN1024_896 ("0xB3D0"),
        SKEIN1024_904 ("0xB3D1"),
        SKEIN1024_912 ("0xB3D2"),
        SKEIN1024_920 ("0xB3D3"),
        SKEIN1024_928 ("0xB3D4"),
        SKEIN1024_936 ("0xB3D5"),
        SKEIN1024_944 ("0xB3D6"),
        SKEIN1024_952 ("0xB3D7"),
        SKEIN1024_960 ("0xB3D8"),
        SKEIN1024_968 ("0xB3D9"),
        SKEIN1024_976 ("0xB3DA"),
        SKEIN1024_984 ("0xB3DB"),
        SKEIN1024_992 ("0xB3DC"),
        SKEIN1024_1000 ("0xB3DD"),
        SKEIN1024_1008 ("0xB3DE"),
        SKEIN1024_1016 ("0xB3DF"),
        SKEIN1024_1024 ("0xB3E0"),
        POSEIDON_BLS12_381_A2_FC1 ("0xB401"),
        POSEIDON_BLS12_381_A2_FC1_SC ("0xB402"),
        SSZ ("0xB501"),
        SSZ_SHA2_256_BMT ("0xB502"),
        ISCC ("0xCC01"),
        ZEROXCERT_IMPRINT_256 ("0xCE11"),
        FIL_COMMITMENT_UNSEALED ("0xF101"),
        FIL_COMMITMENT_SEALED ("0xF102"),
        PLAINTEXTV2 ("0x706C61"),
        HOLOCHAIN_ADR_V0 ("0x807124"),
        HOLOCHAIN_ADR_V1 ("0x817124"),
        HOLOCHAIN_KEY_V0 ("0x947124"),
        HOLOCHAIN_KEY_V1 ("0x957124"),
        HOLOCHAIN_SIG_V0 ("0xA27124"),
        HOLOCHAIN_SIG_V1 ("0xA37124"),
        SKYNET_NS ("0xB19910"),
        ARWEAVE_NS ("0xB29910"),
        SUBSPACE_NS ("0xB39910"),
        KUMANDRA_NS ("0xB49910");

        /**
         * The codec code value.
         */
        public final String code;

        /**
         * The unsigned varint encoding of the code.
         */
        public final String uvarintcode;

        Codec(String code) {
            this.code = code;
            this.uvarintcode = uvarint();
        }

        private static final Map<String, Codec> codeLookup = new TreeMap<>();
        static {
            for (Codec codec: Codec.values()) {
                codeLookup.put(codec.code, codec);
            }
        }

        /**
         * Performs a lookup on the Codec based on the code value.
         * @param lookupCode The string code to lookup.
         * @return The Codec based on the code value
         * @throws IllegalArgumentException if the codec name does not exist.
         */
        public static Codec lookupByCode(String lookupCode) {
            if (!codeLookup.containsKey(lookupCode)) {
                throw new IllegalArgumentException("Unknown Multicodec name: " + lookupCode);
            }
            return codeLookup.get(lookupCode);
        }

        /**
         * Returns the unsigned varint encoding of the code.
         * @return the unsigned varint encoding of the code.
         */
        private String uvarint() {
            byte[] codecBytes = HexUtils.hexToBytes(this.code);
            StringBuilder uvarintBuilder = new StringBuilder();
            for (byte codecByte : codecBytes) {
                byte[] varInt = VarInt.writeUnsignedVarInt(Byte.toUnsignedInt(codecByte));
                String varIntHex = HexUtils.bytesToHex(varInt);
                uvarintBuilder.append(varIntHex);
            }
            return uvarintBuilder.toString();
        }
    }

    /**
     * Encodes the byte array of data for the multicodec type.
     * The multicodec type bytes are unsigned varint encoded and are pre-pended to the byte array.
     * @param multicodec The Multicodec.CodecName enum to use.
     * @param data The bytes of data to encode.
     * @return The multicodec encoding of the input bytes
     *
     */
    public static byte[] encode(Codec multicodec, byte[] data) {

        //Get the multicodec prefix of the encoding type as an array as some codes use multibyte prefixes.
        byte[] multicodecCodeBytes = HexUtils.hexToBytes(multicodec.code);

        //Create a byte array pre-pended with the multicodec prefix for the multicodecType
        //Taking care that the multicodec prefix must be unsigned varint encoded...
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            //As per multicodec spec, perform unsigned varint encoding of each byte of the multicodec prefix
            for (byte b : multicodecCodeBytes) {
                outputStream.write(VarInt.writeUnsignedVarInt(Byte.toUnsignedInt(b)));
            }

            //Append the data bytes
            outputStream.write(data);
            return outputStream.toByteArray();

        } catch (IOException exIO) {
            System.err.println("Unexpected error on multicodec encode: " + exIO.getMessage());
            return null;
        }
    }

    /**
     * Decodes a multicodec encoded byte array.<br/>
     * <br/>
     * <b>Assumption: The decoding only supports single byte codec codes. </b></br>
     * Some codec codes are multibyte values and these cannot be distinguished from single byte codec codes </br>
     * when the data follows.
     * <br/>
     * <br/>
     * Consider this encoding of sample data 'A1E9D3D8EC'<br/>
     *<pre>
     * 1. cidv1 encoding starts with 0x10.
     *    - therefore sample encoding hex data is: 01A1E9D3D8EC
     * 2. udp encoding starts with 0x0111
     *    - therefore sample encoding hex data is: 0111A1E9D3D8EC
     *</pre>
     *
     * Looking 2 it is impossible to determine if its<br/>
     * <ol>
     *   <li> cidv1 encoding with data '11A1E9D3D8EC', or </li>
     *   <li> or if it is udp encoding with data 'A1E9D3D8EC'.</li>
     * </ol>
     *
     * <p>
     * This suggests an issue in the multi codec specification for codec prefixes greater than 1 byte.
     * They cannot be 1:1 unambiguously mapped between each other.
     * <br/>
     * @param multicodecData The multicodec encoded data
     * @return An Object array, where<br/>
     *     - the 0th element is the detected Multicodec.Codec<br/>
     *     - the 1st element is the byte data<br/>
     *     - the 2nd element is the hex encoded data<br/>
     */
    public static Object[] decode(byte[] multicodecData) throws AmbiguousCodecEncodingException {
        Object[] responseObject = new Object[3];
        boolean foundCodec = false;

        //No clever shortcuts - we simply loop over the set of the codecs and find a match at the start of the string.
        //Remembering that the codec at the start will be unsigned varint encoded ...
        String multicodecDataHex = HexUtils.bytesToHex(multicodecData);

        for (Codec c : Codec.values()) {
            //as per stated assumption...
            int codeLength = HexUtils.hexToBytes(c.code).length;
            if (codeLength == 1) {
                if (multicodecDataHex.startsWith(c.uvarintcode)) {
                    responseObject[0] = c;
                    String dataHex = StringUtils.removeStart(multicodecDataHex, c.uvarintcode);
                    responseObject[1] = HexUtils.hexToBytes(dataHex);
                    responseObject[2] = dataHex;
                    foundCodec = true;
                    break;
                }
            }
        }

        if (!foundCodec){
            throw new AmbiguousCodecEncodingException("Could not decode:" + multicodecDataHex);
        }
        return responseObject;
    }

}
