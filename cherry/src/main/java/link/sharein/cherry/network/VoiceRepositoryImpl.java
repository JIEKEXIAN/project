package link.sharein.cherry.network;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

import link.sharein.cherry.domain.model.Voice;
import link.sharein.cherry.domain.repository.VoiceRepository;
import link.sharein.cherry.network.client.HttpClient;

/**
 * Created by jiang on 2016/3/4.
 */
public class VoiceRepositoryImpl implements VoiceRepository {
    private Voice configedVoice;

    @Override
    public String upload(Voice voice) {
        Map<String, String> map = new HashMap<>();
        map.put("content", voice.getContent());
        map.put("vcn", voice.getVcn());
        String result = HttpClient.post(map);
        voice.setUrl(result);
        return result;
    }

    @Override
    public Voice getConfiged() {
        return configedVoice;
    }

    @Override
    public void setConfiged(Voice voice) {
        this.configedVoice = voice;
    }
}
