package com.wu.material.activity.motionlayout

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wu.material.R

/**
 * @author wkq
 *
 * @date 2022年01月24日 13:56
 *
 *@des  侧滑效果(未处理 仅仅能展示顶部动画效果)
 *
 */

class SidePanelActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side_panel)
    }


}