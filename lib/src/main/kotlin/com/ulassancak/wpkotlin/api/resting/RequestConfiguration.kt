package com.ulassancak.resting

internal data class RequestConfiguration(
    internal val urlString: String,
    internal val headers: Map<String, String> = emptyMap(),
    internal val parameters: Map<String, Any>? = null
)