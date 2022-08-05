package com.wu.material.application

import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.baidu.mapapi.CoordType
import com.baidu.mapapi.SDKInitializer
import com.taobao.sophix.SophixManager
import com.wu.material.BuildConfig
import com.wu.material.util.MmkvUtils


/**
 * @author wkq
 *
 * @date 2022年03月17日 16:59
 *
 *@des Application 初始化操作
 *
 */

class MaterialApplication : MultiDexApplication()  {


    companion object{
        var appOnline = false
    }
    override fun onCreate() {
        super.onCreate()
        initBaiduMap()
        initMMKV()
        initArouter()
        //应用程序Activity前后端判断
        registerActivityLifecycleCallbacks(ActivityLifecycle())
        //热修复 初始化
        SophixStubUtil.init(this@MaterialApplication, packageName)
        SophixManager.getInstance().queryAndLoadNewPatch()

    }

    /**
     * 初始化路由
     */
    private fun initArouter() {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        //阿里router需要释放
        ARouter.getInstance().destroy()
    }


    //初始化腾讯MMKV(数据存储)
    private fun initMMKV() {
        MmkvUtils.initMmkv(this)
    }

    //初始化百度地图
    private fun initBaiduMap() {
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
//        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
//        SDKInitializer.setCoordType(CoordType.BD09LL);
    }


}