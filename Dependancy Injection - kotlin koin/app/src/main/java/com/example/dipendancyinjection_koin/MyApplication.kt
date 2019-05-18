package com.example.dipendancyinjection_koin

import android.app.Application
import com.example.dipendancyinjection_k.GitHubServiceAPI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {


    var listofModules = module {
        single { GitHubServiceAPI() }
    }


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listofModules)
        }
    }
}