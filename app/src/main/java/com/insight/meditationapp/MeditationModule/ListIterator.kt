package com.insight.meditationapp.MeditationModule

import com.google.gson.JsonElement
import com.insight.meditationapp.NetworkModule.ApiServices
import com.insight.meditationapp.NetworkModule.RetrofitInstance
import com.insight.meditationapp.Utils.Constants
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListIterator {

    private lateinit var apiServices: ApiServices
    var result: List<ListModel>? = null
    val observable: PublishSubject<List<ListModel>> = PublishSubject.create<List<ListModel>>()

    fun hitApiMeditation(): Observable<List<ListModel>> {

        apiServices = RetrofitInstance.retrofitInstance.create(ApiServices::class.java)

        val call = apiServices.getMeditationList(Constants.MEDITATION_URL)


        call.enqueue(object : Callback<List<ListModel>> {

            override fun onResponse(call: Call<List<ListModel>>, response: Response<List<ListModel>>) {

                try {
                    result = response.body()
                    result!!.forEach { (hitApiPublisher(it.publisherId)) }

                } catch (e: JSONException) {
                    e.printStackTrace()
                    observable.onError(e)
                }

            }

            override fun onFailure(call: Call<List<ListModel>>, t: Throwable) {
                // Log.e("fail", "")
                observable.onError(t)

            }
        })
        return observable
    }

    fun hitApiPublisher(pubid: String) {

        apiServices = RetrofitInstance.retrofitInstance.create(ApiServices::class.java)

        val call = apiServices.getPublisherName(Constants.PUBLISHER_URL + pubid)

        call.enqueue(object : Callback<JsonElement> {

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {

                try {
                    // Log.e("result1", response.body().toString())
                    val jdata = JSONObject(response.body().toString())
                    val _id = jdata.getString("id")
                    val _name = jdata.getString("name")

                    result!!.forEach {
                        if (it.publisherId == _id)
                            it.publisherName = _name
                    }
                    var bool = false
                    result!!.forEach {
                        if (it.publisherName == null) {
                            bool = true
                        }
                    }

                    if (bool == false) {
                        observable.onNext(result!!)
                        observable.onComplete()
                    }

                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                //Log.e("fail", "")
            }
        })

    }

}