package com.ulassancak.wpkotlin.repositories

import com.ulassancak.wpkotlin.api.WPClient
import com.ulassancak.wpkotlin.api.WPClientConfiguration
import com.ulassancak.wpkotlin.api.WPEndpoint
import com.ulassancak.wpkotlin.helpers.*
import com.ulassancak.wpkotlin.models.Post
import com.ulassancak.wpkotlin.models.SimplePost

internal interface PostsRepositoryInterface {
    suspend fun getPosts(page: Int = 1, perPage: Int = 10, order: OrderType = OrderType.DESCENDING, categories: List<Int>? = null, categoriesToExclude: List<Int>? = null, tags: List<Int>? = null, tagsToExclude: List<Int>? = null, include: List<Int>? = null): List<Post>
}

internal interface SearchPostsRepositoryInterface {
    suspend fun searchPosts(term: String, page: Int = 1, perPage: Int = 10): List<SimplePost>
}

internal interface GetPostRepositoryInterface {
    suspend fun getPost(baseURL: String, id: Int): Post
    suspend fun getPost(id: Int): Post
}

class PostsRepository: PostsRepositoryInterface {
    override suspend fun getPosts(page: Int, perPage: Int, order: OrderType, categories: List<Int>?, categoriesToExclude: List<Int>?, tags: List<Int>?, tagsToExclude: List<Int>?, include: List<Int>?): List<Post> {
        val client = WPClient(WPClientConfiguration(WPEndpoint.Posts.path, PostsParamCreator.createParamsForPosts(page, perPage, order, categories, categoriesToExclude, tags, tagsToExclude, include)))
        return client.fetch()
    }
}

class SearchPostsRepository: SearchPostsRepositoryInterface {
    override suspend fun searchPosts(term: String, page: Int, perPage: Int): List<SimplePost> {
        val client = WPClient(WPClientConfiguration(WPEndpoint.Search.path, PostsParamCreator.createParamsForSearchPosts(term, page, perPage)))
        return client.fetch()
    }
}

class GetPostRepository: GetPostRepositoryInterface {
    override suspend fun getPost(baseURL: String, id: Int): Post {
        val client = WPClient(WPClientConfiguration(baseURL, WPEndpoint.Post(id).path))
        return client.fetch()
    }
    override suspend fun getPost(id: Int): Post {
        val client = WPClient(WPClientConfiguration(WPEndpoint.Post(id).path))
        return client.fetch()
    }
}