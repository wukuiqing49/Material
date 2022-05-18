package com.wu.material.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wu.material.R
import com.wu.material.activity.constraint.ConstraintLayoutDemoActivity
import com.wu.material.activity.lazy.LazyLoadingFragmentActivity
import com.wu.material.activity.lazy.LazyLoadingFragmentActivity2
import com.wu.material.activity.livedata.LiveDataActivity
import com.wu.material.activity.motionlayout.MotionLayoutDemoActivity
import com.wu.material.activity.other.OtherActivity
import com.wu.material.activity.rv.RecyclerHomeActivityActivity
import com.wu.material.databinding.ActivityMainBinding
import com.wu.material.util.arouter.ArouterUtil
import com.wu.material.util.NotificationUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.btMotionLayout.setOnClickListener {
            startActivity(Intent(this, MotionLayoutDemoActivity::class.java));
        }
        binding.btConstraint.setOnClickListener {
            startActivity(Intent(this, ConstraintLayoutDemoActivity::class.java));
        }
        binding.btLive.setOnClickListener {
            startActivity(Intent(this, LiveDataActivity::class.java));
        }
        binding.btRv.setOnClickListener {
            startActivity(Intent(this, RecyclerHomeActivityActivity::class.java));
        }

        binding.btRv4.setOnClickListener {
            startActivity(Intent(this, CoroutinesActivity::class.java));
        }

        binding.btRv6.setOnClickListener {
            startActivity(Intent(this, LazyLoadingFragmentActivity::class.java));
        }
        binding.btRv7.setOnClickListener {
            startActivity(Intent(this, LazyLoadingFragmentActivity2::class.java));
        }
        binding.btRv8.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java));
        }
        binding.btMedia.setOnClickListener {
            ArouterUtil.startMediaActivity(this)
        }
        binding.btArouter.setOnClickListener {
            ArouterUtil.startArouterActivity(this)
        }
        binding.btTz.setOnClickListener {
//            startActivity(Intent(this, DragAndDropActivity::class.java));
            NotificationUtil.initNotification(this,"1111","222")
        }


        binding.tvSophix.text="热更新--->基础数据"
        binding.tvArouter.text=    ArouterUtil.getUserName()


    }

}