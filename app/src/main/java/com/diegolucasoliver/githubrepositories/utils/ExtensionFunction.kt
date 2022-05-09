package com.diegolucasoliver.githubrepositories.utils

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun Int?.orZero(): Int {
    return this ?: 0
}

fun View.show() {
    this.visibility = VISIBLE
}

fun View.hide() {
    this.visibility = GONE
}