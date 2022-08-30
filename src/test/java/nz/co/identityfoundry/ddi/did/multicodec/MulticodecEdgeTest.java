package nz.co.identityfoundry.ddi.did.multicodec;

import nz.co.identityfoundry.ddi.did.util.HexUtils;
import nz.co.identityfoundry.ddi.did.util.VarInt;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Tests on specific edge cases.
 *
 */
public class MulticodecEdgeTest {

    public static final String INVALID_CODEC_CODE = "OxFF";

    /**
     * Tests the lookup of an invalid codec code throws an IllegalArgumentException.
     */
    @Test
    public void testLookupInvalid() {
        assertThrows(IllegalArgumentException.class, ()-> Multicodec.Codec.lookupByCode(INVALID_CODEC_CODE));
    }

    /**
     * Tests the unsigned varint logic.
     */
    @Test
    public void testUnsignedVarInt() {

        byte[] inByteArray = HexUtils.hexToBytes(INVALID_CODEC_CODE);
        byte[] outByteArray = null;

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            //As per multicodec spec, perform unsigned varint encoding of each byte of the multicodec prefix
            for (byte b : inByteArray) {
                outputStream.write(VarInt.writeUnsignedVarInt(Byte.toUnsignedInt(b)));
            }
            outByteArray = outputStream.toByteArray();

        } catch (IOException exIO) {
            System.err.println("Unexpected error: " + exIO.getMessage());
        }

        assert outByteArray != null;
        String outHex = HexUtils.bytesToHex(outByteArray);
        assertEquals("UnsignedVarInt expected", "EF01FF01", outHex);

    }
}
