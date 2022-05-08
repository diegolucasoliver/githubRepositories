package com.diegolucasoliver.githubrepositories.domain.model

import com.diegolucasoliver.githubrepositories.utils.EMPTY_TEXT
import com.diegolucasoliver.githubrepositories.utils.ZERO_INT

data class GitHubRepositories(
    val repositories: List<Repository> = emptyList()
)

data class Repository(
    val repoName: String = EMPTY_TEXT,
    val starsCount: Int = ZERO_INT,
    val forksCount: Int = ZERO_INT,
    val owner: Owner = Owner()
)

data class Owner(
    val ownerName: String = EMPTY_TEXT,
    val avatarUrl: String = EMPTY_TEXT
)
