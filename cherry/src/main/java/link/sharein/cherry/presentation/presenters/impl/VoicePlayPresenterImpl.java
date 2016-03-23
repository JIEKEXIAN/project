package link.sharein.cherry.presentation.presenters.impl;

import android.content.Context;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;
import link.sharein.cherry.domain.interactors.PlayVoiceInteractor;
import link.sharein.cherry.domain.interactors.impl.PlayVoiceInteractorImpl;
import link.sharein.cherry.domain.repository.VoiceRepository;
import link.sharein.cherry.presentation.presenters.VoicePlayPresenter;
import link.sharein.cherry.presentation.presenters.base.AbstractPresenter;

/**
 * Created by jiang on 2016/3/6.
 */
public class VoicePlayPresenterImpl extends AbstractPresenter implements VoicePlayPresenter, PlayVoiceInteractor.Callback {
    private Context mContext;
    private VoiceRepository mVoiceRepository;
    private View mView;

    public VoicePlayPresenterImpl(Context context, Executor executor, MainThread mainThread, VoiceRepository voiceRepository, View view) {
        super(executor, mainThread);
        this.mContext = context;
        this.mVoiceRepository = voiceRepository;
        this.mView = view;
    }

    @Override
    public void playVoice() {
        PlayVoiceInteractorImpl playVoiceInteractor = new PlayVoiceInteractorImpl(mContext, mExecutor, mMainThread, mVoiceRepository, this);
        playVoiceInteractor.execute();
    }

    @Override
    public void canclePlay() {

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
    public void onPlayFinish() {
        mView.onPlayFinished();
    }
}
