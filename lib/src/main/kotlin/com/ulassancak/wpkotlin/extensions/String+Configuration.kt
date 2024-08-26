package com.ulassancak.wpkotlin.extensions

import com.ulassancak.wpkotlin.WPKotlin
import com.ulassancak.wpkotlin.api.WPClientConfiguration

internal fun String.Companion.initialize(endpointType: WPClientConfiguration.EndpointType): String {
    return when (endpointType) {
        is WPClientConfiguration.EndpointType.Base -> {
            endpointType.baseURL.appendPath(endpointType.endpoint)
        }
        is WPClientConfiguration.EndpointType.Endpoint -> {
            val configuration = WPKotlin.configuration
            val url = configuration.route.appendPath(configuration.namespace)
            url.appendPath(endpointType.endpoint)
        }
    }
}

internal fun String.Companion.initializeRoute(): String {
    val configuration = WPKotlin.configuration
    return configuration.route
}

private fun String.appendPath(path: String): String {
    //if this ends with / remove it, if path begins with / remove it
    if (this.endsWith("/")) {
        return this + path.removePrefix("/")
    } else {
        return this + "/" + path.removePrefix("/")
    }
}