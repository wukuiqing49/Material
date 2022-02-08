package com.wu.material.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * @author wkq
 *
 * @date 2022年02月08日 10:37
 *
 *@des LiveData  对象
 *
 */

class LiveDataDemoModel : ViewModel() {
    var livadata = MutableLiveData<String>()

    fun getLivedata(): LiveData<String> {
        return livadata
    }

}