package com.wu.material.activity.rv

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.wu.material.R
import com.wu.material.activity.rv.drag.DragAdapter
import com.wu.material.activity.rv.drag.DragAdapterViewHolder
import com.wu.material.activity.rv.drag.DragItemCallback
import com.wu.material.activity.rv.drag.GridSpaceItemDecoration
import com.wu.material.databinding.ActivityDragBinding

class DragActivity : AppCompatActivity() {

    var stringList = arrayListOf<String>("北京", "河北", "河南", "山东", "天津", "陕西",
        "山西", "石家庄", "内蒙古", "黑龙江", "吉林", "新疆", "西藏", "安徽", "湖北"
    )

    private lateinit var mGridItemDecoration: GridSpaceItemDecoration
    var binding: ActivityDragBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityDragBinding>(this, R.layout.activity_drag)
        initView()

    }

    private fun initView() {
        //设置布局选择
        binding!!.btChange.setOnClickListener {
            when ( binding!!.rvContent.layoutManager) {
                is GridLayoutManager -> {
                    binding!!.rvContent.layoutManager = LinearLayoutManager(this)
                }
                else -> {
                    binding!!.rvContent.layoutManager = GridLayoutManager(this, 4)
                }
            }
        }

        //默认网格布局
        var mAdapter = DragAdapter(this)
        mGridItemDecoration = GridSpaceItemDecoration(4)
        binding!!.rvContent.addItemDecoration(mGridItemDecoration, 0)
        binding!!.rvContent.layoutManager = GridLayoutManager(this, 4)
        binding!!.rvContent.adapter = mAdapter
        mAdapter.addItems(stringList)

        //拖拽绑定的监听器
        var callBack = DragItemCallback(mAdapter,true)
        //拖拽触摸的帮助类
        var itemTouchHelper = ItemTouchHelper(callBack)
        //绑定Rv
        itemTouchHelper.attachToRecyclerView(binding!!.rvContent)

        mAdapter.setOnItemClickListener(object : DragAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@DragActivity, mAdapter.getItems().get(position), Toast.LENGTH_SHORT).show()
            }

            override fun onItemLongClick(holder: DragAdapterViewHolder) {
                //长按开启拖拽
                itemTouchHelper.startDrag(holder)
            }
        })

    }
}