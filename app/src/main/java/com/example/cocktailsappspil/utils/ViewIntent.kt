package com.example.cocktailsappspil.utils

/**
 * Defines View Intents
 */
sealed class ViewIntent{

    object SEARCH_DRINK: ViewIntent()

    object RANDOM_DRINK: ViewIntent()

    object DETAILS_DRINK: ViewIntent()

    object FILTER_DRINK: ViewIntent()

    object FAVORITE_DRINK: ViewIntent()

}
