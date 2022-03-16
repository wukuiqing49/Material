package com.wu.material.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.wu.material.R
import com.wu.material.adapter.FragmentAdapter
import com.wu.material.databinding.ActivityLazyLoadingBinding
import com.wu.material.fragment.*
import com.wu.material.widget.CustomTitleView
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator


/**
 * @author wkq
 *
 * @date 2022年03月16日 9:04
 *
 *@des
 *
 */

class LazyLoadingFragmentActivity : AppCompatActivity() {
    var binding: ActivityLazyLoadingBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLazyLoadingBinding>(this, R.layout.activity_lazy_loading)
        initVp()
        initMagicIndicator()
    }

    private fun initMagicIndicator() {

        var mTitles = arrayOf("当前", "历史", "曾经", "未来")
        binding!!.magicIndicator.setBackgroundColor(Color.WHITE)
        val commonNavigator = CommonNavigator(this)
        commonNavigator.scrollPivotX = 0.35f
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return if (mTitles == null) 0 else mTitles.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val simplePagerTitleView = CustomTitleView(context)
                simplePagerTitleView.setText(mTitles.get(index))
                simplePagerTitleView.normalColor = Color.parseColor("#666666")
                simplePagerTitleView.selectedColor = Color.parseColor("#222222")
                simplePagerTitleView.setOnClickListener { binding!!.vpContent.setCurrentItem(index) }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = LinePagerIndicator(context)
                indicator.mode = LinePagerIndicator.MODE_EXACTLY
                indicator.setColors(Color.parseColor("#3399FF"))
                indicator.setRoundRadius(5f)
                return indicator
            }
        }
        binding!!.vpContent.offscreenPageLimit
        binding!!.magicIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(binding!!.magicIndicator, binding!!.vpContent)
    }

    private fun initVp() {
        var fragmentList = ArrayList<Fragment>()

        fragmentList.add(DemoLazyLoadFragment.newInstance())
        fragmentList.add(DemoFragment2.newInstance())
        fragmentList.add(DemoFragment3.newInstance())
        fragmentList.add(DemoFragment4.newInstance())
        var fragmentAdapter = FragmentAdapter(fragmentList, this.supportFragmentManager)
        this.binding!!.vpContent.adapter = fragmentAdapter

    }


}