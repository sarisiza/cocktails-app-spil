package com.example.cocktailsappspil.rest

import com.example.cocktailsappspil.rest.model.alcoholic.AlcoholicResponse
import com.example.cocktailsappspil.rest.model.categories.CategoriesResponse
import com.example.cocktailsappspil.rest.model.drinks.DrinksResponse
import com.example.cocktailsappspil.rest.model.glasses.GlassesResponse
import com.example.cocktailsappspil.rest.model.ingredients.IngredientsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface that defines the API parameters
 * Base URL
 * Paths
 * Queries
 */
interface DrinksApi {

    /**
     * Methods to get information from the API
     */
    @GET(RANDOM_DRINK)
    suspend fun getRandomDrink(): Response<DrinksResponse>

    @GET(SEARCH)
    suspend fun getDrinksByName(
        @Query("s") name: String
    ): Response<DrinksResponse>

    @GET(LOOKUP)
    suspend fun getDrinkById(
        @Query("i") id: String
    ): Response<DrinksResponse>

    @GET(FILTER)
    suspend fun getDrinksByIngredient(
        @Query("i") ingredient: String
    ): Response<DrinksResponse>

    @GET(FILTER)
    suspend fun getDrinksByGlass(
        @Query("g") ingredient: String
    ): Response<DrinksResponse>

    @GET(FILTER)
    suspend fun getDrinksByAlcoholic(
        @Query("a") ingredient: String
    ): Response<DrinksResponse>

    @GET(FILTER)
    suspend fun getDrinksByCategory(
        @Query("c") ingredient: String
    ): Response<DrinksResponse>

    @GET(FILTER_LIST)
    suspend fun getCategoryList(
        @Query("c") list: String = "list"
    ): Response<CategoriesResponse>

    @GET(FILTER_LIST)
    suspend fun getAlcoholicList(
        @Query("a") list: String = "list"
    ): Response<AlcoholicResponse>

    @GET(FILTER_LIST)
    suspend fun getGlassList(
        @Query("g") list: String = "list"
    ): Response<GlassesResponse>

    @GET(FILTER_LIST)
    suspend fun getIngredientList(
        @Query("i") list: String = "list"
    ): Response<IngredientsResponse>

    //Define the API parameters
    companion object{
        const val BASE_URL = "www.thecocktaildb.com/api/json/v1/1/"
        const val RANDOM_DRINK = "random.php"
        const val SEARCH = "search.php"
        const val LOOKUP = "lookup.php"
        const val FILTER_LIST = "list.php"
        const val FILTER = "filter.php"
    }

}