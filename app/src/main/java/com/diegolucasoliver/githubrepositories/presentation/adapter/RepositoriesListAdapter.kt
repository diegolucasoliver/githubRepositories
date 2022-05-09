package com.diegolucasoliver.githubrepositories.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegolucasoliver.githubrepositories.domain.model.GitHubRepository
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoryView
import com.diegolucasoliver.githubrepositories.presentation.adapter.RepositoriesListAdapter.RepositoriesListViewHolder

class RepositoriesListAdapter :
    RecyclerView.Adapter<RepositoriesListViewHolder>() {

    private val repositoriesList: MutableList<GitHubRepository> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesListViewHolder {
        val view = RepositoryView(parent.context)

        return RepositoriesListViewHolder(view)
    }

    override fun getItemCount(): Int = repositoriesList.size

    override fun onBindViewHolder(holder: RepositoriesListViewHolder, position: Int) {
        holder.bind(repositoriesList[position])
    }

    fun setData(repositories: List<GitHubRepository>) {
        repositoriesList.addAll(repositories)
        notifyDataSetChanged()
    }

    class RepositoriesListViewHolder(private val view: RepositoryView): RecyclerView.ViewHolder(view) {

        fun bind(repository: GitHubRepository) {
            view.bind(repository)
        }
    }
}