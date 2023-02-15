package com.example.cocktailsappspil.rest

import com.example.cocktailsappspil.domain.Drink
import com.example.cocktailsappspil.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface DrinksNetworkRepository {

    fun getRandomDrink(): Flow<UIState<Drink>>
    fun searchDrinksByName(drinkName: String): Flow<UIState<List<Drink>>>
    fun getDrinkById(drinkId: String): Flow<UIState<Drink>>
    fun getDrinksWithFilter(filter: Filter): Flow<UIState<List<Drink>>>
    fun getFilterList(filterType: FilterType): Flow<UIState<List<Filter>>>

}

class DrinksNetworkRepositoryImpl(
    private val drinksApi: DrinksApi
): DrinksNetworkRepository{

    override fun getRandomDrink(): Flow<UIState<Drink>> = flow{
        emit(UIState.LOADING)
        try {
            val response = drinksApi.getRandomDrink()
            if(response.isSuccessful){
                response.body()?.let {
                    //todo emit response
                } ?: throw NullResponseException("Random song is null")
            } else throw ResponseFailureException("Could not connect to random song API")
        } catch (e: Exception){
            //todo error handling
        }
    }

    override fun searchDrinksByName(drinkName: String): Flow<UIState<List<Drink>>> {
        TODO("Not yet implemented")
    }

    override fun getDrinkById(drinkId: String): Flow<UIState<Drink>> {
        TODO("Not yet implemented")
    }

    override fun getDrinksWithFilter(filter: Filter): Flow<UIState<List<Drink>>> {
        TODO("Not yet implemented")
    }

    override fun getFilterList(filterType: FilterType): Flow<UIState<List<Filter>>> {
        TODO("Not yet implemented")
    }

}