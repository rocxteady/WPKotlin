plugins {
    `kotlin-dsl` // Is needed to turn our build logic written in Kotlin into Gradle Plugin
}

repositories {
    gradlePluginPortal() // To use 'maven-publish' and 'signing' plugins in our own plugin
}