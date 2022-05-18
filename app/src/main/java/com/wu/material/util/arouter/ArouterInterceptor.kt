package com.wu.material.util.arouter

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter


/**
 * @author wkq
 *
 * @date 2022年05月18日 9:16
 *
 *@des
 *
 */

// 比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
@Interceptor(priority = 10, name = "测试拦截器")
class ArouterInterceptor : IInterceptor {

    var mContext: Context? = null

    // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
    override fun init(context: Context?) {
        mContext = context
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        Log.e("传递的数据", "")
        if (postcard != null) {
            var service = ARouter.getInstance().navigation(UserService::class.java)
            //跳转过程中添加数据以及处理数据
            postcard!!.extras.putString("uid", service.getUid())
        }
        if (callback != null) {
            //传递到页面
            callback!!.onContinue(postcard);
        }
        // 觉得有问题，中断路由流程
        // callback.onInterrupt(new RuntimeException("我觉得有点异常"));

        // 以上两种至少需要调用其中一种，否则不会继续路由
    }


}