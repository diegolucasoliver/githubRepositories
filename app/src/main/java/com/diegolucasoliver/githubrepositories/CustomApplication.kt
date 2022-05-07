package com.diegolucasoliver.githubrepositories

import android.app.Application
import com.diegolucasoliver.githubrepositories.data.di.dataModule
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@CustomApplication)
            modules(
                appModule,
                dataModule
            )
        }
    }

    private val appModule = module {
        single { Gson() }
    }
}