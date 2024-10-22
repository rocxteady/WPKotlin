package mocks

import com.ulassancak.wpkotlin.helpers.OrderType
import com.ulassancak.wpkotlin.models.Post
import com.ulassancak.wpkotlin.repositories.GetPostRepositoryInterface
import com.ulassancak.wpkotlin.repositories.PostsRepositoryInterface

internal class MockedPostsRepository: PostsRepositoryInterface {
    override suspend fun getPosts(page: Int, perPage: Int, order: OrderType, categories: List<Int>?, categoriesToExclude: List<Int>?, tags: List<Int>?, tagsToExclude: List<Int>?, include: List<Int>?): List<Post> {
        return Post.mockArrayData;
    }
}

internal class MockedGetPostRepository: GetPostRepositoryInterface {
    override suspend fun getPost(id: Int): Post {
        return Post.mockData
    }

    override suspend fun getPost(baseURL: String, id: Int): Post {
        return Post.mockData
    }
}

internal class MockedGetPostWithNoEmbeddedRepository: GetPostRepositoryInterface {
    override suspend fun getPost(id: Int): Post {
        return Post.mockDataWithNoEmbedded
    }

    override suspend fun getPost(baseURL: String, id: Int): Post {
        return Post.mockDataWithNoEmbedded
    }
}