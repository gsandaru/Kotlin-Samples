package com.example.dipendancyinjection_koin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Android DI - Sample KOIN
 *
 */
class MainActivity : AppCompatActivity() {

    var listofModules = module {
        single { TestClass() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(listofModules)
        }

        val injectedTestClass: TestClass = get()
        println(injectedTestClass.greeting())
    }
}
