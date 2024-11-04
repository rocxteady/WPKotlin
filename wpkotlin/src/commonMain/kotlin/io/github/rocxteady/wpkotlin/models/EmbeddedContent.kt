package io.github.rocxteady.wpkotlin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
data class EmbeddedContent(
    @SerialName("author") private val _author: List<Author>? = null,
    @SerialName("wp:featuredmedia") private val _featuredMedia: List<FeaturedMedia>? = null
) {
    constructor(author: Author? = null, featuredMedia: FeaturedMedia? = null) : this(
        author?.let { listOf(it) },
        featuredMedia?.let { listOf(it) }
    )
    val author: Author?
        get() = _author?.firstOrNull()

    val featuredMedia: FeaturedMedia?
        get() = _featuredMedia?.firstOrNull()
}
