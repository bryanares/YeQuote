package com.brian.tellinye.network

import com.brian.tellinye.models.Ye
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//base url
private const val BASE_URL = "https://api.kanye.rest"


//build Retrofit object with the moshi converter
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//Api interface with functions to the network
interface YeApiService {
    @GET(BASE_URL)
    suspend fun getYe(): Ye
}

//declare a lazily initialized Retrofit object
object YeApi {
    val retrofitService: YeApiService by lazy {
        retrofit.create(YeApiService::class.java)
    }
}
