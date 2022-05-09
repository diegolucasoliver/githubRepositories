package com.diegolucasoliver.githubrepositories.presentation.ui

import android.app.AlertDialog
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegolucasoliver.githubrepositories.R
import com.diegolucasoliver.githubrepositories.R.id
import com.diegolucasoliver.githubrepositories.R.layout
import com.diegolucasoliver.githubrepositories.domain.model.Repository
import com.diegolucasoliver.githubrepositories.presentation.adapter.RepositoriesListAdapter
import com.diegolucasoliver.githubrepositories.presentation.listener.ScrollEndless
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoriesListContract.Presenter
import com.diegolucasoliver.githubrepositories.presentation.ui.RepositoriesListContract.View
import com.diegolucasoliver.githubrepositories.utils.hide
import com.diegolucasoliver.githubrepositories.utils.show
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class RepositoriesListActivity : AppCompatActivity(), View, KoinComponent {

    private val listContainer: RecyclerView by lazy { findViewById(id.repositories_container) }
    private val progressLoading: ProgressBar by lazy { findViewById(id.pi_loading) }
    private val paginationLoading: TextView by lazy { findViewById(id.tv_pagination_loading) }
    private val repositoriesAdapter: RepositoriesListAdapter by lazy { RepositoriesListAdapter() }
    private val linearLayoutManager: LinearLayoutManager by lazy { LinearLayoutManager(this) }
    private val presenter: Presenter by inject { parametersOf(this) }
    private val scrollEndless: ScrollEndless by lazy {
        ScrollEndless(linearLayoutManager) { page ->
            presenter.getRepositories(page)
            currentPage = page
        }
    }
    private var currentPage = FIRST_PAGE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_repositories_list)
        setupListContainer()
        presenter.getRepositories()
    }

    override fun showLoading() {
        progressLoading.show()
    }

    override fun showPaginationLoading() {
        paginationLoading.show()
    }

    override fun showRepositories(repositories: List<Repository>) {
        repositoriesAdapter.setData(repositories)
        scrollEndless.addedItem()
        hideLoading()
    }

    override fun showEmptyError() {
        hideLoading()
        showErrorDialog(
            this.getString(R.string.internal_error),
            this.getString(R.string.internal_message)
        )
    }

    override fun showError(code: String) {
        hideLoading()
        showErrorDialog(
            this.getString(R.string.service_error, code),
            this.getString(R.string.service_message)
        )
    }

    override fun showInternetError() {
        hideLoading()
        showErrorDialog(
            this.getString(R.string.internet_error),
            this.getString(R.string.internet_message)
        )
    }

    private fun setupListContainer() {
        with(listContainer) {
            adapter = repositoriesAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(scrollEndless)
        }
    }

    private fun hideLoading() {
        progressLoading.hide()
        paginationLoading.hide()
    }

    private fun showErrorDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(this.getString(R.string.positive_button_label)) { _, _ ->
                presenter.checkCurrentPage(currentPage)
            }
        if (currentPage > FIRST_PAGE) {
            builder.setNegativeButton(this.getString(R.string.negative_button_label)) { dialog, _ ->
                dialog.dismiss()
            }
        }
        builder.create()
    }
}