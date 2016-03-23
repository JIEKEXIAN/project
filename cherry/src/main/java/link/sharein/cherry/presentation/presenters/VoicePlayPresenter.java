package link.sharein.cherry.presentation.presenters;

import link.sharein.cherry.presentation.presenters.base.AbstractPresenter;
import link.sharein.cherry.presentation.presenters.base.BasePresenter;
import link.sharein.cherry.presentation.ui.BaseView;

/**
 * Created by jiang on 2016/3/6.
 */
public interface VoicePlayPresenter extends BasePresenter {
    interface View extends BaseView {
        void onPlayFinished();

        void onPlayCancled();
    }

    void playVoice();

    void canclePlay();
}
