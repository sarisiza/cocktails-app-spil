package com.example.cocktailsappspil.rest.model.categories


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class that defines the JSON format to get the categories list
 */
@JsonClass(generateAdapter = true)
data class CategoriesResult(
    @Json(name = "strCategory")
    val strCategory: String? = null
)