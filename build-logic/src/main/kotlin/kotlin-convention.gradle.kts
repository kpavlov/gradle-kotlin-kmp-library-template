import org.jetbrains.kotlin.gradle.dsl.JvmDefaultMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_3
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
}

kotlin {
    explicitApi()

    jvm {
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
        languageVersion = KOTLIN_2_3
        apiVersion = KOTLIN_2_3
        jvmDefault = JvmDefaultMode.ENABLE
        extraWarnings = true
        freeCompilerArgs = listOf()
    }
}

// Run tests in parallel to some degree.
tasks.withType<Test>().configureEach {
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
    forkEvery = 100
    testLogging {
        events("skipped", "failed")
    }
    systemProperty("kotest.output.ansi", "true")
    @Suppress("UnstableApiUsage")
    reports {
        junitXml.required.set(true)
        junitXml.includeSystemOutLog.set(true)
        junitXml.includeSystemErrLog.set(true)
    }
}
