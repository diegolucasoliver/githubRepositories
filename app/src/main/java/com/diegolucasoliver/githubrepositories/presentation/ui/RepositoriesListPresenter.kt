package com.diegolucasoliver.githubrepositories.presentation.ui

import com.diegolucasoliver.githubrepositories.domain.usecase.GetRepositoriesUseCase
import com.diegolucasoliver.githubrepositories.presentation.State
import com.diegolucasoliver.githubrepositories.presentation.State.EmptyError
import com.diegolucasoliver.githubrepositories.presentation.State.Error
import com.diegolucasoliver.githubrepositories.presentation.State.InternetError
import com.diegolucasoliver.githubrepositories.presentation.State.Loading
import com.diegolucasoliver.githubrepositories.presentation.State.PaginationLoading
import com.diegolucasoliver.githubrepositories.presentation.State.Success
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoriesListContract.Presenter
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoriesListContract.View
import com.diegolucasoliver.githubrepositories.utils.EMPTY_TEXT
import com.diegolucasoliver.githubrepositories.utils.SchedulerStrategies
import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.HttpException
import java.io.IOException

const val FIRST_PAGE = 1

class RepositoriesListPresenter(
    private val view: View,
    private val useCase: GetRepositoriesUseCase,
    private val schedulerStrategies: SchedulerStrategies
) : Presenter {


    private val disposables = CompositeDisposable()

    override fun getRepositories() {
        renderStates(Loading)
        getRepositoriesList()
    }

    override fun getRepositories(nextPage: Int) {
        renderStates(PaginationLoading)
        getRepositoriesList(nextPage)
    }

    override fun checkCurrentPage(currentPage: Int) {
        if (currentPage > FIRST_PAGE) getRepositories(currentPage)
        else getRepositories()
    }

    private fun getRepositoriesList(page: Int = FIRST_PAGE) {
        val disposable = useCase.execute(page)
            .compose { schedulerStrategies.applyScheduler(it) }
            .map {
                if (it.repositories.isEmpty()) EmptyError
                else Success(it.repositories)
            }
            .onErrorReturn { checkError(it) }
            .compose { schedulerStrategies.applySchedulerMainThread(it) }
            .subscribe { renderStates(it) }
        disposables.add(disposable)
    }

    private fun checkError(throwable: Throwable): State {
        return when (throwable) {
            is IOException -> InternetError
            is HttpException -> Error(throwable.code().toString())
            else -> Error(EMPTY_TEXT)
        }
    }

    private fun renderStates(state: State) {
        when (state) {
            is Loading -> view.showLoading()
            is PaginationLoading -> view.showPaginationLoading()
            is InternetError -> view.showInternetError()
            is EmptyError -> view.showEmptyError()
            is Error -> view.showError(state.code)
            is Success -> view.showRepositories(state.repositories)
        }
    }
}