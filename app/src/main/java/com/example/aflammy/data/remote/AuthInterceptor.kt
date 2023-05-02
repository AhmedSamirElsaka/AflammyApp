package com.example.aflammy.data.remote

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.local.AppConfiguration
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class AuthInterceptor @Inject constructor(
    private val appConfiguration: AppConfiguration,
) : Interceptor {

    private val apikey = BuildConfig.API_KEY
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val httpUrl = request.url.newBuilder().addQueryParameter(API_KEY_PARAMETER, apikey)
            .addQueryParameter(SESSION_ID_KEY,appConfiguration.getSessionId())
            .build()
        request = request.newBuilder().url(httpUrl).build()
        return chain.proceed(request)
    }

    companion object {
        private const val API_KEY_PARAMETER = "api_key"
        private const val SESSION_ID_KEY = "session_id"
    }
}