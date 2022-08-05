package com.wu.material.activity.rv.snap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.*
import com.wu.material.R
import com.wu.material.databinding.ActivitySnapBinding

class SnapHelpActivity : AppCompatActivity() {
    var binding: ActivitySnapBinding? = null
    val path = "https://img2.baidu.com/it/u=686238839,986827545&fm=253&fmt=auto&app=138&f=JPEG"
    var stringList= arrayListOf<String>(path,path,path,path,path,path,path,path,path,path,path,path,path,path,path,path,path)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivitySnapBinding>(this, R.layout.activity_snap)
        initView()
    }

    private fun initView() {
        //设置布局选择
        binding!!.rvContent.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        //默认网格布局
        var mAdapter = SnapAdapter(this)
        binding!!.rvContent.adapter = mAdapter
        mAdapter.addItems(stringList)

//        var pageHelp=LinearSnapHelper()
        var pageHelp=PagerSnapHelper()

        pageHelp.attachToRecyclerView( binding!!.rvContent)
    }
}