package com.diegolucasoliver.githubrepositories

import android.app.Application
import com.diegolucasoliver.githubrepositories.data.di.dataModule
import com.diegolucasoliver.githubrepositories.domain.di.domainModule
import com.diegolucasoliver.githubrepositories.presentation.di.presentationModule
import com.diegolucasoliver.githubrepositories.utils.SchedulerStrategies
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
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }

    private val appModule = module {
        single { Gson() }
        single { SchedulerStrategies() }
    }
}