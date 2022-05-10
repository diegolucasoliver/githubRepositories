package com.diegolucasoliver.githubrepositories.utils

import com.diegolucasoliver.githubrepositories.data.model.GitRepositoriesResponse
import com.diegolucasoliver.githubrepositories.data.model.OwnerResponse
import com.diegolucasoliver.githubrepositories.data.model.GitRepositoryResponse
import com.diegolucasoliver.githubrepositories.domain.model.GitRepositoriesModel
import com.diegolucasoliver.githubrepositories.domain.model.GitRepositoryModel
import com.diegolucasoliver.githubrepositories.domain.model.OwnerModel
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

fun getGitHubRepositoryResponse(): GitRepositoryResponse {
    return GitRepositoryResponse(
        "okhttp",
        42095,
        8849,
        getOwnerResponse()
    )
}

fun getGitHubRepositoryResponseNull(): GitRepositoryResponse? {
    return null
}

fun getGitHubRepositoriesResponse(): GitRepositoriesResponse {
    return GitRepositoriesResponse(
        listOf(getGitHubRepositoryResponse())
    )
}

fun getGitHubRepositoriesResponseNull(): GitRepositoriesResponse? {
    return null
}

fun getMockGitHubRepositories(): GitRepositoriesModel {
    return GitRepositoriesModel(
        listOf(
            GitRepositoryModel(
                "okhttp",
                42095,
                8849,
                OwnerModel(
                    "square",
                    "https://avatars.githubusercontent.com/u/82592?v=4"
                )
            ),
            GitRepositoryModel(
                "kotlin",
                41376,
                5101,
                OwnerModel(
                    "JetBrains",
                    "https://avatars.githubusercontent.com/u/878437?v=4"
                )
            )
        )
    )
}

fun getMockGitHubRepositoriesEmptyList(): GitRepositoriesModel {
    return GitRepositoriesModel(
        listOf()
    )
}