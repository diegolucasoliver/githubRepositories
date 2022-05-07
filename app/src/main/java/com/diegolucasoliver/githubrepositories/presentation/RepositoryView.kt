package com.diegolucasoliver.githubrepositories.presentation

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.diegolucasoliver.githubrepositories.R
import com.diegolucasoliver.githubrepositories.domain.model.RepositoryDomain

class RepositoryView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attributeSet, defStyleAttr) {

    private val repoName: TextView by lazy { findViewById(R.id.tv_repo_name) }
    private val infoView: InfoView by lazy { findViewById(R.id.info_view) }

    init {
        inflate(context, R.layout.view_repository, this)
    }

    fun bind(repository: RepositoryDomain) {
        repoName.text = repository.repoName
        infoView.bind(
            repository.owner.ownerName,
            R.drawable.ic_fork
        )
    }
}