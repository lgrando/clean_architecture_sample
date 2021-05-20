package com.example.architecture.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.R
import com.example.architecture.data.models.Card
import com.example.architecture.presentation.widgets.GenericAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardListActivity : AppCompatActivity() {

    private val viewModel by viewModel<CardViewModel>()
    private lateinit var cardAdapter: GenericAdapter<Card>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getCardList()

        configureUI()
        configureObservers()
    }

    private fun configureUI() {
        cardAdapter = GenericAdapter(R.layout.item_card) { card ->

        }
        cards.adapter = cardAdapter
    }

    private fun configureObservers() {
        viewModel.apply {
            state.observe(this@CardListActivity) { state ->
                when (state) {
                    is CardViewModel.ViewState.CardListError -> {
                    }
                    is CardViewModel.ViewState.CardListLoaded -> cardAdapter.setupItems(state.cards)
                    CardViewModel.ViewState.Initial -> {
                    }
                }
            }
            action.observe(this@CardListActivity) { action ->
                when (action) {
                    CardViewModel.ActionState.CardListEmpty -> Toast.makeText(this@CardListActivity, "Você não possui cartões", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            loading.observe(this@CardListActivity) { loading ->
                when (loading) {
                    CardViewModel.LoadingState.Start -> loader.visibility = View.VISIBLE
                    CardViewModel.LoadingState.Stop -> loader.visibility = View.GONE
                }
            }
        }
    }
}