package com.ulassancak.resting

data class RequestConfiguration(
    val urlString: String,
    val headers: Map<String, String> = emptyMap(),
    val parameters: Map<String, Any>? = null
)