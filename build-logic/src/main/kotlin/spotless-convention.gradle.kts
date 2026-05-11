plugins {
    id("com.diffplug.spotless")
}

spotless {
    ratchetFrom("origin/main")

    kotlinGradle {
        ktlint()
    }

    kotlin {
        ktlint()
    }

    format("misc") {
        target("*.md", ".gitignore")
        trimTrailingWhitespace()
    }
}
