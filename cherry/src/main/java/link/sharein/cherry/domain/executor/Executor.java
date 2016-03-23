package link.sharein.cherry.domain.executor;

import link.sharein.cherry.domain.interactors.base.AbstractInteractor;
import link.sharein.cherry.domain.interactors.base.Interactor;

/**
 * Created by jiang on 2016/3/3.
 */
public interface Executor {
    void execute(final AbstractInteractor interactor);
}
