package com.wu.material.util;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author wkq
 * @date 2022年03月03日 10:49
 * @des 保存文件
 */

public class FileSaveUtil {

    /**
     * 判断android Q  (10 ) 版本
     *
     * @return
     */
    public static boolean isAdndroidQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    /**
     * 复制文件
     *
     * @param oldPathName
     * @param newPathName
     * @return
     */
    public static boolean copyFile(String oldPathName, String newPathName) {
        try {
            File oldFile = new File(oldPathName);
            if (!oldFile.exists()) {
                return false;
            } else if (!oldFile.isFile()) {
                return false;
            } else if (!oldFile.canRead()) {
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(oldPathName);
            FileOutputStream fileOutputStream = new FileOutputStream(newPathName);
            byte[] buffer = new byte[1024];
            int byteRead;
            while (-1 != (byteRead = fileInputStream.read(buffer))) {
                fileOutputStream.write(buffer, 0, byteRead);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 根据 Android Q 区分地址
     *
     * @param context
     * @return
     */
    public static String getPath(Context context) {
        // equalsIgnoreCase() 忽略大小写
        String fileName = "";
        if (Build.VERSION.SDK_INT >= 29) {
            fileName = context.getExternalFilesDir("").getAbsolutePath() + "/current/";
        } else {
            if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) { // 小米手机
                fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
            } else if ("HUAWEI".equalsIgnoreCase(Build.BRAND)) {
                fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
            } else if ("HONOR".equalsIgnoreCase(Build.BRAND)) {
                fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
            } else if ("OPPO".equalsIgnoreCase(Build.BRAND)) {
                fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
            } else if ("vivo".equalsIgnoreCase(Build.BRAND)) {
                fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
            } else if ("samsung".equalsIgnoreCase(Build.BRAND)) {
                fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
            } else {
                fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/";
            }
        }
        File file = new File(fileName);
        if (file.mkdirs()) {
            return fileName;
        }
        return fileName;
    }


    /**
     * 插入相册 部分机型适配(区分手机系统版本 Android Q)
     *
     * @param context
     * @param filePath
     * @return
     */
    public static boolean insertMediaPic(Context context, String filePath) {
        if (TextUtils.isEmpty(filePath)) return false;
        File file = new File(filePath);
        //判断android Q  (10 ) 版本
        if (isAdndroidQ()) {
            if (file == null || !file.exists()) {
                return false;
            } else {
                try {
                    MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), file.getName(), null);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } else {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DATA, file.getAbsolutePath());
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.ImageColumns.DATE_TAKEN, System.currentTimeMillis() + "");
            context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getAbsolutePath())));
            return true;
        }

    }

}
