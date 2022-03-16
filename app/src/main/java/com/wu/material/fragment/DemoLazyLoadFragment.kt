package com.wu.material.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wu.material.R


/**
 * @author wkq
 *
 * @date 2022年01月30日 14:09
 *
 *@des 懒加载测试页面
 *
 */

class DemoLazyLoadFragment : ViewPagerLazyLoadingFragment() {

    companion object {
        fun newInstance(): DemoLazyLoadFragment {
            val args = Bundle()
            val fragment = DemoLazyLoadFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun lazyLoad() {
        Log.e("DemoLazyLoadFragment :","加载数据")
        Toast.makeText(activity,"懒加载加载数据", Toast.LENGTH_SHORT).show()

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.page_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}