package com.ulassancak.wpkotlin.extensions

val String.decodedHtml: String
    get() {
        val htmlEntities = mapOf(
            "&quot;" to "\"",
            "&amp;" to "&",
            "&lt;" to "<",
            "&gt;" to ">",
            "&apos;" to "'",
            // Add more HTML entities as needed
        )

        var decodedString = this
        for ((entity, char) in htmlEntities) {
            decodedString = decodedString.replace(entity, char)
        }
        return decodedString
    }