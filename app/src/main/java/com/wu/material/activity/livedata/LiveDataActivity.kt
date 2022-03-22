package com.wu.material.activity.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.wu.material.R
import com.wu.material.databinding.ActivityLivedataBinding
import com.wu.material.viewmodel.LiveDataDemoModel


/**
 * @author wkq
 *
 * @date 2022年02月08日 10:31
 *
 *@des
 *
 */

class LiveDataActivity : AppCompatActivity() {

    var binding: ActivityLivedataBinding? = null
    var liveData: LiveDataDemoModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLivedataBinding>(
            this,
            R.layout.activity_livedata
        )
        //创建LiveData
        liveData = LiveDataDemoModel()
        //注册观察
        liveData!!.getLivedata().observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                //接收数据 页面变化
                binding!!.tvContent.text = t
            }
        })
        initView()
    }

    private fun initView() {

        binding!!.btChange.setOnClickListener {
            //数据更改
            liveData!!.livadata.value = "更改了数据"
        }

    }


}