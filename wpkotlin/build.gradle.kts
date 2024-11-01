import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import org.jreleaser.model.Active

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.convention.publication)
    alias(libs.plugins.jreleaser)
}

group = "io.github.rocxteady"
version = "0.0.1"

kotlin {
    jvmToolchain(17)
    androidTarget {
        publishLibraryVariants("release")
    }

    jvm()

    js {
        browser {
            webpackTask {
                mainOutputFileName = "wpkotlin.js"
            }
        }
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    val xcframeworkName = "WPKotlin"
    val xcf = XCFramework(xcframeworkName)

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName
            isStatic = false
            binaryOption("bundleId", "io.github.rocxteady.wpkotlin")
            xcf.add(this)
        }
    }

    listOf(
        macosX64(),
        macosArm64()
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName
            isStatic = false
            binaryOption("bundleId", "io.github.rocxteady.wpkotlin")
            xcf.add(this)
        }
    }

    linuxX64 {
        binaries.staticLib {
            baseName = "wpkotlin"
        }
    }


    mingwX64 {
        binaries.staticLib {
            baseName = "wpkotlin"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.coroutines.test)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.ktor.client.okhttp)
        }

        jvmMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.ktor.client.okhttp)
        }

        jsMain.dependencies {
            implementation(libs.ktor.client.js)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        macosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        linuxMain.dependencies {
            implementation(libs.ktor.client.curl)
        }

        mingwMain.dependencies {
            implementation(libs.ktor.client.winhttp)
        }

    }
}

android {
    namespace = "io.github.rocxteady.wpkotlin"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}

jreleaser {
    signing {
        active.set(Active.ALWAYS)
        armored.set(true)
        passphrase.set("20375Moti.")
        cosign {
            setPublicKeyFile("/Users/ulas/.gnupg/secring.gpg")
        }
    }
    deploy {
        maven {
            mavenCentral {
                create("sonatype") {
                    active.set(Active.ALWAYS)
                    url.set("https://central.sonatype.com/api/v1/publisher")
                    stagingRepository("target/staging-deploy")
                }
            }
        }
    }
}