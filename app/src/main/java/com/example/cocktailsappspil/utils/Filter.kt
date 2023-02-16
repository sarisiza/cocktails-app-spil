package com.example.cocktailsappspil.utils

import com.example.cocktailsappspil.rest.model.alcoholic.AlcoholicResult
import com.example.cocktailsappspil.rest.model.categories.CategoriesResult
import com.example.cocktailsappspil.rest.model.glasses.GlassesResult
import com.example.cocktailsappspil.rest.model.ingredients.IngredientsResult

/**
 * Sealed class that will manage the type of filters
 */
sealed class Filter{

    data class ALCOHOLIC_FILTER(val filter: AlcoholicResult): Filter()
    data class CATEGORY_FILTER(val filter: CategoriesResult): Filter()
    data class GLASS_FILTER(val filter: GlassesResult): Filter()
    data class INGREDIENT_FILTER(val filter: IngredientsResult): Filter()

}
