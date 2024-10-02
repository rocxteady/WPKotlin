package com.ulassancak.wpkotlin.models

// Sealed class for network errors
sealed class WPError : Exception() {
    data object UrlMalformed : WPError() {
        private fun readResolve(): Any = UrlMalformed
    }

    data class Api(val error: Throwable) : WPError()
    data object Unknown : WPError() {
        private fun readResolve(): Any = Unknown
    }

    override fun getLocalizedMessage(): String {
        return when (this) {
            is UrlMalformed -> "URL is malformed."
            is Api -> error.localizedMessage ?: "An error occurred."
            is Unknown -> "Unknown error."
        }
    }
}