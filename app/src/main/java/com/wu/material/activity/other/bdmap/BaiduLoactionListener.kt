package com.wu.material.activity.other.bdmap

import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.mapapi.map.MyLocationData
import com.wu.material.observable.BaiduLoactionObservable


/**
 * @author wkq
 *
 * @date 2022年03月18日 8:56
 *
 *@des
 *
 */

class BaiduLoactionListener: BDAbstractLocationListener() {
    override fun onReceiveLocation(location: BDLocation?) {
        if(location==null)return
        val locData = MyLocationData.Builder()
            .accuracy(location!!.getRadius()) // 此处设置开发者获取到的方向信息，顺时针0-360
            .direction(location!!.getDirection()).latitude(location.getLatitude())
            .longitude(location!!.getLongitude()).build()
        BaiduLoactionObservable.update(locData)
    }


}