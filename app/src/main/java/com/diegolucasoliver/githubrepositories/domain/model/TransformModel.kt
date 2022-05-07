package com.diegolucasoliver.githubrepositories.domain.model

import com.diegolucasoliver.githubrepositories.data.model.GitHubRepositoriesResponse
import com.diegolucasoliver.githubrepositories.data.model.OwnerResponse
import com.diegolucasoliver.githubrepositories.data.model.RepositoryResponse

fun OwnerResponse?.toDomain(): OwnerDomain {
    return OwnerDomain(
        ownerName = this?.ownerName.orEmpty(),
        avatarUrl = this?.avatarUrl.orEmpty()
    )
}

fun RepositoryResponse?.toDomain(): RepositoryDomain {
    return RepositoryDomain(
        repoName = this?.repoName.orEmpty(),
        starsCount = this?.starsCount ?: 0,
        forksCount = this?.forksCount ?: 0,
        owner = this?.owner.toDomain()
    )
}

fun GitHubRepositoriesResponse?.toDomain(): GitHubRepositoriesDomain {
    return GitHubRepositoriesDomain(
        repositories = this?.repositories?.map { it.toDomain() }.orEmpty()
    )
}