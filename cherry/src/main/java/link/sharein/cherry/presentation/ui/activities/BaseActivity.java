package link.sharein.cherry.presentation.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import link.sharein.cherry.presentation.presenters.base.BasePresenter;

/**
 * Created by jiang on 2016/3/5.
 */
public class BaseActivity extends AppCompatActivity {
    protected BasePresenter mBasePresenter;
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mBasePresenter != null)
            mBasePresenter.resume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBasePresenter != null)
            mBasePresenter.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mBasePresenter != null)
            mBasePresenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBasePresenter != null)
            mBasePresenter.destory();
    }

    protected void setPresenter(BasePresenter basePresenter) {
        this.mBasePresenter = basePresenter;
    }
}
