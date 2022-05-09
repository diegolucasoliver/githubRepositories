package com.diegolucasoliver.githubrepositories.data

import com.diegolucasoliver.githubrepositories.data.model.GitHubRepositoriesResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("/search/repositories?q=language:kotlin&sort=stars&per_page=30")
    fun getRepositories(
        @Query("page") page: Int
    ): Single<GitHubRepositoriesResponse>
}