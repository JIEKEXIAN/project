package link.sharein.cherry.presentation.presenters.base;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;
import link.sharein.cherry.domain.interactors.base.AbstractInteractor;

/**
 * Created by jiang on 2016/3/5.
 */
public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
