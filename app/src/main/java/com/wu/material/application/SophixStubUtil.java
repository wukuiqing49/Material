package com.wu.material.application;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.taobao.sophix.SophixManager;

public class SophixStubUtil {

    private static final String SOPHIX_AS_RESTART = "SOPHIX_AS_RESTART";

    private static final Handler handler = new Handler();

    private static SharedPreferences sharedPreferences;

    private static final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (sharedPreferences == null) return;
            if (sharedPreferences.getBoolean(SOPHIX_AS_RESTART, false)) {
                sharedPreferences.edit().putBoolean(SOPHIX_AS_RESTART, false).apply();
                Log.i("SopHix", "退出 检查 需要重启！");
                SophixManager.getInstance().killProcessSafely();
            } else {
                Log.i("SopHix", "退出 检查 没有补丁！");
            }
        }
    };

    public static void init(Context context, String packageName) {
        if (context == null || TextUtils.isEmpty(packageName)) return;
        sharedPreferences = context.getSharedPreferences(packageName, Context.MODE_PRIVATE);
    }

    public static void cancelExitApp() {
        handler.removeCallbacks(runnable);
    }

    public static void exitApp(long time) {
        handler.postDelayed(runnable, time);
    }


}
