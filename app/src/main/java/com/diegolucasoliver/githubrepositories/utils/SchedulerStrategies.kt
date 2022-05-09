package com.diegolucasoliver.githubrepositories.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SchedulerStrategies {
    fun <T> applyScheduler(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}