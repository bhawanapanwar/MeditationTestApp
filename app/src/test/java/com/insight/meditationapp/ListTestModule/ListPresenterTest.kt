package com.insight.meditationapp.ListTestModule

import com.insight.meditationapp.MeditationModule.ListIterator
import com.insight.meditationapp.MeditationModule.ListModel
import com.insight.meditationapp.MeditationModule.ListPresenter
import com.insight.meditationapp.MeditationModule.ListView
import io.reactivex.Observable
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListPresenterTest {

    @Mock
    lateinit var mockListView: ListView

    @Mock
    lateinit var mockList: List<ListModel>

    @Mock
    lateinit var mockListIterator: ListIterator

    lateinit var listPresenter: ListPresenter

    @Before
    fun setUp() {
        listPresenter = ListPresenter(mockListView, mockListIterator)
    }

    @Test
    @Ignore
    fun should_call_updateList_on_getData() {
        `when`(mockListIterator.hitApiMeditation()).thenReturn(Observable.just(mockList))
        listPresenter.getData()
    }
}