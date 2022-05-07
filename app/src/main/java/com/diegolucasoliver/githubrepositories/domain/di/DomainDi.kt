package com.diegolucasoliver.githubrepositories.domain.di


import com.diegolucasoliver.githubrepositories.domain.usecase.GetRepositoriesUseCase
import com.diegolucasoliver.githubrepositories.domain.usecase.GetRepositoriesUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetRepositoriesUseCase> { GetRepositoriesUseCaseImpl(repository = get()) }
}