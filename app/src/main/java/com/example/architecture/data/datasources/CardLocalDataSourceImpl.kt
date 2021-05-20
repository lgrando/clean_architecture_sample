package com.example.architecture.data.datasources

import com.example.architecture.domain.datasources.CardDataSource

class CardLocalDataSourceImpl() : CardDataSource.Local {

    override suspend fun getCachedCardList() {
    }
}