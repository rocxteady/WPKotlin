package com.ulassancak.wpkotlin

internal sealed class WPConfigurationError : Exception() {
    internal data object WasNotSetup : WPConfigurationError()

    internal data object Route : WPConfigurationError()

    internal data object Namespace : WPConfigurationError()

    override val message: String?
        get() = getLocalizedMessage()

    private fun getLocalizedMessage(): String {
        return when (this) {
            is WasNotSetup -> "WPKotlin is not initialized!"
            is Route -> "WPKotlin is not initialized!"
            is Namespace -> "WPKotlin is not initialized!"
        }
    }
}

internal data class WPConfiguration(
    val route: String,
    val namespace: String
)

object WPKotlin {
    internal val configuration: WPConfiguration
        get() {
            val config = _configuration ?: throw WPConfigurationError.WasNotSetup
            if (config.route.isEmpty()) throw WPConfigurationError.Route
            if (config.namespace.isEmpty()) throw WPConfigurationError.Namespace
            return config
        }

    private var _configuration: WPConfiguration? = null

    fun initialize(route: String, namespace: String) {
        _configuration = WPConfiguration(route, namespace)
    }
}

