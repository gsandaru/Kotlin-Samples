package com.example.dipendancyinjection_koin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.dipendancyinjection_k.GitHubServiceAPI
import com.example.dipendancyinjection_koin.retrofit.GitHubService
import com.example.dipendancyinjection_koin.retrofit.Repo
import kotlinx.coroutines.*
import org.koin.android.ext.android.get

/**
 * Android DI - Sample KOIN
 *
 */

class MainActivity : AppCompatActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val serviceAPI: GitHubServiceAPI = get()

    val gitHubService: GitHubService = serviceAPI.getGitHubService()

    val call = gitHubService.listRepos("gsandaru")

    CoroutineScope(Dispatchers.IO).launch {

        val request = gitHubService.listRepos("gsandaru")

        withContext(Dispatchers.IO) {
            try {
                val response = request.await()
                if (response.isSuccessful) {

                    var data : List<Repo>? = response.body();

                    Log.d("MainActicity",
                        "Success ${data?.size} Repos Found")

                } else {

                    Log.d("MainActicity",
                        "Error : Status ${response.code()} ")

                }
            } catch (e: Exception) {
                Log.d("MainActicity",
                    "Exception ${e.message}")

            }
        }
    }
}
}
