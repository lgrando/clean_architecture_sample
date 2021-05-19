package com.example.architecture.data.repositories

import com.example.architecture.domain.datasources.CardDataSource
import com.example.architecture.domain.repositories.CardRepository
import retrofit2.Response

class CardRepositoryImpl(private val dataSource: CardDataSource.Remote) : CardRepository {

    override suspend fun getCardList() = dataSource.getCardList()

    override suspend fun blockCard() = true
}