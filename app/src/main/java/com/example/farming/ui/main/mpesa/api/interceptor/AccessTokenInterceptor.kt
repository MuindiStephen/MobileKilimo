package com.example.farming.ui.main.mpesa.api.interceptor

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class AccessTokenInterceptor(private val consumerkey:String,private val consumersecret:String):
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val keys = "$consumerkey:$consumersecret"
        val request: Request = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Basic " + Base64.encodeToString(keys.toByteArray(), Base64.NO_WRAP)
            )
            .build()
        return chain.proceed(request)
    }
}