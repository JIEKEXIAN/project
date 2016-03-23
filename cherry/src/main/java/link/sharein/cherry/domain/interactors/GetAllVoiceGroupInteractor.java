package link.sharein.cherry.domain.interactors;

import java.util.List;

import link.sharein.cherry.domain.interactors.base.Interactor;
import link.sharein.cherry.network.model.VoiceConfigGroup;

/**
 * Created by jiang on 2016/3/6.
 */
public interface GetAllVoiceGroupInteractor extends Interactor {
    interface Callback {
        void onRetrived(List<VoiceConfigGroup> voiceConfigGroupList);
    }
}
