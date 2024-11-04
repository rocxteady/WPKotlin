package io.github.rocxteady.wpkotlin.api.resting

import io.ktor.client.HttpClient
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.serialization.JsonConvertException
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.utils.io.CancellationException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

internal class RestClient {
    @Throws(
        Exception::class,
        JsonConvertException::class,
        NoTransformationFoundException::class,
        CancellationException::class
    )
    internal suspend inline fun <reified T>fetch(configuration: RequestConfiguration): T {
        val client = HttpClient {
            install(ContentNegotiation) {
                register(ContentType.Text.Html, KotlinxSerializationConverter(
                    Json {
                        explicitNulls = false
                        ignoreUnknownKeys = true
                        encodeDefaults = false
                        coerceInputValues = true
                        isLenient = true
                    }
                ))
                register(ContentType.Application.Json, KotlinxSerializationConverter(
                    Json {
                        explicitNulls = false
                        ignoreUnknownKeys = true
                        encodeDefaults = false
                        coerceInputValues = true
                        isLenient = true
                    }
                ))
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
        try {
            val decodedObject: T = response.body()
            return decodedObject
        } catch (e: JsonConvertException) {
            throw SerializationException(e.message)
        } catch (e: NoTransformationFoundException) {
            throw SerializationException(e.message)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}