package com.wu.material.activity.other.bdmap

import android.Manifest
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.*
import com.baidu.mapapi.model.LatLng
import com.wu.material.observable.BaiduLoactionObservable
import com.wu.material.util.PermissionsUtil
import java.util.*


/**
 * @author wkq
 *
 * @date 2022年03月18日 9:38
 *
 *@des  Map 记住库  裸装地图  处理权限 以及初始化地图以及定位
 *
 */

abstract class BaseMapActivity : AppCompatActivity(), Observer {

    //权限Code
    var REQUEST_MAP = 10011
    var permissionsREAD = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    var mLocationClient: LocationClient? = null
    var baiduMap: MapView? = null
    var parentMap: RelativeLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addRootView()
        BaiduLoactionObservable.addObserver(this)
        // 判断权限
        var isHave = PermissionsUtil.checkPermissions(this, permissionsREAD, REQUEST_MAP)
        if (isHave) {
            baiduMap!!.map.isMyLocationEnabled = true
            startLocation()
        }
    }

    /**
     * 添加跟布局
     */
    private fun addRootView() {
        parentMap = RelativeLayout(this)
        var options = BaiduMapOptions()
        options.compassEnabled(false)
        options.mapType(BaiduMap.MAP_TYPE_NORMAL)
        options.scaleControlEnabled(false)
        options.zoomControlsEnabled(false)
        baiduMap = MapView(this, options)
        parentMap!!.addView(baiduMap)
        setContentView(parentMap!!)
    }

    //授权的回调监听
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_MAP) {
            val hasPermissions =
                PermissionsUtil.onRequestPermissionsResult(
                    this,
                    requestCode,
                    permissions,
                    grantResults
                )
            if (hasPermissions!![0]) {
                startLocation()
            } else {
                showErr("暂无定位权限")
            }
        }
    }

    override fun onResume() {
        baiduMap!!.onResume()
        super.onResume()

    }
    override fun onPause() {
        baiduMap!!.onPause()
        super.onPause()
    }
    override fun onDestroy() {
        baiduMap!!.onDestroy()
        baiduMap!! == null
        super.onDestroy()
        BaiduLoactionObservable.deleteObserver(this)
        if (mLocationClient != null) mLocationClient!!.stop()
    }

    /**
     * 移动地图
     */
    fun mapMovingLocation(ll: LatLng, zoom: Float = 18f) {
        val builder: MapStatus.Builder = MapStatus.Builder()
        builder.target(ll).zoom(18.0f)
        baiduMap!!.map.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()))
    }

    override fun update(o: Observable?, arg: Any?) {
        //百度定位结果监听
        if (o is BaiduLoactionObservable && arg != null) {
            var location = arg as MyLocationData
            baiduMap!!.map.setMyLocationData(location)
            var lat = LatLng(location.latitude, location.longitude)
            mapMovingLocation(lat)
        }
    }
    //展示错误信息
    abstract fun showErr(message: String)
    //初始化创建定位的监听
    abstract fun initLocation(option: LocationClientOption)
    //开启定位
    abstract fun startLocation()
}