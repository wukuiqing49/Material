package com.wu.material.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.wu.material.R


/**
 * @author wkq
 *
 * @date 2021年11月04日 16:40
 *
 *@des
 *
 */

class MaterialBadgeDrawableActivity :AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_badge_drawable)
       var tvContent= findViewById<TextView>(R.id.tv)
       var rl= findViewById<FrameLayout>(R.id.rl)
       var db= BadgeDrawable.create(this).apply {
           number=11
           badgeTextColor=resources.getColor(R.color.white)
           badgeGravity=BadgeDrawable.TOP_END}
        tvContent.post {
            BadgeUtils.attachBadgeDrawable(db,tvContent,rl)
        }

    }


}