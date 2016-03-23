package link.sharein.cherry.application;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import org.xutils.x;

/**
 * Created by jiang on 2016/3/3.
 */
public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "83a4oLKteNQcFMBXm5XHekbi-gzGzoHsz", "HD76vn5GG5YcMl3LAMvzWSgz");
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=56d95473");
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
