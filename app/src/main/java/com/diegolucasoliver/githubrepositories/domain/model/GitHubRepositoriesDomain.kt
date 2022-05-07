package com.diegolucasoliver.githubrepositories.domain.model

data class GitHubRepositoriesDomain(
    val repositories: List<RepositoryDomain> = emptyList()
)

data class RepositoryDomain(
    val repoName: String = "",
    val starsCount: Int = 0,
    val forksCount: Int = 0,
    val owner: OwnerDomain = OwnerDomain()
)

data class OwnerDomain(
    val ownerName: String = "",
    val avatarUrl: String = ""
)
