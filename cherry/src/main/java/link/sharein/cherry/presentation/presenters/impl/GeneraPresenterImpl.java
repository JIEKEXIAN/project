package link.sharein.cherry.presentation.presenters.impl;

import java.util.List;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;
import link.sharein.cherry.domain.executor.impl.ThreadExecutor;
import link.sharein.cherry.domain.interactors.GetAllVoiceGroupInteractor;
import link.sharein.cherry.domain.interactors.PlayVoiceInteractor;
import link.sharein.cherry.domain.interactors.impl.GetAllVoiceGroupInteractorImpl;
import link.sharein.cherry.domain.interactors.impl.PlayVoiceInteractorImpl;
import link.sharein.cherry.domain.model.Voice;
import link.sharein.cherry.domain.model.VoiceConfig;
import link.sharein.cherry.domain.repository.VoiceConfigRepository;
import link.sharein.cherry.network.model.VoiceConfigGroup;
import link.sharein.cherry.presentation.presenters.GeneratePresenter;
import link.sharein.cherry.presentation.presenters.base.AbstractPresenter;
import link.sharein.cherry.threading.MainThreadImpl;

/**
 * Created by jiang on 2016/3/5.
 */
public class GeneraPresenterImpl extends AbstractPresenter implements GeneratePresenter, GetAllVoiceGroupInteractor.Callback {
    private View mView;
    private VoiceConfigRepository mVoiceConfigRepository;

    public GeneraPresenterImpl(Executor executor, MainThread mainThread, View view, VoiceConfigRepository voiceConfigRepository) {
        super(executor, mainThread);
        this.mView = view;
        this.mVoiceConfigRepository = voiceConfigRepository;
        mView.showProgress();
        getAllVoiceConfigGroup();
    }

    @Override
    public void getTypeVoiceConfig(String type) {

    }

    @Override
    public void shareVoice(Voice voice) {

    }

    @Override
    public void perfromConfig(VoiceConfig voiceConfig) {

    }

    @Override
    public void getAllVoiceConfigGroup() {
        GetAllVoiceGroupInteractorImpl getAllVoiceGroupInteractor = new GetAllVoiceGroupInteractorImpl(mExecutor, mMainThread, mVoiceConfigRepository, this);
        getAllVoiceGroupInteractor.execute();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onRetrived(List<VoiceConfigGroup> voiceConfigGroupList) {
        mView.hideProgress();
        mView.showConfig(voiceConfigGroupList);
    }
}
