package com.example.cocktailsappspil.domain

import com.example.cocktailsappspil.rest.model.glasses.GlassesResult

/**
 * Data class that defines a glass for the filter
 */
data class Glass(
    val glassName: String?
)

fun GlassesResult?.mapGlass() =
    Glass(this?.strGlass)