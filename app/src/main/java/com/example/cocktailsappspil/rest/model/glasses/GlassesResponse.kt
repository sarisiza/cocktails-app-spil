package com.example.cocktailsappspil.rest.model.glasses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class that defines the JSON format to get the glasses response
 */
@JsonClass(generateAdapter = true)
data class GlassesResponse(
    @Json(name = "drinks")
    val drinks: List<GlassesResult?>? = null
)