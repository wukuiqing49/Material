package com.wu.material.activity.rv.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wu.material.R


/**
 * @author wkq
 *
 * @date 2022年03月14日 13:29
 *
 *@des
 *
 */

class KtViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var rootView: View? = null

    init {
        rootView = view
    }

    fun getTextView(): TextView {
        var tvContent = rootView!!.findViewById<TextView>(R.id.tv_content)
        return tvContent
    }
    fun getImageView(): ImageView {
        return rootView!!.findViewById<ImageView>(R.id.iv_icon)
    }

    fun getAddressTypeImageView(): ImageView {
            return rootView!!.findViewById<ImageView>(R.id.iv_icon_type)
    }

    fun getRecyclerView(): RecyclerView {
        return rootView!!.findViewById<RecyclerView>(R.id.rv_content)
    }
}