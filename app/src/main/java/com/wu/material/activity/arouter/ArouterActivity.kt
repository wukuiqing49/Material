package com.wu.material.activity.arouter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.wu.material.R
import com.wu.material.databinding.ActivityArouterBinding
import com.wu.material.util.arouter.ArouterUtil
import com.wu.material.util.arouter.UserService
import com.wu.material.util.arouter.UserServiceImpl


/**
 * @author wkq
 *
 * @date 2022年05月18日 13:16
 *
 *@des
 *
 */
@Route(path = "/route/ArouterActivity")
class ArouterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding =
            DataBindingUtil.setContentView<ActivityArouterBinding>(this, R.layout.activity_arouter)

        binding.btService.setOnClickListener {

            //方法1
            var service = ARouter.getInstance().navigation(UserService::class.java)
            var name= service.getName()
            //方法2
            var userServiceImpl =
                ARouter.getInstance().build("/service/UserSericice").navigation() as UserServiceImpl
            var userName = userServiceImpl.getName()
            binding.tvName.text = userName
        }

        binding.btJumpActivity.setOnClickListener {
            ArouterUtil.startMediaActivity(this)
        }

        binding.btCallback.setOnClickListener {
            ArouterUtil.startMediaActivity2(this)
        }

        binding.btInterceptor.setOnClickListener {
            Toast.makeText(this,"ArouterInterceptor 是拦截器加注释就可以了",Toast.LENGTH_LONG).show()
        }

    }


}