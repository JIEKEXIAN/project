package link.sharein.cherry.presentation.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

import link.sharein.cherry.R;

public class EditActivity extends BaseActivity implements SynthesizerListener {
    private EditText editText;
    public static final String CONTENT_TEXT = "content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final String[] words = getResources().getStringArray(R.array.words);
        editText = (EditText) findViewById(R.id.editText);

        findViewById(R.id.generate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(EditActivity.this, "还没有输入任何文本哟！", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(EditActivity.this, GenerateActivity.class);
                intent.putExtra(CONTENT_TEXT, content);
                startActivity(intent);
            }
        });

        findViewById(R.id.newWords).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = (int) (Math.random() * 1000);
                int index = value % 10;
                Log.d(TAG, "onClick: " + index);
                editText.setText(words[index]);
            }
        });
    }

    private static final String TAG = "EditActivity";

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
