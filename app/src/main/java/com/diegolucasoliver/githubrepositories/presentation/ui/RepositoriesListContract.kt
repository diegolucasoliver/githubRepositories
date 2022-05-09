package com.diegolucasoliver.githubrepositories.presentation.ui

import com.diegolucasoliver.githubrepositories.domain.model.Repository

interface RepositoriesListContract {
    interface View {
        fun showLoading()
        fun showPaginationLoading()
        fun showRepositories(repositories: List<Repository>)
        fun showEmptyError()
        fun showError(code: String)
        fun showInternetError()
    }

    interface Presenter {
        fun getRepositories()
        fun getRepositories(page: Int)
    }
}