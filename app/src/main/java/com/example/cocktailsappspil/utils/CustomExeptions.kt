package com.example.cocktailsappspil.utils

/**
 * Exception for failed API call
 */
class ResponseFailureException(message: String): Exception(message)

/**
 * Exception for Null Response
 */
class NullResponseException(message: String): Exception(message)
