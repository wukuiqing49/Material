package com.wu.material.activity.rv

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wu.material.R
import com.wu.material.activity.rv.snap.SnapHelpActivity
import com.wu.material.databinding.ActivityRecyclerviewBinding
import com.wu.material.databinding.ActivityRecyclerviewHomeBinding


/**
 * @author wkq
 *
 * @date 2022年02月17日 10:43
 *
 *@des
 *
 */

class RecyclerHomeActivityActivity : AppCompatActivity() {
    var binding: ActivityRecyclerviewHomeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityRecyclerviewHomeBinding>(this, R.layout.activity_recyclerview_home)

        binding!!.btRv.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java));
        }
        binding!!.btRv2.setOnClickListener {
            startActivity(Intent(this, ComplicatedRecyclerViewActivity::class.java));
        }
        binding!!.btRv3.setOnClickListener {
            startActivity(Intent(this, StaggeredGridLayoutManagerActivity::class.java));
        }
        binding!!.btRv5.setOnClickListener {
            startActivity(Intent(this, RecyclerTreeViewActivity::class.java));
        }
        binding!!.btRv6.setOnClickListener {
            startActivity(Intent(this, DragActivity::class.java));
        }
        binding!!.btRv7.setOnClickListener {
            startActivity(Intent(this, SnapHelpActivity::class.java));
        }
    }


}