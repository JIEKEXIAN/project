package link.sharein.cherry.domain.interactors.impl;

import android.content.Context;
import android.os.Bundle;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;
import link.sharein.cherry.domain.interactors.PlayVoiceInteractor;
import link.sharein.cherry.domain.interactors.base.AbstractInteractor;
import link.sharein.cherry.domain.model.Voice;
import link.sharein.cherry.domain.repository.VoiceRepository;

/**
 * Created by jiang on 2016/3/6.
 */
public class PlayVoiceInteractorImpl extends AbstractInteractor implements PlayVoiceInteractor, SynthesizerListener {
    private VoiceRepository mVoicRepository;
    private Callback mCallback;
    private Context mContext;

    public PlayVoiceInteractorImpl(Context context, Executor threadExecutor, MainThread mainThread, VoiceRepository voiceRepository, Callback callback) {
        super(threadExecutor, mainThread);
        this.mVoicRepository = voiceRepository;
        this.mCallback = callback;
        this.mContext = context;
    }

    @Override
    public void run() {
        SpeechSynthesizer synthesizer = SpeechSynthesizer.createSynthesizer(mContext, null);
        synthesizer.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
        synthesizer.setParameter(SpeechConstant.VOICE_NAME, mVoicRepository.getConfiged().getVcn());
        synthesizer.setParameter(SpeechConstant.SPEED, "50");
        synthesizer.setParameter(SpeechConstant.VOLUME, "80");
        synthesizer.startSpeaking(mVoicRepository.getConfiged().getContent(), this);
    }

    @Override
    public void onSpeakBegin() {

    }

    @Override
    public void onBufferProgress(int i, int i1, int i2, String s) {

    }

    @Override
    public void onSpeakPaused() {

    }

    @Override
    public void onSpeakResumed() {

    }

    @Override
    public void onSpeakProgress(int i, int i1, int i2) {

    }

    @Override
    public void onCompleted(SpeechError speechError) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onPlayFinish();
            }
        });
    }

    @Override
    public void onEvent(int i, int i1, int i2, Bundle bundle) {

    }
}
