package link.sharein.cherry.presentation.presenters;

import java.util.List;

import link.sharein.cherry.domain.model.Voice;
import link.sharein.cherry.domain.model.VoiceConfig;
import link.sharein.cherry.network.model.VoiceConfigGroup;
import link.sharein.cherry.presentation.presenters.base.BasePresenter;
import link.sharein.cherry.presentation.ui.BaseView;

/**
 * Created by jiang on 2016/3/4.
 */
public interface GeneratePresenter extends BasePresenter {
    interface View extends BaseView {
        void showConfig(List<VoiceConfigGroup> configs);

        void onConfigTypeClick(String type);

        void onConfigClick(VoiceConfig config);

        void onShareClick();

        VoiceConfig getConfiged();

    }

    void getTypeVoiceConfig(String type);

    void shareVoice(Voice voice);

    void perfromConfig(VoiceConfig voiceConfig);

    void getAllVoiceConfigGroup();
}
