package link.sharein.cherry.domain.executor;

/**
 * Created by jiang on 2016/3/3.
 */
public interface MainThread {
    void post(final Runnable runnable);
}
