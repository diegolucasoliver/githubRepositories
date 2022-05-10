package com.diegolucasoliver.githubrepositories.utils

import com.diegolucasoliver.githubrepositories.data.model.GitHubRepositoriesResponse
import com.diegolucasoliver.githubrepositories.data.model.OwnerResponse
import com.diegolucasoliver.githubrepositories.data.model.RepositoryResponse
import com.diegolucasoliver.githubrepositories.domain.model.GitHubRepositories
import com.diegolucasoliver.githubrepositories.domain.model.GitHubRepository
import com.diegolucasoliver.githubrepositories.domain.model.Owner
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response

fun getMockHttpException(): HttpException {
    return HttpException(
        Response.error<Any>(
            422,
            EMPTY_TEXT.toResponseBody("application/json".toMediaType())
        )
    )
}

fun getOwnerResponse(): OwnerResponse {
    return OwnerResponse(
        "square",
        "https://avatars.githubusercontent.com/u/82592?v=4"
    )
}

fun getOwnerResponseNull(): OwnerResponse? {
    return null
}

fun getGitHubRepositoryResponse(): RepositoryResponse {
    return RepositoryResponse(
        "okhttp",
        42095,
        8849,
        getOwnerResponse()
    )
}

fun getGitHubRepositoryResponseNull(): RepositoryResponse? {
    return null
}

fun getGitHubRepositoriesResponse(): GitHubRepositoriesResponse {
    return GitHubRepositoriesResponse(
        listOf(getGitHubRepositoryResponse())
    )
}

fun getGitHubRepositoriesResponseNull(): GitHubRepositoriesResponse? {
    return null
}

fun getMockGitHubRepositories(): GitHubRepositories {
    return GitHubRepositories(
        listOf(
            GitHubRepository(
                "okhttp",
                42095,
                8849,
                Owner(
                    "square",
                    "https://avatars.githubusercontent.com/u/82592?v=4"
                )
            ),
            GitHubRepository(
                "kotlin",
                41376,
                5101,
                Owner(
                    "JetBrains",
                    "https://avatars.githubusercontent.com/u/878437?v=4"
                )
            )
        )
    )
}

fun getMockGitHubRepositoriesEmptyList(): GitHubRepositories {
    return GitHubRepositories(
        listOf()
    )
}