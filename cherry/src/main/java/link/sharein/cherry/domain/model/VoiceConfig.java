package link.sharein.cherry.domain.model;

/**
 * Created by jiang on 2016/3/3.
 */
public class VoiceConfig {
    private String name;
    private String vcn;
    private String icon;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        return this.getVcn().equals(((VoiceConfig) o).getVcn());
    }

    @Override
    public String toString() {
        return "VoiceConfig{" +
                "name='" + name + '\'' +
                ", vcn='" + vcn + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
