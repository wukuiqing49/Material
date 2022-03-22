package com.wu.material.application

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.baidu.mapapi.CoordType
import com.baidu.mapapi.SDKInitializer
import com.tencent.mmkv.MMKV
import com.wu.material.util.MmkvUtils


/**
 * @author wkq
 *
 * @date 2022年03月17日 16:59
 *
 *@des Application 初始化操作
 *
 */

class MaterialApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initBaiduMap()
        initMMKV()

    }

    //初始化腾讯MMKV(数据存储)
    private fun initMMKV() {
        MmkvUtils.initMmkv(this)
    }

    //初始化百度地图
    private fun initBaiduMap() {
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);

    }


}