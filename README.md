# wpkotlin

Kotlin Multiplatform Library

### Publish to MavenCentral

1) Registering a Sonatype account as described here: 
   https://dev.to/kotlin/how-to-build-and-publish-a-kotlin-multiplatform-library-going-public-4a8k
2) Add developer id, name, email and the project url to
   `/convention-plugins/src/main/kotlin/convention.publication.gradle.kts`
3) Add the secrets to `local.properties`:

```
signing.keyId=...
signing.password=...
signing.secretKeyRingFile=...
ossrhUsername=...
ossrhPassword=...
```

4) Run `./gradlew :wpkotlin:publishAllPublicationsToSonatypeRepository`

### Build platform artifacts

#### Android aar

- Run `./gradlew :wpkotlin:assembleRelease`
- Output: `/wpkotlin/build/outputs/aar/wpkotlin-release.aar`

#### JVM jar

- Run `./gradlew :wpkotlin:jvmJar`
- Output: `/wpkotlin/build/libs/wpkotlin-jvm-1.0.jar`

#### iOS Framework

- Run `./gradlew :wpkotlin:linkReleaseFrameworkIosArm64`
- Output: `/wpkotlin/build/bin/iosArm64/releaseFramework/wpkotlin.framework`

#### JS file

- Run `./gradlew :wpkotlin:jsBrowserProductionWebpack`
- Output: `/wpkotlin/build/dist/js/productionExecutable/wpkotlin.js`

#### macOS Framework

- Run `./gradlew :wpkotlin:linkReleaseFrameworkMacosArm64`
- Output: `/wpkotlin/build/bin/macosArm64/releaseFramework/wpkotlin.framework`

#### Linux static library

- Run `./gradlew :wpkotlin:linkReleaseStaticLinuxX64`
- Output: `/wpkotlin/build/bin/linuxX64/releaseStatic/libwpkotlin.a`

#### Windows static library

- Run `./gradlew :wpkotlin:linkReleaseStaticMingwX64`
- Output: `/wpkotlin/build/bin/mingwX64/releaseStatic/libwpkotlin.a`

#### Wasm binary file

- Run `./gradlew :wpkotlin:wasmJsBrowserDistribution`
- Output: `/wpkotlin/build/dist/wasmJs/productionExecutable/wpkotlin-wasm-js.wasm`
