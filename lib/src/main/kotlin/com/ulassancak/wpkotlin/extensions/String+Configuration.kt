package com.ulassancak.wpkotlin.extensions

import com.ulassancak.wpkotlin.WPKotlin
import com.ulassancak.wpkotlin.api.WPClientConfiguration
import java.net.URL

fun String.Companion.initialize(endpointType: WPClientConfiguration.EndpointType): String {
    return when (endpointType) {
        is WPClientConfiguration.EndpointType.Base -> {
            var url = URL(endpointType.baseURL)
            url = url.appendPath(endpointType.endpoint)
            url.toString()
        }
        is WPClientConfiguration.EndpointType.Endpoint -> {
            val configuration = WPKotlin.configuration
            var url = URL(configuration.route)
            url = url.appendPath(configuration.namespace)
            url = url.appendPath(endpointType.endpoint)
            url.toString()
        }
    }
}

private fun URL.appendPath(path: String): URL {
    val urlPath = this.path
    val newPath = if (urlPath.endsWith("/")) {
        "$urlPath$path"
    } else {
        "$urlPath/$path"
    }
    return URL(this.protocol, this.host, this.port, newPath)
}