package link.sharein.cherry.domain.repository;

import link.sharein.cherry.domain.model.Voice;

/**
 * Created by jiang on 2016/3/3.
 */
public interface VoiceRepository {
    String upload(Voice voice);

    Voice getConfiged();

    void setConfiged(Voice voice);
}
