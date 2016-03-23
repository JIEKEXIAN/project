package link.sharein.cherry.domain.interactors.base;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.executor.MainThread;

/**
 * Created by jiang on 2016/3/3.
 */
public abstract class AbstractInteractor implements Interactor {
    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean isCanceled;
    protected volatile boolean isRunning;

    public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }

    public abstract void run();

    public void cancel() {
        isCanceled = true;
         isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void onFinished() {
        isRunning = false;
        isCanceled = false;
    }

    public void execute() {
        this.isRunning = true;
        mThreadExecutor.execute(this);
    }
}
