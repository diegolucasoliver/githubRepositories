package com.diegolucasoliver.githubrepositories.domain

import com.diegolucasoliver.githubrepositories.domain.model.GitHubRepositories
import com.diegolucasoliver.githubrepositories.domain.model.GitHubRepository
import com.diegolucasoliver.githubrepositories.domain.model.Owner
import com.diegolucasoliver.githubrepositories.domain.model.toDomain
import com.diegolucasoliver.githubrepositories.utils.getGitHubRepositoriesResponse
import com.diegolucasoliver.githubrepositories.utils.getGitHubRepositoriesResponseNull
import com.diegolucasoliver.githubrepositories.utils.getGitHubRepositoryResponse
import com.diegolucasoliver.githubrepositories.utils.getGitHubRepositoryResponseNull
import com.diegolucasoliver.githubrepositories.utils.getOwnerResponse
import com.diegolucasoliver.githubrepositories.utils.getOwnerResponseNull
import org.junit.Assert.assertEquals
import org.junit.Test

class TransformModelTest {

    @Test
    fun `transform OwnerResponse into Owner`() {
        assertEquals(
            Owner(
                "square",
                "https://avatars.githubusercontent.com/u/82592?v=4"
            ),
            getOwnerResponse().toDomain()
        )
    }

    @Test
    fun `transform OwnerResponse null into Owner`() {
        assertEquals(
            Owner(
                "",
                ""
            ),
            getOwnerResponseNull().toDomain()
        )
    }

    @Test
    fun `transform RepositoryResponse into GitHubRepository`() {
        assertEquals(
            GitHubRepository(
                "okhttp",
                42095,
                8849,
                Owner(
                    "square",
                    "https://avatars.githubusercontent.com/u/82592?v=4"
                )
            ),
            getGitHubRepositoryResponse().toDomain()
        )
    }

    @Test
    fun `transform RepositoryResponse null into GitHubRepository`() {
        assertEquals(
            GitHubRepository(
                "",
                0,
                0,
                Owner()
            ),
            getGitHubRepositoryResponseNull().toDomain()
        )
    }

    @Test
    fun `transform GitHubRespositoriesResponse into GitHubRepositories`() {
        assertEquals(
            GitHubRepositories(
                listOf(
                    GitHubRepository(
                        "okhttp",
                        42095,
                        8849,
                        Owner(
                            "square",
                            "https://avatars.githubusercontent.com/u/82592?v=4"
                        )
                    )
                )
            ),
            getGitHubRepositoriesResponse().toDomain()
        )
    }

    @Test
    fun `transform GitHubRespositoriesResponse null into GitHubRepositories`() {
        assertEquals(
            GitHubRepositories(listOf()),
            getGitHubRepositoriesResponseNull().toDomain()
        )
    }
}