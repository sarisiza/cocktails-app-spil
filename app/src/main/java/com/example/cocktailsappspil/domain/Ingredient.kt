package com.example.cocktailsappspil.domain

import com.example.cocktailsappspil.rest.model.ingredients.IngredientsResult

/**
 * Data class that defines an ingredient for the filter
 */
data class Ingredient(
    val ingredientName: String?,
    val imageUrl: String?
)

fun IngredientsResult?.mapIngredient() =
    Ingredient(this?.strIngredient1,
    "www.thecocktaildb.com/images/ingredients/${this?.strIngredient1}-Small.png")
