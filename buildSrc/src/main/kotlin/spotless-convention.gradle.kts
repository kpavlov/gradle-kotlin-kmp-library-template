import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import kotlin.ranges.coerceAtLeast
import kotlin.text.set

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    ratchetFrom("origin/main")

    kotlinGradle {
        ktlint()
    }

    kotlin {
        ktfmt().kotlinlangStyle()
        toggleOffOn()
    }

    format("misc") {
        target("*.md", ".gitignore")
        trimTrailingWhitespace()
    }
}
