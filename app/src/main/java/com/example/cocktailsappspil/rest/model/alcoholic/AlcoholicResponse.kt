package com.example.cocktailsappspil.rest.model.alcoholic


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data class that defines the JSON format to get the alcoholic response
 */
@JsonClass(generateAdapter = true)
data class AlcoholicResponse(
    @Json(name = "drinks")
    val drinks: List<AlcoholicResult?>? = null
)