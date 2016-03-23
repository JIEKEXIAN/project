package link.sharein.cherry.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

import link.sharein.cherry.R;

public class MainActivity extends AppCompatActivity implements SynthesizerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AndroidShare androidShare = new AndroidShare(this, "分享测试http://cherry102.leanapp.cn/voice/1457028684448vixx", "http://cherry102.leanapp.cn/img/cherry.jpg");
//        androidShare.show();

        SpeechSynthesizer synthesizer = SpeechSynthesizer.createSynthesizer(this, null);
        synthesizer.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
        synthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
        synthesizer.setParameter(SpeechConstant.SPEED, "50");
        synthesizer.setParameter(SpeechConstant.VOLUME, "80");
        synthesizer.startSpeaking("hello,饶大奇", this);

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

    }

    @Override
    public void onEvent(int i, int i1, int i2, Bundle bundle) {

    }
}
