package com.wu.material.activity.rv.snap
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wu.material.R
import com.wu.material.databinding.ItemSnapBinding


/**
 * @author wkq
 *
 * @date 2022年08月04日 13:05
 *
 * @des  拖拽的Adapter
 *
 * @param limitPosition 禁止操作的条目位置 默认第一个
 *
 */

class SnapAdapter(mContext: Context, limitPosition:Int=0) : RecyclerView.Adapter<SnapAdapterViewHolder>() {

    //上下文
    var mContext=mContext
    // 固定条目的位置
    val limitPosition = limitPosition
    //内容数据
   private var contentList = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnapAdapterViewHolder {
        var binding = DataBindingUtil.inflate<ItemSnapBinding>(
            LayoutInflater.from(mContext),
            R.layout.item_snap,
            parent,
            false
        )
        var holder = SnapAdapterViewHolder(binding.root)
        holder.setDataBinding(binding)
        return holder
    }

    override fun onBindViewHolder(holder: SnapAdapterViewHolder, position: Int) {
        var binding = holder.getBinding() as ItemSnapBinding
        Glide.with(mContext).load(getItem(position)).into(binding.ivContent)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    fun addItems(items: ArrayList<String>) {
        contentList.addAll(items)
    }

    fun addItems(item: String) {
        contentList.add(item)
    }

    fun remove(item: String) {
        contentList.remove(item)
        notifyDataSetChanged()
    }

    fun getItems():ArrayList<String>{
        return contentList
    }
    fun getItem(index:Int):String{
        return contentList.get(index)
    }
    private var mListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onItemLongClick(holder: SnapAdapterViewHolder)
    }

}