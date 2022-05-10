package com.diegolucasoliver.githubrepositories.presentation

import com.diegolucasoliver.githubrepositories.domain.model.GitRepositoryModel

sealed class State {
    object Loading : State()
    object PaginationLoading : State()
    object EmptyList : State()
    data class Error(val code: String) : State()
    data class Success(val repositories: List<GitRepositoryModel>) : State()
}
