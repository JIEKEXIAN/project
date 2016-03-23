package link.sharein.cherry.network.model;

/**
 * Created by jiang on 2016/3/3.
 */
public class VoiceConfig {
    private String name;
    private String vcn;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVcn() {
        return vcn;
    }

    public void setVcn(String vcn) {
        this.vcn = vcn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VoiceConfig)) return false;

        VoiceConfig that = (VoiceConfig) o;

        if (!name.equals(that.name)) return false;
        if (!vcn.equals(that.vcn)) return false;
        return img.equals(that.img);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + vcn.hashCode();
        result = 31 * result + img.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "VoiceConfig{" +
                "name='" + name + '\'' +
                ", vcn='" + vcn + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
