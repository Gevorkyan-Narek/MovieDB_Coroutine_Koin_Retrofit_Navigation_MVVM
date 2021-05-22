package com.example.moviedb.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkModule {

    companion object {

        private val moshi by lazy { Moshi.Builder().add(KotlinJsonAdapterFactory()).build() }

        private val loggingInterceptor by lazy {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpLoggingInterceptor
        }

        private val httpClient by lazy {
            OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        }

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(httpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        fun authApi(): AuthApi = retrofit.create(AuthApi::class.java)
        fun movieApi(): MovieApi = retrofit.create(MovieApi::class.java)
    }
}