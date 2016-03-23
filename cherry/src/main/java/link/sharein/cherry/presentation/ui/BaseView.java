package link.sharein.cherry.presentation.ui;

/**
 * Created by jiang on 2016/3/4.
 */
public interface BaseView {
    void showProgress();

    void hideProgress();

    void showError(String message);
}
