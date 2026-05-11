plugins {
    alias(libs.plugins.kotlin.jvm)
    id("detekt-convention")
    id("dokka-convention")
    id("spotless-convention")
}

dependencies {
    dokka(project(":lib"))
    dokka(project(":examples"))
}

dokka {
    moduleName.set("Kotlin Multiplatform Library Template")
    dokkaPublications.html {
        outputDirectory = layout.projectDirectory.dir("public/apidocs")
    }
}
