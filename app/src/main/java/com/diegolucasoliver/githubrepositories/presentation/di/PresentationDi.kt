package com.diegolucasoliver.githubrepositories.presentation.di

import com.diegolucasoliver.githubrepositories.presentation.ui.ImageLoader
import com.diegolucasoliver.githubrepositories.presentation.ui.ImageLoaderImpl
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoriesListContract
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoriesListPresenter
import org.koin.dsl.module

val presentationModule = module {
    factory<RepositoriesListContract.Presenter> { (view: RepositoriesListContract.View) ->
        RepositoriesListPresenter(
            view = view,
            useCase = get(),
            schedulerStrategies = get()
        )
    }
    factory<ImageLoader> { ImageLoaderImpl() }
}