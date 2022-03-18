package com.wu.material.observable

import com.baidu.mapapi.map.MyLocationData
import java.util.*


/**
 * @author wkq
 *
 * @date 2022年03月18日 8:58
 *
 *@des 定位观察则
 *
 */

object BaiduLoactionObservable:Observable() {

    fun update(locationData: MyLocationData){
        setChanged()
        notifyObservers(locationData)
    }


}