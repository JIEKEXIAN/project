package link.sharein.cherry;

import android.app.Application;
import android.test.mock.MockApplication;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import link.sharein.cherry.application.AndroidApplication;
import link.sharein.cherry.network.client.HttpClient;
import link.sharein.cherry.network.leancloud.CloudAPI;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    public void testUpload() {
        Map<String, String> map = new HashMap<>();
        map.put("content", "hello");
        map.put("vcn", "xiaoyan");
        String result = HttpClient.post(map);
        System.out.print(result);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("content", "饶大奇是傻逼");
        map.put("vcn", "xiaoyan");
        String result = HttpClient.post(map);
        System.out.print(result);
    }

}