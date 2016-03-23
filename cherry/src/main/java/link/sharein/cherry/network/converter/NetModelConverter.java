package link.sharein.cherry.network.converter;

import java.util.ArrayList;
import java.util.List;

import link.sharein.cherry.domain.model.VoiceConfig;
import link.sharein.cherry.network.model.VoiceConfigGroup;

/**
 * Created by jiang on 2016/3/3.
 */
public class NetModelConverter {
    public static VoiceConfig convertToDomainModel(link.sharein.cherry.network.model.VoiceConfig voiceConfig) {
        VoiceConfig domainVoiceConfig = new VoiceConfig();
        domainVoiceConfig.setName(voiceConfig.getName());
        domainVoiceConfig.setIcon(voiceConfig.getImg());
        domainVoiceConfig.setVcn(voiceConfig.getVcn());
        return domainVoiceConfig;
    }

    public static List<VoiceConfig> convertListToDomainModel(List<link.sharein.cherry.network.model.VoiceConfig> voiceConfigList) {
        List<VoiceConfig> list = new ArrayList<>();
        for (link.sharein.cherry.network.model.VoiceConfig voiceConfig : voiceConfigList) {
            list.add(convertToDomainModel(voiceConfig));
        }
        return list;
    }

    public static List<VoiceConfig> convertConfigGroupToDomainModel(List<VoiceConfigGroup> voiceConfigList) {
        List<VoiceConfig> list = new ArrayList<>();
        for (VoiceConfigGroup voiceConfig : voiceConfigList) {
            List<link.sharein.cherry.network.model.VoiceConfig> voiceConfigs = voiceConfig.getContent();
            for (link.sharein.cherry.network.model.VoiceConfig config : voiceConfigs) {
                VoiceConfig domainVoiceConfig = convertToDomainModel(config);
                domainVoiceConfig.setType(voiceConfig.getType());
                list.add(domainVoiceConfig);
            }

        }
        return list;
    }

}
