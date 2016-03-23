package link.sharein.cherry.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import link.sharein.cherry.domain.model.Voice;
import link.sharein.cherry.domain.model.VoiceConfig;
import link.sharein.cherry.domain.repository.VoiceConfigRepository;
import link.sharein.cherry.network.converter.NetModelConverter;
import link.sharein.cherry.network.leancloud.CloudAPI;
import link.sharein.cherry.network.model.VoiceConfigGroup;

/**
 * Created by jiang on 2016/3/4.
 */
public class VoiceConfigRepositoryImpl implements VoiceConfigRepository {
    @Override
    public List<VoiceConfig> getAllConfig() {
        List<VoiceConfigGroup> groupList = getAllTypeGroup();
        return NetModelConverter.convertConfigGroupToDomainModel(groupList);
    }

    public List<VoiceConfigGroup> getAllTypeGroup() {
        String jsonConfig = CloudAPI.getVoiceConfig();
        JSONArray configs = JSON.parseArray(jsonConfig);
        List<VoiceConfigGroup> list = new ArrayList<>();
        int size = configs.size();
        for (int i = 0; i < size; i++) {
            VoiceConfigGroup configGroup = configs.getObject(i, VoiceConfigGroup.class);
            list.add(configGroup);
        }
        return list;
    }

    public static void main(String[] args) {
        String value = "[{\"type\":\"口音\",\"content\":[{ \"name\": \"女普\", \"vcn\": \"xiaoqi\", \"img\":\"http://cherry102.leanapp.cn/img/people/xiaoqi.png\"}, { \"name\": \"男普\", \"vcn\": \"xiaoyu\", \"img\":\"http://cherry102.leanapp.cn/img/people/xiaoyu.png\"}, { \"name\": \"童声\", \"vcn\": \"vinn\", \"img\":\"http://cherry102.leanapp.cn/img/people/tnns.png\" }, { \"name\": \"台普\", \"vcn\": \"vixl\", \"img\":\"http://cherry102.leanapp.cn/img/people/twpt.png\" }, { \"name\": \"粤语\", \"vcn\": \"xiaomei\", \"img\":\"http://cherry102.leanapp.cn/img/people/xiaomei.png\" }, { \"name\": \"陕西话\", \"vcn\": \"vixying\", \"img\":\"http://cherry102.leanapp.cn/img/people/sxh.png\"}, { \"name\": \"四川话\", \"vcn\": \"vixr\",\"img\":\"http://cherry102.leanapp.cn/img/people/sch.png\" }, { \"name\": \"东北话\", \"vcn\": \"vixyun\", \"img\":\"http://cherry102.leanapp.cn/img/people/dbh.png\"}, { \"name\": \"河南话\", \"vcn\": \"vixk\",\"img\":\"http://cherry102.leanapp.cn/img/people/hnh.png\" }, { \"name\": \"湖南话\", \"vcn\": \"vixqa\",\"img\":\"http://cherry102.leanapp.cn/img/people/hunh.png\" }, { \"name\": \"女英\", \"vcn\": \"catherine\", \"img\":\"http://cherry102.leanapp.cn/img/people/mary.png\" }, { \"name\": \"男英\", \"vcn\": \"henry\", \"img\":\"http://cherry102.leanapp.cn/img/people/henry.png\" }]},{\"type\":\"情感\",\"content\":[{ \"name\": \"开心\", \"vcn\": \"happy\" }, { \"name\": \"难过\", \"vcn\": \"sad\" }, { \"name\": \"生气\", \"vcn\": \"angry\" }, { \"name\": \"中立\", \"vcn\": \"neutral\" }]}]";
        JSONArray configs = JSON.parseArray(value);
        int size = configs.size();
        for (int i = 0; i < size; i++) {
            VoiceConfigGroup configGroup = configs.getObject(i, VoiceConfigGroup.class);
            System.out.println(configGroup.toString());
        }
    }

}
