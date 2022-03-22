package com.wu.material.util

import android.content.Context
import android.os.Build
import android.os.Parcelable
import android.text.TextUtils
import com.getkeepsafe.relinker.ReLinker
import com.tencent.mmkv.MMKV
import com.tencent.mmkv.MMKV.LibLoader


/**
 * @author wkq
 *
 * @date 2022年03月22日 9:19
 *
 *@des  腾讯 MMKV 数据存储工具类  默认明文存储(encode各式存储)
 *
 */

object MmkvUtils {

    /**
     * 初始化
     */
    fun initMmkv(context: Context) {
        if (context == null) return
        var dir = context.getFilesDir().getAbsolutePath() + "/mmkv"
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            // 兼容版本19 更新 找不到库问题
            MMKV.initialize(dir,
                LibLoader { libName -> ReLinker.loadLibrary(context, libName) })
        } else {
            MMKV.initialize(context)
        }

    }

    fun initMmkv(context: Context, path: String) {
        if (context == null) return
        if (TextUtils.isEmpty(path)) initMmkv(context)
        //自定义存储位置
        try {
            MMKV.initialize(context, path)
        }catch (e:Exception){
            // 兼容版本19 更新 找不到库问题
            MMKV.initialize(path,
                LibLoader { libName -> ReLinker.loadLibrary(context, libName) })
        }


    }


//   存储数据


    /**
     * 存储常规数据
     */
    fun put(key: String, content: Any?): Boolean {
        if (TextUtils.isEmpty(key) || content == null) return false
        var mmkv = MMKV.defaultMMKV();
        try {
            if (content is String) {
                mmkv.encode(key, content!!)
            } else if (content is Double) {
                mmkv.encode(key, content!!)
            } else if (content is Float) {
                mmkv.encode(key, content!!)
            } else if (content is Int) {
                mmkv.encode(key, content!!)
            } else if (content is Parcelable) {
                mmkv.encode(key, content!!)
            } else if (content is ByteArray) {
                mmkv.encode(key, content!!)
            } else if (content is Long) {
                mmkv.encode(key, content!!)
            } else if (content is Boolean) {
                mmkv.encode(key, content!!)
            } else {
                return false
            }
        } catch (exception: Exception) {
            return false
        }
        return true
    }

    /**
     * 存储set集合
     */
    fun putSet(key: String, content: Set<String>): Boolean {
        if (TextUtils.isEmpty(key) || content == null) return false
        var mmkv = MMKV.defaultMMKV();
        mmkv.encode(key, content!!)
        return true
    }


//   获取数据   int 0  Double 0.0  float 0
    /**
     * 获取String 数据
     */
    fun getString(key: String): String {
        var mmkv = MMKV.defaultMMKV();
        return mmkv.decodeString(key) ?: ""
        String.format("", "%s /天")
    }

    fun getString(key: String, defult: String): String {
        var mmkv = MMKV.defaultMMKV();
        if (TextUtils.isEmpty(mmkv.decodeString(key))) return defult
        return mmkv.decodeString(key) ?: ""
    }

    fun getDouble(key: String): Double {
        var mmkv = MMKV.defaultMMKV();
        return mmkv.decodeDouble(key)
    }

    fun getDouble(key: String, defult: Double): Double {
        var mmkv = MMKV.defaultMMKV();
        if (mmkv.decodeDouble(key) == 0.0) return defult
        return mmkv.decodeDouble(key)
    }

    fun getFloat(key: String): Float {
        var mmkv = MMKV.defaultMMKV();
        return mmkv.decodeFloat(key)
    }

    fun getFloat(key: String, defult: Float): Float {
        var mmkv = MMKV.defaultMMKV();
        if (mmkv.decodeDouble(key) == 0.0) return defult
        return mmkv.decodeFloat(key)
    }

    fun getInt(key: String): Int {
        var mmkv = MMKV.defaultMMKV();
        return mmkv.decodeInt(key)
    }

    fun getInt(key: String, defult: Int): Int {
        var mmkv = MMKV.defaultMMKV();
        if (mmkv.decodeInt(key) == 0) return defult
        return mmkv.decodeInt(key)
    }

    fun getByteArray(key: String): ByteArray? {
        var mmkv = MMKV.defaultMMKV()
        return mmkv.decodeBytes(key) ?: null
    }

    fun getByteArray(key: String, defult: Int): ByteArray? {
        var mmkv = MMKV.defaultMMKV();
        return mmkv.decodeBytes(key) ?: null
    }

    fun getParcelable(key: String, clazz: Class<Parcelable>): Parcelable? {
        var mmkv = MMKV.defaultMMKV()
        return mmkv.decodeParcelable(key, clazz) ?: null
    }

    fun getSet(key: String): Set<String>? {
        var mmkv = MMKV.defaultMMKV()
        return mmkv.decodeStringSet(key) ?: null
    }

    //   删除数据
    fun remove(key: String) {
        var mmkv = MMKV.defaultMMKV()
        mmkv.removeValueForKey(key)
    }
    // 删除多个数据
    fun remove(vararg key: String) {
        var mmkv = MMKV.defaultMMKV()
        var keys = arrayOfNulls<String>(key.size)
        key.forEachIndexed { index, content ->
            keys.set(index, content)
        }
        mmkv.removeValuesForKeys(keys)
    }

    // 清理所有数据
    fun clearAll() {
        var mmkv = MMKV.defaultMMKV()
        mmkv.clearAll()
    }


    //加密
    fun jmMMKV(key: String) {
        var kv = MMKV.mmkvWithID("MyID", MMKV.SINGLE_PROCESS_MODE, key)
    }

}