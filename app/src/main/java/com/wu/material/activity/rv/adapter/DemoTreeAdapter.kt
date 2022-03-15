package com.wu.material.activity.rv.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.wu.material.R
import com.wu.material.activity.rv.model.NodeInfo
import com.wu.material.activity.rv.model.TreeInfo


/**
 * @author wkq
 *
 * @date 2022年03月14日 13:28
 *
 *@des
 *
 */

class DemoTreeAdapter(mContext: Context) : RecyclerView.Adapter<KtViewHolder>() {
    var mContext: Context? = null
    var listData = ArrayList<NodeInfo>()

    init {
        this.mContext = mContext
    }

    var listener: ItemClickListener? = null
    fun setOnItemClickListener(listener: ItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KtViewHolder {

        var view =
            LayoutInflater.from(mContext).inflate(R.layout.item_rv_tree_content, parent, false)
        var viewHolder = KtViewHolder(view)
        return viewHolder
    }

    fun getItem(position: Int): NodeInfo {
        return listData.get(position)
    }

    // 局部刷新
    override fun onBindViewHolder(holder: KtViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        var info = listData.get(position)
        var iconImageView = holder.getAddressTypeImageView()
        var recycleView = holder.getRecyclerView()
        if (payloads != null && payloads!!.size > 0 && "1".equals(payloads.get(0))) {
            if (info.nodes.size == 0) {
                iconImageView.visibility = View.GONE
            } else {
                iconImageView.visibility = View.VISIBLE
                if (info.isExpen) {
                    recycleView.visibility = View.VISIBLE
                } else {
                    recycleView.visibility = View.GONE
                }
            }
            if (info.isExpen) {
                iconImageView.setBackgroundResource(R.mipmap.iv_address_delete)
            } else {
                iconImageView.setBackgroundResource(R.mipmap.iv_address_add)
            }
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }

    }

    override fun onBindViewHolder(holder: KtViewHolder, position: Int) {
        var mHolder = holder
        var info = listData.get(position)
        var titleTextView = mHolder.getTextView()
        titleTextView.text = listData.get(position).name
        var recycleView = mHolder.getRecyclerView()
        var iconImageView = mHolder.getAddressTypeImageView()
        recycleView.layoutManager = LinearLayoutManager(mContext)
        var contentAdapter = DemoTreeAdapter(mContext!!)
        recycleView.adapter = contentAdapter
        if (info.nodes.size == 0) {
            iconImageView.visibility = View.GONE
        } else {
            iconImageView.visibility = View.VISIBLE
            if (info.isExpen) {
                recycleView.visibility = View.VISIBLE
            } else {
                recycleView.visibility = View.GONE
            }
            contentAdapter.addItems(info.nodes)
        }

        if (info.isExpen) {
            iconImageView.setBackgroundResource(R.mipmap.iv_address_delete)
        } else {
            iconImageView.setBackgroundResource(R.mipmap.iv_address_add)
        }

        contentAdapter.setOnItemClickListener(object : DemoTreeAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                var info = contentAdapter.getItem(position)
                if (info.nodes.size == 0) {
                    Toast.makeText(mContext, info.full_name, Toast.LENGTH_SHORT).show()
                } else {
                    info.isExpen = !info.isExpen
                    contentAdapter.notifyItemChanged(position, "1")
                }

            }
        })

        titleTextView!!.setOnClickListener {
            if (listener != null) {
                listener!!.onItemClick(position)
            }
        }


    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun addItems(items: List<NodeInfo>) {
        listData.addAll(items)
        //刷新数据
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

}
