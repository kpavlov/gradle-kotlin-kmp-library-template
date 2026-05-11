plugins {
    base
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.kover)
}

dependencies {
    kover(project(":lib"))
    kover(project(":examples"))
}

kover {
    reports {
        total {
            xml
            html
        }
        verify {
            rule {
                bound {
                    minValue = 30
                }
            }
        }
    }
}

