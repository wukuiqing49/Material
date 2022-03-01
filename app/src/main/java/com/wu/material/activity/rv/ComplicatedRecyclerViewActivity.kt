package com.wu.material.activity.rv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wu.material.R
import com.wu.material.databinding.ActivityComplicatedRecyclerviewBinding


/**
 * @author wkq
 *
 * @date 2022年03月01日 9:19
 *
 *@des
 *
 */

class ComplicatedRecyclerViewActivity : AppCompatActivity() {
    var binding: ActivityComplicatedRecyclerviewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityComplicatedRecyclerviewBinding>(this, R.layout.activity_complicated_recyclerview)
        initView()
    }

    private fun initView() {
        var mAdapter = RecyclerViewActivity.DemoAdapter(this)
        //一行分多少份
        var gridLayoutManager = GridLayoutManager(this, 120)
        binding!!.rvContent.layoutManager = gridLayoutManager

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                // 返回的是 表示每个条目占用几几份  屏幕分了120份
                when (position) {
                    0 -> {
                        return 120
                    }
                    1 -> {
                        return 60
                    }
                    2 -> {
                        return 60
                    }
                    3 -> {
                        return 40
                    }
                    4 -> {
                        return 40
                    }
                    5 -> {
                        return 40
                    }
                    6 -> {
                        return 120
                    }
                    else -> {
                        return 30
                    }

                }
            }
        }

        //设置 Adapter
        binding!!.rvContent.adapter = mAdapter
        var listData = ArrayList<String>()
        listData.add("Android新控件")
        listData.add("循环效果2:循环")
        listData.add("Android")
        listData.add("MotionLayout")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("Banner")
        listData.add("循环效果2")
        listData.add("Android新控件之MotionLayout实现Banner循环效果2:循环")
        //刷新数据
        mAdapter.addItems(listData)
    }


    // 自定义Adapter
    class DemoAdapter(mContext: Context) : RecyclerView.Adapter<DemoViewHolder>() {
        var mContext: Context? = null
        var listData = ArrayList<String>()

        init {
            this.mContext = mContext
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
            var view = LayoutInflater.from(mContext).inflate(R.layout.item_demo, parent, false)
            var viewHolder = DemoViewHolder(view)
            return viewHolder
        }

        override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
            var mHolder = holder
            mHolder.getTextView().text = listData.get(position)
        }

        override fun getItemCount(): Int {
            return listData.size
        }

        fun addItems(items: ArrayList<String>) {
            listData.addAll(items)
            //刷新数据
            notifyDataSetChanged()
//            notifyItemChanged(2)
        }

    }

    // 自定义Holder
    class DemoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var rootView: View? = null

        init {
            rootView = view
        }

        fun getTextView(): TextView {
            var tvContent = rootView!!.findViewById<TextView>(R.id.tv_content)
            return tvContent
        }
    }


}