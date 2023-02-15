package com.example.cocktailsappspil.domain

import com.example.cocktailsappspil.rest.model.alcoholic.AlcoholicResult

/**
 * Data class that defines alcoholic for the filter
 */
data class Alcoholic(
    val alcoholicName: String?
)

fun AlcoholicResult?.mapAlcoholic() =
    Alcoholic(this?.strAlcoholic)
