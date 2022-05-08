package com.diegolucasoliver.githubrepositories.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegolucasoliver.githubrepositories.domain.model.Repository
import com.diegolucasoliver.githubrepositories.presentation.RepositoryView
import com.diegolucasoliver.githubrepositories.presentation.adapter.RepositoriesListAdapter.RepositoriesListViewHolder

class RepositoriesListAdapter :
    RecyclerView.Adapter<RepositoriesListViewHolder>() {

    private val repositoryList: MutableList<Repository> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesListViewHolder {
        val view = RepositoryView(parent.context)

        return RepositoriesListViewHolder(view)
    }

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: RepositoriesListViewHolder, position: Int) {
        holder.bind(repositoryList[position])
    }

    fun setData(repositories: List<Repository>) {
        repositoryList.addAll(repositories)
        notifyDataSetChanged()
    }

    class RepositoriesListViewHolder(private val view: RepositoryView): RecyclerView.ViewHolder(view) {

        fun bind(repository: Repository) {
            view.bind(repository)
        }
    }
}