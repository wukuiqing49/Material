package com.wu.material.activity.rv.snap

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/**
 * @author wkq
 *
 * @date 2022年08月04日 13:06
 *
 *@des
 *
 */

class SnapAdapterViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private var binding:ViewDataBinding?=null

    fun setDataBinding(binding:ViewDataBinding){
        this.binding=binding
    }

    fun getBinding():ViewDataBinding?{
        return binding
    }


}