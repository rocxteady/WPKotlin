package io.github.rocxteady.wpkotlin.repositories

import io.github.rocxteady.wpkotlin.api.resting.RequestConfiguration
import io.github.rocxteady.wpkotlin.api.resting.RestClient
import io.github.rocxteady.wpkotlin.extensions.initializeRoute
import io.github.rocxteady.wpkotlin.models.APIInfo

internal interface APIInfoRepositoryInterface {
    suspend fun getAPIInfo(route: String? = null): APIInfo
}

class APIInfoRepository: APIInfoRepositoryInterface {
    override suspend fun getAPIInfo(route: String?): APIInfo {
        var urlString: String = ""
        route?.let {
            urlString = route
        } ?: run {
            urlString = String.Companion.initializeRoute()
        }
        val restClient = RestClient()
        val info: APIInfo = restClient.fetch(RequestConfiguration(urlString))
        return info
    }
}