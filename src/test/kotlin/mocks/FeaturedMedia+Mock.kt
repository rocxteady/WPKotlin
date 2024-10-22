package mocks

import com.ulassancak.wpkotlin.models.FeaturedMedia
import com.ulassancak.wpkotlin.models.MediaDetails
import com.ulassancak.wpkotlin.models.RenderedContent
import com.ulassancak.wpkotlin.models.Size

val FeaturedMedia.Companion.mock: FeaturedMedia
    get() = FeaturedMedia(
        id = 1,
        title = RenderedContent(
            rendered = "Featured Media Title"
        ),
        caption = RenderedContent(
            rendered = "<p>Featured Media Caption</p>"
        ),
        altText = "Featured Media Alt Text",
        sourceURL = "https://example.com/wp-content/uploads/2024/06/7D5B29B3-CCFC-4E56-B838-81B48EBE9C24.jpg?quality=85",
        mediaDetails = MediaDetails(
            width = 1024,
            height = 684,
            sizes = mapOf(
                "thumbnail" to Size(
                    width = 150,
                    height = 150,
                    sourceURL = "https://example.com/wp-content/uploads/2024/06/7D5B29B3-CCFC-4E56-B838-81B48EBE9C24.jpg?quality=85&w=150&h=150&crop=1"
                )
            )
        )
    )