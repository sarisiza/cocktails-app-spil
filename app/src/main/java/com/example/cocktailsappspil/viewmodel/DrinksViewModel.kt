package com.example.cocktailsappspil.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailsappspil.domain.Drink
import com.example.cocktailsappspil.usecases.DrinkByNameUseCase
import com.example.cocktailsappspil.usecases.RandomDrinkUseCase
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
    private val drinkByNameUseCase: DrinkByNameUseCase,
    private val randomDrinkUseCase: RandomDrinkUseCase
):ViewModel() {

    private val _cocktailsList: MutableLiveData<UIState<List<Drink>>> = MutableLiveData(UIState.LOADING)
    val cocktailsList: LiveData<UIState<List<Drink>>> get() = _cocktailsList

    fun getIntentView(intent: ViewIntent){
        when(intent){
            is ViewIntent.DETAILS -> {
            }
            ViewIntent.FAVORITE -> {
                TODO()
            }
            ViewIntent.FILTER -> {
                TODO()
            }
            ViewIntent.RANDOM -> {
                getRandomDrinks()
            }
            is ViewIntent.SEARCH -> {
                getDrinksByName(intent.drinkName)
            }
        }
    }

    private fun getDrinksByName(drinkName: String){
        viewModelScope.launch(ioDispatcher) {
            drinkByNameUseCase.getDrinksByName(drinkName).collect{
                _cocktailsList.postValue(it)
            }
        }
    }

    private fun getRandomDrinks(){
        viewModelScope.launch(ioDispatcher) {
            randomDrinkUseCase.getRandomDrinks().collect(){
                if(it is UIState.SUCCESS){
                    val randomList = it.response.shuffled()
                    _cocktailsList.postValue(UIState.SUCCESS(randomList))
                } else _cocktailsList.postValue(it)
            }
        }
    }

}