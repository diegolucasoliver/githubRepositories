package com.diegolucasoliver.githubrepositories.presentation

import com.diegolucasoliver.githubrepositories.domain.model.Repository

sealed class State {
    object Loading : State()
    object PaginationLoading : State()
    object InternetError : State()
    object EmptyError : State()
    data class Error(val code: String) : State()
    data class Success(val repositories: List<Repository>) : State()
}