import com.ulassancak.wpkotlin.mocks.mock
import com.ulassancak.wpkotlin.models.Post
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class PostRepositoryTests {
    @Test fun testGettingPosts() {
        runBlocking {
            val response = MockedPostsRepository().getPosts();
            assertEquals(response.size, 1);

            val post = response[0];
            val mockedPost = Post.mock;

            assertEquals(mockedPost.id, post.id);
            assertEquals(mockedPost.date, post.date);
            assertEquals(mockedPost.modified, post.modified);
            assertEquals(mockedPost.status, post.status);
            assertEquals(mockedPost.title.rendered, post.title.rendered);
            assertEquals(mockedPost.content?.rendered, post.content?.rendered);
            assertEquals(mockedPost.excerpt?.rendered, post.excerpt?.rendered);
            assertEquals(mockedPost.author, post.author);
            assertEquals(mockedPost.featuredMedia, post.featuredMedia);
            assertEquals(mockedPost.commentStatus, post.commentStatus);
            assertEquals(mockedPost.categories, post.categories);
            assertEquals(mockedPost.tags, post.tags);
            assertEquals(mockedPost.link, post.link);

            val mockedEmbeddedContent = mockedPost.embeddedContent;
            val embeddedContent = post.embeddedContent;

            val mockedAuthor = mockedEmbeddedContent?.author
            val author = embeddedContent?.author

            assertEquals(mockedAuthor?.id, author?.id);
            assertEquals(mockedAuthor?.name, author?.name);
            assertEquals(mockedAuthor?.description, author?.description);

            val mockedMedia = mockedEmbeddedContent?.featuredMedia
            val media = embeddedContent?.featuredMedia

            assertEquals(mockedMedia?.id, media?.id);
            assertEquals(mockedMedia?.title, media?.title);
            assertEquals(mockedMedia?.caption, media?.caption);
            assertEquals(mockedMedia?.altText, media?.altText);
            assertEquals(mockedMedia?.sourceURL, media?.sourceURL);

            val mockedMediaDetails = mockedMedia?.mediaDetails
            val mediaDetails = media?.mediaDetails

            assertEquals(mockedMediaDetails?.width, mediaDetails?.width);
            assertEquals(mockedMediaDetails?.height, mediaDetails?.height);

            val mockedSizes = mockedMediaDetails?.sizes
            val sizes = mediaDetails?.sizes

            assertEquals(mockedSizes?.size, sizes?.size);

            val mockedThumbnail = mockedSizes?.get("thumbnail")
            val thumbnail = sizes?.get("thumbnail")

            assertEquals(mockedThumbnail?.width, thumbnail?.width);
            assertEquals(mockedThumbnail?.height, thumbnail?.height);
            assertEquals(mockedThumbnail?.sourceURL, thumbnail?.sourceURL);
        }
    }
}
