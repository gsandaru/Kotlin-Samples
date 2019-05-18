package com.example.dipendancyinjection_koin

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import com.example.dipendancyinjection_k.TestClass
import com.example.dipendancyinjection_koin.retrofit.GitHubService
import com.example.dipendancyinjection_koin.retrofit.Repo
import kotlinx.coroutines.*
import okhttp3.Response
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.HttpException
import javax.security.auth.callback.Callback

/**
 * Android DI - Sample KOIN
 *
 */
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val injectedTestClass: TestClass = get()
        val gitHubService: GitHubService = injectedTestClass.getGitHubService()

        println(injectedTestClass.greeting())
        val call = gitHubService.listRepos("gsandaru")

        CoroutineScope(Dispatchers.IO).launch {
            val request = gitHubService.listRepos("gsandaru")
            withContext(Dispatchers.IO) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        //Do something with response e.g show to the UI.
                        var a : Int  = 0;
                    } else {
                        Toast.makeText(this@MainActivity,"Error: ${response.code()}",Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity,"Exception ${e.message}",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}
