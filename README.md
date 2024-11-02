# WPKotlin

WPKotlin is a Kotlin Multiplatform client library for the WordPress REST API.

## Supported Platforms

- Android
- iOS
- macOS
- JVM
- JavaScript (Browser)
- WebAssembly
- Linux (x64)
- Windows (x64)

## Installation

### Kotlin

```kotlin
// build.gradle.kts
dependencies {
    implementation("io.github.rocxteady:wpkotlin:0.0.1")
}
```

### Android

```kotlin
// build.gradle.kts
dependencies {
    implementation("io.github.rocxteady:wpkotlin-android:0.0.1")
}
```

## Features

- Built with Kotlin Multiplatform
- Powered by Ktor client
- Kotlinx Serialization for JSON parsing
- Coroutines support
- Cross-platform support

## Requirements

- Kotlin 1.9+
- Android minSdk 24+
- Xcode 15+ (for iOS/macOS)

## Dependencies

- kotlinx-coroutines
- kotlinx-serialization
- kotlinx-datetime
- ktor-client

## License

WPKotlin is available under the Apache License, Version 2.0. See the LICENSE file for more info.

## Author

Ulaş Sancak ([@rocxteady](https://github.com/rocxteady))