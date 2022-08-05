package com.wu.material.activity.rv.drag

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author wkq
 *
 * @date 2022年08月04日 13:27
 *
 *@des  分割器
 *
 */
class GridSpaceItemDecoration(private val spanCount: Int, private val spacing: Int = 20) :RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, recyclerView: RecyclerView, state: RecyclerView.State) {
        when (recyclerView.layoutManager) {
            //网格布局
            is GridLayoutManager -> {
                val position = recyclerView.getChildAdapterPosition(view) // 获取item在adapter中的位置
                val column = position % spanCount // item所在的列
                outRect.left = column * spacing / spanCount
                outRect.right = spacing - (column + 1) * spacing / spanCount
                if (position >= spanCount) {
                    outRect.top = spanCount
                }
                outRect.bottom = spacing
            }
            //线性布局
            is LinearLayoutManager -> {
                outRect.top = spanCount
                outRect.bottom = spacing
            }
        }
    }

}