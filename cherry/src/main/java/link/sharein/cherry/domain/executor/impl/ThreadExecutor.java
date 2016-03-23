package link.sharein.cherry.domain.executor.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import link.sharein.cherry.domain.executor.Executor;
import link.sharein.cherry.domain.interactors.base.AbstractInteractor;

/**
 * Created by jiang on 2016/3/3.
 */
public class ThreadExecutor implements Executor {

    private static volatile ThreadExecutor instance;

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();
    private ThreadPoolExecutor mThreadPoolExecutor;

    public static Executor getInstance() {
        if (instance == null)
            instance = new ThreadExecutor();
        return instance;
    }

    private ThreadExecutor() {
        long keepAlive = KEEP_ALIVE_TIME;
        mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, keepAlive, TimeUnit.SECONDS, WORK_QUEUE);
    }

    @Override
    public void execute(final AbstractInteractor interactor) {
        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                interactor.run();
                interactor.onFinished();
            }
        });
    }
}
