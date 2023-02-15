package com.example.cocktailsappspil.rest

import com.example.cocktailsappspil.domain.*
import com.example.cocktailsappspil.rest.model.alcoholic.AlcoholicResponse
import com.example.cocktailsappspil.rest.model.categories.CategoriesResponse
import com.example.cocktailsappspil.rest.model.glasses.GlassesResponse
import com.example.cocktailsappspil.rest.model.ingredients.IngredientsResponse
import com.example.cocktailsappspil.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Defines the functions to get information from the database
 */
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
                    emit(UIState.SUCCESS(it.drinks?.get(0).mapToDrink()))
                } ?: throw NullResponseException("Random drink is null")
            } else throw ResponseFailureException("Could not connect to random drink API")
        } catch (e: Exception){
            emit(UIState.ERROR(e))
        }
    }

    override fun searchDrinksByName(drinkName: String): Flow<UIState<List<Drink>>> = flow {
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

    override fun getDrinkById(drinkId: String): Flow<UIState<Drink>> = flow{
        emit(UIState.LOADING)
        try {
            val response = drinksApi.getDrinkById(drinkId)
            if(response.isSuccessful){
                response.body()?.let {
                    emit(UIState.SUCCESS(it.drinks?.get(0).mapToDrink()))
                } ?: throw NullResponseException("Drink is null")
            } else throw ResponseFailureException("Could not connect to random drink API")
        } catch (e: Exception){
            emit(UIState.ERROR(e))
        }
    }

    override fun getDrinksWithFilter(filter: Filter): Flow<UIState<List<Drink>>> = flow{
        try {
            val response = when(filter){
                is Filter.ALCOHOLIC_FILTER ->
                    drinksApi.getDrinksByAlcoholic(filter.filter.alcoholicName?:"")
                is Filter.CATEGORY_FILTER ->
                    drinksApi.getDrinksByCategory(filter.filter.categoryName?:"")
                is Filter.GLASS_FILTER ->
                    drinksApi.getDrinksByGlass(filter.filter.glassName?:"")
                is Filter.INGREDIENT_FILTER ->
                    drinksApi.getDrinksByIngredient(filter.filter.ingredientName?:"")
            }
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
                                filtersList.add(it.mapAlcoholic() as Filter)
                            }
                        FilterType.INGREDIENT ->
                            (it as IngredientsResponse).drinks?.forEach {
                                filtersList.add(it.mapIngredient() as Filter)
                            }
                        FilterType.GLASS ->
                            (it as GlassesResponse).drinks?.forEach {
                                filtersList.add(it.mapGlass() as Filter)
                            }
                        FilterType.CATEGORY ->
                            (it as CategoriesResponse).drinks?.forEach {
                                filtersList.add(it.mapCategory() as Filter)
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