package com.example.cocktailsappspil.rest.model.ingredients


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientsResponse(
    @Json(name = "drinks")
    val drinks: List<IngredientsResult?>? = null
)