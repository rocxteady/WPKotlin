package mocks

import com.ulassancak.wpkotlin.models.Author
import com.ulassancak.wpkotlin.models.EmbeddedContent
import com.ulassancak.wpkotlin.models.FeaturedMedia

val EmbeddedContent.Companion.mock: EmbeddedContent
    get() = EmbeddedContent(
        author = Author.mock,
        featuredMedia = FeaturedMedia.mock
    )

val EmbeddedContent.Companion.mockWithNoEmbedded: EmbeddedContent
    get() = EmbeddedContent(author = null, featuredMedia = null)