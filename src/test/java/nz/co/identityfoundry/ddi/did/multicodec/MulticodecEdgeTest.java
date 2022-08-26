package nz.co.identityfoundry.ddi.did.multicodec;

import org.junit.Test;

import static org.junit.Assert.*;

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
        assertThrows(IllegalArgumentException.class, ()->{
            Multicodec.Codec.lookupByCode(INVALID_CODEC_CODE);
        });


    }
}
