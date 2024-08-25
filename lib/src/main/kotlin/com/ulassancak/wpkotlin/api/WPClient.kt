package com.ulassancak.wpkotlin.api

import com.ulassancak.resting.RequestConfiguration
import com.ulassancak.resting.RestClient
import com.ulassancak.wpkotlin.extensions.initialize

class WPClient(configuration: WPClientConfiguration) {
    val restClient: RestClient = RestClient()
    val requestConfig: RequestConfiguration = RequestConfiguration(
        urlString = String.initialize(configuration.endpointType),
        parameters = configuration.parameters
    )

    suspend inline fun <reified T>fetch(): T {
        val response: T = restClient.fetch(requestConfig);
        return response;
    }
}