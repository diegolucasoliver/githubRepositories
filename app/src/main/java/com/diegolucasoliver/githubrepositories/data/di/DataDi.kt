package com.diegolucasoliver.githubrepositories.data.di

import com.diegolucasoliver.githubrepositories.data.RetrofitClient
import com.diegolucasoliver.githubrepositories.data.Service
import com.diegolucasoliver.githubrepositories.data.repository.GitHubRepository
import com.diegolucasoliver.githubrepositories.data.repository.GitHubRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<Service> { get<RetrofitClient>().service }
    factory<GitHubRepository> { GitHubRepositoryImpl(service = get()) }
}