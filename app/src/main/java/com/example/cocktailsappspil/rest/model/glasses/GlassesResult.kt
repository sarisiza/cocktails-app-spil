package com.example.cocktailsappspil.rest.model.glasses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class that defines the JSON format to get the glass list
 */
@JsonClass(generateAdapter = true)
data class GlassesResult(
    @Json(name = "strGlass")
    val strGlass: String? = null
)