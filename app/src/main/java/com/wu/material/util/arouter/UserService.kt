package com.wu.material.util.arouter

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author wkq
 *
 * @date 2022年05月17日 16:45
 *
 *@des  创建服务
 *
 */
interface UserService:IProvider {
    fun getUid():String?
    fun getName():String?
    fun getFace():String?
}