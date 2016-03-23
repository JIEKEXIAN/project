package link.sharein.cherry.presentation.presenters;

import link.sharein.cherry.presentation.presenters.base.BasePresenter;
import link.sharein.cherry.presentation.ui.BaseView;

/**
 * Created by jiang on 2016/3/4.
 */
public interface EditPresenter extends BasePresenter {
    interface View extends BaseView {
        void onClickGenerate(String text);

        void onClickHelp();
    }
}
