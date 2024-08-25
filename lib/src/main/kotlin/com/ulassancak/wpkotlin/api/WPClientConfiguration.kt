package com.ulassancak.wpkotlin.api

data class WPClientConfiguration(
    val endpointType: EndpointType,
    val parameters: Map<String, Any>? = null
) {
    sealed class EndpointType {
        data class Base(val baseURL: String, val endpoint: String) : EndpointType()
        data class Endpoint(val endpoint: String) : EndpointType()
    }

    constructor(endpoint: String, parameters: Map<String, Any>? = null) : this(
        EndpointType.Endpoint(endpoint),
        parameters
    )

    constructor(baseURL: String, endpoint: String, parameters: Map<String, Any>? = null) : this(
        EndpointType.Base(baseURL, endpoint),
        parameters
    )
}