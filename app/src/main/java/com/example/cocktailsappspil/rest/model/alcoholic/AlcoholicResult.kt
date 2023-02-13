package com.example.cocktailsappspil.rest.model.alcoholic


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class that defines the JSON format to get the alcoholic list
 */
@JsonClass(generateAdapter = true)
data class AlcoholicResult(
    @Json(name = "strAlcoholic")
    val strAlcoholic: String? = null
)