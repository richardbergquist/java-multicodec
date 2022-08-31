package nz.co.identityfoundry.ddi.did.multicodec;

import nz.co.identityfoundry.ddi.did.util.HexUtils;

/**
 * <p>A bean to encapsulate decoded data and its codec.</p>
 * <p>The bean provides access to an array of bytes to express the decoded data payload.
 * The data can set/get either as a byte[] or as a hex string in such a way as the operations are consistent ways to act
 * on the same payload of data.</p>
 */
public class DecodedData {
    private Multicodec codec;
    private byte[] data;

    public DecodedData() {
    }

    /**
     * Gets the Multicodec value of the data.
     * @return the Multicodec value of the data.
     */
    public Multicodec getCodec() {
        return codec;
    }

    /**
     * Sets the Multicodec value of the data.
     * @param codec the Multicodec value of the data.
     */
    public void setCodec(Multicodec codec) {
        this.codec = codec;
    }

    /**
     * Gets the data as a byte array.
     * @return the data as a byte array.
     */
    public byte[] getDataAsBytes() {
        return data;
    }

    /**
     * Sets the data.
     * @param data the data as a byte array.
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * Alternative method to get the data as a hex string.
     * @return get the data as a hex string.
     */
    public String getDataAsHex() {
        return HexUtils.bytesToHex(this.data);
    }

    /**
     * Alternative method to set the data as a hex string.
     * @param hexData the data as a hex string.
     */
    public void setData(String hexData) {
        setData(HexUtils.hexToBytes(hexData));
    }

    /**
     * Determines if this object is populated with non-null information.
     * @return true, if this object is populated with non-null information.
     */
    public boolean isSet() {
        return (getCodec() != null) && (getDataAsBytes() != null && getDataAsBytes().length > 0);

    }
}
