package link.sharein.cherry.presentation.presenters.impl;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;
import link.sharein.cherry.domain.interactors.ShareInteractor;
import link.sharein.cherry.domain.interactors.impl.ShareInteractorImpl;
import link.sharein.cherry.domain.repository.VoiceRepository;
import link.sharein.cherry.presentation.presenters.SharePresenter;
import link.sharein.cherry.presentation.presenters.base.AbstractPresenter;

/**
 * Created by jiang on 2016/3/7.
 */
public class SharePresenterImpl extends AbstractPresenter implements SharePresenter, ShareInteractor.Callback {
    private VoiceRepository mVoiceRepository;
    private View mView;

    public SharePresenterImpl(Executor executor, MainThread mainThread, VoiceRepository voiceRepository, View view) {
        super(executor, mainThread);
        this.mView = view;
        this.mVoiceRepository = voiceRepository;
    }

    @Override
    public void share() {
        ShareInteractorImpl shareInteractor = new ShareInteractorImpl(mExecutor, mMainThread, mVoiceRepository, this);
        shareInteractor.execute();
        mView.showProgress();
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
    public void onShared(String url) {
        mView.hideProgress();
        mView.onShared(url);
    }
}
