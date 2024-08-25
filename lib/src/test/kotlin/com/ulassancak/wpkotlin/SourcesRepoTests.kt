import com.ulassancak.wpkotlin.WPKotlin
import com.ulassancak.wpkotlin.repositories.PostsRepository
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class LibraryTest {
    @Test fun someLibraryMethodReturnsTrue() {
        WPKotlin.initialize("https://time.com/wp-json", "wp/v2");
        runBlocking {
            val response = PostsRepository().getAllPosts();
            assertEquals(response.size, 10);
        }
    }
}
