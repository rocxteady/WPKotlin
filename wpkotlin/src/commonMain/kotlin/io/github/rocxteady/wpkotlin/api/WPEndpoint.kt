package io.github.rocxteady.wpkotlin.api

sealed class WPEndpoint(val path: String) {

    // Posts Endpoints
    data object Posts : WPEndpoint("/posts")
    data object Search : WPEndpoint("/search")
    data object Categories : WPEndpoint("/categories")

    // Regular class instead of data class for Post
    class Post(id: Int) : WPEndpoint("/posts/$id")

    // Categories Endpoints
    class Category(id: Int) : WPEndpoint("/categories/$id")
}