package link.sharein.cherry.domain.interactors.impl;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;
import link.sharein.cherry.domain.interactors.GetAllVoiceGroupInteractor;
import link.sharein.cherry.domain.interactors.ShareInteractor;
import link.sharein.cherry.domain.interactors.base.AbstractInteractor;
import link.sharein.cherry.domain.repository.VoiceRepository;

/**
 * Created by jiang on 2016/3/7.
 */
public class ShareInteractorImpl extends AbstractInteractor implements ShareInteractor {

    private VoiceRepository mVoiceRepository;
    private Callback mCallback;

    public ShareInteractorImpl(Executor threadExecutor, MainThread mainThread, VoiceRepository voiceRepository, Callback callback) {
        super(threadExecutor, mainThread);
        this.mVoiceRepository = voiceRepository;
        this.mCallback = callback;
    }

    @Override
    public void run() {
        final String url = mVoiceRepository.upload(mVoiceRepository.getConfiged());
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onShared(url);
            }
        });
    }
}
