package com.yin.administrator.smbox.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.tandong.sa.activity.SmartActivity;
import com.tandong.sa.zUImageLoader.cache.disc.naming.Md5FileNameGenerator;
import com.tandong.sa.zUImageLoader.cache.memory.MemoryCache;
import com.tandong.sa.zUImageLoader.cache.memory.impl.LRULimitedMemoryCache;
import com.tandong.sa.zUImageLoader.cache.memory.impl.LruMemoryCache;
import com.tandong.sa.zUImageLoader.core.ImageLoader;
import com.tandong.sa.zUImageLoader.core.ImageLoaderConfiguration;
import com.tandong.sa.zUImageLoader.core.assist.QueueProcessingType;
import com.yin.administrator.smbox.R;
import com.yin.administrator.smbox.util.NetManager;

/**
 * Created by yinjianan on 2015/3/13.
 */
public class WelcomeActivity extends SmartActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        int memoryCacheSize;

        MemoryCache memoryCache;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            int memClass = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE))
                    .getMemoryClass();
            memoryCacheSize = (memClass / 8) * 1024 * 1024; // 1/8 of app memory
            // limit
            memoryCache = new LruMemoryCache(memoryCacheSize);
        } else {
            memoryCacheSize = 2 * 1024 * 1024;
            memoryCache = new LRULimitedMemoryCache(memoryCacheSize);
        }
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .memoryCache(memoryCache)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        ImageLoader.getInstance().init(config);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                init();
            }
        }, 1000);

    }

    private void init() {
        NetManager.getInstance().init(this);
    }
}
