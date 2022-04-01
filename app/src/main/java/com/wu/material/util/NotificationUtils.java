package com.wu.material.util;

/**
 * @author wkq
 * @date 2022年04月01日 16:44
 * @des
 */
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;

import com.wu.material.R;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
public class NotificationUtils {




    /**
     * 创建：wukuiqing
     * <p>
     * 时间：2018/4/4
     * <p>
     * 描述：  Notification
     */

        Notification.Builder builder;
        //通知Id
        int mNotificationID = 0x10000;
        //记录消息发送的时间
        long notificationTime = 0;
        private static NotificationUtils instance;
        long[] pattern = {100, 400, 100, 400};   // 停止 开启 停止 开启

        public static NotificationUtils getInstance() {
            if (instance == null) instance = new NotificationUtils();
            return instance;
        }

        /**
         * 这是版本更新用的 不能手动销毁掉的 Nitification  setOngoing未true
         *
         * @param mContext
         * @param NotificationID id
         * @param title          标题
         * @param content        内容
         */
        public void initNotification(Context mContext, int NotificationID, String title, String content) {
            mNotificationID = NotificationID;
            NotificationManager mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            if (mNotificationManager == null) return;
            //26(O版本)版本以上需要增加 channel
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    NotificationChannel channel = new NotificationChannel(2 + "", "版本更新", NotificationManager.IMPORTANCE_DEFAULT);
                    channel.enableLights(true);
                    channel.setLightColor(Color.GREEN);
                    channel.setShowBadge(true);
                    channel.enableVibration(true);
                    channel.setDescription("网家家 版本更新");
                    channel.setVibrationPattern(pattern);
                    channel.setLightColor(Color.GREEN);
                    channel.setLockscreenVisibility(Notification.FLAG_ONLY_ALERT_ONCE);
                    mNotificationManager.createNotificationChannel(channel);
                    builder = new Notification.Builder(mContext, 2 + ""); //与channelId对应
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

            builder.setTicker(title);
            builder.setContentTitle(title);
            builder.setContentText(content);
            builder.setWhen(System.currentTimeMillis());//设置通知时间，一般设置的是收到通知时的System.currentTimeMillis()
            builder.setNumber(0);
            builder.setOngoing(true);  //设置 只能代码调用取消
            builder.setProgress(100, 0, false);
            builder.setOnlyAlertOnce(true);//设置只展示一次
        }

        /**
         * 设置普通的 notification(设置角标)
         *
         * @param mContext
         * @param NotificationID id
         * @param title          标题
         * @param content        内容
         * @param mclass         跳转的页面
         */
        public void initOrdinaryNotification(Context mContext, int NotificationID, int number, String title, String content, String targetId, String chatType, String specialGroupData, Class mclass) {
            initOrdinaryNotification(mContext, NotificationID, number, title, content, targetId, chatType, specialGroupData, mclass, null);
        }

        public void initOrdinaryNotification(Context mContext, int NotificationID, int number, String title, String content, String targetId, String chatType, String specialGroupData, Class mclass, boolean showBigTextStyle) {
            initOrdinaryNotification(mContext, NotificationID, number, title, content, targetId, chatType, specialGroupData, mclass, null, showBigTextStyle);
        }


        public void initOrdinaryNotification(Context mContext, int NotificationID, int number, String title, String content, String targetId, String chatType, String specialGroupData, Class mclass,
                                             Class mainClass) {
            initOrdinaryNotification(mContext, NotificationID, number, title, content, targetId, chatType, specialGroupData, mclass, mainClass, false);
        }

        public void initOrdinaryNotification(Context mContext, int NotificationID, int number, String title, String content, String targetId, String chatType, String specialGroupData, Class mclass,
                                             Class mainClass, boolean showBigTextStyle) {
            List<Intent> intents = new ArrayList<Intent>();

            if (mainClass != null) {
                Intent intentMain = new Intent(mContext, mainClass);
                intentMain.putExtra("showFirstTab", true);
                intents.add(intentMain);
            }

            if (null != targetId && !"".equals(targetId)) {
                Intent intent = new Intent(mContext, mclass);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("targetId", targetId);
                intent.putExtra("chatType", chatType);
                intent.putExtra("conversationName", title);
                intent.putExtra("specialGroupData", specialGroupData);
                intents.add(intent);
            } else {
                Intent intent = new Intent(mContext, mclass);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intents.add(intent);
            }
            initOrdinaryNotification(mContext, NotificationID, number, title, content, targetId, chatType, specialGroupData, intents.toArray(new Intent[]{}), showBigTextStyle);
        }

        public void initOrdinaryNotification(Context mContext, int NotificationID, int number, String title, String content, String targetId, String chatType, String specialGroupData, Intent[] intents) {
            initOrdinaryNotification(mContext, NotificationID, number, title, content, targetId, chatType, specialGroupData, intents, false);
        }

        public void initOrdinaryNotification(Context mContext, int NotificationID, int number, String title, String content, String targetId, String chatType, String specialGroupData, Intent[] intents, boolean showBigTextStyle) {
            initOrdinaryNotification(mContext, NotificationID, number, title, content, targetId, chatType, specialGroupData, intents, showBigTextStyle, null);
        }

        public void initOrdinaryNotification(Context mContext, int NotificationID, int number, String title, String content, String targetId, String chatType, String specialGroupData, Intent[] intents, boolean showBigTextStyle, String summary) {
            NotificationManager mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            Notification.Builder mBulider = null;
            if (mNotificationManager == null) return;
            if (null == title || "".equals(title)) {
                title = "新消息";
            }

            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    if (NotificationID == -1) this.mNotificationID = NotificationID;
                    if (TextUtils.isEmpty(title)) title = "中国 网家家";
                    NotificationChannel channel = new NotificationChannel(mNotificationID + "",
                            "消息", NotificationManager.IMPORTANCE_DEFAULT);
                    channel.enableLights(true);
                    channel.setLightColor(Color.GREEN);
                    channel.setShowBadge(true);
                    channel.enableVibration(true);
                    channel.setDescription("会话消息通知");
                    channel.setVibrationPattern(pattern);
                    if (channel != null) {
                        mNotificationManager.createNotificationChannel(channel);
                        mBulider = new Notification.Builder(mContext, mNotificationID + "");
                        mBulider.setShowWhen(true);
                    }

                } catch (Exception e) {
                    Log.e("推送适配8.0异常*************:", e.getMessage());
                }
            } else {
                mBulider = new Notification.Builder(mContext); //与channelId对应
                if (Build.VERSION.SDK_INT > 16) {
                    mBulider.setShowWhen(true);
                }
            }

            PendingIntent pi = PendingIntent.getActivities(mContext, 0, intents, PendingIntent.FLAG_CANCEL_CURRENT);
            //处理 多个通知同时触发的状况 一秒内通知不触发 设置声音的操作
            if (System.currentTimeMillis() - notificationTime > 1000)
                mBulider.setDefaults(Notification.DEFAULT_SOUND);
            else
                mBulider.setDefaults(Notification.DEFAULT_VIBRATE);
            Uri notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            mBulider

                    .setTicker(title)
                    .setWhen(System.currentTimeMillis())//设置通知时间，一般设置的是收到通知时的System.currentTimeMillis()
                    .setContentTitle(title)
                    .setContentText(content)
                    .setSound(notificationUri)
                    .setContentIntent(pi);
            if (showBigTextStyle) {
                //创建大文本样式
                Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                bigTextStyle
                        .setBigContentTitle(title)
                        .bigText(content);
                if (!TextUtils.isEmpty(summary)) bigTextStyle.setSummaryText(summary);
                mBulider.setStyle(bigTextStyle); //设置大文本样式
            }

            NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notification = mBulider.build();    //创建通知栏对象，显示通知信息
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(NotificationID, notification);

//        Notification notification = mBulider.build();    //创建通知栏对象，显示通知信息
//        notification.flags |= Notification.FLAG_AUTO_CANCEL;
//        BadgeUtil.sendBadgeNotification(notification, NotificationID, mContext, number, 0);  //设置角标

            notificationTime = System.currentTimeMillis();
        }

        /**
         * Notification 更新进度
         *
         * @param progress
         */
        public void upProgress(Context context, int progress) {
            // 这里是处理 Notification 频繁更新卡顿问题.(部分手机可以开线程 小部分手机不兼容 华为p8 不兼容)
            if (progress % 5 == 0) {
                builder.setProgress(100, progress, false);
                NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                if (mNotificationManager != null)
                    mNotificationManager.notify(mNotificationID, builder.build());
            }
        }

        /**
         * 代码取消 Notification
         *
         * @param context
         */
        public void cancleNotification(Context context) {
            if (context == null) return;
            try {
                NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                if (mNotificationManager != null) mNotificationManager.cancel(mNotificationID);
                if (builder != null) builder = null;
            } catch (Exception e) {
            }


        }

        /**
         * 代码取消 Notification
         *
         * @param context
         */
        public void cancleNotification(Context context, int notificationId) {
            if (context == null) return;
            try {
                NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                if (mNotificationManager != null) mNotificationManager.cancel(notificationId);
                if (builder != null) builder = null;
            } catch (Exception e) {
            }


        }

        /**
         * 代码取消App发送的所有Notification(不包含app进程结束后 小米sdk 华为sdk 魅族sdk 发送的离线推送)
         *
         * @param context
         */
        public void cancleAllNotification(Context context) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.cancelAll();
            } catch (Exception e) {

            }

        }

        /**
         * 拉起 App安装器
         *
         * @param mContext
         * @param content
         * @param apkFile  文件
         */
        public void updateSucess(Context mContext, String content, File apkFile) {
            Intent installIntent = new Intent(Intent.ACTION_VIEW);
            installIntent.setAction(Intent.ACTION_VIEW);
            installIntent.addCategory(Intent.CATEGORY_DEFAULT);
            installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //判读版本是否在7.0以上
                String authority = mContext.getApplicationInfo().packageName + ".fileprovider";
                //添加这一句表示对目标应用临时授权该Uri所代表的文件
                installIntent.setDataAndType(FileProvider.getUriForFile(mContext, authority, apkFile), "application/vnd.android.package-archive");
                installIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                installIntent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            }
            //隐式意图拉起安装器
            PendingIntent mPendingIntent = PendingIntent.getActivity(mContext, 0, installIntent, 0);
            builder.setContentText(content);
            builder.setContentIntent(mPendingIntent);
            NotificationManager mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            if (mNotificationManager != null)
                mNotificationManager.notify(mNotificationID, builder.build());
            mContext.startActivity(installIntent);// 下载完成之后自动弹出安装界面
            cancleNotification(mContext);
        }

        /**
         * 判断通知是否开启
         *
         * @param context
         * @return
         */
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public boolean isNotificationEnabled(Context context) {
            ApplicationInfo appInfo = context.getApplicationInfo();
            String pkg = context.getApplicationContext().getPackageName();
            int uid = appInfo.uid;
            if (Build.VERSION.SDK_INT >= 26) {
                return isEnableV26(context, pkg, uid);
            } else {
                return isEnableV19(context, pkg, uid);
            }

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        private static boolean isEnableV19(Context context, String pkg, int uid) {
            try {
                String CHECK_OP_NO_THROW = "checkOpNoThrow";
                String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
                Class appOpsClass = null;
                AppOpsManager mAppOps = null;
                mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
                appOpsClass = Class.forName(AppOpsManager.class.getName());
                Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE,
                        Integer.TYPE, String.class);
                Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);

                int value = (Integer) opPostNotificationValue.get(Integer.class);
                return ((Integer) checkOpNoThrowMethod.invoke(mAppOps, value, uid, pkg) ==
                        AppOpsManager.MODE_ALLOWED);
            } catch (Exception e) {
                return true;
            }
        }

        private static boolean isEnableV26(Context context, String pkg, int uid) {
            try {
                NotificationManager notificationManager = (NotificationManager)
                        context.getSystemService(Context.NOTIFICATION_SERVICE);
                Method sServiceField = notificationManager.getClass().getDeclaredMethod("getService");
                sServiceField.setAccessible(true);
                Object sService = sServiceField.invoke(notificationManager);

                Method method = sService.getClass().getDeclaredMethod("areNotificationsEnabledForPackage"
                        , String.class, Integer.TYPE);
                method.setAccessible(true);
                return (boolean) method.invoke(sService, pkg, uid);
            } catch (Exception e) {
                return true;
            }
        }

        /**
         * 设置通知权限
         *
         * @param context
         */
        public void gotoSet(Context context) {
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT >= 26) {
                // android 8.0引导
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            } else if (Build.VERSION.SDK_INT >= 21) {
                // android 5.0-7.0
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", context.getPackageName());
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            } else {
                // 其他
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }

