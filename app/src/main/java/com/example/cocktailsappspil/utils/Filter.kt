package com.example.cocktailsappspil.utils

import com.example.cocktailsappspil.domain.Alcoholic
import com.example.cocktailsappspil.domain.Category
import com.example.cocktailsappspil.domain.Glass
import com.example.cocktailsappspil.domain.Ingredient

/**
 * Sealed class that will manage the type of filters
 */
sealed class Filter{

    data class ALCOHOLIC_FILTER(val filter: Alcoholic): Filter()
    data class CATEGORY_FILTER(val filter: Category): Filter()
    data class GLASS_FILTER(val filter: Glass): Filter()
    data class INGREDIENT_FILTER(val filter: Ingredient): Filter()

}
