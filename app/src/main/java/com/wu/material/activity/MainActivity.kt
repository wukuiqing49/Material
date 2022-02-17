package com.wu.material.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wu.material.R
import com.wu.material.activity.constraint.ConstraintLayoutDemoActivity
import com.wu.material.activity.livedata.LiveDataActivity
import com.wu.material.activity.motionlayout.*
import com.wu.material.activity.rv.RecyclerViewActivity
import com.wu.material.databinding.ActivityMainBinding

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
            startActivity(Intent(this, RecyclerViewActivity::class.java));
        }


    }

}