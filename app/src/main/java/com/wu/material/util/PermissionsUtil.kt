package com.wu.material.util

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.text.TextUtils
import androidx.core.app.ActivityCompat
import java.util.ArrayList


/**
 * @author wkq
 *
 * @date 2022年03月18日 9:14
 *
 *@des
 *
 */

object PermissionsUtil {

    /**
     * 校验权限
     */
    fun checkPermissions(
        activity: Activity?,
        permissions: Array<String>,
        requestCode: Int
    ): Boolean { //Android6.0以下默认有权限
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return true
        val needList: MutableList<String> = ArrayList()
        var needShowRationale = false
        val length = permissions.size
        for (i in 0 until length) {
            val permisson = permissions[i]
            if (TextUtils.isEmpty(permisson)) continue
            if (ActivityCompat.checkSelfPermission(activity!!, permisson)
                != PackageManager.PERMISSION_GRANTED
            ) {
                needList.add(permisson)
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        activity,
                        permisson
                    )
                ) needShowRationale = true
            }
        }
        return if (needList.size != 0) {
            if (needShowRationale) {
                //
                return false
            }
            ActivityCompat.requestPermissions(activity!!, needList.toTypedArray(), requestCode)
            false
        } else {
            true
        }
    }

    /**
     * 判断权限
     */
    fun onRequestPermissionsResult(
        activity: Activity?,
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ): BooleanArray? {
        var result = true
        var isNerverAsk = false
        val length = grantResults.size
        for (i in 0 until length) {
            val permission = permissions[i]
            val grandResult = grantResults[i]
            if (grandResult == PackageManager.PERMISSION_DENIED) {
                result = false
                if (!ActivityCompat.shouldShowRequestPermissionRationale(
                        activity!!,
                        permission!!
                    )
                ) isNerverAsk = true
            }
        }
        return booleanArrayOf(result, isNerverAsk)
    }

}