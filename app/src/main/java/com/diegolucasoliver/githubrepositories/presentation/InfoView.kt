package com.diegolucasoliver.githubrepositories.presentation

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.diegolucasoliver.githubrepositories.R

class InfoView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attributeSet, defStyleAttr) {

    private val infoLabel: TextView by lazy { findViewById(R.id.tv_info_label) }
    private val infoIcon: ImageView by lazy { findViewById(R.id.iv_info_icon) }

    init {
        inflate(context, R.layout.view_infos, this)
    }

    fun bind(label: String, url: String) {
        infoLabel.text = label
        Glide.with(this)
            .load(url)
            .apply(RequestOptions.overrideOf(150, 150))
            .into(infoIcon)
    }

    fun bind(label: String, icon: Int) {
        infoLabel.text = label
        Glide.with(this)
            .load(icon)
            .apply(RequestOptions.overrideOf(70 , 70))
            .into(infoIcon)
        infoIcon.setColorFilter(
            ContextCompat.getColor(context, R.color.iconColor),
            PorterDuff.Mode.SRC_IN
        )
    }
}