package com.nevermore.network

import androidx.collection.ArrayMap

/**
 * Create on 2019/9/29 15:25
 * @author XuChuanting
 */
class Request {

    var url: String = ""
    var params: ArrayMap<String, Any> = ArrayMap()
        private set

    fun addParam(key: String, value: Any): Request {
        params[key] = value
        return this
    }

}