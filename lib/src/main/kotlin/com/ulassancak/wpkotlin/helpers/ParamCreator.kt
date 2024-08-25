package com.ulassancak.wpkotlin.helpers

enum class OrderType(val value: String) {
    ASCENDING("asc"),
    DESCENDING("desc")
}

class PostsParamCreator {
    companion object {
        fun createParamsForPost(
            categories: List<Int> = emptyList(),
            categoriesToExclude: List<Int> = emptyList(),
            tags: List<Int> = emptyList(),
            tagsToExclude: List<Int> = emptyList()
        ): Map<String, Any> {
            val categoriesStr = categories.joinToString(",")
            val categoriesToExcludeStr = categoriesToExclude.joinToString(",")
            val tagsStr = tags.joinToString(",")
            val tagsToExcludeStr = tagsToExclude.joinToString(",")

            val params = mutableMapOf<String, Any>(
                "_embed" to "",
                "_fields" to "id,date_gmt,modified_gmt,status,title,content,contentHTML,excerpt,author,featured_media,comment_status,categories,tags,link,_links"
            )

            if (categoriesStr.isNotEmpty()) {
                params["categories"] = categoriesStr
            }
            if (categoriesToExcludeStr.isNotEmpty()) {
                params["categories_exclude"] = categoriesToExcludeStr
            }
            if (tagsStr.isNotEmpty()) {
                params["tags"] = tagsStr
            }
            if (tagsToExcludeStr.isNotEmpty()) {
                params["tags_exclude"] = tagsToExcludeStr
            }

            return params
        }

        fun createParamsForPosts(
            page: Int = 1,
            perPage: Int = 10,
            order: OrderType = OrderType.DESCENDING,
            categories: List<Int>? = null,
            categoriesToExclude: List<Int>? = null,
            tags: List<Int>? = null,
            tagsToExclude: List<Int>? = null,
            include: List<Int>? = null
        ): Map<String, Any> {
            val params = mutableMapOf<String, Any>(
                "page" to page,
                "per_page" to perPage,
                "order" to order.value,
                "_embed" to "",
                "_fields" to "id,date_gmt,modified_gmt,status,title,content,contentHTML,excerpt,author,featured_media,comment_status,categories,tags,link,_links"
            )

            categories?.joinToString(",")?.let {
                if (it.isNotEmpty()) params["categories"] = it
            }
            categoriesToExclude?.joinToString(",")?.let {
                if (it.isNotEmpty()) params["categories_exclude"] = it
            }
            tags?.joinToString(",")?.let {
                if (it.isNotEmpty()) params["tags"] = it
            }
            tagsToExclude?.joinToString(",")?.let {
                if (it.isNotEmpty()) params["tags_exclude"] = it
            }
            include?.joinToString(",")?.let {
                if (it.isNotEmpty()) params["include"] = it
            }

            return params
        }

        fun createParamsForSearchPosts(
            term: String,
            page: Int = 1,
            perPage: Int = 10
        ): Map<String, Any> {
            return mapOf(
                "search" to term,
                "page" to page,
                "per_page" to perPage,
                "subtype" to "post",
                "_fields" to "id,title,url"
            )
        }

        fun createParamsForCategories(
            page: Int = 1,
            perPage: Int = 100,
            order: OrderType = OrderType.DESCENDING
        ): Map<String, Any> {
            return mapOf(
                "page" to page,
                "per_page" to perPage,
                "order" to order.value,
                "orderby" to "count",
                "hide_empty" to 1,
                "_fields" to "id,count,description,link,name,parent"
            )
        }

        fun createParamsForCategory(): Map<String, Any> {
            return mapOf(
                "_fields" to "id,count,description,link,name,parent"
            )
        }
    }
}
