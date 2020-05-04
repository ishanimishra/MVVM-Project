package com.example.repoinfo.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.repoinfo.model.UserDetails
import com.example.repoinfo.network.UsersApi
import com.example.repoinfo.network.UsersApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UserRepositories {
    private var userDetailsResponseLiveData : LiveData<UserDetails>? = null
    private val _response = MutableLiveData<String>()

    private fun getUserProperties() {
        UsersApi.retrofitService.getProperties(since = 5).enqueue(
            object: Callback<List<UserDetails>> {
                override fun onFailure(call: Call<List<UserDetails>>, t: Throwable) {
                    _response.value = "Failure: " + t.message
                }

                override fun onResponse(call: Call<List<UserDetails>>, response: Response<List<UserDetails>>) {
                    _response.value = response.body().toString()
                }
            })
    }

    fun getUserResponseLiveData() : LiveData<UserDetails>? {
        return userDetailsResponseLiveData
    }

    fun init() {
        getUserProperties()
    }


}

