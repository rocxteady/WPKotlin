package mocks

import com.ulassancak.wpkotlin.models.Author

val Author.Companion.mock: Author
    get() = Author(
        id = 123,
        name = "Author Name",
        description = "Author Description"
    )