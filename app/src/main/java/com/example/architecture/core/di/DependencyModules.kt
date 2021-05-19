package com.example.architecture.core.di

import com.example.architecture.core.api.CardService
import com.example.architecture.core.api.getApi
import com.example.architecture.data.datasources.CardRemoteDataSourceImpl
import com.example.architecture.data.repositories.CardRepositoryImpl
import com.example.architecture.data.usecases.GetCardList
import com.example.architecture.domain.datasources.CardDataSource
import com.example.architecture.domain.repositories.CardRepository
import com.example.architecture.presentation.CardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DependencyModules {
    val appModule = module {

        // Services
        single { getApi(CardService::class.java) }

        // Data sources
        factory<CardDataSource.Remote> { CardRemoteDataSourceImpl(get()) }

        // Repositories
        factory<CardRepository> { CardRepositoryImpl(get()) }

        // Usecases
        factory { GetCardList(get()) }

        // View models
        viewModel { CardViewModel(get()) }
    }
}