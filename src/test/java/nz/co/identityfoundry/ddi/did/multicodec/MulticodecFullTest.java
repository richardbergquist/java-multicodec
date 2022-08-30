package nz.co.identityfoundry.ddi.did.multicodec;

import nz.co.identityfoundry.ddi.did.util.HexUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests over all the documented codec values.
 */
@RunWith(Parameterized.class)
public class MulticodecFullTest {

    private static final String SAMPLE_DATA_HEX = "A1E9D3D8EC";

    private final Multicodec.Codec codec;
    private final byte[] raw;
    private final String expectedEncodingHex;

    public MulticodecFullTest(Multicodec.Codec codec, byte[] raw, String expectedEncodingHex) {
        this.codec = codec;
        this.raw = raw;
        this.expectedEncodingHex = expectedEncodingHex;
    }

    @Parameters(name = "{index}: {0}, {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Multicodec.Codec.IDENTITY,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.IDENTITY.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CIDV1,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CIDV1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CIDV2,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CIDV2.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CIDV3,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CIDV3.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.IP4,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.IP4.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.TCP,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.TCP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA1,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA2_256,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA2_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA2_512,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA2_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA3_512,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA3_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA3_384,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA3_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA3_256,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA3_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA3_224,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA3_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHAKE_128,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHAKE_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHAKE_256,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHAKE_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.KECCAK_224,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.KECCAK_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.KECCAK_256,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.KECCAK_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.KECCAK_384,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.KECCAK_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.KECCAK_512,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.KECCAK_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE3,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE3.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA2_384,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA2_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DCCP,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DCCP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MURMUR3_X64_64,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MURMUR3_X64_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MURMUR3_32,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MURMUR3_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.IP6,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.IP6.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.IP6ZONE,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.IP6ZONE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.PATH,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.PATH.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MULTICODEC,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MULTICODEC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MULTIHASH,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MULTIHASH.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MULTIADDR,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MULTIADDR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MULTIBASE,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MULTIBASE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DNS,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DNS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DNS4,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DNS4.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DNS6,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DNS6.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DNSADDR,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DNSADDR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.PROTOBUF,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.PROTOBUF.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CBOR,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CBOR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.RAW,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.RAW.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DBL_SHA2_256,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DBL_SHA2_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.RLP,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.RLP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BENCODE,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BENCODE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DAG_PB,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DAG_PB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DAG_CBOR,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DAG_CBOR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.LIBP2P_KEY,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.LIBP2P_KEY.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.GIT_RAW,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.GIT_RAW.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.TORRENT_INFO,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.TORRENT_INFO.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.TORRENT_FILE,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.TORRENT_FILE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.LEOFCOIN_BLOCK,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.LEOFCOIN_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.LEOFCOIN_TX,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.LEOFCOIN_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.LEOFCOIN_PR,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.LEOFCOIN_PR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SCTP,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SCTP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DAG_JOSE,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DAG_JOSE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DAG_COSE,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DAG_COSE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_BLOCK,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_BLOCK_LIST,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_BLOCK_LIST.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_TX_TRIE,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_TX_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_TX,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_TX_RECEIPT_TRIE,            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_TX_RECEIPT_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_TX_RECEIPT,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_TX_RECEIPT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_STATE_TRIE,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_STATE_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_ACCOUNT_SNAPSHOT,           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_ACCOUNT_SNAPSHOT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_STORAGE_TRIE,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_STORAGE_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_RECEIPT_LOG_TRIE,           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_RECEIPT_LOG_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ETH_RECIEPT_LOG,                HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ETH_RECIEPT_LOG.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.AES_128,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.AES_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.AES_192,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.AES_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.AES_256,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.AES_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CHACHA_128,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CHACHA_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CHACHA_256,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CHACHA_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BITCOIN_BLOCK,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BITCOIN_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BITCOIN_TX,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BITCOIN_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BITCOIN_WITNESS_COMMITMENT,     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BITCOIN_WITNESS_COMMITMENT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ZCASH_BLOCK,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ZCASH_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ZCASH_TX,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ZCASH_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CAIP_50,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CAIP_50.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.STREAMID,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.STREAMID.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.STELLAR_BLOCK,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.STELLAR_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.STELLAR_TX,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.STELLAR_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MD4,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MD4.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MD5,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MD5.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DECRED_BLOCK,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DECRED_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DECRED_TX,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DECRED_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.IPLD_NS,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.IPLD_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.IPFS_NS,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.IPFS_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SWARM_NS,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SWARM_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.IPNS_NS,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.IPNS_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ZERONET,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ZERONET.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SECP256K1_PUB,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SECP256K1_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DNSLINK,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DNSLINK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLS12_381_G1_PUB,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLS12_381_G1_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLS12_381_G2_PUB,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLS12_381_G2_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.X25519_PUB,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.X25519_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ED25519_PUB,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ED25519_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLS12_381_G1G2_PUB,             HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLS12_381_G1G2_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DASH_BLOCK,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DASH_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DASH_TX,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DASH_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SWARM_MANIFEST,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SWARM_MANIFEST.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SWARM_FEED,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SWARM_FEED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.UDP,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.UDP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P2P_WEBRTC_STAR,                HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P2P_WEBRTC_STAR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P2P_WEBRTC_DIRECT,              HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P2P_WEBRTC_DIRECT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P2P_STARDUST,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P2P_STARDUST.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.WEBRTC,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.WEBRTC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P2P_CIRCUIT,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P2P_CIRCUIT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.DAG_JSON,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.DAG_JSON.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.UDT,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.UDT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.UTP,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.UTP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.UNIX,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.UNIX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.THREAD,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.THREAD.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P2P,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P2P.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.IPFS,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.IPFS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.HTTPS,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.HTTPS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ONION,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ONION.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ONION3,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ONION3.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.GARLIC64,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.GARLIC64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.GARLIC32,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.GARLIC32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.TLS,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.TLS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.NOISE,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.NOISE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.QUIC,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.QUIC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.WEBTRANSPORT,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.WEBTRANSPORT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CERTHASH,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CERTHASH.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.WS,                             HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.WS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.WSS,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.WSS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P2P_WEBSOCKET_STAR,             HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P2P_WEBSOCKET_STAR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.HTTP,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.HTTP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SWHID_1_SNP,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SWHID_1_SNP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.JSON,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.JSON.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MESSAGEPACK,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MESSAGEPACK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CAR,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CAR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.LIBP2P_PEER_RECORD,             HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.LIBP2P_PEER_RECORD.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.LIBP2P_RELAY_RSVP,              HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.LIBP2P_RELAY_RSVP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CAR_INDEX_SORTED,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CAR_INDEX_SORTED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.CAR_MULTIHASH_INDEX_SORTED,     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.CAR_MULTIHASH_INDEX_SORTED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.TRANSPORT_BITSWAP,              HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.TRANSPORT_BITSWAP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.TRANSPORT_GRAPHSYNC_FILECOINV1, HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.TRANSPORT_GRAPHSYNC_FILECOINV1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA2_256_TRUNC254_PADDED,       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA2_256_TRUNC254_PADDED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA2_224,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA2_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA2_512_224,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA2_512_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SHA2_512_256,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SHA2_512_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.MURMUR3_X64_128,                HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.MURMUR3_X64_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.RIPEMD_128,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.RIPEMD_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.RIPEMD_160,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.RIPEMD_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.RIPEMD_256,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.RIPEMD_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.RIPEMD_320,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.RIPEMD_320.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.X11,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.X11.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P256_PUB,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P256_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P384_PUB,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P384_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.P521_PUB,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.P521_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ED448_PUB,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ED448_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.X448_PUB,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.X448_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.RSA_PUB,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.RSA_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SM2_PUB,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SM2_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ED25519_PRIV,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ED25519_PRIV.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SECP256K1_PRIV,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SECP256K1_PRIV.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.X25519_PRIV,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.X25519_PRIV.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.KANGAROOTWELVE,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.KANGAROOTWELVE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SM3_256,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SM3_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_8,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_16,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_24,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_32,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_40,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_48,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_56,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_64,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_72,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_80,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_88,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_96,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_104,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_112,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_120,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_128,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_136,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_144,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_152,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_160,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_168,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_176,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_184,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_192,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_200,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_208,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_216,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_224,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_232,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_240,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_248,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_256,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_264,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_264.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_272,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_272.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_280,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_280.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_288,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_288.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_296,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_296.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_304,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_304.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_312,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_312.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_320,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_320.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_328,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_328.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_336,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_336.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_344,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_344.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_352,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_352.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_360,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_360.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_368,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_368.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_376,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_376.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_384,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_392,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_392.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_400,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_400.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_408,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_408.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_416,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_416.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_424,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_424.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_432,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_432.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_440,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_440.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_448,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_448.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_456,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_456.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_464,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_464.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_472,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_472.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_480,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_480.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_488,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_488.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_496,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_496.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_504,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_504.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2B_512,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2B_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_8,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_16,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_24,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_32,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_40,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_48,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_56,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_64,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_72,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_80,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_88,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_96,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_104,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_112,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_120,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_128,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_136,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_144,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_152,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_160,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_168,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_176,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_184,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_192,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_200,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_208,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_216,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_224,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_232,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_240,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_248,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.BLAKE2S_256,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.BLAKE2S_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_8,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_16,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_24,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_32,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_40,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_48,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_56,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_64,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_72,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_80,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_88,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_96,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_104,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_112,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_120,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_128,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_136,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_144,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_152,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_160,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_168,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_176,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_184,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_192,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_200,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_208,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_216,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_224,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_232,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_240,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_248,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN256_256,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN256_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_8,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_16,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_24,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_32,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_40,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_48,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_56,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_64,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_72,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_80,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_88,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_96,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_104,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_112,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_120,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_128,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_136,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_144,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_152,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_160,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_168,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_176,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_184,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_192,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_200,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_208,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_216,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_224,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_232,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_240,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_248,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_256,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_264,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_264.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_272,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_272.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_280,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_280.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_288,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_288.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_296,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_296.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_304,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_304.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_312,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_312.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_320,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_320.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_328,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_328.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_336,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_336.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_344,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_344.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_352,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_352.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_360,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_360.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_368,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_368.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_376,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_376.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_384,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_392,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_392.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_400,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_400.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_408,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_408.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_416,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_416.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_424,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_424.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_432,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_432.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_440,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_440.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_448,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_448.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_456,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_456.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_464,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_464.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_472,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_472.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_480,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_480.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_488,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_488.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_496,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_496.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_504,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_504.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN512_512,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN512_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_8,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_16,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_24,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_32,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_40,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_48,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_56,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_64,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_72,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_80,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_88,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_96,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_104,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_112,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_120,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_128,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_136,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_144,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_152,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_160,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_168,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_176,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_184,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_192,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_200,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_208,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_216,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_224,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_232,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_240,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_248,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_256,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_264,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_264.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_272,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_272.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_280,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_280.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_288,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_288.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_296,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_296.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_304,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_304.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_312,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_312.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_320,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_320.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_328,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_328.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_336,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_336.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_344,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_344.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_352,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_352.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_360,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_360.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_368,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_368.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_376,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_376.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_384,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_392,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_392.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_400,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_400.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_408,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_408.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_416,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_416.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_424,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_424.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_432,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_432.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_440,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_440.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_448,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_448.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_456,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_456.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_464,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_464.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_472,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_472.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_480,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_480.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_488,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_488.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_496,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_496.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_504,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_504.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_512,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_520,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_520.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_528,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_528.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_536,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_536.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_544,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_544.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_552,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_552.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_560,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_560.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_568,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_568.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_576,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_576.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_584,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_584.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_592,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_592.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_600,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_600.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_608,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_608.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_616,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_616.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_624,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_624.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_632,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_632.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_640,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_640.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_648,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_648.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_656,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_656.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_664,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_664.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_672,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_672.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_680,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_680.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_688,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_688.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_696,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_696.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_704,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_704.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_712,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_712.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_720,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_720.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_728,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_728.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_736,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_736.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_744,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_744.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_752,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_752.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_760,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_760.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_768,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_768.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_776,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_776.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_784,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_784.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_792,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_792.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_800,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_800.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_808,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_808.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_816,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_816.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_824,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_824.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_832,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_832.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_840,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_840.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_848,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_848.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_856,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_856.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_864,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_864.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_872,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_872.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_880,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_880.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_888,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_888.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_896,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_896.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_904,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_904.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_912,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_912.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_920,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_920.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_928,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_928.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_936,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_936.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_944,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_944.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_952,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_952.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_960,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_960.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_968,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_968.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_976,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_976.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_984,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_984.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_992,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_992.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_1000,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_1000.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_1008,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_1008.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_1016,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_1016.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKEIN1024_1024,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKEIN1024_1024.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.POSEIDON_BLS12_381_A2_FC1,      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.POSEIDON_BLS12_381_A2_FC1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.POSEIDON_BLS12_381_A2_FC1_SC,   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.POSEIDON_BLS12_381_A2_FC1_SC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SSZ,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SSZ.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SSZ_SHA2_256_BMT,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SSZ_SHA2_256_BMT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ISCC,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ISCC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ZEROXCERT_IMPRINT_256,          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ZEROXCERT_IMPRINT_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.FIL_COMMITMENT_UNSEALED,        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.FIL_COMMITMENT_UNSEALED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.FIL_COMMITMENT_SEALED,          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.FIL_COMMITMENT_SEALED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.PLAINTEXTV2,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.PLAINTEXTV2.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.HOLOCHAIN_ADR_V0,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.HOLOCHAIN_ADR_V0.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.HOLOCHAIN_ADR_V1,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.HOLOCHAIN_ADR_V1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.HOLOCHAIN_KEY_V0,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.HOLOCHAIN_KEY_V0.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.HOLOCHAIN_KEY_V1,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.HOLOCHAIN_KEY_V1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.HOLOCHAIN_SIG_V0,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.HOLOCHAIN_SIG_V0.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.HOLOCHAIN_SIG_V1,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.HOLOCHAIN_SIG_V1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SKYNET_NS,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SKYNET_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.ARWEAVE_NS,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.ARWEAVE_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.SUBSPACE_NS,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.SUBSPACE_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.Codec.KUMANDRA_NS,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.Codec.KUMANDRA_NS.uvarintcode + SAMPLE_DATA_HEX}
        });
    }

    /**
     * Tests the encoding of bytes to a multicodec codec type.
     */
    @Test
    public void testEncode() {
        byte[] actualEncoding = Multicodec.encode(codec, raw);
        byte[] expectedEncodingBytes = HexUtils.hexToBytes(expectedEncodingHex);
        assert actualEncoding != null;

        String actualEncodingHex = HexUtils.bytesToHex(actualEncoding);
        //System.out.println(String.format("multicodec encoding for:[%s(%s)] is:[%s]", codec.name(), codec.code, expectedEncodingHex));
        if (!StringUtils.equals(expectedEncodingHex, actualEncodingHex)) {
            System.err.println("Encoding error found for:" + codec.name() + "(" + codec.code + ")" + "\nexpected:" + expectedEncodingHex + "\ngot:" + actualEncodingHex);
        }
        assertArrayEquals("multicodec encoding for:" + codec.name() + "(" + codec.code + ")", expectedEncodingBytes, actualEncoding);
    }

    /**
     * Tests the decoding of an encoded multicodec byte array.<br/>
     * <br/>
     * Assumes decoding is only supported for single byte codec codes, as multibyte codecs codes cannot be
     * unambiguously decoded as per comments in the linked references below.<br/>
     * <br/>
     * Refer to: {@link nz.co.identityfoundry.ddi.did.multicodec.AmbiguousCodecEncodingException} for more information.
     * <br/>
     * @see nz.co.identityfoundry.ddi.did.multicodec.AmbiguousCodecEncodingException
     *
     */
    @Test
    public void testDecodeSingleByteCodec() {

        //As per assumption, only test over single byte codec codes
        int codeLength = HexUtils.hexToBytes(codec.code).length;
        if (codeLength == 1) {
            Object[] output = new Object[0];
            try {
                output = Multicodec.decode(HexUtils.hexToBytes(expectedEncodingHex));
            } catch (AmbiguousCodecEncodingException exAmbiguousCodecEncoding) {
                exAmbiguousCodecEncoding.printStackTrace();
                System.err.println("AmbiguousCodecEncodingException:" + exAmbiguousCodecEncoding.getMessage());
            }

            if (output.length == 3) {
                Multicodec.Codec decodedCodec = (Multicodec.Codec) output[0];
                byte[] actualByteData = (byte[]) output[1];
                String actualByteDataHex = (String) output[2];

                assertEquals(String.format("Expected codec %s, but got %s", codec.name(), decodedCodec.name()), codec.name(), decodedCodec.name());
                assertArrayEquals(String.format("Expected data %s, but got %s", HexUtils.bytesToHex(raw), actualByteDataHex), raw, actualByteData);
            }
        }
    }

    /**
     * <p>Tests the decoding of an encoded multicodec byte array.
     * </p>
     * <br/>
     * <p>Tests over single byte and multibyte codecs to demonstrate issues where some multibyte codecs code clash with
     * the code of others to produce situations where its ambiguous to determine which codec is in use.
     * </p>
     * <br/>
     * Refer to: {@link nz.co.identityfoundry.ddi.did.multicodec.AmbiguousCodecEncodingException} for more information.
     * <br/>
     *
     */
    @Test
    public void testDecodeAllCodecs() {

        Object[] output = new Object[0];
        try {
            output = Multicodec.decode(HexUtils.hexToBytes(expectedEncodingHex));
        } catch (AmbiguousCodecEncodingException exAmbiguousCodecEncoding) {
            //This 'clash of codecs' decoding condition will be reported below.
        }

        if (output.length == 3) {
            Multicodec.Codec decodedCodec = (Multicodec.Codec) output[0];
            if (!StringUtils.equals(codec.name(), decodedCodec.name())) {
                String codecClashMessage =
                        String.format("'Clash of codecs' spec problem: cannot decode between [%s(%s)], and [%s(%s)] for sample data:[%s] because codes start with the same values.",
                                codec.name(),
                                codec.code,
                                decodedCodec.name(),
                                decodedCodec.code,
                                expectedEncodingHex);
                System.out.println(codecClashMessage);
            }
        }
    }

    /**
     * Tests the lookup of codec code.
     */
    @Test
    public void testLookup() {
        String codecCode = codec.code;
        Multicodec.Codec lookupCodec = Multicodec.Codec.lookupByCode(codecCode);
        assertEquals(String.format("Lookup found codec %s", codecCode), codecCode, lookupCodec.code);
    }

}
