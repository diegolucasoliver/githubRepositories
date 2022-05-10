package com.diegolucasoliver.githubrepositories

import com.diegolucasoliver.githubrepositories.utils.SchedulerStrategies
import com.google.gson.Gson
import org.koin.dsl.module

val appModule = module {
    single { Gson() }
    single { SchedulerStrategies() }
}