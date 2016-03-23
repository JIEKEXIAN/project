package link.sharein.cherry.domain.interactors;

import link.sharein.cherry.domain.interactors.base.Interactor;

/**
 * Created by jiang on 2016/3/7.
 */
public interface ShareInteractor extends Interactor {
    interface Callback {
        void onShared(String url);
    }
}
