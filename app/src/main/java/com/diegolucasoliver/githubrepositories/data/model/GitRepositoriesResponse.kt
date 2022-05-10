package com.diegolucasoliver.githubrepositories.data.model

import com.google.gson.annotations.SerializedName

data class GitRepositoriesResponse(
    @SerializedName("items")
    val repositories: List<GitRepositoryResponse?>?
)

data class GitRepositoryResponse(
    @SerializedName("name")
    val repoName: String?,
    @SerializedName("stargazers_count")
    val starsCount: Int?,
    @SerializedName("forks_count")
    val forksCount: Int?,
    @SerializedName("owner")
    val owner: OwnerResponse?
)

data class OwnerResponse(
    @SerializedName("login")
    val ownerName: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String?
)