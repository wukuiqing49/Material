package com.wkq.snaphelper

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper


/**
 * @author wkq
 *
 * @date 2022年08月05日 10:51
 *
 *@des
 *
 */

class CustomSnapHelper :SnapHelper() {


    /**
     * 这个方法会计算第二个参数对应的ItemView当前的坐标与需要对齐的坐标之间的距离。该方法返回一个大小为2的int数组，分别对应x轴和y轴方向上的距离。
     */
    override fun calculateDistanceToFinalSnap(
        layoutManager: RecyclerView.LayoutManager,
        targetView: View
    ): IntArray? {

        return  IntArray(1)
    }

    /**
     * 该方法会找到当前layoutManager上最接近对齐位置的那个view，该view称为SanpView，对应的position称为SnapPosition。如果返回null，就表示没有需要对齐的View，也就不会做滚动对齐调整
     */
    override fun findSnapView(layoutManager: RecyclerView.LayoutManager?): View? {

        return layoutManager!!.getChildAt(0)

    }
    /**
     *
     *  该方法会根据触发Fling操作的速率（参数velocityX和参数velocityY）来找到RecyclerView需要滚动到哪个位置，该位
     */
    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager?,
        velocityX: Int,
        velocityY: Int
    ): Int {

        return 0

    }

    /**
     *  绑定RecycleView
     */
    override fun attachToRecyclerView(recyclerView: RecyclerView?) {
        super.attachToRecyclerView(recyclerView)
    }


}