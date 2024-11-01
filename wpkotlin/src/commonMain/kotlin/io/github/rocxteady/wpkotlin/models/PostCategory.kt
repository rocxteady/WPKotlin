package io.github.rocxteady.wpkotlin.models
import kotlinx.serialization.Serializable

@Serializable
data class PostCategory (
    val id: Int,
    val count: Int,
    val description: String,
    val link: String,
    val name: String,
    val parent: Int
)