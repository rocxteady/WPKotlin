package com.ulassancak.wpkotlin.api.resting

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

internal class RestClient {
    @OptIn(ExperimentalSerializationApi::class)
    internal suspend inline fun <reified T>fetch(configuration: RequestConfiguration): T {
        val client = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    allowTrailingComma = true
                })
            }
        }
        val response = client.get(configuration.urlString) {
            url {
                configuration.parameters?.forEach {
                    parameters.append(it.key, "${it.value}")
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