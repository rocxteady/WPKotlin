package io.github.rocxteady.wpkotlin.api.resting

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class RestClient {
    internal suspend inline fun <reified T>fetch(configuration: RequestConfiguration): T {
        val client = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            install(Logging)
        }
        val response = client.get(configuration.urlString) {
            url {
                configuration.headers.forEach {
                    parameters.append(it.key, it.value)
                }
            }
            headers {
                configuration.headers.forEach {
                    append(it.key, it.value)
                }
            }
        }
        val decodedObject: T = response.body()
        return decodedObject
    }
}