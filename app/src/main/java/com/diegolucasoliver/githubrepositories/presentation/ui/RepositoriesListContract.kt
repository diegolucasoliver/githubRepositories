package com.diegolucasoliver.githubrepositories.presentation.ui

import com.diegolucasoliver.githubrepositories.domain.model.GitHubRepository

interface RepositoriesListContract {
    interface View {
        fun showLoading()
        fun showPaginationLoading()
        fun showRepositories(repositories: List<GitHubRepository>)
        fun showEmptyListMessage()
        fun showError(code: String)
        fun showInternetError()
    }

    interface Presenter {
        fun getRepositories()
        fun getRepositories(nextPage: Int)
        fun checkCurrentPage(currentPage: Int)
    }
}