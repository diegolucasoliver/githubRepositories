package com.diegolucasoliver.githubrepositories.domain.model

import com.diegolucasoliver.githubrepositories.data.model.GitHubRepositoriesResponse
import com.diegolucasoliver.githubrepositories.data.model.OwnerResponse
import com.diegolucasoliver.githubrepositories.data.model.RepositoryResponse
import com.diegolucasoliver.githubrepositories.utils.orZero

fun OwnerResponse?.toDomain(): Owner {
    return Owner(
        ownerName = this?.ownerName.orEmpty(),
        avatarUrl = this?.avatarUrl.orEmpty()
    )
}

fun RepositoryResponse?.toDomain(): GitHubRepository {
    return GitHubRepository(
        repoName = this?.repoName.orEmpty(),
        starsCount = this?.starsCount.orZero(),
        forksCount = this?.forksCount.orZero(),
        owner = this?.owner.toDomain()
    )
}

fun GitHubRepositoriesResponse?.toDomain(): GitHubRepositories {
    return GitHubRepositories(
        repositories = this?.repositories?.map { it.toDomain() }.orEmpty()
    )
}