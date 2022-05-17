package com.wu.material.util

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.wu.material.util.arouter.UserService


/**
 * @author wkq
 *
 * @date 2022年05月17日 16:03
 *
 *@des
 *
 */

object ArouterUtil {

    fun startMediaActivity(mContext: Context) {
        ARouter.getInstance().build("/rv/MediaPlayerActivity").navigation(mContext)
    }

    fun getUserName(): String? {
        var service = ARouter.getInstance().navigation(UserService::class.java)
        return service.getName()
    }

}