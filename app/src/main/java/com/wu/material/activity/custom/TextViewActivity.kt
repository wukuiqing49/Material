package com.wu.material.activity.custom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wu.material.R
import com.wu.material.databinding.ActivityTextViewBinding


/**
 * @author wkq
 *
 * @date 2022年04月19日 10:55
 *
 *@des
 *
 */

class TextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityTextViewBinding>(
            this,
            R.layout.activity_text_view
        )
    }


}