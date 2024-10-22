package com.ulassancak.wpkotlin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaDetails(
    var width: Int = 0,
    var height: Int = 0,
    var sizes: Map<String, Size> = emptyMap()
)

@Serializable
data class Size(
    var width: Int,
    var height: Int,
    @SerialName("source_url") var sourceURL: String
)

@Serializable
data class FeaturedMedia(
    val id: Int? = null,
    val title: RenderedContent? = null,
    val caption: RenderedContent? = null,
    @SerialName("alt_text") val altText: String? = null,
    @SerialName("media_details") val mediaDetails: MediaDetails? = null,
    @SerialName("source_url") val sourceURL: String? = null
) {
    val thumbnailURL: String?
        get() = mediaDetails?.sizes?.get("thumbnail")?.sourceURL
}