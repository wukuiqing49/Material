package com.wu.material.util.arouter

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route


/**
 * @author wkq
 *
 * @date 2022年05月17日 16:46
 *
 *@des  实现服务
 *
 */
// 注解
@Route(path = "/service/UserSericice")
class UserServiceImpl:UserService {
    override fun getUid(): String? {
        return nickUid
    }

    override fun getName(): String? {
        return nickName
    }

    override fun getFace(): String? {
        return nickFace
    }
    var nickName=""
    var nickFace=""
    var nickUid=""
    override fun init(context: Context?) {
        nickName="我是测试"
        nickFace="我是头像"
        nickUid="10010"
    }


}