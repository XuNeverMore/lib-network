package com.nevermore.network.request

import androidx.collection.ArrayMap

/**
 * Create on 2019/9/29 15:25
 * @author XuChuanting
 */
class Request {

    var url: String? = null
    var mParams: ArrayMap<String, Any> = ArrayMap()
        private set

    fun addParam(key:String,value:Any):Request{
        mParams[key] = value
        return this
    }

}