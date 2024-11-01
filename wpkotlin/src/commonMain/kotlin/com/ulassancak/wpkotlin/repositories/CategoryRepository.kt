package com.ulassancak.wpkotlin.repositories

import com.ulassancak.wpkotlin.api.WPClient
import com.ulassancak.wpkotlin.api.WPClientConfiguration
import com.ulassancak.wpkotlin.api.WPEndpoint
import com.ulassancak.wpkotlin.helpers.*;
import com.ulassancak.wpkotlin.models.Post
import com.ulassancak.wpkotlin.models.PostCategory

internal interface CategoriesRepositoryInterface {
    suspend fun getCategories(page: Int = 1, perPage: Int = 10, order: OrderType = OrderType.DESCENDING): List<PostCategory>
}

internal interface GetCategoryRepositoryInterface {
    suspend fun getCategory(id: Int): PostCategory
}

class CategoriesRepository: CategoriesRepositoryInterface {
    override suspend fun getCategories(page: Int, perPage: Int, order: OrderType): List<PostCategory> {
        val client = WPClient(WPClientConfiguration(WPEndpoint.Categories.path, PostsParamCreator.createParamsForCategories(page, perPage, order)))
        return client.fetch();
    }
}

class GetCategoryRepository: GetCategoryRepositoryInterface {
    override suspend fun getCategory(id: Int): PostCategory {
        val client = WPClient(WPClientConfiguration(WPEndpoint.Category(id).path, PostsParamCreator.createParamsForCategory()))
        return client.fetch();
    }
}