plugins {
    id("kotlin-convention")
    id("detekt-convention")
    id("dokka-convention")
    id("knit-convention")
    id("spotless-convention")
    id("publish-convention")
    id("netty-convention") // optional, if Netty is used
    alias(libs.plugins.kover)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.coroutines.core)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.kotest.assertions.core)
                implementation(libs.mockk)
                implementation(libs.kotlinx.coroutines.test)
            }
        }

        jvmMain {
            dependencies {
                runtimeOnly(libs.slf4j.simple)
                runtimeOnly(libs.bytebuddy)
            }
        }

        jvmTest {
            dependencies {
                implementation(libs.kotest.runner.junit5)
            }
        }
    }
}
