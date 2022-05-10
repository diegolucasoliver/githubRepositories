package com.diegolucasoliver.githubrepositories.data.repository

import com.diegolucasoliver.githubrepositories.data.Service
import com.diegolucasoliver.githubrepositories.data.model.GitRepositoriesResponse
import io.reactivex.rxjava3.core.Single

interface GitHubRepository {
    fun getRepositories(page: Int): Single<GitRepositoriesResponse>
}

class GitHubRepositoryImpl(private val service: Service): GitHubRepository {

    override fun getRepositories(page: Int): Single<GitRepositoriesResponse> {
        return service.getRepositories(page)
    }
}