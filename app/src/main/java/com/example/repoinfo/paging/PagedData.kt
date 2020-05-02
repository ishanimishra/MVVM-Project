//package com.example.repoinfo.paging
//
//import androidx.paging.PageKeyedDataSource
//import com.example.repoinfo.model.UserDetails
//import com.example.repoinfo.network.UsersApi
//import com.example.repoinfo.network.UsersApiService
//
//class PagedData(): PageKeyedDataSource<Int, UserDetails>() {
//
//
//
//    override fun loadInitial(
//        params: LoadInitialParams<Int>,
//        callback: LoadInitialCallback<Int, UserDetails>
//    ) {
//        val request = UsersApi.
//    }
//
//    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserDetails>) {
//
//    }
//
//    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserDetails>) {
//
//    }
//
//    override fun invalidate() {
//        super.invalidate()
//    }
//
//}