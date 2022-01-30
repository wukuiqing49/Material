package com.wu.material.activity

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

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        initVp()
    }

    private fun initVp() {

        var vp = ViewPagerAdapter(supportFragmentManager)
        vp.addPageFragment(DemoFragment(), "List")
        vp.addPageFragment(DemoFragment(), "Type2")
        vp.addPageFragment(DemoFragment(), "Type3")
        vp.addPageFragment(DemoFragment(), "Type4")
        var pager = findViewById<ViewPager>(R.id.pager)
        var tabs = findViewById<TabLayout>(R.id.tabs)
        var motion_layout = findViewById<MotionLayout>(R.id.motion_layout)
        pager.adapter = vp
        tabs.setupWithViewPager(pager)

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val progress = (position + positionOffset) / (vp.count - 1)
                motion_layout.progress = progress
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }


}