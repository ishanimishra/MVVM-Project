package com.example.repoinfo.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.repoinfo.model.UserDetails
import com.example.repoinfo.repositories.UserRepositories


class UserViewModel(application: Application) : AndroidViewModel(application) {
    private var userRepositories : UserRepositories? = null
    private var userDetailsResponseLiveData : LiveData<UserDetails>? = null

//    fun UserViewModel(application: Application) {
//        super.application
//    }

    fun init() {
        userRepositories = UserRepositories()
        userDetailsResponseLiveData = userRepositories!!.getUserResponseLiveData()
    }

    fun getUserResponseLiveData(): LiveData<UserDetails>? {
        return userDetailsResponseLiveData
    }
}


//    fun searchVolumes(keyword: String?, author: String?) {
//        val dotenv: Dotenv = Dotenv.configure().directory("/assets").filename("env").load()
//        bookRepository.searchVolumes(keyword, author, dotenv.get("GOOGLE_API_KEY"))
//    }
