package com.wu.material.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.wu.material.R
import com.wu.material.adapter.ViewPagerAdapter
import com.wu.material.fragment.DemoFragment


/**
 * @author wkq
 *
 * @date 2022年01月30日 13:54
 *
 *@des
 *
 */

class EntranceActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)
    }



}