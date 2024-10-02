package com.ulassancak.wpkotlin.api

import com.ulassancak.wpkotlin.api.resting.RequestConfiguration
import com.ulassancak.wpkotlin.api.resting.RestClient
import com.ulassancak.wpkotlin.extensions.initialize

internal class WPClient(configuration: WPClientConfiguration) {
    internal val restClient: RestClient = RestClient()
    internal val requestConfig: RequestConfiguration = RequestConfiguration(
        urlString = String.initialize(configuration.endpointType),
        parameters = configuration.parameters
    )

    internal suspend inline fun <reified T>fetch(): T {
        val response: T = restClient.fetch(requestConfig)
        return response
    }
}