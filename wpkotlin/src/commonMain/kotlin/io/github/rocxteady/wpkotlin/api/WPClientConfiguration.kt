package io.github.rocxteady.wpkotlin.api

internal data class WPClientConfiguration(
    val endpointType: EndpointType,
    val parameters: Map<String, Any>? = null
) {
    internal sealed class EndpointType {
        data class Base(val baseURL: String, val endpoint: String) : EndpointType()
        data class Endpoint(val endpoint: String) : EndpointType()
    }

    internal constructor(endpoint: String, parameters: Map<String, Any>? = null) : this(
        EndpointType.Endpoint(endpoint),
        parameters
    )

    internal constructor(baseURL: String, endpoint: String, parameters: Map<String, Any>? = null) : this(
        EndpointType.Base(baseURL, endpoint),
        parameters
    )
}