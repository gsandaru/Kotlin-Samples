package com.example.dipendancyinjection_koin.retrofit

import android.util.Log
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String):
            Deferred<Response<List<Repo>>>
}


