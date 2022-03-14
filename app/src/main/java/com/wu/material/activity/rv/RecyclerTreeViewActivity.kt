package com.wu.material.activity.rv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.wu.material.R
import com.wu.material.activity.rv.adapter.DemoTreeAdapter
import com.wu.material.activity.rv.model.TreeContentInfo
import com.wu.material.activity.rv.model.TreeInfo
import com.wu.material.databinding.ActivityRecyclerviewBinding


/**
 * @author wkq
 *
 * @date 2022年02月17日 10:43
 *
 *@des
 *
 */

class RecyclerTreeViewActivity : AppCompatActivity() {
    var binding: ActivityRecyclerviewBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityRecyclerviewBinding>(this, R.layout.activity_recyclerview)
        initView()
    }

    private fun initView() {
        var mAdapter = DemoTreeAdapter(this)
        //设置LayoutManager
        var linearLayoutManager = LinearLayoutManager(this)
        binding!!.rvContent.layoutManager = linearLayoutManager
        //设置 Adapter
        binding!!.rvContent.adapter = mAdapter
//        binding!!.rvContent.setHasFixedSize(true)
//        //关闭动画效果
//        var sa = binding!!.rvContent.getItemAnimator() as SimpleItemAnimator;
//        sa.setSupportsChangeAnimations(false);
//        //设置动画为空
//        binding!!.rvContent.setItemAnimator(null)

        var listData = ArrayList<TreeInfo>()
        //刷新数据
        for (index in 0..10) {
            var contentDatas = ArrayList<TreeInfo>()
            for (index in 0..10) {
                var contentDatas2 = ArrayList<TreeInfo>()

                for (index in 0..5) {
                    var info = TreeInfo(-1, false, "这是最里边内容:" + index + "类型" + 2, ArrayList<TreeInfo>())
                    contentDatas2.add(info)
                }
                var info = TreeInfo(1, false, "标题:" + index, contentDatas2)
                contentDatas.add(info)
            }
            var group = TreeInfo(0, false, "标题" + index, contentDatas)
            listData.add(group)
        }

        mAdapter.addItems(listData)

        mAdapter.setOnItemClickListener(object : DemoTreeAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                var info = mAdapter.getItem(position)
                info.isExpen = !info.isExpen
                mAdapter.notifyItemChanged(position, "1")
            }
        })

    }

}