package com.diegolucasoliver.githubrepositories.presentation

import com.diegolucasoliver.githubrepositories.domain.usecase.GetRepositoriesUseCase
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoriesListContract
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoriesListPresenter
import com.diegolucasoliver.githubrepositories.utils.SchedulerStrategiesMock
import com.diegolucasoliver.githubrepositories.utils.getMockGitHubRepositories
import com.diegolucasoliver.githubrepositories.utils.getMockGitHubRepositoriesEmptyList
import com.diegolucasoliver.githubrepositories.utils.getMockHttpException
import io.reactivex.rxjava3.core.Single
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

class RepositoriesListPresenterTest {

    private val view: RepositoriesListContract.View = mock()
    private val useCase: GetRepositoriesUseCase = mock()
    private val schedulerStrategies = SchedulerStrategiesMock()
    private lateinit var presenter: RepositoriesListPresenter

    @Before
    fun setup() {
        presenter = RepositoriesListPresenter(view, useCase, schedulerStrategies)
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(view)
    }

    @Test
    fun `call getRepositories for first page and return success`() {
        whenever(useCase.execute(1)).thenReturn(Single.just(getMockGitHubRepositories()))

        presenter.getRepositories()

        verify(view).showLoading()
        verify(view).showRepositories(any())
    }

    @Test
    fun `call getRepositories after first page and return success`() {
        whenever(useCase.execute(2)).thenReturn(Single.just(getMockGitHubRepositories()))

        presenter.getRepositories(2)

        verify(view).showPaginationLoading()
        verify(view).showRepositories(any())
    }

    @Test
    fun `cal getRepositories and return empty list`() {
        whenever(useCase.execute(1)).thenReturn(Single.just(getMockGitHubRepositoriesEmptyList()))

        presenter.getRepositories()

        verify(view).showLoading()
        verify(view).showEmptyListMessage()
    }

    @Test
    fun `call getRepositories and return http error`() {
        whenever(useCase.execute(1)).thenReturn(Single.error(getMockHttpException()))

        presenter.getRepositories()

        verify(view).showLoading()
        verify(view).showError("422")
    }

    @Test
    fun `call getRepositories and return generic error`() {
        whenever(useCase.execute(1)).thenReturn(Single.error(Throwable()))

        presenter.getRepositories()

        verify(view).showLoading()
        verify(view).showError("")
    }
}