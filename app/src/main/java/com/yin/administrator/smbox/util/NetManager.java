package com.yin.administrator.smbox.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;

import com.tandong.sa.json.Gson;
import com.tandong.sa.json.reflect.TypeToken;
import com.tandong.sa.loopj.AsyncHttpClient;
import com.tandong.sa.loopj.FileAsyncHttpResponseHandler;
import com.yin.administrator.smbox.activity.MainActivity;
import com.yin.administrator.smbox.bean.Props;

import org.apache.http.Header;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Created by Administrator on 2016/4/13 0013.
 */
public class NetManager {
    private static NetManager manager;
    private static String url = "http://yin-sm.oss-cn-shanghai.aliyuncs.com/sm%2Fjson%2Fsm_props_content_json.txt";
    private static String imgBase = "http://yin-sm.oss-cn-shanghai.aliyuncs.com/sm%2Fimage%2Fprops%2F";
    private static String path;
    private static List<Props> propses;

    public NetManager() {
        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
    }

    public static synchronized NetManager getInstance() {
        if (manager == null) {
            manager = new NetManager();
        }
        return manager;
    }

    public void init(Activity activity) {
        initPropsData(activity);
    }

    public List<Props> getPropsData() {
        return propses;
    }

    private void initPropsData(final Activity activity) {
        final String apkPath = path + "11.txt";
        File file = new File(apkPath);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new FileAsyncHttpResponseHandler(file) {
            @Override
            public void onFailure(int i, Header[] headers, Throwable throwable, File file) {
                System.out.println(00000);
            }

            @Override
            public void onSuccess(int i, Header[] headers, File file) {
                BufferedReader br = null;
                String line;
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    br = new BufferedReader(new FileReader(file));
                    while ((line = br.readLine()) != null) {
                        stringBuffer.append(line);
                    }
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                propses = gson.fromJson(stringBuffer.toString(), new TypeToken<List<Props>>() {
                }.getType());
                for (int j = 1; j <= propses.size(); j++) {
                    propses.get(j - 1).setImgUrl(imgBase + j + ".jpg");
                }
                activity.startActivity(new Intent(activity, MainActivity.class));
                activity.finish();
            }
        });
    }
}
