package com.wu.material.bdmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wu.material.R
import com.wu.material.databinding.ActivityMainBinding
import com.wu.material.databinding.ActivityMapBinding


/**
 * @author wkq
 *
 * @date 2022年03月17日 17:18
 *
 *@des
 *
 */

class MaterialMapActivity : AppCompatActivity() {

    var binding: ActivityMapBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMapBinding>(this, R.layout.activity_map)
    }

    override fun onResume() {
        super.onResume()
        binding!!.bmapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding!!.bmapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding!!.bmapView.onDestroy()

    }


}