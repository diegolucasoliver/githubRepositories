package com.diegolucasoliver.githubrepositories.domain.model

import com.diegolucasoliver.githubrepositories.utils.EMPTY_TEXT
import com.diegolucasoliver.githubrepositories.utils.ZERO_INT

data class GitRepositoriesModel(
    val repositories: List<GitRepositoryModel> = emptyList()
)

data class GitRepositoryModel(
    val repoName: String = EMPTY_TEXT,
    val starsCount: Int = ZERO_INT,
    val forksCount: Int = ZERO_INT,
    val owner: OwnerModel = OwnerModel()
)

data class OwnerModel(
    val ownerName: String = EMPTY_TEXT,
    val avatarUrl: String = EMPTY_TEXT
)
