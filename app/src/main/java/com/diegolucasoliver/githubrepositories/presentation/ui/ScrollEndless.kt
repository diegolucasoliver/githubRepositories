package com.diegolucasoliver.githubrepositories.presentation.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScrollEndless(
    private var layoutManager: LinearLayoutManager,
    private val visibleThreshold: Int = 5,
    private val pageSize: Int = 30,
    private val moveMoreAction: (Int) -> Unit
) : RecyclerView.OnScrollListener() {

    private var hasMoreItem = false

    private var currentPage = 1

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (dy == 0 || hasMoreItem.not()) return

        if (isLastPage(layoutManager.itemCount, currentPage, pageSize)) return

        if (isLastVisibleItem(layoutManager.itemCount, layoutManager.findLastVisibleItemPosition(), visibleThreshold)) {
            hasMoreItem = false
            currentPage += 1
            moveMoreAction(currentPage)
        }
    }

    fun addedItem() {
        hasMoreItem = true
    }

    private fun isLastVisibleItem(itemAllCount: Int, lastItemVisible: Int, visibleThreshold: Int): Boolean = (itemAllCount) <= lastItemVisible + visibleThreshold

    private fun isLastPage(itemAllCount: Int, currentPage: Int, sizePage: Int = 30): Boolean = itemAllCount / currentPage < sizePage
}