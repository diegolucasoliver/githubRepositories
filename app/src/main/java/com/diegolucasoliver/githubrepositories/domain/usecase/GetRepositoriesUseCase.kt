package com.diegolucasoliver.githubrepositories.domain.usecase

import com.diegolucasoliver.githubrepositories.data.repository.GitHubRepository
import com.diegolucasoliver.githubrepositories.domain.model.GitHubRepositories
import com.diegolucasoliver.githubrepositories.domain.model.toDomain
import io.reactivex.rxjava3.core.Observable

interface GetRepositoriesUseCase {
    fun execute(page: Int): Observable<GitHubRepositories>
}

class GetRepositoriesUseCaseImpl(val repository: GitHubRepository): GetRepositoriesUseCase {
    override fun execute(page: Int): Observable<GitHubRepositories> {
        return repository.getRepositories(page).map { it.toDomain() }
    }
}