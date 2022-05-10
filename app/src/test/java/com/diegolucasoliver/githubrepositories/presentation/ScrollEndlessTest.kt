package com.diegolucasoliver.githubrepositories.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegolucasoliver.githubrepositories.presentation.ui.ScrollEndless
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class ScrollEndlessTest {

    private var moveMoreAction: (Int) -> Unit = mock()
    private val recyclerView: RecyclerView = mock()
    private lateinit var scrollEndless: ScrollEndless
    private var linearLayoutManager: LinearLayoutManager = mock()

    @Before
    fun setup() {
        scrollEndless = ScrollEndless(linearLayoutManager, 5, 30, moveMoreAction)
    }

    @Test
    fun `when call onScrolled with moving Y equal zero`() {
        scrollEndless.onScrolled(recyclerView, 0, 0)
        verify(moveMoreAction, never()).invoke(1)
    }

    @Test
    fun `when called isLastVisibleItem Return true`() {
        Assert.assertTrue(scrollEndless.isLastVisibleItem(30, 25, 5))
    }

    @Test
    fun `when called isLastVisibleItem Return False`() {
        Assert.assertFalse(scrollEndless.isLastVisibleItem(30, 24, 5))
    }

    @Test
    fun `when called isLastPage Return True`() {
        Assert.assertTrue(scrollEndless.isLastPage(100, 4))
    }

    @Test
    fun `when called isLastPage Return False`() {
        Assert.assertFalse(scrollEndless.isLastPage(120, 4))
    }

    @Test
    fun `when called onScrolled With arrived last item call next page`() {
        scrollEndless.addedItem()
        whenever(linearLayoutManager.itemCount).thenReturn(30)
        whenever(linearLayoutManager.findLastVisibleItemPosition()).thenReturn(25)
        scrollEndless.onScrolled(recyclerView, 1, 1)
        verify(moveMoreAction).invoke(2)
    }

    @Test
    fun `when called onScrolled With arrived last item dont call next page`() {
        scrollEndless.addedItem()
        whenever(linearLayoutManager.itemCount).thenReturn(30)
        whenever(linearLayoutManager.findLastVisibleItemPosition()).thenReturn(24)
        scrollEndless.onScrolled(recyclerView, 1, 1)
        verify(moveMoreAction, never()).invoke(any())
    }
}