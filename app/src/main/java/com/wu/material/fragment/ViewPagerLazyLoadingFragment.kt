package com.wu.material.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment


/**
 * @author wkq
 *
 * @date 2022年01月30日 14:09
 *
 *@des ViewPager+Fragment懒加载
 *
 */

// Fragment 完整生命周期：
// onAttach -> onCreate -> onCreatedView -> onActivityCreated ->
// onStart -> onResume ->
// onPause -> onStop ->
// onDestroyView -> onDestroy -> onDetach

abstract class ViewPagerLazyLoadingFragment : Fragment() {


    /**
     * 当前页面是否可见
     */
    private var isVisibleToUser = false

    private var isResume = false

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("LazyLoadingFragment :", "onHiddenChanged()" + hidden)
    }


    /**
     * 懒加载执行的方法
     */

    abstract fun lazyLoad()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("LazyLoadingFragment :", "onAttach()")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LazyLoadingFragment :", "onCreate()")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("LazyLoadingFragment :", "onViewCreated()")

    }

    override fun onStart() {
        super.onStart()
        Log.e("LazyLoadingFragment :", "onStart()")

    }

    override fun onResume() {
        super.onResume()
        isResume = true
        if (isVisibleToUser) {
            lazyLoad()
        }
        Log.e("LazyLoadingFragment :", "onResume()")
    }

    /**
     * 是否用户可见
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser

        if (isVisibleToUser && isResume) {
            lazyLoad()
        }
        Log.e("LazyLoadingFragment :", "setUserVisibleHint()" + isVisibleToUser)
    }


    override fun onPause() {
        super.onPause()
        isResume = false
        Log.e("LazyLoadingFragment :", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LazyLoadingFragment :", "onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("LazyLoadingFragment :", "onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        isResume = false
        isVisibleToUser = false
        Log.e("LazyLoadingFragment :", "onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("LazyLoadingFragment :", "onDetach()")
    }

}