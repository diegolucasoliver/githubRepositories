package com.diegolucasoliver.githubrepositories.presentation.ui

import com.diegolucasoliver.githubrepositories.domain.model.GitRepositoryModel

interface RepositoriesListContract {
    interface View {
        fun showLoading()
        fun showPaginationLoading()
        fun showRepositories(repositories: List<GitRepositoryModel>)
        fun showEmptyListMessage()
        fun showError(code: String)
    }

    interface Presenter {
        fun getRepositories()
        fun getRepositories(nextPage: Int)
        fun checkCurrentPage(currentPage: Int)
    }
}