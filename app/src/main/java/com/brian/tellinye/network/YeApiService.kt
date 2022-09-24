package com.brian.tellinye.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//base url
private const val BASE_URL = "https://api.kanye."


//build Moshi object with Kotlin adapter factory for Retrofit to to parse the JSON
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//build Retrofit object with the moshi converter
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//Api interface with functions to the network
interface YeApiService{
    @GET("rest")
    suspend fun getYe(): Ye
}

//declare a lazily initialized Retrofit object
object YeApi{
    val retrofitService : YeApiService by lazy {
        retrofit.create(YeApiService::class.java)
    }
}
