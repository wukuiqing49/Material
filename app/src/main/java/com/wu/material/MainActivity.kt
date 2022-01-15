package com.wu.material

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.bt_badge).setOnClickListener {
            startActivity(Intent(this,MothionLayoutDemo1Activity::class.java));
        }

        findViewById<Button>(R.id.bt_image_filter).setOnClickListener {
            startActivity(Intent(this,MothionImageFilterViewActivity::class.java));
        }
        findViewById<Button>(R.id.bt_Keyset).setOnClickListener {
            startActivity(Intent(this,MothionKeysetActivity::class.java));
        }
    }

}