pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "kotlin-kmp-library"

includeBuild("build-logic")

include(
    ":docs",
    ":lib",
    ":examples",
)
