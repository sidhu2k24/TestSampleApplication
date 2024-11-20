package com.example.testsampleapplication.network

import com.example.testsampleapplication.network.model.Quote
import com.example.testsampleapplication.network.model.QuoteData
import retrofit2.Call
import retrofit2.http.GET

interface QuoteServiceAPI {

    //https://dummyjson.com/quotes
    @GET("quotes")
    fun getQuotes(): Call<QuoteData>
}