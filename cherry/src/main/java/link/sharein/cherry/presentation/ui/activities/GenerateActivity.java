package link.sharein.cherry.presentation.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;
import cn.sharesdk.onekeyshare.themes.classic.ClassicTheme;
import link.sharein.cherry.R;
import link.sharein.cherry.domain.executor.impl.ThreadExecutor;
import link.sharein.cherry.domain.model.Voice;
import link.sharein.cherry.domain.model.VoiceConfig;
import link.sharein.cherry.domain.repository.VoiceRepository;
import link.sharein.cherry.network.VoiceConfigRepositoryImpl;
import link.sharein.cherry.network.VoiceRepositoryImpl;
import link.sharein.cherry.network.converter.NetModelConverter;
import link.sharein.cherry.network.model.VoiceConfigGroup;
import link.sharein.cherry.presentation.presenters.GeneratePresenter;
import link.sharein.cherry.presentation.presenters.SharePresenter;
import link.sharein.cherry.presentation.presenters.VoicePlayPresenter;
import link.sharein.cherry.presentation.presenters.impl.GeneraPresenterImpl;
import link.sharein.cherry.presentation.presenters.impl.SharePresenterImpl;
import link.sharein.cherry.presentation.presenters.impl.VoicePlayPresenterImpl;
import link.sharein.cherry.presentation.ui.adapters.EmotionAdapter;
import link.sharein.cherry.presentation.ui.adapters.VoiceConfigAdapter;
import link.sharein.cherry.threading.MainThreadImpl;
import link.sharein.cherry.utils.ConnectUtil;

public class GenerateActivity extends BaseActivity implements GeneratePresenter.View, ViewPager.OnPageChangeListener, VoicePlayPresenter.View, SharePresenter.View {
    private RadioGroup radioGroup;
    private RadioButton accent, emotion, person;
    private ViewPager configPager;
    private ImageButton shareButton;
    private VoiceConfigAdapter[] configAdapters;
    private int[] radioButtonIds;
    private String text;
    private VoiceConfig choosedConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        text = getIntent().getStringExtra(EditActivity.CONTENT_TEXT);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        accent = (RadioButton) findViewById(R.id.accent);
//        emotion = (RadioButton) findViewById(R.id.emotion);
//        person = (RadioButton) findViewById(R.id.person);
        configPager = (ViewPager) findViewById(R.id.configPager);
        shareButton = (ImageButton) findViewById(R.id.shareButton);
        GeneraPresenterImpl generaPresenter = new GeneraPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this, new VoiceConfigRepositoryImpl());
        setPresenter(generaPresenter);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShareClick();
            }
        });
    }

    private void initRadioGroup(List<VoiceConfigGroup> configs) {
        radioGroup.removeAllViews();
        int firstId = 0;
        radioButtonIds = new int[configs.size()];
        RadioGroup.LayoutParams layoutPrams = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        layoutPrams.gravity = Gravity.CENTER;
        int margin = getResources().getDimensionPixelOffset(R.dimen.radio_group_margin);
        layoutPrams.setMargins(margin, margin, margin, margin);
        for (int i = 0; i < configs.size(); i++) {
            String type = configs.get(i).getType();
            int id = type.hashCode();
            if (i == 0)
                firstId = id;
            RadioButton radioButton = (RadioButton) LayoutInflater.from(this).inflate(R.layout.custom_radio_button, null);
            radioButton.setText(type);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setId(id);
            radioButton.setLayoutParams(layoutPrams);
            radioButtonIds[i] = id;
            radioGroup.addView(radioButton);
        }
        radioGroup.check(firstId);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                configPager.setCurrentItem(getRadioButtonPostion(checkedId));
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {

    }

    private int getRadioButtonPostion(int id) {
        for (int i = 0; i < radioButtonIds.length; i++) {
            if (id == radioButtonIds[i])
                return i;
        }
        return 0;
    }

    private void initViewPager(List<VoiceConfigGroup> configs) {
        configAdapters = new VoiceConfigAdapter[configs.size()];
        List<View> viewList = new ArrayList<>(configs.size());
        for (int i = 0; i < configs.size(); i++) {
            RecyclerView recyclerView = new RecyclerView(this);
            recyclerView.setBackgroundColor(Color.argb(0, 0, 0, 0));
            VoiceConfigAdapter adapter = new VoiceConfigAdapter(this, this);
            configAdapters[i] = adapter;
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            recyclerView.setAdapter(adapter);
            adapter.addConfigs(configs.get(i));
            viewList.add(recyclerView);
        }
        EmotionAdapter emotionAdapter = new EmotionAdapter(viewList);
        configPager.setAdapter(emotionAdapter);
        configPager.addOnPageChangeListener(this);
    }

    @Override
    public void showConfig(List<VoiceConfigGroup> configs) {
        initRadioGroup(configs);
        initViewPager(configs);
    }

    @Override
    public void onConfigTypeClick(String type) {

    }

    @Override
    public void onConfigClick(VoiceConfig config) {
        if (!ConnectUtil.isConnected(this)) {
            showError("网络开小差了~~不能播放哦");
        }
        choosedConfig = config;
        VoiceRepository voiceRepository = new VoiceRepositoryImpl();
        Voice voice = new Voice();
        voice.setContent(text);
        voice.setVcn(config.getVcn());
        voiceRepository.setConfiged(voice);
        VoicePlayPresenter voicePlayPresenter = new VoicePlayPresenterImpl(this, ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), voiceRepository, this);
        voicePlayPresenter.playVoice();
        for (int i = 0; i < configAdapters.length; i++) {
            configAdapters[i].notifyDataSetChanged();
        }
    }

    @Override
    public void onShareClick() {
        if (!ConnectUtil.isConnected(this)) {
            showError("网络开小差了~~不能分享哦");
            return;
        }
        if (choosedConfig == null)
            choosedConfig = NetModelConverter.convertToDomainModel(configAdapters[0].getVoiceConfigGroup().getContent().get(0));
        VoiceRepository voiceRepository = new VoiceRepositoryImpl();
        Voice voice = new Voice();
        voice.setContent(text);
        voice.setVcn(choosedConfig.getVcn());
        voiceRepository.setConfiged(voice);
        SharePresenterImpl sharePresenter = new SharePresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), voiceRepository, this);
        sharePresenter.share();
    }

    @Override
    public VoiceConfig getConfiged() {
        return choosedConfig;
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        radioGroup.check(radioButtonIds[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPlayFinished() {

    }

    @Override
    public void onPlayCancled() {

    }

    @Override
    public void onShared(String result) {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setText("我用cherry说了句话，快来听吧");
        oks.setImageUrl("http://ac-83a4olkt.clouddn.com/bc2fc28bcd7f3c17.jpg");
        oks.setUrl(result);
        oks.setSite(getString(R.string.app_name));
        oks.setSiteUrl(result);
        oks.setTitleUrl(result);
        oks.setTitle(getString(R.string.app_name));
        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                showError("分享成功啦~~");
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                showError("哎呀，分享出错了~~");
            }

            @Override
            public void onCancel(Platform platform, int i) {
                showError("你没有分享给大家哦~~");
            }
        });
        // 启动分享GUI
        oks.show(this);

    }
}
