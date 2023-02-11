package com.example.cocktailsappspil.rest.model.drinks


import com.example.cocktailsappspil.rest.model.drinks.DrinkResult
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DrinksResponse(
    @Json(name = "drinks")
    val drinks: List<DrinkResult?>? = null
)