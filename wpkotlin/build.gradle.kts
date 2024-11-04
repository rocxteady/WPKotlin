import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.convention.publication)
    alias(libs.plugins.vanniktech)
}

group = "io.github.rocxteady"
version = "0.0.3"
val artifact = "wpkotlin"

kotlin {
    jvmToolchain(21)
    androidTarget {
        publishLibraryVariants("release")
    }

    jvm()

    js {
        browser {
            webpackTask {
                mainOutputFileName = "$artifact.js"
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
            binaryOption("bundleId", "${group as? String}.${artifact}")
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
            binaryOption("bundleId", "${group as? String}.${artifact}")
            xcf.add(this)
        }
    }

    linuxX64 {
        binaries.staticLib {
            baseName = artifact
        }
    }


    mingwX64 {
        binaries.staticLib {
            baseName = artifact
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
    namespace =  "${group as? String}.${artifact}"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}

mavenPublishing {
    coordinates(group as? String, artifact, version as? String)
    pom {
        name.set("WPKotlin")
        description.set("WPKotlin is a Kotlin client for the WordPress REST API")
        inceptionYear.set("2024")
        url.set("https://github.com/rocxteady/WPKotlin/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("rocxteady")
                name.set("Ulaş Sancak")
                url.set("https://github.com/rocxteady/")
            }
        }
        scm {
            url.set("https://github.com/rocxteady/WPKotlin/")
            connection.set("scm:git:git://github.comrocxteady/WPKotlin.git")
            developerConnection.set("scm:git:ssh://git@github.com/rocxteady/WPKotlin.git")
        }
    }
    configure(KotlinMultiplatform(
        sourcesJar = true,
        javadocJar = JavadocJar.None()
    ))
    publishToMavenCentral(SonatypeHost.Companion.CENTRAL_PORTAL)
    signAllPublications()
}
