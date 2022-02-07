package com.wu.material.activity.motionlayout

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.wu.material.R


/**
 * @author wkq
 *
 * @date 2021年11月04日 16:40
 *
 *@des  触摸平移动画
 *
 */

class MothionKeyCycleActivity :AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_cycle)
        setShowLines()
    }

    /**
     * 设置展示动画路径
     */
    private fun setShowLines() {
       var motionLayout= findViewById<MotionLayout>(R.id.motionLayout)
        motionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_PATH)
    }


}