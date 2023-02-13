package com.example.cocktailsappspil.domain

/**
 * Data class that defines a drink
 */
data class Drink(
    val drinkId: String,
    val alcoholic: Alcoholic,
    val category: Category,
    val drinkName: String,
    val drinkThumb: String,
    val glass: Glass,
    val ingredients: List<Ingredient>,
    val measures: List<String>,
    val instructions: String,
    val isFavorite: Boolean = false
)
