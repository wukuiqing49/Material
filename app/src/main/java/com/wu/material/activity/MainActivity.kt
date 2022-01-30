package com.wu.material.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wu.material.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }

}