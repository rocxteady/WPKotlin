package io.github.rocxteady.wpkotlin.models

import io.github.rocxteady.wpkotlin.extensions.decodedHtml
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
enum class CommentStatus(val value: String) {
    @SerialName("open") OPEN("open"),
    @SerialName("closed") CLOSED("closed"),
    @SerialName("close") CLOSE("close");

    val isOpen: Boolean
        get() = this == OPEN
}

@Serializable
data class RenderedContent(
    val rendered: String,
    val protected: Boolean = false
)

@Serializable
data class Post(
    val id: Int,
    @SerialName("date_gmt") val date: LocalDateTime? = null,
    @SerialName("modified_gmt") val modified: LocalDateTime? = null,
    val status: String? = null,
    val title: RenderedContent,
    val content: RenderedContent,
    val excerpt: RenderedContent? = null,
    val author: Int? = null,
    @SerialName("featured_media") val featuredMedia: Int? = null,
    @SerialName("comment_status") val commentStatus: CommentStatus = CommentStatus.CLOSED,
    val categories: List<Int> = emptyList(),
    val tags: List<Int> = emptyList(),
    val link: String,
    @SerialName("_embedded") val embeddedContent: EmbeddedContent? = null,
    val htmlDecodedTitle: String = title.rendered.decodedHtml,
)