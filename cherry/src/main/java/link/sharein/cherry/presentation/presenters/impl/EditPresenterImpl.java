package link.sharein.cherry.presentation.presenters.impl;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;
import link.sharein.cherry.presentation.presenters.EditPresenter;
import link.sharein.cherry.presentation.presenters.base.AbstractPresenter;

/**
 * Created by jiang on 2016/3/5.
 */
public class EditPresenterImpl extends AbstractPresenter implements EditPresenter {
    public EditPresenterImpl(Executor executor, MainThread mainThread,View view) {
        super(executor, mainThread);
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
}
