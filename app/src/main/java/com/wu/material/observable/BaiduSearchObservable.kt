package com.wu.material.observable

import com.baidu.mapapi.map.MyLocationData
import com.baidu.mapapi.search.sug.SuggestionResult
import java.util.*


/**
 * @author wkq
 *
 * @date 2022年03月18日 8:58
 *
 *@des 搜索结果的观察者
 *
 */

object BaiduSearchObservable:Observable() {

    fun update(locationData: SuggestionResult){
        setChanged()
        notifyObservers(locationData)
    }


}