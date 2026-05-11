# Kotlin Multiplatform Library Template

[![Build Status](https://img.shields.io/github/actions/workflow/status/kpavlov/gradle-kotlin-kmp-library-template/build.yml?branch=main)](https://github.com/kpavlov/gradle-kotlin-kmp-library-template/actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Kotlin](https://img.shields.io/badge/kotlin-2.3-blue.svg?logo=kotlin)](https://kotlinlang.org)
[![Target JVM](https://img.shields.io/badge/Target%20JDK-17-green.svg)](https://jdk.java.net/17/)

Template for creating Kotlin Multiplatform libraries with testing, code quality, and documentation tooling.

## Quick Start

```bash
git clone <your-repo> && cd <your-repo>
./gradlew build
```

## Project Structure

- **`lib/`** — Library module (KMP: commonMain, jvmMain, commonTest, jvmTest)
- **`examples/`** — Usage examples
- **`docs/`** — Dokka documentation aggregation
- **`build-logic/`** — Convention plugins

## License

MIT — see [LICENSE](LICENSE).
