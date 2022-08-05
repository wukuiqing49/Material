package com.wu.material.activity.rv.drag

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wu.material.R
import com.wu.material.databinding.ItemDragBinding


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

class DragAdapter(mContext: Context,limitPosition:Int=0) : RecyclerView.Adapter<DragAdapterViewHolder>() {

    //上下文
    var mContext=mContext
    // 固定条目的位置
    val limitPosition = limitPosition
    //内容数据
   private var contentList = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAdapterViewHolder {
        var binding = DataBindingUtil.inflate<ItemDragBinding>(
            LayoutInflater.from(mContext),
            R.layout.item_drag,
            parent,
            false
        )
        var holder = DragAdapterViewHolder(binding.root)
        holder.setDataBinding(binding)
        return holder
    }

    override fun onBindViewHolder(holder: DragAdapterViewHolder, position: Int) {
        var binding = holder.getBinding() as ItemDragBinding

        if (limitPosition==position){
            binding.tvContent.setBackgroundResource(R.drawable.shape_radius5_green2)
        }else{
            binding.tvContent.setBackgroundResource(R.drawable.shape_radius5_green)
        }
        binding.tvContent.text = contentList.get(position)

        binding.tvContent.setOnClickListener {
            mListener?.onItemClick(holder.adapterPosition)
        }
        binding.tvContent.setOnLongClickListener {
            mListener?.onItemLongClick(holder)
            return@setOnLongClickListener true
        }
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
    private var mListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onItemLongClick(holder: DragAdapterViewHolder)
    }

}