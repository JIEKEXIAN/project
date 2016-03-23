package link.sharein.cherry.network.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2016/3/4.
 */
public class VoiceConfigGroup {
    private String type;
    private List<VoiceConfig> content = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<VoiceConfig> getContent() {
        return content;
    }

    public void setContent(List<VoiceConfig> content) {
        this.content = content;
    }

    public void addVoiceConfig(VoiceConfig voiceConfig) {
        this.content.add(voiceConfig);
    }

    @Override
    public String toString() {
        return "VoiceConfigGroup{" +
                "type='" + type + '\'' +
                ", content=" + getString() +
                '}';
    }

    private String getString() {
        StringBuilder sb = new StringBuilder();
        for (VoiceConfig voiceConfig : content) {
            sb.append(voiceConfig.toString());
        }
        return sb.toString();
    }
}
