package com.diegolucasoliver.githubrepositories.presentation

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.diegolucasoliver.githubrepositories.R
import com.diegolucasoliver.githubrepositories.domain.model.Owner
import com.diegolucasoliver.githubrepositories.domain.model.Repository

class RepositoryView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attributeSet, defStyleAttr) {

    private val repoName: TextView by lazy { findViewById(R.id.tv_repo_name) }
    private val ownerInfo: InfoView by lazy { findViewById(R.id.owner_info) }
    private val forksInfo: InfoView by lazy { findViewById(R.id.forks_info) }
    private val starsInfo: InfoView by lazy { findViewById(R.id.stars_info) }

    init {
        inflate(context, R.layout.view_repository, this)
    }

    fun bind(repository: Repository) {
        repoName.text = repository.repoName
        setOwnerInfo(repository.owner)
        setForksInfo(repository.forksCount)
        setStarsInfo(repository.starsCount)
    }

    private fun setOwnerInfo(owner: Owner) {
        ownerInfo.bind(owner.ownerName, owner.avatarUrl)
    }

    private fun setForksInfo(forksCount: Int) {
        forksInfo.bind(forksCount.toString(), R.drawable.ic_fork)
    }

    private fun setStarsInfo(starsCount: Int) {
        starsInfo.bind(starsCount.toString(), R.drawable.ic_star)
    }
}