package com.samrraa.qurioapp.di

import com.samrraa.qurioapp.datasource.remote.api.TriviaApiService
import com.samrraa.qurioapp.util.NetworkConstants.BASE_URL
import com.samrraa.qurioapp.util.NetworkConstants.CONNECTION_TIMEOUT
import com.samrraa.qurioapp.util.NetworkConstants.READ_TIMEOUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideTriviaApi(retrofit: Retrofit): TriviaApiService =
        retrofit.create(TriviaApiService::class.java)
}