package link.sharein.cherry.domain.model;

/**
 * Created by jiang on 2016/3/3.
 */
public class Voice {
    private String content;
    private String vcn;
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVcn() {
        return vcn;
    }

    public void setVcn(String vcn) {
        this.vcn = vcn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voice voice = (Voice) o;

        if (!content.equals(voice.content)) return false;
        if (!vcn.equals(voice.vcn)) return false;
        return url.equals(voice.url);

    }

    @Override
    public int hashCode() {
        int result = content.hashCode();
        result = 31 * result + vcn.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Voice{" +
                "content='" + content + '\'' +
                ", vcn='" + vcn + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
