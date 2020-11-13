package com.example.koinapplication.repo

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { providesNetworkClient(get()) }
    single { NetworkService(get()) }
    single { NetworkRepo(get()) }
    single { DataRepo(get())}
}

val appModule = module {

}

fun providesNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.familycart.ie/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideForecastApi(retrofit: Retrofit): DataSource = retrofit.create(DataSource::class.java)

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url().newBuilder().addQueryParameter("APPID", "your_key").build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}

class NetworkService(val retrofit: Retrofit) {
    fun getNetworkService(): RetrofitSource = retrofit.create(RetrofitSource::class.java)
}