package com.wu.material

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

/**
 * @author wkq
 *
 * @date 2022年01月24日 13:56
 *
 *@des
 *
 */

class CoordinatorLayoutActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mothion_coordinator_layout)
        //显示路径
        var motionLayout = findViewById<MotionLayout>(R.id.ml)
        motionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_PATH)


        var appBarLayout = findViewById<AppBarLayout>(R.id.app_layout)
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                //绑定 MotionLayout偏移量
                motionLayout.progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
            }
        })
    }


}