package io.github.rocxteady.wpkotlin.models

import io.github.rocxteady.wpkotlin.extensions.decodedHtml
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimplePost(
    val id: Int,
    val title: String,
    @SerialName("url") val link: String
) {
    @Suppress("unused")
    val htmlDecodedTitle: String
        get() = title.decodedHtml
}