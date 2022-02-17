package com.wu.material.activity.rv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wu.material.R
import com.wu.material.databinding.ActivityRecyclerviewBinding


/**
 * @author wkq
 *
 * @date 2022年02月17日 10:43
 *
 *@des
 *
 */

class RecyclerViewActivity : AppCompatActivity() {
    var binding: ActivityRecyclerviewBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityRecyclerviewBinding>(this, R.layout.activity_recyclerview)
        initView()
    }

    private fun initView() {
        binding!!.rvContent.layoutManager = LinearLayoutManager(this)
        var mAdapter = DemoAdapter(this)
        binding!!.rvContent.adapter = mAdapter
        var listData=ArrayList<String>()
        listData.add("Android新控件")
        listData.add("循环效果2:循环")
        listData.add("Android")
        listData.add("MotionLayout")
        listData.add("Banner")
        listData.add("循环效果2")
        listData.add("Android新控件之MotionLayout实现Banner循环效果2:循环")
        mAdapter.addItems(listData)
    }

    // 自定义Adapter
    class DemoAdapter(mContext: Context) : RecyclerView.Adapter<DemoViewHolder>() {
        var mContext: Context? = null
        var listData=ArrayList<String>()
        init {
            this.mContext = mContext
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
            var view = LayoutInflater.from(mContext).inflate(R.layout.item_demo, parent, false)
            var viewHolder = DemoViewHolder(view)
            return viewHolder
        }

        override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
           var mHolder=  holder
            mHolder.getTextView().text=listData.get(position)
        }

        override fun getItemCount(): Int {
           return  listData.size
        }

        fun addItems(items:ArrayList<String>){
            listData.addAll(items)
            notifyDataSetChanged()
        }

    }
    // 自定义Holder
    class DemoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var rootView:View?=null
        init {
            rootView = view
        }
        fun getTextView():TextView{
           var tvContent= rootView!!.findViewById<TextView>(R.id.tv_content)
            return tvContent
        }


    }

}