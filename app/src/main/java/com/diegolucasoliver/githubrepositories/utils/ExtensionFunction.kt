package com.diegolucasoliver.githubrepositories.utils

fun Int?.orZero(): Int {
    return this ?: 0
}