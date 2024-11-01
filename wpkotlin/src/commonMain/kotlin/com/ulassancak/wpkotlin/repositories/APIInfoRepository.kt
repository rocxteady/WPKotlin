package com.ulassancak.wpkotlin.repositories

import com.ulassancak.resting.RequestConfiguration
import com.ulassancak.wpkotlin.api.resting.RestClient
import com.ulassancak.wpkotlin.extensions.initializeRoute
import com.ulassancak.wpkotlin.models.APIInfo

internal interface APIInfoRepositoryInterface {
    suspend fun getAPIInfo(route: String? = null): APIInfo
}

class APIInfoRepository: APIInfoRepositoryInterface {
    override suspend fun getAPIInfo(route: String?): APIInfo {
        var urlString: String = ""
        route?.let {
            urlString = route
        } ?: run {
            urlString = String.initializeRoute();
        }
        val restClient = RestClient();
        val info: APIInfo = restClient.fetch(RequestConfiguration(urlString));
        return info;
    }
}