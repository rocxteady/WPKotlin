package com.ulassancak.wpkotlin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmbeddedContent(
    @SerialName("author") private val _author: List<Author>? = null,
    @SerialName("wp:featuredmedia") private val _featuredMedia: List<FeaturedMedia>? = null
) {
    val author: Author?
        get() = _author?.firstOrNull()

    val featuredMedia: FeaturedMedia?
        get() = _featuredMedia?.firstOrNull()
}