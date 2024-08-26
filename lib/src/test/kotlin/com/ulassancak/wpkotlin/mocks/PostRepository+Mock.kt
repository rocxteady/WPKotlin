import com.ulassancak.wpkotlin.helpers.OrderType
import com.ulassancak.wpkotlin.models.Post
import com.ulassancak.wpkotlin.repositories.PostsRepositoryInterface
import com.ulassancak.wpkotlin.mocks.mockArrayData;

internal class MockedPostsRepository: PostsRepositoryInterface {
    override suspend fun getPosts(page: Int, perPage: Int, order: OrderType, categories: List<Int>?, categoriesToExclude: List<Int>?, tags: List<Int>?, tagsToExclude: List<Int>?, include: List<Int>?): List<Post> {
        return Post.mockArrayData;
    }
}