package com.wu.material.application

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle

/**
 * @author wkq
 * @date 2022年05月12日 14:22
 * @des
 */
open class BaseActivityLifecycle : ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        currentActivityName = activity.javaClass.name
        ++numRunning
    }

    override fun onActivityStarted(activity: Activity) {
        currentActivityName = activity.javaClass.name
        ++activeCount
        if (!isActive) {
            isActive = true
        }
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivityName = activity.javaClass.name
    }

    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {
        --activeCount
        if (activeCount == 0 && isActive) {
            isActive = false
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {
        --numRunning
    }

    companion object {
        var isActive = false
            private set
        private var activeCount = 0
        var numRunning = 0
            private set
        var currentActivityName: String? = null
            private set
    }
}