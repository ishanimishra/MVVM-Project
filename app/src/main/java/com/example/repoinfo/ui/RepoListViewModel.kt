package com.example.repoinfo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.repoinfo.model.UserDetails
import com.example.repoinfo.repositories.UserRepositories

class RepoListViewModel : ViewModel() {
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

