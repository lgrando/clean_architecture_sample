package com.example.architecture.data.usecases

import com.example.architecture.data.models.Card
import com.example.architecture.domain.repositories.CardRepository
import retrofit2.Response

class GetCardList(private val cardRepository: CardRepository) {

    suspend operator fun invoke(): Response<List<Card>> = cardRepository.getCardList()
}