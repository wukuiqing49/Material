package com.wu.material.activity.other.mmkv

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.wu.material.R
import com.wu.material.util.MmkvUtils


/**
 * @author wkq
 *
 * @date 2022年03月22日 9:05
 *
 *@des
 *
 */

class MMKVActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmkv)
        findViewById<Button>(R.id.bt_mmkv).setOnClickListener {
            MmkvUtils.put("demo","123134")
        }
    }


}