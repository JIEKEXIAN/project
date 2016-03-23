package link.sharein.cherry.network.client;

import com.avos.avoscloud.okhttp.FormEncodingBuilder;
import com.avos.avoscloud.okhttp.OkHttpClient;
import com.avos.avoscloud.okhttp.Request;
import com.avos.avoscloud.okhttp.RequestBody;
import com.avos.avoscloud.okhttp.Response;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by jiang on 2016/3/3.
 */
public class HttpClient {
    private static volatile OkHttpClient okHttpClient = new OkHttpClient();
    public static final String BASE_URL = "http://cherry102.leanapp.cn/tts";

    public static String post(Map<String, String> values) {
        String result = null;
        FormEncodingBuilder builder = new FormEncodingBuilder();
        Set<Map.Entry<String, String>> entrySet = values.entrySet();
        for (Map.Entry<String, String> entery : entrySet) {
            String name = entery.getKey();
            String value = entery.getValue();
            builder.add(name, value);
        }
        Request request = new Request.Builder().url(BASE_URL).post(builder.build()).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
