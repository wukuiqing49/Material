package com.wu.material.activity.other

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.baidu.mapapi.CoordType
import com.baidu.mapapi.SDKInitializer
import com.wu.material.R
import com.wu.material.activity.other.bdmap.MaterialMapActivity
import com.wu.material.activity.other.mmkv.MMKVActivity


/**
 * @author wkq
 *
 * @date 2022年03月22日 8:57
 *
 *@des
 *
 */

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(application);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);

        initView()
    }

    private fun initView() {

        findViewById<Button>(R.id.bt_map).setOnClickListener {
            startActivity(Intent(this, MaterialMapActivity::class.java));
        }
        findViewById<Button>(R.id.bt_mmkv).setOnClickListener {
            startActivity(Intent(this, MMKVActivity::class.java));
        }
    }


}