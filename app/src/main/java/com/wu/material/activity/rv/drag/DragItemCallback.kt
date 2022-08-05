package com.wu.material.activity.rv.drag


import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


/**
 * @author wkq
 *
 * @date 2022年08月04日 13:27
 *
 *@des  拖拽的接口回调
 *
 *@param isSwipe  是否支持侧滑  默认支持
 *
 */

class DragItemCallback(adapter: DragAdapter, isSwipe: Boolean = true) : ItemTouchHelper.Callback() {

    private var mAdapter = adapter
    private var mData = adapter.getItems()
    private var isSwipe = isSwipe

    // 这个方法用于让RecyclerView拦截向上滑动，向下滑动，想左滑动
    // makeMovementFlags(dragFlags, swipeFlags); dragFlags显示项目支持拖动的方向  swipe标记物品可以滑动的方向  0 表示禁止
    //  网格布局:上下左右
    //  线性布局:上下/左右

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        //拖动标记 0 表示禁止
        var dragFlags = 0
        //侧滑标记
        var swipeFlags = 0
        var layoytManager = recyclerView.layoutManager
        if (layoytManager is GridLayoutManager) {
            //网格布局  默认禁止侧滑
            if (viewHolder.adapterPosition != mAdapter.limitPosition) {
                dragFlags =ItemTouchHelper.LEFT or ItemTouchHelper.UP or ItemTouchHelper.RIGHT or ItemTouchHelper.DOWN
            }
            return makeMovementFlags(dragFlags, swipeFlags)
        } else if (layoytManager is LinearLayoutManager) {

            //处理 禁止滑动模块得逻辑  禁止移动得模块 禁止左右滑动
            if (viewHolder.adapterPosition != mAdapter.limitPosition) {
                dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
            }
            return makeMovementFlags(dragFlags, swipeFlags)
        }
        //默认 禁止滑动  禁止拖拽
        return makeMovementFlags(dragFlags, swipeFlags)

    }

    /**
     * 拖拽移动得回调
     */
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        // 起始位置
        val fromPosition = viewHolder.adapterPosition
        // 结束位置
        val toPosition = target.adapterPosition
        // 固定位置  处理笃定位置不要移动
        if (fromPosition == mAdapter.limitPosition || toPosition == mAdapter.limitPosition) {
            return false
        }
        // 根据滑动方向 交换数据  for 循环不包含  toPosition  1 替代2     2替代3  3 替代4
        if (fromPosition < toPosition) {
            // 含头不含尾
            for (index in fromPosition until toPosition) {
                //交换集合得位置
                Collections.swap(mData, index, index + 1)
            }
        } else {
            // 含头不含尾
            for (index in fromPosition downTo toPosition + 1) {
                Collections.swap(mData, index, index - 1)
            }
        }
        // 刷新布局
        mAdapter.notifyItemMoved(fromPosition, toPosition)
        return true
    }

    /**
     * 滑动结束得回调 滑动删除得逻辑
     */
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        // direction 滑动的状态
        //ItemTouchHelper.START表示向左滑动
        // ItemTouchHelper.END  向右边滑动
        val position = viewHolder.adapterPosition
        if (position != mAdapter.limitPosition) {
            //表示  禁止移动得布局
            mData.removeAt(position)
            mAdapter.notifyItemRemoved(position)
        }

    }


    /**
     * 选中会回调这里  处理选中布局的展示样式
     */
    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {

        if (viewHolder == null) return
        //空闲状态
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            ViewCompat.animate(viewHolder!!.itemView).setDuration(100).scaleX(1.2F).scaleY(1.2F)
                .start()
        }
        super.onSelectedChanged(viewHolder, actionState)

    }


    /**
     * 滑动结束 清理选中得状态  恢复布局的样式
     */
    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        // 恢复显示
        // 这里不能用if判断，因为GridLayoutManager是LinearLayoutManager的子类，改用when，类型推导有区别
        ViewCompat.animate(viewHolder.itemView).setDuration(100).scaleX(1F).scaleY(1F).start()
        super.clearView(recyclerView, viewHolder)
    }


    /**
     * 是否支持长按拖拽，默认true
     * 因为我们外部监听了长安处理操作所以 这里需要禁用没改掉
     */
    override fun isLongPressDragEnabled(): Boolean {
        return false
    }


    /**
     * 是否支持侧滑默认true(线性布局的时候外部可以传进来)
     */
    override fun isItemViewSwipeEnabled(): Boolean {
        return isSwipe
    }
}