package com.example.cocktailsappspil.rest.model.ingredients


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class that defines the JSON format to get the ingredients response
 */
@JsonClass(generateAdapter = true)
data class IngredientsResponse(
    @Json(name = "drinks")
    val drinks: List<IngredientsResult?>? = null
)