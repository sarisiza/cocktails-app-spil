package com.example.cocktailsappspil.rest.model.drinks


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
/**
 * Data class that defines the JSON format to get the drinks response
 */
@JsonClass(generateAdapter = true)
data class DrinksResponse(
    @Json(name = "drinks")
    val drinks: List<DrinkResult>? = null
)