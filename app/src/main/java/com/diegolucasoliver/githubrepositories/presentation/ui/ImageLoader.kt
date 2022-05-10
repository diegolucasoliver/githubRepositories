package com.diegolucasoliver.githubrepositories.presentation.ui

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

const val AVATAR = 0
const val ICON = 1
private const val AVATAR_SIZE = 150
private const val ICON_SIZE = 70

interface ImageLoader {
    fun <T> load(view: ImageView, image: T, size: Int)
}

class ImageLoaderImpl: ImageLoader {
    override fun <T> load(view: ImageView, image: T, size: Int) {
        Glide.with(view)
            .load(image)
            .apply(checkSize(size))
            .into(view)
    }

    private fun checkSize(size: Int): RequestOptions {
        return if (size == AVATAR) RequestOptions.overrideOf(AVATAR_SIZE, AVATAR_SIZE)
        else RequestOptions.overrideOf(ICON_SIZE, ICON_SIZE)
    }
}