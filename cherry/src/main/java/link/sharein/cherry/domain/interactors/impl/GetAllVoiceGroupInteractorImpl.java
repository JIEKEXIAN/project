package link.sharein.cherry.domain.interactors.impl;

import java.util.List;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;
import link.sharein.cherry.domain.interactors.GetAllVoiceGroupInteractor;
import link.sharein.cherry.domain.interactors.base.AbstractInteractor;
import link.sharein.cherry.domain.repository.VoiceConfigRepository;
import link.sharein.cherry.network.model.VoiceConfigGroup;

/**
 * Created by jiang on 2016/3/6.
 */
public class GetAllVoiceGroupInteractorImpl extends AbstractInteractor implements GetAllVoiceGroupInteractor {

    private Callback mCallback;
    private VoiceConfigRepository mVoiceConfigRepository;

    public GetAllVoiceGroupInteractorImpl(Executor threadExecutor, MainThread mainThread, VoiceConfigRepository voiceConfigRepository, Callback callback) {
        super(threadExecutor, mainThread);

        if (voiceConfigRepository == null || callback == null)
            throw new IllegalArgumentException("Arguments can not be null!");
        this.mVoiceConfigRepository = voiceConfigRepository;
        this.mCallback = callback;
    }

    @Override
    public void run() {
        final List<VoiceConfigGroup> list = mVoiceConfigRepository.getAllTypeGroup();
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onRetrived(list);
            }
        });

    }
}
