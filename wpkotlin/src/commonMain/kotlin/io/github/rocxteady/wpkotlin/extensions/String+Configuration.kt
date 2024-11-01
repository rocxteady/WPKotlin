package io.github.rocxteady.wpkotlin.extensions

import io.github.rocxteady.wpkotlin.WPKotlin
import io.github.rocxteady.wpkotlin.api.WPClientConfiguration

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
    return if (this.endsWith("/")) {
        this + path.removePrefix("/")
    } else {
        this + "/" + path.removePrefix("/")
    }
}