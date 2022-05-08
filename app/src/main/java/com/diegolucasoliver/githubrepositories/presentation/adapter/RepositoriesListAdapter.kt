package com.diegolucasoliver.githubrepositories.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegolucasoliver.githubrepositories.domain.model.RepositoryDomain
import com.diegolucasoliver.githubrepositories.presentation.RepositoryView
import com.diegolucasoliver.githubrepositories.presentation.adapter.RepositoriesListAdapter.RepositoriesListViewHolder

class RepositoriesListAdapter :
    RecyclerView.Adapter<RepositoriesListViewHolder>() {

    private val repositoryList: MutableList<RepositoryDomain> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesListViewHolder {
        val view = RepositoryView(parent.context)

        return RepositoriesListViewHolder(view)
    }

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: RepositoriesListViewHolder, position: Int) {
        holder.bind(repositoryList[position])
    }

    fun setData(repositories: List<RepositoryDomain>) {
        repositoryList.addAll(repositories)
        notifyDataSetChanged()
    }

    class RepositoriesListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(repository: RepositoryDomain) {
            (view as RepositoryView).bind(repository)
        }
    }
}