package com.wu.material.application

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.wu.material.activity.MainActivity

class ActivityLifecycle : BaseActivityLifecycle() {
    private val TAG = javaClass.name

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        super.onActivityCreated(activity, savedInstanceState)
    }

    override fun onActivityStarted(activity: Activity) {
        super.onActivityStarted(activity)
        if (isActive) {
            //重置双击时间
        }
    }

    override fun onActivityResumed(activity: Activity) {
        super.onActivityResumed(activity)
        if (!MaterialApplication.appOnline) {
            SophixStubUtil.cancelExitApp()
        }
    }

    override fun onActivityStopped(activity: Activity) {
        super.onActivityStopped(activity)
        if (!isActive) {
            SophixStubUtil.exitApp(if (activity is MainActivity) 5000 else 10000.toLong())
        }
    }

}