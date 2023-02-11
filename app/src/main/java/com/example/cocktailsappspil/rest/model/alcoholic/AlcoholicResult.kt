package com.example.cocktailsappspil.rest.model.alcoholic


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlcoholicResult(
    @Json(name = "strAlcoholic")
    val strAlcoholic: String? = null
)