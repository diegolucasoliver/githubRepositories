package com.diegolucasoliver.githubrepositories.domain.model

import com.diegolucasoliver.githubrepositories.utils.EMPTY_TEXT
import com.diegolucasoliver.githubrepositories.utils.ZERO_INT

data class GitHubRepositoriesDomain(
    val repositories: List<RepositoryDomain> = emptyList()
)

data class RepositoryDomain(
    val repoName: String = EMPTY_TEXT,
    val starsCount: Int = ZERO_INT,
    val forksCount: Int = ZERO_INT,
    val owner: OwnerDomain = OwnerDomain()
)

data class OwnerDomain(
    val ownerName: String = EMPTY_TEXT,
    val avatarUrl: String = EMPTY_TEXT
)
