package com.wu.material.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.wkq.flow.FlowLayout
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

        initFlow(binding)
        binding.tvSophix.text="热更新--->基础数据"
        binding.tvArouter.text=    ArouterUtil.getUserName()
    }
    var lists= arrayListOf<String>("LiveData学习","路由数据","MotionLayout学习","ConstraintLayout学习","RecyclerView","携程下载图片","Fragment懒加载一",
        "Fragment懒加载二","三方库使用","音频播放","路由Arouter","通知")
    private fun initFlow(binding: ActivityMainBinding?) {

        binding!!.fl.addLabels(lists)
        binding!!.fl.addLabelsListener(object : FlowLayout.FlowLayoutLabelslListener{
            override fun onLabelsClick(content: Any) {
                processClick(content)
                Toast.makeText(this@MainActivity,content.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun processClick(content: Any) {
       when(content as String){

        "通知" ->{  NotificationUtil.initNotification(this,"1111","222") }
        "路由Arouter" ->{      ArouterUtil.startArouterActivity(this) }
        "MotionLayout学习" ->{    startActivity(Intent(this, MotionLayoutDemoActivity::class.java));}
        "RecyclerView" ->{    startActivity(Intent(this, RecyclerHomeActivityActivity::class.java)); }
        "ConstraintLayout学习" ->{     startActivity(Intent(this, ConstraintLayoutDemoActivity::class.java));}
        "携程下载图片" ->{   startActivity(Intent(this, CoroutinesActivity::class.java)); }
        "音频播放" ->{   ArouterUtil.startMediaActivity(this)}
        "Fragment懒加载二" ->{   startActivity(Intent(this, LazyLoadingFragmentActivity::class.java)); }
        "Fragment懒加载一" ->{   startActivity(Intent(this, LazyLoadingFragmentActivity2::class.java));}
        "三方库使用" ->{   startActivity(Intent(this, OtherActivity::class.java)); }
        "LiveData学习" ->{   startActivity(Intent(this, LiveDataActivity::class.java));}
       }
    }


}