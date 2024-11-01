package com.ulassancak.wpkotlin.models

// Sealed class for network errors
sealed class WPError : Exception() {
    data object UrlMalformed : WPError()

    data class Api(val error: Throwable) : WPError()
    data object Unknown : WPError()

    override val message: String?
        get() = getLocalizedMessage()

    private fun getLocalizedMessage(): String {
        return when (this) {
            is UrlMalformed -> "URL is malformed."
            is Api -> super.message ?: "An error occurred."
            is Unknown -> "Unknown error."
        }
    }
}