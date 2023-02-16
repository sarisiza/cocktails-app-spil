package com.example.cocktailsappspil.utils

/**
 * Defines View Intents
 */
sealed class ViewIntent{

    data class SEARCH(val drinkName: String): ViewIntent()

    object RANDOM: ViewIntent()

    data class DETAILS(val drinkId: String): ViewIntent()

    object FILTER: ViewIntent()

    object FAVORITE: ViewIntent()

}
