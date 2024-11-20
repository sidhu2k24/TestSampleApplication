package com.example.testsampleapplication.network

import com.example.testsampleapplication.network.model.Quote
import com.example.testsampleapplication.network.model.QuoteData
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkCall {

    fun getQuotes(callback: (List<Quote>?) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(QuoteServiceAPI::class.java)

        apiService.getQuotes().enqueue(object : Callback<QuoteData> {
            override fun onResponse(p0: Call<QuoteData>, p1: Response<QuoteData>) {
                println("Network call Success")
                if (p1.isSuccessful) {
                   val quotesData = p1.body()
                   callback(quotesData?.quotes)
                } else {
                    callback(emptyList())
                }
            }

            override fun onFailure(p0: Call<QuoteData>, p1: Throwable) {
                println("Network call failed")
            }

        })

    }

}