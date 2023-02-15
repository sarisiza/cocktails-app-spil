package com.example.cocktailsappspil.domain

import com.example.cocktailsappspil.rest.model.categories.CategoriesResult

/**
 * Data class that defines a category for the filter
 */
data class Category(
    val categoryName: String?
)

fun CategoriesResult?.mapCategory() =
    Category(this?.strCategory)
