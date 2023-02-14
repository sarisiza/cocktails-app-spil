package com.example.cocktailsappspil.utils

/**
 * Sealed class that defines the states of the information for the UI
 */
sealed class UIState<out T>{

    object LOADING: UIState<Nothing>()

    data class SUCCESS<T>(val response: T): UIState<T>()

    data class ERROR(val error: Exception): UIState<Nothing>()

}
