package com.ulassancak.wpkotlin.repositories

import com.ulassancak.wpkotlin.api.WPClient
import com.ulassancak.wpkotlin.api.WPClientConfiguration
import com.ulassancak.wpkotlin.api.WPEndpoint
import com.ulassancak.wpkotlin.helpers.*;
import com.ulassancak.wpkotlin.models.Post

interface PostsRepositoryInterface {
    suspend fun getAllPosts(page: Int = 1, perPage: Int = 10, order: OrderType = OrderType.DESCENDING, categories: List<Int>? = null, categoriesToExclude: List<Int>? = null, tags: List<Int>? = null, tagsToExclude: List<Int>? = null, include: List<Int>? = null): List<Post>
}

class PostsRepository: PostsRepositoryInterface {
    override suspend fun getAllPosts(page: Int, perPage: Int, order: OrderType, categories: List<Int>?, categoriesToExclude: List<Int>?, tags: List<Int>?, tagsToExclude: List<Int>?, include: List<Int>?): List<Post> {
        val client = WPClient(WPClientConfiguration(WPEndpoint.Posts.path, PostsParamCreator.createParamsForPosts(page, perPage, order, categories, categoriesToExclude, tags, tagsToExclude, include)))
        return client.fetch();
    }
}