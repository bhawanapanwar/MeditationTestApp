package com.insight.meditationapp.MeditationModule

data class ListModel (
        val id: String,
        val title: String,
        val image: String,
        val publisherId: String,
        var publisherName: String
)