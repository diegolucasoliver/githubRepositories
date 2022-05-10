package com.diegolucasoliver.githubrepositories.presentation.ui

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.diegolucasoliver.githubrepositories.R
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class InfoView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attributeSet, defStyleAttr), KoinComponent {

    private val infoLabel: TextView by lazy { findViewById(R.id.tv_info_label) }
    private val infoIcon: ImageView by lazy { findViewById(R.id.iv_info_icon) }
    private val imageLoader: ImageLoader by inject()

    init {
        inflate(context, R.layout.view_infos, this)
    }

    fun bind(label: String, url: String) {
        infoLabel.text = label
        imageLoader.load(infoIcon, url, AVATAR)
    }

    fun bind(label: String, icon: Int) {
        infoLabel.text = label
        imageLoader.load(infoIcon, icon, ICON)
        setIconColor()
    }

    private fun setIconColor() {
        infoIcon.setColorFilter(
            ContextCompat.getColor(context, R.color.iconColor),
            PorterDuff.Mode.SRC_IN
        )
    }
}