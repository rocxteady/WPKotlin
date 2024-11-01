package io.github.rocxteady.wpkotlin.api

import io.github.rocxteady.wpkotlin.api.resting.RequestConfiguration
import io.github.rocxteady.wpkotlin.api.resting.RestClient
import io.github.rocxteady.wpkotlin.extensions.initialize

internal class WPClient(configuration: WPClientConfiguration) {
    internal val restClient: RestClient = RestClient()
    internal val requestConfig: RequestConfiguration = RequestConfiguration(
        urlString = String.Companion.initialize(configuration.endpointType),
        parameters = configuration.parameters
    )

    internal suspend inline fun <reified T>fetch(): T {
        val response: T = restClient.fetch(requestConfig)
        return response
    }
}