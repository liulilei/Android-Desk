package com.androiddesk.base.component.net

import com.androiddesk.base.component.BuildConfig
import com.androiddesk.base.component.net.cookie.CookieJarImpl
import com.androiddesk.base.component.net.cookie.store.MemoryCookieStore
import com.orhanobut.logger.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *@Description:
 * @author: lll
 * @date: 2018/8/7
 */
object RetrofitHelp {

    private const val DEFAULT_TIME_OUT = 30

    private var retrofit: Retrofit? = null

    private var client: OkHttpClient? = null

    private var baseUrl: String? = null

    private var autoInterceptor: AutoInterceptor = AutoInterceptor()

    fun setBaseUrl(baseUrl: String) {
        this.baseUrl = baseUrl
    }

    fun setInterceptor(autoInterceptor: AutoInterceptor) {
        this.autoInterceptor = autoInterceptor
    }

    fun getRetrofit(): Retrofit? {
        if (baseUrl == null || baseUrl == "") {
            throw RuntimeException("baseUrl can't empty")
        }
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getOkHttpClient())
                    .build()
        }
        return retrofit
    }

    fun getOkHttpClient(): OkHttpClient? {
        if (client == null) {
            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder.cookieJar(CookieJarImpl(MemoryCookieStore()))
            okHttpClientBuilder.connectTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)
            okHttpClientBuilder.retryOnConnectionFailure(true)
            okHttpClientBuilder.interceptors().add(AutoInterceptor())

            if (BuildConfig.DEBUG) {
                okHttpClientBuilder
                        .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Logger.e("url:", "" + message) }).setLevel(HttpLoggingInterceptor.Level.BODY))
            }

            client = okHttpClientBuilder.build()
        }
        return client
    }
}