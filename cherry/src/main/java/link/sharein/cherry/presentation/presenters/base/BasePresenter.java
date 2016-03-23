package link.sharein.cherry.presentation.presenters.base;

/**
 * Created by jiang on 2016/3/4.
 */
public interface BasePresenter {
    void resume();

    void pause();

    void stop();

    void destory();

    void onError(String message);
}
