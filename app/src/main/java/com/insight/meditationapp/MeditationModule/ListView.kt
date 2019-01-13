package com.insight.meditationapp.MeditationModule

interface ListView{
    fun showList(list:MutableList<ListModel>)
    fun updateList(list:List<ListModel>)
}