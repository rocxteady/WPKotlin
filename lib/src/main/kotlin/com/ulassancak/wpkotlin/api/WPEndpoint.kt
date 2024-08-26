package com.ulassancak.wpkotlin.api

sealed class WPEndpoint(val path: String) {

    // Posts Endpoints
    object Posts : WPEndpoint("/posts")
    object Search : WPEndpoint("/search")
    object Categories : WPEndpoint("/categories")

    // Regular class instead of data class for Post
    class Post(id: Int) : WPEndpoint("/posts/$id")

    // Categories Endpoints
    class Category(id: Int) : WPEndpoint("/categories/$id")
}