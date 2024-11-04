package io.github.rocxteady.wpkotlin.repositories

import io.github.rocxteady.wpkotlin.api.WPClient
import io.github.rocxteady.wpkotlin.api.WPClientConfiguration
import io.github.rocxteady.wpkotlin.api.WPEndpoint
import io.github.rocxteady.wpkotlin.helpers.OrderType
import io.github.rocxteady.wpkotlin.helpers.PostsParamCreator
import io.github.rocxteady.wpkotlin.models.PostCategory
import kotlinx.serialization.SerializationException
import kotlin.coroutines.cancellation.CancellationException

internal interface CategoriesRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    suspend fun getCategories(page: Int = 1, perPage: Int = 10, order: OrderType = OrderType.DESCENDING): List<PostCategory>
}

internal interface GetCategoryRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    suspend fun getCategory(id: Int): PostCategory
}

@Suppress("unused")
class CategoriesRepository: CategoriesRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    override suspend fun getCategories(page: Int, perPage: Int, order: OrderType): List<PostCategory> {
        val client = WPClient(
            WPClientConfiguration(
                WPEndpoint.Categories.path,
                PostsParamCreator.createParamsForCategories(page, perPage, order)
            )
        )
        return client.fetch()
    }
}

@Suppress("unused")
class GetCategoryRepository: GetCategoryRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    override suspend fun getCategory(id: Int): PostCategory {
        val client = WPClient(
            WPClientConfiguration(
                WPEndpoint.Category(id).path,
                PostsParamCreator.createParamsForCategory()
            )
        )
        return client.fetch()
    }
}