package com.ulassancak.wpkotlin.models

import com.ulassancak.wpkotlin.extensions.decodedHtml
import com.ulassancak.wpkotlin.extensions.javaVersion
import kotlinx.datetime.LocalDateTime
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
    @SerialName("date_gmt") private val _date: LocalDateTime? = null,
    @SerialName("modified_gmt") private val _modified: LocalDateTime? = null,
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
    @kotlinx.serialization.Transient val date: java.time.LocalDateTime? = _date?.javaVersion,
    @kotlinx.serialization.Transient val modified: java.time.LocalDateTime? = _modified?.javaVersion,
)