package link.sharein.cherry.network.leancloud;

import com.avos.avoscloud.AVCloud;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;

/**
 * Created by jiang on 2016/3/3.
 */
public class CloudAPI {

    public static final String json = "[{\"type\":\"口音\",\"content\":[{ \"name\": \"女普\", \"vcn\": \"xiaoqi\", \"img\":\"http://cherry102.leanapp.cn/img/people/xiaoqi.png\"}, { \"name\": \"男普\", \"vcn\": \"xiaoyu\", \"img\":\"http://cherry102.leanapp.cn/img/people/xiaoyu.png\"}, { \"name\": \"童声\", \"vcn\": \"vinn\", \"img\":\"http://cherry102.leanapp.cn/img/people/tnns.png\" }, { \"name\": \"台普\", \"vcn\": \"vixl\", \"img\":\"http://cherry102.leanapp.cn/img/people/twpt.png\" }, { \"name\": \"粤语\", \"vcn\": \"xiaomei\", \"img\":\"http://cherry102.leanapp.cn/img/people/xiaomei.png\" }, { \"name\": \"陕西话\", \"vcn\": \"vixying\", \"img\":\"http://cherry102.leanapp.cn/img/people/sxh.png\"}, { \"name\": \"四川话\", \"vcn\": \"vixr\",\"img\":\"http://cherry102.leanapp.cn/img/people/sch.png\" }, { \"name\": \"东北话\", \"vcn\": \"vixyun\", \"img\":\"http://cherry102.leanapp.cn/img/people/dbh.png\"}, { \"name\": \"河南话\", \"vcn\": \"vixk\",\"img\":\"http://cherry102.leanapp.cn/img/people/hnh.png\" }, { \"name\": \"湖南话\", \"vcn\": \"vixqa\",\"img\":\"http://cherry102.leanapp.cn/img/people/hunh.png\" }, { \"name\": \"女英\", \"vcn\": \"catherine\", \"img\":\"http://cherry102.leanapp.cn/img/people/mary.png\" }, { \"name\": \"男英\", \"vcn\": \"henry\", \"img\":\"http://cherry102.leanapp.cn/img/people/henry.png\" }]},{\"type\":\"情感\",\"content\":[{ \"name\": \"开心\", \"vcn\": \"happy\",\"img\":\"http://cherry102.leanapp.cn/img/people/xiaoai_happy.png\" }, { \"name\": \"难过\", \"vcn\": \"sad\",\"img\":\"http://cherry102.leanapp.cn/img/people/xiaoai_sad.png\" }, { \"name\": \"生气\", \"vcn\": \"angry\",\"img\":\"http://cherry102.leanapp.cn/img/people/xiaoai_angry.png\" }, { \"name\": \"中立\", \"vcn\": \"nautral\",\"img\":\"http://cherry102.leanapp.cn/img/people/xiaoai_nautral.png\" }]}, {\"type\":\"人物\",\"content\": [{ \"name\": \"小瑞\", \"vcn\": \"aisxrui\",\"img\":\"http://cherry102.leanapp.cn/img/people/liruiying.png\" }, { \"name\": \"小辉\", \"vcn\": \"aisxhui\",\"img\":\"http://cherry102.leanapp.cn/img/people/kanghui.png\" }, { \"name\": \"小淳\", \"vcn\": \"aisxchun\",\"img\":\"http://cherry102.leanapp.cn/img/people/lizhengchun.png\" }, { \"name\": \"小英\", \"vcn\": \"aisjying\",\"img\":\"http://cherry102.leanapp.cn/img/people/zhangyunying.png\" }, { \"name\": \"小宏\", \"vcn\": \"xiaohong20\",\"img\":\"http://cherry102.leanapp.cn/img/people/hongshu.png\" }, { \"name\": \"小叶\", \"vcn\": \"yefang\",\"img\":\"http://cherry102.leanapp.cn/img/people/yefang.png\" }, { \"name\": \"小孟\", \"vcn\": \"aismengchun\",\"img\":\"http://cherry102.leanapp.cn/img/people/mengchun.png\" }, { \"name\": \"小丸子\", \"vcn\": \"aisxwz\",\"img\":\"http://cherry102.leanapp.cn/img/people/xiaowanzi.png\" }, { \"name\": \"小新\", \"vcn\": \"vixx\",\"img\":\"http://cherry102.leanapp.cn/img/people/xiaoxin.png\" }, { \"name\": \"鸭先生\", \"vcn\": \"aisduck\",\"img\":\"http://cherry102.leanapp.cn/img/people/tanglaoya.png\" }, { \"name\": \"楠楠\", \"vcn\": \"aisnn\",\"img\":\"http://cherry102.leanapp.cn/img/people/nannan.png\" }, { \"name\": \"子琪\", \"vcn\": \"ziqi\",\"img\":\"http://cherry102.leanapp.cn/img/people/dengziqi.png\" }]}]";

    public static String getVoiceConfig() {
        String result = null;
//        try {
//            result = AVCloud.callFunction("tts", null);
//        } catch (AVException e) {
//            e.printStackTrace();
//        }
        return json;
    }
}
