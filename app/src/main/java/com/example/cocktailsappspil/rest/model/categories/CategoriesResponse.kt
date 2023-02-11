package com.example.cocktailsappspil.rest.model.categories


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoriesResponse(
    @Json(name = "drinks")
    val drinks: List<CategoriesResult?>? = null
)