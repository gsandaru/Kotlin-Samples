package com.example.dipendancyinjection_k
import com.example.dipendancyinjection_koin.retrofit.GitHubService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class GitHubServiceAPI {

    fun getGitHubService() : GitHubService {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit.create(GitHubService::class.java)
    }
}