package com.example.cocktailsappspil.usecases

import com.example.cocktailsappspil.domain.Drink
import com.example.cocktailsappspil.rest.DrinksNetworkRepository
import com.example.cocktailsappspil.rest.NetworkState
import com.example.cocktailsappspil.utils.NoConnectionException
import com.example.cocktailsappspil.utils.UIState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RandomDrinkUseCase @Inject constructor(
    private val drinksNetworkRepository: DrinksNetworkRepository,
    private val networkState: NetworkState
) {

    fun getRandomDrinks(): Flow<UIState<List<Drink>>>{
        return if(networkState.isInternetOn()){
            drinksNetworkRepository.getDrinksByAlcohol("Alcoholic")
        } else throw NoConnectionException()
    }

}