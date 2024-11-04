package io.github.rocxteady.wpkotlin.repositories

import io.github.rocxteady.wpkotlin.api.resting.RequestConfiguration
import io.github.rocxteady.wpkotlin.api.resting.RestClient
import io.github.rocxteady.wpkotlin.extensions.initializeRoute
import io.github.rocxteady.wpkotlin.models.APIInfo
import kotlinx.serialization.SerializationException
import kotlin.coroutines.cancellation.CancellationException

internal interface APIInfoRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    suspend fun getAPIInfo(route: String? = null): APIInfo
}

@Suppress("unused")
class APIInfoRepository: APIInfoRepositoryInterface {
    @Throws(
        SerializationException::class,
        CancellationException::class,
    )
    override suspend fun getAPIInfo(route: String?): APIInfo {
        var urlString = ""
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