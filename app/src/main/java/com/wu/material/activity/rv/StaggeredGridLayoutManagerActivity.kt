package com.wu.material.activity.rv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.wu.material.R
import com.wu.material.databinding.ActivityStaggeredBinding


/**
 * @author wkq
 *
 * @date 2022年03月01日 9:19
 *
 *@des
 *
 */

class StaggeredGridLayoutManagerActivity : AppCompatActivity() {
    var binding: ActivityStaggeredBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityStaggeredBinding>(this, R.layout.activity_staggered)
        initView()
    }

    var mAdapter: DemoAdapter? = null

    private fun initView() {
        mAdapter = DemoAdapter(this)
        //一行分多少份
        var staggeredGridLayoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        binding!!.rvContent.layoutManager = staggeredGridLayoutManager
        (binding!!.rvContent.getItemAnimator() as DefaultItemAnimator).supportsChangeAnimations = false
        (binding!!.rvContent.getItemAnimator() as SimpleItemAnimator).supportsChangeAnimations = false
        binding!!.rvContent.getItemAnimator()!!.setChangeDuration(0)

        binding!!.rvContent.adapter = mAdapter
        addData()
        binding!!.btAdd.setOnClickListener {
            addData()
        }
    }

    fun addData() {
        var listData = ArrayList<String>()
        listData.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2Ftp01%2F1ZZQ20QJS6-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1648703608&t=95791a95a7cef403ce51a595a97e74a6")
        listData.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F1113%2F092919113248%2F1Z929113248-8-1200.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1648703608&t=f335964873e513f059e338c9cc5bbd87")
        listData.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2F68%2Fc8%2F7d%2F68c87deaf34b1b521135181ebfb12633.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1648703608&t=5b154bbc15f5611cfe37e0bd42a1baa4")
        //刷新数据
        mAdapter!!.addItems(listData)
    }

    // 自定义Adapter
    class DemoAdapter(mContext: Context) : RecyclerView.Adapter<DemoViewHolder>() {
        var mContext: Context? = null
        var listData = ArrayList<String>()

        init {
            this.mContext = mContext
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
            var view = LayoutInflater.from(mContext).inflate(R.layout.item_staggered, parent, false)
            var viewHolder = DemoViewHolder(view)
            return viewHolder
        }

        override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
           var imageView= holder.getTextView()
            var layoutParams=imageView.layoutParams

            if (position%2==0){
                layoutParams.height=400
            }else{
                layoutParams.height=660
            }
            imageView.layoutParams=layoutParams
            Glide.with(mContext!!).load(listData.get(position)).into(imageView)
        }

        override fun getItemCount(): Int {
            return listData.size
        }

        fun addItems(items: ArrayList<String>) {
            listData.addAll(items)
            //刷新数据
            notifyItemInserted(listData.size)
        }

    }

    // 自定义Holder
    class DemoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var rootView: View? = null

        init {
            rootView = view
        }

        fun getTextView(): ImageView {
            var tvContent = rootView!!.findViewById<ImageView>(R.id.tv_content)
            return tvContent
        }
    }


}