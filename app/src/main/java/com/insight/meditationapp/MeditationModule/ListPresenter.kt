package com.insight.meditationapp.MeditationModule

class ListPresenter(var listView: ListView, val listInteractor: ListIterator) {

    fun getData() {

        listInteractor.hitApiMeditation().subscribeWith(ListObserver(listView))
    }

}

