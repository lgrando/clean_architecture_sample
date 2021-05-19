package com.example.architecture.core.api

import com.example.architecture.data.models.Card
import retrofit2.Response
import retrofit2.http.GET

interface CardService {

    @GET("cards/list")
    suspend fun getCardList() : Response<List<Card>>
}