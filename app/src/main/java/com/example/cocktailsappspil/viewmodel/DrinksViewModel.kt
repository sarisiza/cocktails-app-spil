package com.example.cocktailsappspil.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailsappspil.domain.Drink
import com.example.cocktailsappspil.rest.DrinksNetworkRepository
import com.example.cocktailsappspil.usecases.DrinkByNameUseCase
import com.example.cocktailsappspil.utils.UIState
import com.example.cocktailsappspil.utils.ViewIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Defining the View Model of the app
 */
@HiltViewModel
class DrinksViewModel @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val drinkByNameUseCase: DrinkByNameUseCase
):ViewModel() {

    private val _cocktailsList: MutableLiveData<UIState<List<Drink>>> = MutableLiveData(UIState.LOADING)
    val cocktailsList: LiveData<UIState<List<Drink>>> get() = _cocktailsList

    fun getIntentView(intent: ViewIntent){
        when(intent){
            ViewIntent.DETAILS_DRINK -> TODO()
            ViewIntent.FAVORITE_DRINK -> TODO()
            ViewIntent.FILTER_DRINK -> TODO()
            ViewIntent.RANDOM_DRINK -> {
                getDrinks()
            }
            ViewIntent.SEARCH_DRINK -> TODO()
        }
    }

    private fun getDrinks(name: String? = null){
        viewModelScope.launch(ioDispatcher) {
            drinkByNameUseCase.getDrinksByName(name).collect{
                _cocktailsList.postValue(it)
            }
        }
    }

}