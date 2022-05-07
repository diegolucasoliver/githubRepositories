package com.diegolucasoliver.githubrepositories.data.di

import com.diegolucasoliver.githubrepositories.data.GitHubRepository
import com.diegolucasoliver.githubrepositories.data.GitHubRepositoryImpl
import com.diegolucasoliver.githubrepositories.data.RetrofitClient
import com.diegolucasoliver.githubrepositories.data.Service
import org.koin.dsl.module

val dataModule = module {
    single<Service> { get<RetrofitClient>().service }
    factory<GitHubRepository> { GitHubRepositoryImpl(service = get()) }
}