package mocks

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
internal val Json.create: Json
    get() = Json {
        ignoreUnknownKeys = true
        allowTrailingComma = true
    }