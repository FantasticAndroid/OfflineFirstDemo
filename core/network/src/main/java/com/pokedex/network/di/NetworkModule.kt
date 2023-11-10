package com.pokedex.network.di

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.pokedex.network.NetworkConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit.Builder {

        return Retrofit.Builder()
            .baseUrl(NetworkConstant.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())

    }

    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(OkHttpProfilerInterceptor())
            .callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

}