package link.sharein.cherry.presentation.presenters;

import link.sharein.cherry.presentation.presenters.base.BasePresenter;
import link.sharein.cherry.presentation.ui.BaseView;

/**
 * Created by jiang on 2016/3/7.
 */
public interface SharePresenter extends BasePresenter {
    interface View extends BaseView {
        void onShared(String result);
    }

    void share();
}
