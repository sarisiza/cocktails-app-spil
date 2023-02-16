package com.example.cocktailsappspil.rest

import com.example.cocktailsappspil.domain.*
import com.example.cocktailsappspil.rest.model.alcoholic.AlcoholicResponse
import com.example.cocktailsappspil.rest.model.categories.CategoriesResponse
import com.example.cocktailsappspil.rest.model.glasses.GlassesResponse
import com.example.cocktailsappspil.rest.model.ingredients.IngredientsResponse
import com.example.cocktailsappspil.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Defines the functions to get information from the database
 */
interface DrinksNetworkRepository {

    fun getDrinksByName(drinkName: String): Flow<UIState<List<Drink>>>
    fun getFilterList(filterType: FilterType): Flow<UIState<List<Filter>>>

}

class DrinksNetworkRepositoryImpl @Inject constructor(
    private val drinksApi: DrinksApi
): DrinksNetworkRepository{


    override fun getDrinksByName(drinkName: String): Flow<UIState<List<Drink>>> = flow {
        emit(UIState.LOADING)
        try {
            val response = drinksApi.getDrinksByName(drinkName)
            if(response.isSuccessful){
                response.body()?.let {
                    val drinksList = mutableListOf<Drink>()
                    it.drinks?.forEach {
                        drinksList.add(it.mapToDrink())
                    }
                    emit(UIState.SUCCESS(drinksList))
                } ?: throw NullResponseException("Drink list is null")
            } else throw ResponseFailureException("Could not connect to random drink API")
        } catch (e: Exception){
            emit(UIState.ERROR(e))
        }
    }

    override fun getFilterList(filterType: FilterType): Flow<UIState<List<Filter>>> = flow {
        try {
            val response = when(filterType){
                FilterType.ALCOHOLIC ->
                    drinksApi.getAlcoholicList()
                FilterType.INGREDIENT ->
                    drinksApi.getIngredientList()
                FilterType.GLASS ->
                    drinksApi.getGlassList()
                FilterType.CATEGORY ->
                    drinksApi.getCategoryList()
            }
            if(response.isSuccessful){
                response.body()?.let {
                    val filtersList = mutableListOf<Filter>()
                    when(filterType){
                        FilterType.ALCOHOLIC ->
                            (it as AlcoholicResponse).drinks?.forEach {
                                filtersList.add(it as Filter)
                            }
                        FilterType.INGREDIENT ->
                            (it as IngredientsResponse).drinks?.forEach {
                                filtersList.add(it as Filter)
                            }
                        FilterType.GLASS ->
                            (it as GlassesResponse).drinks?.forEach {
                                filtersList.add(it as Filter)
                            }
                        FilterType.CATEGORY ->
                            (it as CategoriesResponse).drinks?.forEach {
                                filtersList.add(it as Filter)
                            }
                    }
                    emit(UIState.SUCCESS(filtersList))
                } ?: throw NullResponseException("Filter list is null")
            } else throw ResponseFailureException("Could not connect to random drink API")
        } catch (e: Exception){
            emit(UIState.ERROR(e))
        }
    }

}