package com.wu.material.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import com.wu.material.R;

/**
 * @author wkq
 * @date 2022年04月01日 16:46
 * @des
 */

public class NotificationUtil {
    private  static  Notification.Builder builder;
    //通知Id
    private  static   int mNotificationID = 0x10000;
    //记录消息发送的时间
    private  long notificationTime = 0;
    private static NotificationUtils instance;
    static long[] pattern = {100, 400, 100, 400};   // 停止 开启 停止 开启

      public static void initNotification(Context mContext,  String title, String content) {
        NotificationManager mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (mNotificationManager == null) return;
        //26(O版本)版本以上需要增加 channel
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                NotificationChannel channel = new NotificationChannel(mNotificationID+ "", "新消息", NotificationManager.IMPORTANCE_DEFAULT);
                channel.enableLights(true);
                channel.setLightColor(Color.GREEN);
                channel.setShowBadge(true);
                channel.enableVibration(true);
                channel.setDescription("新消息");
                channel.setVibrationPattern(pattern);
                channel.setLightColor(Color.GREEN);
                channel.setLockscreenVisibility(Notification.FLAG_ONLY_ALERT_ONCE);
                mNotificationManager.createNotificationChannel(channel);
                builder = new Notification.Builder(mContext, mNotificationID + ""); //与channelId对应
            } catch (Exception e) {
                Log.e("推送适配8.0异常*************:", e.getMessage());
            }
        } else {
            builder = new Notification.Builder(mContext); //与channelId对应
            if (Build.VERSION.SDK_INT > 16) {
                //设置显示时间
                builder.setShowWhen(true);
            }
        }
          builder.setSmallIcon(R.drawable.nt_icon);
        builder.setTicker(title);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setWhen(System.currentTimeMillis());
        builder.setNumber(0);
        builder.setOngoing(false);
        builder.setOnlyAlertOnce(true);
          mNotificationManager.notify(1,builder.build());
    }
}
