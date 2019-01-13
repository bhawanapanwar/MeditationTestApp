package com.insight.meditationapp.MeditationModule

import io.reactivex.observers.DisposableObserver

class ListObserver(private val listView:ListView) : DisposableObserver<List<ListModel>>() {

    override fun onComplete() {
        this.dispose()
    }

    override fun onNext(t: List<ListModel>) {

        listView.updateList(t.sortedBy { it.publisherName })
    }

    override fun onError(e: Throwable) {

    }

}