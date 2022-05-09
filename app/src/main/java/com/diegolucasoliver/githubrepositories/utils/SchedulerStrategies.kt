package com.diegolucasoliver.githubrepositories.utils

import com.diegolucasoliver.githubrepositories.domain.model.GitHubRepositories
import com.diegolucasoliver.githubrepositories.presentation.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SchedulerStrategies {
    fun applyScheduler(observable: Observable<GitHubRepositories>): Observable<GitHubRepositories> {
        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun applySchedulerMainThread(observable: Observable<State>): Observable<State> {
        return observable.observeOn(AndroidSchedulers.mainThread())
    }
}