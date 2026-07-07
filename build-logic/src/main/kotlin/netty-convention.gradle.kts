import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    id("org.gradle.base")
}

val nettyVersion = "4.2.16.Final"

pluginManager.withPlugin("org.jetbrains.kotlin.multiplatform") {
    val kmp = extensions.getByType<KotlinMultiplatformExtension>()

    val osName = providers.systemProperty("os.name").get().lowercase()
    val osArch = providers.systemProperty("os.arch").get().lowercase()

    kmp.sourceSets.getByName("jvmTest").dependencies {
        implementation(project.dependencies.platform("io.netty:netty-bom:$nettyVersion"))

        when {
            osName.contains("linux") -> {
                val archClassifier =
                    if (osArch.contains("aarch64")) "linux-aarch_64" else "linux-x86_64"
                runtimeOnly("io.netty:netty-transport-native-epoll:$nettyVersion:$archClassifier")
            }

            osName.contains("mac") -> {
                val archClassifier =
                    if (osArch.contains("aarch64")) "osx-aarch_64" else "osx-x86_64"
                runtimeOnly("io.netty:netty-transport-native-kqueue:$nettyVersion:$archClassifier")
                runtimeOnly("io.netty:netty-resolver-dns-native-macos:$nettyVersion:$archClassifier")
            }
        }
    }
}
