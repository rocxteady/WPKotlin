package com.ulassancak.wpkotlin.mocks
import com.ulassancak.wpkotlin.models.*
import kotlinx.serialization.json.Json
import java.io.File
import java.time.LocalDateTime

val Post.mockData: Post
    get() {
        val classLoader = this::class.java.classLoader
        val resource = classLoader.getResource("Post.json")
        resource?.let {
            val file = File(resource.file)
            val jsonContent = file.readText()
            val post = Json.decodeFromString<Post>(jsonContent)
            return post
        } ?: run {
            throw ErrorMock("Post.json")
        }
    }

val Post.Companion.mockArrayData: List<Post>
    get() {
        val classLoader = this::class.java.classLoader
        val resource = classLoader.getResource("Posts.json")
        resource?.let {
            val file = File(resource.file)
            val jsonContent = file.readText()
            val post = Json.decodeFromString<List<Post>>(jsonContent)
            return post
        } ?: run {
            throw ErrorMock("Posts.json")
            }
        }

val Post.Companion.mock: Post
    get() {
        val post = Post(
            id = 1234,
            date = LocalDateTime.parse("2023-10-06T14:08:00"),
            modified = LocalDateTime.parse("2023-10-06T14:08:00"),
            status = "publish",
            title = RenderedContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            content = RenderedContent("<p> Malesuada porta eu velit urna ante venenatis mus cum, facilisis ipsum rutrum molestie. Euismod diam netus id varius, varius adipiscing phasellus nisl nam. Natoque tellus pulvinar faucibus primis. Imperdiet nascetur nullam aliquam ut mus torquent litora aptent libero? Elementum nostra, lorem tincidunt cursus! Dui tristique dignissim felis curae;. Dis praesent pellentesque varius pharetra aenean elementum non amet tincidunt. Porttitor urna aptent mattis odio scelerisque augue convallis fringilla. </p> <p> Rutrum conubia volutpat ad vulputate bibendum senectus magna molestie tincidunt placerat ultrices pulvinar. Vulputate semper sociis convallis eleifend et, ac aliquam sem massa diam. Metus at pharetra montes mi turpis arcu. Metus vestibulum feugiat massa sem aliquam odio blandit vivamus a lacinia nisi tellus. Urna venenatis sit ligula dis. In hac enim commodo vel euismod euismod. Quam condimentum vestibulum non orci. Lectus lacinia habitasse erat praesent. Nunc enim felis tempus hendrerit natoque viverra dui malesuada. Sapien dictum tortor nisl pulvinar, ut urna euismod velit. Ad convallis; rhoncus semper sapien urna. Vivamus magnis malesuada habitasse, platea platea. </p> <p> Condimentum nam iaculis congue habitasse tortor cursus blandit commodo. Vestibulum euismod egestas risus. Ultricies blandit mattis montes ipsum orci accumsan rutrum aenean. Cras sociis, nibh lacus morbi. Justo convallis convallis sem primis ad proin. Gravida magna convallis ultrices torquent nec. Fames maecenas natoque parturient. Natoque ipsum fusce et fames, morbi ipsum. Lacinia aenean facilisi nascetur sociosqu, vitae faucibus. Maecenas tincidunt varius neque fermentum. </p> <p> Magnis primis diam dui mauris dis habitant eleifend ligula at mollis. Nec parturient fermentum habitant torquent turpis laoreet dignissim nulla amet! Rhoncus nibh sapien lectus rhoncus. Suspendisse id hac conubia luctus diam nec curae;, proin tellus lacus ad est! Consequat proin mus erat duis leo a vivamus molestie massa. Varius, eros sit in pretium porttitor lacinia hendrerit habitasse vulputate? Nascetur potenti maecenas vestibulum nullam tellus lorem convallis augue ut. </p> <p> Torquent hac augue donec tristique. Feugiat netus iaculis faucibus. Dis ullamcorper egestas id dictumst. Parturient rhoncus pharetra maecenas. Curabitur ad velit curae; integer. Lorem sodales et commodo nascetur ornare sociosqu aenean ligula at vestibulum. Vestibulum nam purus mollis varius sit nec mauris. Auctor tellus consectetur non et bibendum diam cubilia erat! Aptent vestibulum pretium mattis. Justo ac, nec integer. Turpis sem netus sed mus penatibus tempus. Potenti erat accumsan tempus mattis risus senectus curae;! </p>"),
            excerpt = RenderedContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
            author = 1,
            featuredMedia = 5678,
            commentStatus = CommentStatus.OPEN,
            categories = listOf(1, 2),
            tags = listOf(3, 4),
            link = "https://example.com/1234",
            embeddedContent = EmbeddedContent(
                _author = listOf(
                    Author(
                        id = 123,
                        name = "Author Name",
                        description = "Author Description"
                    )
                ),
                _featuredMedia = listOf(
                    FeaturedMedia(
                        id = 123,
                        title = RenderedContent("Featured Media Title"),
                        caption = RenderedContent("<p>Featured Media Caption</p>"),
                        altText = "Featured Media Alt Text",
                        mediaDetails = MediaDetails(
                            width = 1024,
                            height = 684,
                            sizes = mapOf(
                                "thumbnail" to Size(
                                    width = 150,
                                    height = 150,
                                    sourceURL = "https://example.com/wp-content/uploads/2024/06/7D5B29B3-CCFC-4E56-B838-81B48EBE9C24.jpg?quality=85&w=150&h=150&crop=1"
                                )
                            )
                        ),
                        sourceURL = "https://example.com/wp-content/uploads/2024/06/7D5B29B3-CCFC-4E56-B838-81B48EBE9C24.jpg?quality=85"
                    )
                )
            )
        )
        return post
    }

val Post.Companion.mockArray: List<Post>
    get() {
        val post = Post(
            id = 1234,
            date = LocalDateTime.parse("2023-10-06T14:08:00"),
            modified = LocalDateTime.parse("2023-10-06T14:08:00"),
            status = "publish",
            title = RenderedContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            content = RenderedContent("<p> Malesuada porta eu velit urna ante venenatis mus cum, facilisis ipsum rutrum molestie. Euismod diam netus id varius, varius adipiscing phasellus nisl nam. Natoque tellus pulvinar faucibus primis. Imperdiet nascetur nullam aliquam ut mus torquent litora aptent libero? Elementum nostra, lorem tincidunt cursus! Dui tristique dignissim felis curae;. Dis praesent pellentesque varius pharetra aenean elementum non amet tincidunt. Porttitor urna aptent mattis odio scelerisque augue convallis fringilla. </p> <p> Rutrum conubia volutpat ad vulputate bibendum senectus magna molestie tincidunt placerat ultrices pulvinar. Vulputate semper sociis convallis eleifend et, ac aliquam sem massa diam. Metus at pharetra montes mi turpis arcu. Metus vestibulum feugiat massa sem aliquam odio blandit vivamus a lacinia nisi tellus. Urna venenatis sit ligula dis. In hac enim commodo vel euismod euismod. Quam condimentum vestibulum non orci. Lectus lacinia habitasse erat praesent. Nunc enim felis tempus hendrerit natoque viverra dui malesuada. Sapien dictum tortor nisl pulvinar, ut urna euismod velit. Ad convallis; rhoncus semper sapien urna. Vivamus magnis malesuada habitasse, platea platea. </p> <p> Condimentum nam iaculis congue habitasse tortor cursus blandit commodo. Vestibulum euismod egestas risus. Ultricies blandit mattis montes ipsum orci accumsan rutrum aenean. Cras sociis, nibh lacus morbi. Justo convallis convallis sem primis ad proin. Gravida magna convallis ultrices torquent nec. Fames maecenas natoque parturient. Natoque ipsum fusce et fames, morbi ipsum. Lacinia aenean facilisi nascetur sociosqu, vitae faucibus. Maecenas tincidunt varius neque fermentum. </p> <p> Magnis primis diam dui mauris dis habitant eleifend ligula at mollis. Nec parturient fermentum habitant torquent turpis laoreet dignissim nulla amet! Rhoncus nibh sapien lectus rhoncus. Suspendisse id hac conubia luctus diam nec curae;, proin tellus lacus ad est! Consequat proin mus erat duis leo a vivamus molestie massa. Varius, eros sit in pretium porttitor lacinia hendrerit habitasse vulputate? Nascetur potenti maecenas vestibulum nullam tellus lorem convallis augue ut. </p> <p> Torquent hac augue donec tristique. Feugiat netus iaculis faucibus. Dis ullamcorper egestas id dictumst. Parturient rhoncus pharetra maecenas. Curabitur ad velit curae; integer. Lorem sodales et commodo nascetur ornare sociosqu aenean ligula at vestibulum. Vestibulum nam purus mollis varius sit nec mauris. Auctor tellus consectetur non et bibendum diam cubilia erat! Aptent vestibulum pretium mattis. Justo ac, nec integer. Turpis sem netus sed mus penatibus tempus. Potenti erat accumsan tempus mattis risus senectus curae;! </p>"),
            excerpt = RenderedContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
            author = 1,
            featuredMedia = 5678,
            commentStatus = CommentStatus.OPEN,
            categories = listOf(1, 2),
            tags = listOf(3, 4),
            link = "https://example.com/1234",
            embeddedContent = EmbeddedContent(
                _author = listOf(
                    Author(
                        id = 123,
                        name = "Author Name",
                        description = "Author Description"
                    )
                ),
                _featuredMedia = listOf(
                    FeaturedMedia(
                        id = 123,
                        title = RenderedContent("Featured Media Title"),
                        caption = RenderedContent("<p>Featured Media Caption</p>"),
                        altText = "Featured Media Alt Text",
                        mediaDetails = MediaDetails(
                            width = 1024,
                            height = 684,
                            sizes = mapOf(
                                "thumbnail" to Size(
                                    width = 150,
                                    height = 150,
                                    sourceURL = "https://example.com/wp-content/uploads/2024/06/7D5B29B3-CCFC-4E56-B838-81B48EBE9C24.jpg?quality=85&w=150&h=150&crop=1"
                                )
                            )
                        ),
                        sourceURL = "https://example.com/wp-content/uploads/2024/06/7D5B29B3-CCFC-4E56-B838-81B48EBE9C24.jpg?quality=85"
                    )
                )
            )
        )
        return listOf(post)
    }