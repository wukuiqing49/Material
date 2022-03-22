package com.wu.material.activity.other

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wu.material.R
import com.wu.material.activity.other.bdmap.MaterialMapActivity
import com.wu.material.activity.other.mmkv.MMKVActivity
import kotlinx.android.synthetic.main.activity_other.*


/**
 * @author wkq
 *
 * @date 2022年03月22日 8:57
 *
 *@des
 *
 */

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        initView()
    }

    private fun initView() {

        bt_map.setOnClickListener {
            startActivity(Intent(this, MaterialMapActivity::class.java));
        }

        bt_mmkv.setOnClickListener {
            startActivity(Intent(this, MMKVActivity::class.java));
        }
    }


}