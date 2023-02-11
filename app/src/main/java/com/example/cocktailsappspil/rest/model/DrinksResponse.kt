package com.example.cocktailsappspil.rest.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DrinksResponse(
    @Json(name = "drinks")
    val drinks: List<DrinkResult?>? = null
)