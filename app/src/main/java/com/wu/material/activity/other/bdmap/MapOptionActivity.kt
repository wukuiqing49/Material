package com.wu.material.activity.other.bdmap

import android.R
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.BitmapDescriptorFactory
import com.baidu.mapapi.map.MarkerOptions
import com.baidu.mapapi.map.OverlayOptions
import com.baidu.mapapi.model.LatLng
import com.baidu.mapapi.search.sug.SuggestionSearch
import com.baidu.mapapi.search.sug.SuggestionSearchOption
import com.wu.material.observable.BaiduSearchObservable
import java.util.*


/**
 * @author wkq
 *
 * @date 2022年03月17日 17:18
 *
 *@des  功能提供层  提供地图的各种通用功能
 *
 */

open abstract class MapOptionActivity : BaseMapActivity(), Observer {

    override fun onCreate(savedInstanceState: Bundle?) {
        initMapOptionLocation()
        super.onCreate(savedInstanceState)
    }

    /**
     * 添加上下浮层
     * location  0 1 2 3  上下左右
     */
    fun addLayerView(layerView: View, location: Int = 0) {
        if (layerView == null) return
        var lp = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        when (location) {
            0 -> {
                lp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE)
            }
            1 -> {
                lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
            }
            2 -> {
                lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
            }
            3 -> {
                lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
            }
        }
        parentMap!!.addView(layerView, lp)
    }

    /**
     * 开启定位
     */
    override fun startLocation() {
        if (mapLocationOption == null) return
        mLocationClient = LocationClient(this);
        mLocationClient!!.setLocOption(mapLocationOption)
        var listener = BaiduLoactionListener()
        mLocationClient!!.registerLocationListener(listener)
        mLocationClient!!.start()
    }

    /**
     * 关闭定位
     */
    fun stopLocation() {
        if (mLocationClient != null) mLocationClient!!.stop()
    }

    /**
     * 设置地图类型
     *
     * type: 1: MAP_TYPE_NORMAL(普通)  2:MAP_TYPE_SATELLITE(卫星)  3: MAP_TYPE_NONE(空白地图)
     */
    fun setMapType(type: Int) {
        baiduMap!!.map.setMapType(type)
    }

    /**
     * 搜索功能  结果以观察者方式对外发出
     */
    fun searchAddress(address: String) {
        var mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener {
            if (it != null && it.allSuggestions != null && it.allSuggestions.size > 0) {
                BaiduSearchObservable.update(it)
            } else {
                showErr("未搜索到内容")
            }
        }

        mSuggestionSearch.requestSuggestion(SuggestionSearchOption().city("北京").keyword(address))
    }

    /**
     * 出我提示
     */
    override fun showErr(message: String) {
        Toast.makeText(this@MapOptionActivity, message, Toast.LENGTH_SHORT).show()
    }

    var mapLocationOption: LocationClientOption? = null
    override fun initLocation(option: LocationClientOption) {
        mapLocationOption = option
    }

    fun openIndoorEnable() {
        baiduMap!!.map.setIndoorEnable(false)
    }

    /**
     * 添加maker点
     */
    fun addmark(latitude: Double, longitude: Double, res: Int = R.drawable.ic_input_add) {
        //定义Maker坐标点
        val point = LatLng(latitude, longitude)
        //构建Marker图标
        val bitmap = BitmapDescriptorFactory
            .fromResource(res)
        //构建MarkerOption，用于在地图上添加Marker
        val option: OverlayOptions = MarkerOptions()
            .position(point)
            .icon(bitmap)
        //在地图上添加Marker，并显示
        baiduMap!!.map.addOverlay(option)

    }

    /**
     * 初始化定位配置
     */
    abstract fun initMapOptionLocation()


}