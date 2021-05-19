package com.example.architecture.domain.datasources

import com.example.architecture.data.models.Card
import retrofit2.Response

interface CardDataSource {

    interface Remote {
        suspend fun getCardList(): Response<List<Card>>
    }

    interface Local {

    }
}