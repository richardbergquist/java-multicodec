package nz.co.identityfoundry.ddi.did.multicodec;

/**
 * A bean to encapsulate decoded data
 */
public class DecodedData {
    private Multicodec codec;
    private byte[] byteData;
    private String hexData;

    public DecodedData() {
    }

    public Multicodec getCodec() {
        return codec;
    }

    public void setCodec(Multicodec codec) {
        this.codec = codec;
    }

    public byte[] getByteData() {
        return byteData;
    }

    public void setByteData(byte[] byteData) {
        this.byteData = byteData;
    }

    public String getHexData() {
        return hexData;
    }

    public void setHexData(String hexData) {
        this.hexData = hexData;
    }

    public boolean isSet() {
        return (getCodec() != null) && (getByteData() != null && getByteData().length > 0);

    }
}
