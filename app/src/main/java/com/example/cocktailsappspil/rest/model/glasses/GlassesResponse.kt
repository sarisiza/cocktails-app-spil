package com.example.cocktailsappspil.rest.model.glasses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GlassesResponse(
    @Json(name = "drinks")
    val drinks: List<GlassesResult?>? = null
)