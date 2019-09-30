package com.nevermore.network

import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.OkHttpClient

/**
 * Create on 2019/9/29 16:38
 * @author XuChuanting
 */
internal class OkHttpMethod : IHttpMethod {
    override fun <T> syncGet(request: Request, clazz: Class<T>): Response<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    var client: OkHttpClient = OkHttpClient()

    override fun <T> syncPost(request: Request, clazz: Class<T>): Response<T> {

        val requestBuilder = okhttp3.Request.Builder()
        requestBuilder.url(request.url)

        val params = request.params
        if (params.size > 0) {
            val builder = FormBody.Builder()
            for ((key, value) in params) {
                builder.add(key, value.toString())
            }
            requestBuilder.put(builder.build())
        }

        val newCall = client.newCall(requestBuilder.build())
        val rep = newCall.execute()
        val response = Response<T>()
        response.code = rep.code
        response.message = rep.message

        if (rep.isSuccessful) {

            var json = rep.body?.string() ?: ""
            Log.i("request", json)


            if (clazz == String::class.java) {
                response.data = json as T
            } else {
                if (TextUtils.isEmpty(json)) {
                    return response
                }
                rep.body.apply {
                    if (this != null) {
                        response.data = Gson().fromJson(json, clazz)
                    }
                }

            }
        }
        return response
    }


}

