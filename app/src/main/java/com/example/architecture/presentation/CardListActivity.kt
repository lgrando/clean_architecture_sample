package com.example.architecture.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.R
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardListActivity : AppCompatActivity() {

    private val viewModel by viewModel<CardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getCardList()
    }
}