package com.example.repoinfo.network

import com.example.repoinfo.model.UserDetails
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.github.com/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface UsersApiService {
    @GET("repositories")
    fun getProperties(@Query("since") since: Int):
            Call<List<UserDetails>>
}

object UsersApi {
    val retrofitService : UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java) }
}