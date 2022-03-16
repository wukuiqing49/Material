package com.wu.material.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


/**
 *
 * 作者:吴奎庆
 *
 * 时间:2021/11/13
 *
 * 用途:方案二的 Adapter
 */


class FragmentAdapter2(fragmentList:ArrayList<Fragment>, fm: FragmentManager): FragmentStatePagerAdapter (fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    var fragmentList=ArrayList<Fragment>()
    init {
        this.fragmentList=fragmentList
    }
    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}