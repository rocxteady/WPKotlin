import com.ulassancak.wpkotlin.WPKotlin
import com.ulassancak.wpkotlin.extensions.formatted
import com.ulassancak.wpkotlin.repositories.*
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

private class LibraryTest {
    @Test fun posts() {
        WPKotlin.initialize("https://time.com/wp-json", "wp/v2");
        runBlocking {
            val response = PostsRepository().getPosts();
            assertEquals(response.size, 10);
        }
    }

    @Test fun post() {
        WPKotlin.initialize("https://time.com/wp-json", "wp/v2");
        runBlocking {
            val response = GetPostRepository().getPost(7012318);
            println(response.date?.formatted);
        }
    }

    @Test fun postWithBaseURL() {
        runBlocking {
            val response = GetPostRepository().getPost("https://time.com/wp-json/wp/v2", 7012318);
            println(response);
        }
    }

    @Test fun searchPosts() {
        WPKotlin.initialize("https://time.com/wp-json", "wp/v2");
        runBlocking {
            val response = SearchPostsRepository().searchPosts("coronavirus");
            assertEquals(response.size, 10);
        }
    }

    @Test fun categories() {
        WPKotlin.initialize("https://time.com/wp-json", "wp/v2");
        runBlocking {
            val response = CategoriesRepository().getCategories();
            assertEquals(response.size, 10);
        }
    }

    @Test fun category() {
        WPKotlin.initialize("https://time.com/wp-json", "wp/v2");
        runBlocking {
            val response = GetCategoryRepository().getCategory(1258);
            println(response);
        }
    }

    @Test fun apiInfo() {
        runBlocking {
            val response = APIInfoRepository().getAPIInfo("https://time.com/wp-json");
            println(response);
        }
    }
}
