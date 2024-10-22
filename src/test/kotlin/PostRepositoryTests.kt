import mocks.mock
import com.ulassancak.wpkotlin.models.Post
import kotlinx.coroutines.runBlocking
import mocks.MockedGetPostRepository
import mocks.MockedGetPostWithNoEmbeddedRepository
import mocks.MockedPostsRepository
import mocks.mockArray
import mocks.mockWithNoEmbedded
import kotlin.test.Test
import kotlin.test.assertEquals

class PostRepositoryTests {
    @Test fun testGettingPosts() {
        runBlocking {
            val posts = MockedPostsRepository().getPosts()
            val mockedPosts = Post.mockArray
            assertEquals(posts.size, mockedPosts.size)

            val post = posts[0]
            val mockedPost = mockedPosts[0]

            test(post, mockedPost)
        }
    }

    @Test fun testGettingPost() {
        runBlocking {
            val post = MockedGetPostRepository().getPost(1)
            val mockedPost = Post.mock

            test(post, mockedPost)
        }
    }

    @Test fun testGettingPostWithNoEmbedded() {
        runBlocking {
            val post = MockedGetPostWithNoEmbeddedRepository().getPost(1)
            val mockedPost = Post.mockWithNoEmbedded

            testWithNoEmbedded(post, mockedPost)
        }
    }

    fun test(post: Post, mockedPost: Post) {
        assertEquals(mockedPost.id, post.id)
        assertEquals(mockedPost.date, post.date)
        assertEquals(mockedPost.modified, post.modified)
        assertEquals(mockedPost.status, post.status)
        assertEquals(mockedPost.title.rendered, post.title.rendered)
        assertEquals(mockedPost.content.rendered, post.content.rendered)
        assertEquals(mockedPost.excerpt?.rendered, post.excerpt?.rendered)
        assertEquals(mockedPost.author, post.author)
        assertEquals(mockedPost.featuredMedia, post.featuredMedia)
        assertEquals(mockedPost.commentStatus, post.commentStatus)
        assertEquals(mockedPost.categories, post.categories)
        assertEquals(mockedPost.tags, post.tags)
        assertEquals(mockedPost.link, post.link)

        val mockedEmbeddedContent = mockedPost.embeddedContent
        val embeddedContent = post.embeddedContent

        val mockedAuthor = mockedEmbeddedContent?.author
        val author = embeddedContent?.author

        assertEquals(mockedAuthor?.id, author?.id)
        assertEquals(mockedAuthor?.name, author?.name)
        assertEquals(mockedAuthor?.description, author?.description)

        val mockedMedia = mockedEmbeddedContent?.featuredMedia
        val media = embeddedContent?.featuredMedia

        assertEquals(mockedMedia?.id, media?.id)
        assertEquals(mockedMedia?.title, media?.title)
        assertEquals(mockedMedia?.caption, media?.caption)
        assertEquals(mockedMedia?.altText, media?.altText)
        assertEquals(mockedMedia?.sourceURL, media?.sourceURL)

        val mockedMediaDetails = mockedMedia?.mediaDetails
        val mediaDetails = media?.mediaDetails

        assertEquals(mockedMediaDetails?.width, mediaDetails?.width)
        assertEquals(mockedMediaDetails?.height, mediaDetails?.height)

        val mockedSizes = mockedMediaDetails?.sizes
        val sizes = mediaDetails?.sizes

        assertEquals(mockedSizes?.size, sizes?.size)

        val mockedThumbnail = mockedSizes?.get("thumbnail")
        val thumbnail = sizes?.get("thumbnail")

        assertEquals(mockedThumbnail?.width, thumbnail?.width)
        assertEquals(mockedThumbnail?.height, thumbnail?.height)
        assertEquals(mockedThumbnail?.sourceURL, thumbnail?.sourceURL)
    }

    fun testWithNoEmbedded(post: Post, mockedPost: Post) {
        assertEquals(mockedPost.id, post.id)
        assertEquals(mockedPost.date, post.date)
        assertEquals(mockedPost.modified, post.modified)
        assertEquals(mockedPost.status, post.status)
        assertEquals(mockedPost.title.rendered, post.title.rendered)
        assertEquals(mockedPost.content.rendered, post.content.rendered)
        assertEquals(mockedPost.excerpt?.rendered, post.excerpt?.rendered)
        assertEquals(mockedPost.author, post.author)
        assertEquals(mockedPost.featuredMedia, post.featuredMedia)
        assertEquals(mockedPost.commentStatus, post.commentStatus)
        assertEquals(mockedPost.categories, post.categories)
        assertEquals(mockedPost.tags, post.tags)
        assertEquals(mockedPost.link, post.link)

        val mockedEmbeddedContent = mockedPost.embeddedContent
        val embeddedContent = post.embeddedContent

        val mockedAuthor = mockedEmbeddedContent?.author
        val author = embeddedContent?.author

        assertEquals(mockedAuthor, author)

        val mockedMedia = mockedEmbeddedContent?.featuredMedia
        val media = embeddedContent?.featuredMedia

        assertEquals(mockedMedia, media)
    }
}
