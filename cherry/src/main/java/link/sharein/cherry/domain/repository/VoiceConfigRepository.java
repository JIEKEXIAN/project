package link.sharein.cherry.domain.repository;

import java.util.List;

import link.sharein.cherry.domain.model.VoiceConfig;
import link.sharein.cherry.network.model.VoiceConfigGroup;

/**
 * Created by jiang on 2016/3/3.
 */
public interface VoiceConfigRepository {
    List<VoiceConfig> getAllConfig();

    List<VoiceConfigGroup> getAllTypeGroup();
}
