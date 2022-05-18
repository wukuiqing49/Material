package com.wu.material.util.arouter

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService


/**
 * @author wkq
 *
 * @date 2022年05月18日 10:57
 *
 *@des
 *
 */
@Route(path = "/xxx/xxx")
class ArouterDegradeService: DegradeService {
    var mContext: Context? = null
    override fun init(context: Context?) {
        mContext = context
    }

    override fun onLost(context: Context?, postcard: Postcard?) {
        Log.e("传递的数据", "")
    }


}