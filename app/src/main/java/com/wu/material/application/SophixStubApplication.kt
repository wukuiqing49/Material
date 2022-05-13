package com.wu.material.application

import android.content.Context
import android.util.Log
import androidx.annotation.Keep
import androidx.multidex.MultiDex
import com.taobao.sophix.PatchStatus
import com.taobao.sophix.SophixApplication
import com.taobao.sophix.SophixEntry
import com.taobao.sophix.SophixManager
import com.taobao.sophix.listener.PatchLoadStatusListener


/**
 * @author wkq
 *
 * @date 2022年05月12日 13:34
 *
 *@des
 *
 */

class SophixStubApplication : SophixApplication() {

    var TAG = "热修复"

    var SOPHIX_AS_RESTART = "SOPHIX_AS_RESTART"

    @Keep
    @SophixEntry(MaterialApplication::class)
    internal class RealApplicationStub

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        // 如果需要使用MultiDex，需要在此处调用。
        MultiDex.install(this)
        try {
            initSophix()
        } catch (e: Exception) {
            Log.i("Strike", "热修复功能初始化失败！", e)
        }
    }

    // 热修复
    private fun initSophix() {
        var instance = SophixManager.getInstance();
        val sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE)

        val packageName = this.packageName
        val appVersion = packageManager.getPackageInfo(packageName, 0).versionName
        val appId = "333707573-1"
        val appSecret = "c2ac57bf90524901a6c930a1b76ce116"
        val appRSA =
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCUNA5v6ePImog3YFuk7F+VByQs68BcjeXnOa/aMdbK8uR+BfKDcXymXc0LznRRTJhil7uWwm2dIBkQgP5zRP0A1X5DbETeewqFmmV+pKXMIup6+ZiBbRSGBcE4hUGu/SKCXa6+6TOsV0nGsc9WoGZyD86Enns44585F226zYb1uKJR1SnPSJ1uQV/zZkBhAOrDcg2VqggJUBJBzu3PtM0dxzgvyY1XW1ZIGqG0lrQ4d18bGpcmSWK9IeHu2kgcQG20tdSC1YbOjdnYp0VOLDlei9zX/DGUH4VJQBHiCa31tILUPR9lI7ciZJNTR6g4LJcDlugxNYCGV+BtT5eLBqlbAgMBAAECggEAOAxL3XU16PrQQykU35VpPIIb40UxVY9wf/boE3u/wLcFRMfZBG7Z9k0JK8rjYI+4HalGj2hubfrin8Q49r0DddpHyxXaIc2kmAxhD/kSntYhmWpli6UGGv14Knjy80vWTjlByf+FxEqqoxNB14AH3mEt+Ce7cDNdVwkOPZRW0vxt/5cLLGog+D8h+UD6Rum5oLpUCwNZGZRQh184YAhnDZ5TN1jMt4q/iVuthyBGY51uIjhAad5cAUSgAmIzOZy+dMAxJ5FFB/Esj2J8ZS+L2ulGaeeSCjIJE0IBeL6j1eCqF+9B67tc58D0j1OWHdh9z7M4nBkO4aqqn+Ymo7XRkQKBgQD30ge6httFC38CPvuO4ZAs8VDObsx3wIBeQhIe6rF0vCpEW6ePFYpUz3S/32ucRf2N+3IIqsDvpm2nNfxHA3wfxAQwgVElEElG4Wz2VD96bTeYmKsalEMEeRf4DBHgp+f3dEUiswu9ng6eaFhobBBEdqgGqARmUS9fxedX7mOQgwKBgQCZGE6j9IiENQWqmVB+dDE5VAk2wD6aDmXFAOL5zuljVGNm5So0NhvrgDI19ohQ8/79M0zEoAGmOwYk+th42eKebXrovyuxO1EeUQav8lq3aygGXY9KZetyOcyPLygAKF9b0zl2iN5NYB/Ulef5H30t7s8LWqIEb/RetSL1B2F8SQKBgDCQdTlFcjTeot4iz5NZerKD+8zog6M4Ey/ljL2ISoxQz4uj1ntAwmIKYZu0QddXE/A+BUPTiomsOLLa7nxQH4PuGtASl39G6MU+Kec/7UylmI6L5IQJ5/Q5cswGOX6oCNpCa8X4BmX7UmwSkLit7KYuBpF/XZVbdYg0NTjTG6nXAoGAc3IM+z4PJAMHvtnWBUWBSQXB3POjQXDR9XjxsAcDn8+nFZSB+tVCwJfvRRofOUyFYFIq9arjE4M24vP2AUvsxCMyqAhg3kkopn/bVxqepem8SPCMeUHaBkznoKGivFu1bP0fO++CEz8FQb25K/c+4kBPCPTTcB0sXa6iKbvjG2ECgYEA0KpWqDlLCrF0JSLq4vYG26yv65loXWQckqHMLZWaps5jFP9RT8r7Pr6psRxXsd8jRvbU3hoLVWwAzXCzdDX/o2jOLKGyfPennJbpSTs98w2c349CJGYlGbbkWmXq3V+cSOtoCcDTPuEmnmD3wpPnTwTCykFYXWBmvbRxV4NR484="
        instance.setContext(this)
            .setAppVersion(appVersion)
            .setSecretMetaData(appId, appSecret, appRSA)
                //注意debug relase 版本区分
            .setEnableDebug(true)
            .setEnableFullLog()
            .setPatchLoadStatusStub(object : PatchLoadStatusListener {
                override fun onLoad(mode: Int, code: Int, info: String?, handlePatchVersion: Int) {
                    val tag = "mode %s code %s info %s version %s"
                    Log.i(TAG, "状态回调 ： " + String.format(tag, mode, code, info, handlePatchVersion))
                    if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                        Log.i(TAG, "热修复 加载 成功!")
                    } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                        Log.i(TAG, "热修复 安装 成功，等待重启.")
                        sharedPreferences?.edit()
                            ?.putBoolean(SOPHIX_AS_RESTART, true)?.apply()
                    } else if (code == PatchStatus.CODE_REQ_CLEARPATCH) {
                        Log.i(TAG, "热修复 回滚 成功，等待重启.")
                    } else if (code == PatchStatus.CODE_REQ_NOUPDATE) {
                        Log.i(TAG, "热修复 没有 可更新补丁!")
                        sharedPreferences?.edit()
                            ?.putBoolean(SOPHIX_AS_RESTART, false)?.apply()
                    }
                }

            }).initialize()
    }

}