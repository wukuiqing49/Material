package com.wu.material.activity.motionlayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wu.material.R
import com.wu.material.databinding.ActivityMotionLayoutBinding


/**
 * @author wkq
 *
 * @date 2022年02月06日 10:38
 *
 *@des
 *
 */

class MotionLayoutDemoActivity :AppCompatActivity() {
    var binding:ActivityMotionLayoutBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=  DataBindingUtil.setContentView<ActivityMotionLayoutBinding>(this, R.layout.activity_motion_layout)
        findViewById<Button>(R.id.bt_badge).setOnClickListener {
            startActivity(Intent(this, MothionLayoutDemo1Activity::class.java));
        }

        findViewById<Button>(R.id.bt_image_filter).setOnClickListener {
            startActivity(Intent(this, MothionImageFilterViewActivity::class.java));
        }
        findViewById<Button>(R.id.bt_Keyset).setOnClickListener {
            startActivity(Intent(this, MothionKeysetActivity::class.java));
        }
        findViewById<Button>(R.id.bt_coor).setOnClickListener {
            startActivity(Intent(this, CoordinatorLayoutActivity::class.java));
        }
        findViewById<Button>(R.id.bt_coor2).setOnClickListener {
            startActivity(Intent(this, CoordinatorLayout2Activity::class.java));
        }
        findViewById<Button>(R.id.bt_coor3).setOnClickListener {
            startActivity(Intent(this, DrawerLayoutActivity::class.java));

        }
        findViewById<Button>(R.id.bt_coor4).setOnClickListener {
            startActivity(Intent(this, SidePanelActivity::class.java));
        }
        findViewById<Button>(R.id.bt_coor5).setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java));
        }
        findViewById<Button>(R.id.bt_coor6).setOnClickListener {
            startActivity(Intent(this, SearchLayoutActivity::class.java));
        }

        findViewById<Button>(R.id.bt_coor7).setOnClickListener {
            startActivity(Intent(this, EntranceActivity::class.java));
        }
        findViewById<Button>(R.id.bt_coor8).setOnClickListener {
            startActivity(Intent(this, CarouselActivity::class.java));
        }
        findViewById<Button>(R.id.bt_coor9).setOnClickListener {
            startActivity(Intent(this, Carousel2Activity::class.java));
        }
        findViewById<Button>(R.id.bt_coor10).setOnClickListener {
            startActivity(Intent(this, MothionBallActivity::class.java));
        }
    }


}