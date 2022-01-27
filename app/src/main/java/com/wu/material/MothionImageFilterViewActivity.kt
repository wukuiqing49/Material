package com.wu.material

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils


/**
 * @author wkq
 *
 * @date 2021年11月04日 16:40
 *
 *@des  触摸平移动画
 *
 */

class MothionImageFilterViewActivity :AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mothion_image_filter)

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