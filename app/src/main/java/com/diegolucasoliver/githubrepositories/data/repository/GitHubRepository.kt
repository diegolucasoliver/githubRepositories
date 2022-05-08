package com.diegolucasoliver.githubrepositories.data.repository

import com.diegolucasoliver.githubrepositories.data.Service
import com.diegolucasoliver.githubrepositories.data.model.GitHubRepositoriesResponse
import io.reactivex.rxjava3.core.Single

interface GitHubRepository {
    fun getRepositories(page: Int): Single<GitHubRepositoriesResponse>
}

class GitHubRepositoryImpl(private val service: Service): GitHubRepository {

    override fun getRepositories(page: Int): Single<GitHubRepositoriesResponse> {
        return service.getRepositories(page)
    }
}