package com.example.architecture.domain.repositories

import com.example.architecture.data.models.Card
import retrofit2.Response

interface CardRepository {

    suspend fun getCardList(): Response<List<Card>>

    suspend fun blockCard(): Boolean
}