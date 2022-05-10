package com.diegolucasoliver.githubrepositories.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegolucasoliver.githubrepositories.domain.model.GitRepositoryModel
import com.diegolucasoliver.githubrepositories.presentation.adapter.RepositoriesListAdapter.RepositoriesListViewHolder
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoryView

class RepositoriesListAdapter :
    RecyclerView.Adapter<RepositoriesListViewHolder>() {

    private val repositoriesList: MutableList<GitRepositoryModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesListViewHolder {
        val view = RepositoryView(parent.context)

        return RepositoriesListViewHolder(view)
    }

    override fun getItemCount(): Int = repositoriesList.size

    override fun onBindViewHolder(holder: RepositoriesListViewHolder, position: Int) {
        holder.bind(repositoriesList[position])
    }

    fun setData(repositories: List<GitRepositoryModel>) {
        repositoriesList.addAll(repositories)
        notifyDataSetChanged()
    }

    class RepositoriesListViewHolder(private val view: RepositoryView): RecyclerView.ViewHolder(view) {

        fun bind(repository: GitRepositoryModel) {
            view.bind(repository)
        }
    }
}