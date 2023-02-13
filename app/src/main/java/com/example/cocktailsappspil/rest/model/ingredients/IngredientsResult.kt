package com.example.cocktailsappspil.rest.model.ingredients

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class that defines the JSON format to get the ingredients list
 */
@JsonClass(generateAdapter = true)
data class IngredientsResult(
    @Json(name = "strIngredient1")
    val strIngredient1: String? = null
)