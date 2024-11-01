package io.github.rocxteady.wpkotlin.repositories

import io.github.rocxteady.wpkotlin.api.WPClient
import io.github.rocxteady.wpkotlin.api.WPClientConfiguration
import io.github.rocxteady.wpkotlin.api.WPEndpoint
import io.github.rocxteady.wpkotlin.helpers.OrderType
import io.github.rocxteady.wpkotlin.helpers.PostsParamCreator
import io.github.rocxteady.wpkotlin.models.PostCategory

internal interface CategoriesRepositoryInterface {
    suspend fun getCategories(page: Int = 1, perPage: Int = 10, order: OrderType = OrderType.DESCENDING): List<PostCategory>
}

internal interface GetCategoryRepositoryInterface {
    suspend fun getCategory(id: Int): PostCategory
}

class CategoriesRepository: CategoriesRepositoryInterface {
    override suspend fun getCategories(page: Int, perPage: Int, order: OrderType): List<PostCategory> {
        val client = WPClient(
            WPClientConfiguration(
                WPEndpoint.Categories.path,
                PostsParamCreator.Companion.createParamsForCategories(page, perPage, order)
            )
        )
        return client.fetch()
    }
}

class GetCategoryRepository: GetCategoryRepositoryInterface {
    override suspend fun getCategory(id: Int): PostCategory {
        val client = WPClient(
            WPClientConfiguration(
                WPEndpoint.Category(id).path,
                PostsParamCreator.Companion.createParamsForCategory()
            )
        )
        return client.fetch()
    }
}