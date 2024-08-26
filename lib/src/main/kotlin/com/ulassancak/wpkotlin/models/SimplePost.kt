package com.ulassancak.wpkotlin.models

import com.ulassancak.wpkotlin.extensions.decodedHtml
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimplePost(
    val id: Int,
    val title: String,
    @SerialName("url") val link: String
) {
    val htmlDecodedTitle: String
        get() = title.decodedHtml
}