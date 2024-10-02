package com.ulassancak.wpkotlin.models

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null
)
