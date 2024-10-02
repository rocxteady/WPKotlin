package com.ulassancak.wpkotlin.models

import kotlinx.serialization.Serializable

@Serializable
data class APIInfo (
    val name: String,
    val description: String?,
    val url: String?,
    val home: String?,
)