package io.github.rocxteady.wpkotlin.models

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
    val id: Int,
    val title: RenderedContent,
    val caption: RenderedContent,
    @SerialName("alt_text") val altText: String,
    @SerialName("media_details") val mediaDetails: MediaDetails,
    @SerialName("source_url") val sourceURL: String
) {
    @Suppress("unused")
    val thumbnailURL: String?
        get() = mediaDetails.sizes["thumbnail"]?.sourceURL
}