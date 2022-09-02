package com.identityfoundry.ddi.protocol.multicodec;

import com.identityfoundry.ddi.protocol.common.HexUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Tests over all the documented codec values.
 */
@RunWith(Parameterized.class)
public class MulticodecEncoderFullTest {

    private static final String SAMPLE_DATA_HEX = "A1E9D3D8EC";

    private final Multicodec codec;
    private final byte[] raw;
    private final String expectedEncodingHex;

    public MulticodecEncoderFullTest(Multicodec codec, byte[] raw, String expectedEncodingHex) {
        this.codec = codec;
        this.raw = raw;
        this.expectedEncodingHex = expectedEncodingHex;
    }

    @Parameters(name = "{index}: {0}, {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Multicodec.IDENTITY,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.IDENTITY.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CIDV1,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CIDV1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CIDV2,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CIDV2.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CIDV3,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CIDV3.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.IP4,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.IP4.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.TCP,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.TCP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA1,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA2_256,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA2_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA2_512,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA2_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA3_512,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA3_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA3_384,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA3_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA3_256,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA3_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA3_224,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA3_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHAKE_128,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHAKE_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHAKE_256,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHAKE_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.KECCAK_224,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.KECCAK_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.KECCAK_256,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.KECCAK_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.KECCAK_384,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.KECCAK_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.KECCAK_512,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.KECCAK_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE3,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE3.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA2_384,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA2_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DCCP,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DCCP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MURMUR3_X64_64,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MURMUR3_X64_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MURMUR3_32,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MURMUR3_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.IP6,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.IP6.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.IP6ZONE,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.IP6ZONE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.PATH,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.PATH.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MULTICODEC,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MULTICODEC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MULTIHASH,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MULTIHASH.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MULTIADDR,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MULTIADDR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MULTIBASE,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MULTIBASE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DNS,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DNS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DNS4,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DNS4.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DNS6,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DNS6.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DNSADDR,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DNSADDR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.PROTOBUF,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.PROTOBUF.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CBOR,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CBOR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.RAW,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.RAW.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DBL_SHA2_256,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DBL_SHA2_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.RLP,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.RLP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BENCODE,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BENCODE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DAG_PB,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DAG_PB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DAG_CBOR,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DAG_CBOR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.LIBP2P_KEY,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.LIBP2P_KEY.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.GIT_RAW,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.GIT_RAW.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.TORRENT_INFO,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.TORRENT_INFO.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.TORRENT_FILE,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.TORRENT_FILE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.LEOFCOIN_BLOCK,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.LEOFCOIN_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.LEOFCOIN_TX,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.LEOFCOIN_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.LEOFCOIN_PR,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.LEOFCOIN_PR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SCTP,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SCTP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DAG_JOSE,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DAG_JOSE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DAG_COSE,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DAG_COSE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_BLOCK,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_BLOCK_LIST,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_BLOCK_LIST.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_TX_TRIE,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_TX_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_TX,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_TX_RECEIPT_TRIE,            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_TX_RECEIPT_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_TX_RECEIPT,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_TX_RECEIPT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_STATE_TRIE,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_STATE_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_ACCOUNT_SNAPSHOT,           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_ACCOUNT_SNAPSHOT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_STORAGE_TRIE,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_STORAGE_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_RECEIPT_LOG_TRIE,           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_RECEIPT_LOG_TRIE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ETH_RECIEPT_LOG,                HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ETH_RECIEPT_LOG.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.AES_128,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.AES_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.AES_192,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.AES_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.AES_256,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.AES_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CHACHA_128,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CHACHA_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CHACHA_256,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CHACHA_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BITCOIN_BLOCK,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BITCOIN_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BITCOIN_TX,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BITCOIN_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BITCOIN_WITNESS_COMMITMENT,     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BITCOIN_WITNESS_COMMITMENT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ZCASH_BLOCK,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ZCASH_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ZCASH_TX,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ZCASH_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CAIP_50,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CAIP_50.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.STREAMID,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.STREAMID.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.STELLAR_BLOCK,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.STELLAR_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.STELLAR_TX,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.STELLAR_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MD4,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MD4.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MD5,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MD5.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DECRED_BLOCK,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DECRED_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DECRED_TX,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DECRED_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.IPLD_NS,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.IPLD_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.IPFS_NS,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.IPFS_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SWARM_NS,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SWARM_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.IPNS_NS,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.IPNS_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ZERONET,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ZERONET.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SECP256K1_PUB,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SECP256K1_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DNSLINK,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DNSLINK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLS12_381_G1_PUB,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLS12_381_G1_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLS12_381_G2_PUB,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLS12_381_G2_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.X25519_PUB,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.X25519_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ED25519_PUB,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ED25519_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLS12_381_G1G2_PUB,             HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLS12_381_G1G2_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DASH_BLOCK,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DASH_BLOCK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DASH_TX,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DASH_TX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SWARM_MANIFEST,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SWARM_MANIFEST.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SWARM_FEED,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SWARM_FEED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.UDP,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.UDP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P2P_WEBRTC_STAR,                HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P2P_WEBRTC_STAR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P2P_WEBRTC_DIRECT,              HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P2P_WEBRTC_DIRECT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P2P_STARDUST,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P2P_STARDUST.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.WEBRTC,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.WEBRTC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P2P_CIRCUIT,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P2P_CIRCUIT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.DAG_JSON,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.DAG_JSON.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.UDT,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.UDT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.UTP,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.UTP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.UNIX,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.UNIX.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.THREAD,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.THREAD.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P2P,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P2P.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.IPFS,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.IPFS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.HTTPS,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.HTTPS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ONION,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ONION.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ONION3,                         HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ONION3.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.GARLIC64,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.GARLIC64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.GARLIC32,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.GARLIC32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.TLS,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.TLS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.NOISE,                          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.NOISE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.QUIC,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.QUIC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.WEBTRANSPORT,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.WEBTRANSPORT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CERTHASH,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CERTHASH.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.WS,                             HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.WS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.WSS,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.WSS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P2P_WEBSOCKET_STAR,             HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P2P_WEBSOCKET_STAR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.HTTP,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.HTTP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SWHID_1_SNP,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SWHID_1_SNP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.JSON,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.JSON.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MESSAGEPACK,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MESSAGEPACK.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CAR,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CAR.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.LIBP2P_PEER_RECORD,             HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.LIBP2P_PEER_RECORD.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.LIBP2P_RELAY_RSVP,              HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.LIBP2P_RELAY_RSVP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CAR_INDEX_SORTED,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CAR_INDEX_SORTED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.CAR_MULTIHASH_INDEX_SORTED,     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.CAR_MULTIHASH_INDEX_SORTED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.TRANSPORT_BITSWAP,              HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.TRANSPORT_BITSWAP.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.TRANSPORT_GRAPHSYNC_FILECOINV1, HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.TRANSPORT_GRAPHSYNC_FILECOINV1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA2_256_TRUNC254_PADDED,       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA2_256_TRUNC254_PADDED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA2_224,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA2_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA2_512_224,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA2_512_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SHA2_512_256,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SHA2_512_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.MURMUR3_X64_128,                HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.MURMUR3_X64_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.RIPEMD_128,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.RIPEMD_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.RIPEMD_160,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.RIPEMD_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.RIPEMD_256,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.RIPEMD_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.RIPEMD_320,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.RIPEMD_320.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.X11,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.X11.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P256_PUB,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P256_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P384_PUB,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P384_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.P521_PUB,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.P521_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ED448_PUB,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ED448_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.X448_PUB,                       HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.X448_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.RSA_PUB,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.RSA_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SM2_PUB,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SM2_PUB.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ED25519_PRIV,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ED25519_PRIV.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SECP256K1_PRIV,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SECP256K1_PRIV.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.X25519_PRIV,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.X25519_PRIV.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.KANGAROOTWELVE,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.KANGAROOTWELVE.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SM3_256,                        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SM3_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_8,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_16,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_24,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_32,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_40,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_48,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_56,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_64,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_72,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_80,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_88,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_96,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_104,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_112,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_120,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_128,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_136,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_144,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_152,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_160,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_168,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_176,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_184,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_192,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_200,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_208,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_216,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_224,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_232,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_240,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_248,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_256,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_264,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_264.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_272,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_272.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_280,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_280.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_288,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_288.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_296,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_296.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_304,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_304.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_312,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_312.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_320,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_320.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_328,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_328.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_336,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_336.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_344,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_344.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_352,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_352.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_360,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_360.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_368,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_368.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_376,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_376.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_384,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_392,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_392.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_400,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_400.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_408,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_408.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_416,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_416.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_424,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_424.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_432,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_432.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_440,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_440.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_448,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_448.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_456,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_456.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_464,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_464.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_472,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_472.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_480,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_480.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_488,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_488.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_496,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_496.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_504,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_504.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2B_512,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2B_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_8,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_16,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_24,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_32,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_40,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_48,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_56,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_64,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_72,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_80,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_88,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_96,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_104,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_112,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_120,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_128,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_136,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_144,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_152,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_160,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_168,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_176,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_184,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_192,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_200,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_208,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_216,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_224,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_232,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_240,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_248,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.BLAKE2S_256,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.BLAKE2S_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_8,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_16,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_24,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_32,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_40,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_48,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_56,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_64,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_72,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_80,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_88,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_96,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_104,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_112,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_120,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_128,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_136,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_144,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_152,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_160,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_168,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_176,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_184,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_192,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_200,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_208,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_216,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_224,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_232,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_240,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_248,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN256_256,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN256_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_8,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_16,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_24,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_32,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_40,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_48,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_56,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_64,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_72,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_80,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_88,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_96,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_104,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_112,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_120,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_128,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_136,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_144,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_152,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_160,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_168,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_176,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_184,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_192,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_200,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_208,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_216,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_224,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_232,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_240,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_248,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_256,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_264,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_264.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_272,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_272.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_280,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_280.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_288,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_288.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_296,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_296.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_304,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_304.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_312,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_312.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_320,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_320.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_328,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_328.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_336,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_336.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_344,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_344.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_352,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_352.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_360,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_360.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_368,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_368.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_376,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_376.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_384,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_392,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_392.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_400,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_400.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_408,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_408.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_416,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_416.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_424,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_424.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_432,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_432.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_440,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_440.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_448,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_448.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_456,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_456.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_464,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_464.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_472,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_472.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_480,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_480.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_488,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_488.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_496,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_496.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_504,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_504.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN512_512,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN512_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_8,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_8.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_16,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_16.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_24,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_24.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_32,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_32.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_40,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_40.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_48,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_48.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_56,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_56.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_64,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_64.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_72,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_72.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_80,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_80.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_88,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_88.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_96,                   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_96.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_104,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_104.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_112,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_112.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_120,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_120.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_128,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_128.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_136,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_136.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_144,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_144.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_152,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_152.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_160,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_160.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_168,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_168.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_176,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_176.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_184,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_184.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_192,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_192.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_200,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_200.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_208,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_208.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_216,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_216.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_224,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_224.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_232,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_232.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_240,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_240.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_248,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_248.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_256,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_264,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_264.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_272,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_272.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_280,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_280.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_288,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_288.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_296,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_296.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_304,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_304.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_312,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_312.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_320,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_320.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_328,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_328.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_336,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_336.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_344,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_344.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_352,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_352.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_360,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_360.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_368,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_368.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_376,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_376.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_384,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_384.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_392,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_392.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_400,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_400.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_408,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_408.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_416,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_416.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_424,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_424.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_432,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_432.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_440,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_440.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_448,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_448.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_456,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_456.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_464,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_464.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_472,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_472.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_480,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_480.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_488,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_488.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_496,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_496.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_504,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_504.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_512,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_512.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_520,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_520.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_528,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_528.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_536,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_536.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_544,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_544.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_552,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_552.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_560,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_560.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_568,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_568.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_576,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_576.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_584,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_584.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_592,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_592.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_600,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_600.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_608,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_608.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_616,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_616.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_624,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_624.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_632,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_632.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_640,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_640.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_648,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_648.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_656,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_656.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_664,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_664.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_672,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_672.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_680,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_680.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_688,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_688.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_696,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_696.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_704,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_704.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_712,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_712.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_720,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_720.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_728,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_728.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_736,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_736.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_744,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_744.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_752,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_752.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_760,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_760.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_768,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_768.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_776,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_776.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_784,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_784.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_792,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_792.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_800,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_800.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_808,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_808.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_816,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_816.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_824,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_824.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_832,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_832.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_840,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_840.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_848,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_848.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_856,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_856.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_864,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_864.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_872,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_872.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_880,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_880.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_888,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_888.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_896,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_896.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_904,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_904.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_912,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_912.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_920,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_920.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_928,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_928.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_936,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_936.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_944,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_944.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_952,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_952.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_960,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_960.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_968,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_968.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_976,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_976.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_984,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_984.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_992,                  HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_992.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_1000,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_1000.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_1008,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_1008.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_1016,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_1016.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKEIN1024_1024,                 HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKEIN1024_1024.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.POSEIDON_BLS12_381_A2_FC1,      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.POSEIDON_BLS12_381_A2_FC1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.POSEIDON_BLS12_381_A2_FC1_SC,   HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.POSEIDON_BLS12_381_A2_FC1_SC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SSZ,                            HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SSZ.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SSZ_SHA2_256_BMT,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SSZ_SHA2_256_BMT.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ISCC,                           HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ISCC.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ZEROXCERT_IMPRINT_256,          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ZEROXCERT_IMPRINT_256.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.FIL_COMMITMENT_UNSEALED,        HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.FIL_COMMITMENT_UNSEALED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.FIL_COMMITMENT_SEALED,          HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.FIL_COMMITMENT_SEALED.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.PLAINTEXTV2,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.PLAINTEXTV2.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.HOLOCHAIN_ADR_V0,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.HOLOCHAIN_ADR_V0.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.HOLOCHAIN_ADR_V1,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.HOLOCHAIN_ADR_V1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.HOLOCHAIN_KEY_V0,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.HOLOCHAIN_KEY_V0.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.HOLOCHAIN_KEY_V1,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.HOLOCHAIN_KEY_V1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.HOLOCHAIN_SIG_V0,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.HOLOCHAIN_SIG_V0.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.HOLOCHAIN_SIG_V1,               HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.HOLOCHAIN_SIG_V1.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SKYNET_NS,                      HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SKYNET_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.ARWEAVE_NS,                     HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.ARWEAVE_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.SUBSPACE_NS,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.SUBSPACE_NS.uvarintcode + SAMPLE_DATA_HEX},
                {Multicodec.KUMANDRA_NS,                    HexUtils.hexToBytes(SAMPLE_DATA_HEX), Multicodec.KUMANDRA_NS.uvarintcode + SAMPLE_DATA_HEX}
        });
    }

    /**
     * Tests the encoding of bytes to a multicodec codec type.
     */
    @Test
    public void testEncode() {
        byte[] actualEncoding = MulticodecEncoder.encode(codec, raw);
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
     * Refer to: {@link AmbiguousCodecEncodingException} for more information.
     * <br/>
     * @see AmbiguousCodecEncodingException
     *
     */
    @Test
    public void testDecodeSingleByteCodec() {

        //As per assumption, only test over single byte codec codes
        int codeLength = HexUtils.hexToBytes(codec.code).length;
        if (codeLength == 1) {
            DecodedData decodedData = null;
            try {
                decodedData = MulticodecEncoder.decode(HexUtils.hexToBytes(expectedEncodingHex));
            } catch (AmbiguousCodecEncodingException exAmbiguousCodecEncoding) {
                System.err.println("AmbiguousCodecEncodingException:" + exAmbiguousCodecEncoding.getMessage());
            }
            assertNotNull("DecodedData was not null", decodedData);
            assertEquals(String.format("Expected codec %s, but got %s", codec.name(), decodedData.getCodec().name()), codec.name(), decodedData.getCodec().name());
            assertArrayEquals(String.format("Expected data %s, but got %s", HexUtils.bytesToHex(raw), decodedData.getDataAsHex()), raw, decodedData.getDataAsBytes());
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
     * Refer to: {@link AmbiguousCodecEncodingException} for more information.
     * <br/>
     *
     */
    @Test
    public void testDecodeAllCodecs() {

        DecodedData decodedData = null;
        try {
            decodedData = MulticodecEncoder.decode(HexUtils.hexToBytes(expectedEncodingHex));
        } catch (AmbiguousCodecEncodingException exAmbiguousCodecEncoding) {
            //This 'clash of codecs' decoding condition will be reported below.
        }

        if ((decodedData != null) && !StringUtils.equals(codec.name(), decodedData.getCodec().name())) {
            String codecClashMessage =
                    String.format("'Clash of codecs' spec problem: cannot decode between [%s(%s)], and [%s(%s)] for sample data:[%s] because codes start with the same values.",
                            codec.name(),
                            codec.code,
                            decodedData.getCodec().name(),
                            decodedData.getCodec().code,
                            expectedEncodingHex);
            System.out.println(codecClashMessage);
        }

    }

    /**
     * Tests the lookup of codec code.
     */
    @Test
    public void testLookup() {
        String codecCode = codec.code;
        Multicodec lookupCodec = Multicodec.lookupByCode(codecCode);
        assertEquals(String.format("Lookup found codec %s", codecCode), codecCode, lookupCodec.code);
    }

}
