package com.wu.material.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import androidx.databinding.DataBindingUtil
import com.wu.material.R
import com.wu.material.databinding.ActivityCarouselBinding

/**
 * @author wkq
 *
 * @date 2022年01月24日 13:56
 *
 *@des  侧滑效果(未处理 仅仅能展示顶部动画效果)
 *
 */

class CarouselActivity : AppCompatActivity() {
    var binding: ActivityCarouselBinding? = null

    // Some data for the Carousel examples...
    var images = intArrayOf(
            R.drawable.bryce_canyon,
            R.drawable.cathedral_rock,
            R.drawable.death_valley,
            R.drawable.fitzgerald_marine_reserve,
            R.drawable.goldengate,
            R.drawable.golden_gate_bridge,
            R.drawable.shipwreck_1,
            R.drawable.shipwreck_2,
            R.drawable.grand_canyon,
            R.drawable.horseshoe_bend,
            R.drawable.muir_beach,
            R.drawable.rainbow_falls)

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityCarouselBinding>(this, R.layout.activity_carousel)
        initView()
    }

    private fun initView() {

        binding!!.carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return images.size
            }

            override fun populate(view: View, index: Int) {
                if (view is ImageView) {
                    view.setImageResource(images[index])
                }
            }

            override fun onNewItem(index: Int) {
            }
        })
    }


}