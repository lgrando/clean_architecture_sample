package com.example.architecture.data.datasources

import com.example.architecture.core.api.CardService
import com.example.architecture.domain.datasources.CardDataSource

class CardRemoteDataSourceImpl(private val service: CardService): CardDataSource.Remote {

    override suspend fun getCardList() = service.getCardList()
}