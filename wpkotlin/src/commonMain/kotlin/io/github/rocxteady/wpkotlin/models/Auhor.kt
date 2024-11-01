package io.github.rocxteady.wpkotlin.models

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val id: Int,
    val name: String,
    val description: String
)