package com.wu.material.activity.constraint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wu.material.R
import com.wu.material.databinding.ActivityConstraintLayoutBinding


/**
 * @author wkq
 *
 * @date 2022年02月06日 10:38
 *
 *@des
 *
 */

class ConstraintLayoutDemoActivity :AppCompatActivity() {
    var binding:ActivityConstraintLayoutBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=  DataBindingUtil.setContentView<ActivityConstraintLayoutBinding>(this, R.layout.activity_constraint_layout)
    }


}