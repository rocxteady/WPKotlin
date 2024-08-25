package com.ulassancak.wpkotlin.models

import com.ulassancak.wpkotlin.extensions.decodedHtml
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    @SerialName("date_gmt") val date: String? = null,
    @SerialName("modified_gmt") val modified: String? = null,
    val status: String? = null,
    @SerialName("title") val title: RenderedContent,
    @SerialName("content") val content: RenderedContent? = null,
    @SerialName("excerpt") val excerpt: RenderedContent? = null,
    val author: Int? = null,
    @SerialName("featured_media") val featuredMedia: Int? = null,
    @SerialName("comment_status") val commentStatus: CommentStatus = CommentStatus.CLOSED,
    val categories: List<Int> = emptyList(),
    val tags: List<Int> = emptyList(),
    val link: String,
    @SerialName("_embedded") val embeddedContent: EmbeddedContent? = null,
    @SerialName("content_html") val contentHTML: String? = null
) {
    val htmlDecodedTitle: String
        get() = title.rendered.decodedHtml
}