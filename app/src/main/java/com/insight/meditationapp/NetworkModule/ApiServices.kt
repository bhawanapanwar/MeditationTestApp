package com.insight.meditationapp.NetworkModule

import com.google.gson.JsonElement
import com.insight.meditationapp.MeditationModule.ListModel
import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @Headers("Content-Type: application/json")
    @GET
    fun getMeditationList(@Url url:String): Call<List<ListModel>>

    @Headers("Content-Type: application/json")
    @GET
    fun getPublisherName(@Url url:String): Call<JsonElement>
}