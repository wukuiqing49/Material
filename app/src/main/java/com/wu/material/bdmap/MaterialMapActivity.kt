package com.wu.material.bdmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.search.sug.SuggestionResult
import com.wu.material.R
import com.wu.material.databinding.LayoutMapLayerBinding
import com.wu.material.observable.BaiduSearchObservable
import java.util.*


/**
 * @author wkq
 *
 * @date 2022年03月17日 17:18
 *
 *@des
 *
 */

class MaterialMapActivity : MapOptionActivity(), Observer, View.OnClickListener {

    override fun initMapOptionLocation() {
        var option = LocationClientOption()
        // 可选，设置定位模式，默认高精度 LocationMode.Hight_Accuracy：高精度；
        option!!.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.isOpenGps = true // 打开gps
        option.setCoorType("bd09ll") // 设置坐标类型
        option.setScanSpan(1000)
        //开启单次定位
        option.setOnceLocation(true);
        initLocation(option)
    }

    var layerBinding: LayoutMapLayerBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaiduSearchObservable.addObserver(this)
        addLayer()
        openIndoorEnable()

    }

    var latitude = 39.963175
    var longitude = 116.400244

    private fun addLayer() {
        layerBinding = DataBindingUtil.inflate<LayoutMapLayerBinding>(
            LayoutInflater.from(this),
            R.layout.layout_map_layer,
            null,
            false
        )
        addLayerView(layerBinding!!.root, 0)
        layerBinding!!.onClick = this
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_add_maker -> {
                addmark(latitude, longitude)
                latitude += 0.01
                longitude += 0.01
            }
            R.id.bt_type -> {
                setMapType(2)
            }
            R.id.bt_search -> {
                searchAddress("育新")
            }
        }
    }

    override fun update(o: Observable?, arg: Any?) {
        super.update(o, arg)
        if (o is BaiduSearchObservable && arg != null) {
            var info = arg as SuggestionResult
            showErr("总共搜索到:" + info.allSuggestions.size + "数据")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        BaiduSearchObservable.deleteObserver(this)
    }


}