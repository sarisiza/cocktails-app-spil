package com.example.cocktailsappspil.rest.model.ingredients


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientsResult(
    @Json(name = "strIngredient1")
    val strIngredient1: String? = null
)