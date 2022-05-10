package com.diegolucasoliver.githubrepositories.utils

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SchedulerStrategiesMock: SchedulerStrategies() {
    override fun <T> applyScheduler(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(Schedulers.trampoline())
    }
}