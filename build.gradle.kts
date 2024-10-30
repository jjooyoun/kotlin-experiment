buildscript {
    repositories {
        google()
        mavenCentral()

        // Android Build Server
//        maven { url = uri("../nowinandroid-prebuilts/m2repository") }
    }
    dependencies {
//        classpath(libs.google.oss.licenses.plugin) {
//            exclude(group = "com.google.protobuf")
//        }
    }

}

/*
 * By listing all the plugins used throughout all subprojects in the root project build script, it
 * ensures that the build script classpath remains the same for all projects. This avoids potential
 * problems with mismatching versions of transitive plugin dependencies. A subproject that applies
 * an unlisted plugin will have that plugin and its dependencies _appended_ to the classpath, not
 * replacing pre-existing dependencies.
 */
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.dependencyGuard) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.gms) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.room) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.module.graph) apply true // Plugin applied to allow module graph generation
}