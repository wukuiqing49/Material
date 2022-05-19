package com.wu.material.util.arouter

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter


/**
 * @author wkq
 *
 * @date 2022年05月17日 16:03
 *
 *@des
 *
 */

object ArouterUtil {

    fun startArouterActivity(mContext: Context) {
        ARouter.getInstance().build("/route/ArouterActivity")
            .navigation(mContext)
    }

    fun startMediaActivity(mContext: Context) {
        ARouter.getInstance().build("/rv/MediaPlayerActivity").withString("name", "测试名字数据")
            .navigation(mContext)
    }


    fun startMediaIGreenChannelInterceptorActivity(mContext: Context) {
        // 使用绿色通道(跳过所有的拦截器)
        ARouter.getInstance().build("/rv/MediaPlayerActivity").withString("name", "测试名字数据")
            .greenChannel().navigation(mContext)
    }


    fun startMediaActivity2(mContext: Context) {
        ARouter.getInstance().build("/rv/MediaPlayerActivity").withString("name", "测试名字数据")
            .navigation(mContext, object : NavigationCallback {
                override fun onFound(postcard: Postcard?) {
                    Log.e("Arouter", "onFound")
                }

                override fun onLost(postcard: Postcard?) {
                    Log.e("Arouter", "onLost")
                }

                override fun onArrival(postcard: Postcard?) {
                    Log.e("Arouter", "onArrival")
                }

                override fun onInterrupt(postcard: Postcard?) {
                    Log.e("Arouter", "onInterrupt")
                }
            })
    }

    fun getUserName(): String? {
        //方法1
        var service = ARouter.getInstance().navigation(UserService::class.java)
       var name= service.getName()

        //方法2
        var userServiceImpl =
            ARouter.getInstance().build("/service/UserSericice").navigation() as UserServiceImpl
        var userName = userServiceImpl.getName()

        return service.getName()
    }

}