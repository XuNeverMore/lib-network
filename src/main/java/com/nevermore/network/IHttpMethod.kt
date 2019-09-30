package com.nevermore.network

/**
 * Create on 2019/9/29 16:34
 * @author XuChuanting
 */
interface IHttpMethod {

    fun <T>syncGet(request: Request,clazz:Class<T>): Response<T>

    fun <T>syncPost(request: Request,clazz:Class<T>): Response<T>
}