package com.nevermore.network

/**
 * Create on 2019/9/29 16:31
 * @author XuChuanting
 */
class NetClient private constructor() {

    companion object : IHttpMethod {
        private val client = OkHttpMethod()

        override fun <T> syncGet(request: Request, clazz: Class<T>): Response<T> {
            return client.syncGet(request, clazz)
        }

        override fun <T> syncPost(request: Request, clazz: Class<T>): Response<T> {
            return client.syncPost(request, clazz)
        }

    }
}