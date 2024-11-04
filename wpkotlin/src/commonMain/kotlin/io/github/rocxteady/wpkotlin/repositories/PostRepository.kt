package io.github.rocxteady.wpkotlin.repositories

import io.github.rocxteady.wpkotlin.api.WPClient
import io.github.rocxteady.wpkotlin.api.WPClientConfiguration
import io.github.rocxteady.wpkotlin.api.WPEndpoint
import io.github.rocxteady.wpkotlin.helpers.OrderType
import io.github.rocxteady.wpkotlin.helpers.PostsParamCreator
import io.github.rocxteady.wpkotlin.models.Post
import io.github.rocxteady.wpkotlin.models.SimplePost
import kotlinx.serialization.SerializationException
import kotlin.coroutines.cancellation.CancellationException

internal interface PostsRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    suspend fun getPosts(page: Int = 1, perPage: Int = 10, order: OrderType = OrderType.DESCENDING, categories: List<Int>? = null, categoriesToExclude: List<Int>? = null, tags: List<Int>? = null, tagsToExclude: List<Int>? = null, include: List<Int>? = null): List<Post>
}

internal interface SearchPostsRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    suspend fun searchPosts(term: String, page: Int = 1, perPage: Int = 10): List<SimplePost>
}

internal interface GetPostRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    suspend fun getPost(baseURL: String, id: Int): Post
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    suspend fun getPost(id: Int): Post
}

@Suppress("unused")
class PostsRepository: PostsRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    override suspend fun getPosts(page: Int, perPage: Int, order: OrderType, categories: List<Int>?, categoriesToExclude: List<Int>?, tags: List<Int>?, tagsToExclude: List<Int>?, include: List<Int>?): List<Post> {
        val client = WPClient(
            WPClientConfiguration(
                WPEndpoint.Posts.path,
                PostsParamCreator.createParamsForPosts(
                    page,
                    perPage,
                    order,
                    categories,
                    categoriesToExclude,
                    tags,
                    tagsToExclude,
                    include
                )
            )
        )
        return client.fetch()
    }
}

@Suppress("unused")
class SearchPostsRepository: SearchPostsRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    override suspend fun searchPosts(term: String, page: Int, perPage: Int): List<SimplePost> {
        val client = WPClient(
            WPClientConfiguration(
                WPEndpoint.Search.path,
                PostsParamCreator.createParamsForSearchPosts(term, page, perPage)
            )
        )
        return client.fetch()
    }
}

@Suppress("unused")
class GetPostRepository: GetPostRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    override suspend fun getPost(baseURL: String, id: Int): Post {
        val client = WPClient(WPClientConfiguration(baseURL, WPEndpoint.Post(id).path))
        return client.fetch()
    }
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    override suspend fun getPost(id: Int): Post {
        val client = WPClient(WPClientConfiguration(WPEndpoint.Post(id).path))
        return client.fetch()
    }
}