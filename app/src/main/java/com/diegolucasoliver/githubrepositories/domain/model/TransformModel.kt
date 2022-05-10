package com.diegolucasoliver.githubrepositories.domain.model

import com.diegolucasoliver.githubrepositories.data.model.GitRepositoriesResponse
import com.diegolucasoliver.githubrepositories.data.model.OwnerResponse
import com.diegolucasoliver.githubrepositories.data.model.GitRepositoryResponse
import com.diegolucasoliver.githubrepositories.utils.orZero

fun OwnerResponse?.toDomain(): OwnerModel {
    return OwnerModel(
        ownerName = this?.ownerName.orEmpty(),
        avatarUrl = this?.avatarUrl.orEmpty()
    )
}

fun GitRepositoryResponse?.toDomain(): GitRepositoryModel {
    return GitRepositoryModel(
        repoName = this?.repoName.orEmpty(),
        starsCount = this?.starsCount.orZero(),
        forksCount = this?.forksCount.orZero(),
        owner = this?.owner.toDomain()
    )
}

fun GitRepositoriesResponse?.toDomain(): GitRepositoriesModel {
    return GitRepositoriesModel(
        repositories = this?.repositories?.map { it.toDomain() }.orEmpty()
    )
}