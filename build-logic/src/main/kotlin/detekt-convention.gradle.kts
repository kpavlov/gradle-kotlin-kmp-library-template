import dev.detekt.gradle.extensions.FailOnSeverity

plugins {
    id("dev.detekt")
}

detekt {
    config.from(rootProject.projectDir.resolve("detekt.yml"))
    buildUponDefaultConfig = true
    parallel = true
    failOnSeverity = FailOnSeverity.Warning
}
