plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.dokka.plugin)
    implementation(libs.spotless.plugin)
    implementation(libs.vanniktech.maven.publish)
    implementation(libs.knit.plugin)
    implementation(libs.detekt.plugin)
    implementation(libs.kover.plugin)
}
