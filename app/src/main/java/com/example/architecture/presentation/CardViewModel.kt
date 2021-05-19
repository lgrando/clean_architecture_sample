package com.example.architecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.data.models.Card
import com.example.architecture.data.usecases.GetCardList
import kotlinx.coroutines.launch

class CardViewModel(
    private val getCardListUseCase: GetCardList
) : ViewModel() {

    private val _state = MutableLiveData<ViewState>(ViewState.Initial)
    val state: LiveData<ViewState> get() = _state

    private val _action = MutableLiveData<ActionState>()
    val action: LiveData<ActionState> get() = _action

    fun getCardList() {
        _state.postValue(ViewState.Loading)
        viewModelScope.launch {
            try {
                val response = getCardListUseCase()

                if (response.isSuccessful) {

                    val cardList = response.body()
                    if (cardList.isNullOrEmpty())
                        _action.postValue(ActionState.CardListEmpty)
                    else
                        _state.postValue(ViewState.CardListLoaded(cardList))
                }
            } catch (e: Exception) {
                _state.postValue(ViewState.CardListError(e))
            }
        }
    }

    sealed class ViewState {
        object Initial : ViewState()
        object Loading : ViewState()
        data class CardListLoaded(val cards: List<Card>) : ViewState()
        data class CardListError(val exception: Exception) : ViewState()
    }

    sealed class ActionState {
        object CardListEmpty : ActionState()
    }

}