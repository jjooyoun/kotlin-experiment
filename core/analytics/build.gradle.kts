plugins {
    alias(libs.plugins.experiment.android.library)
    alias(libs.plugins.experiment.android.library.compose)
    alias(libs.plugins.experiment.android.hilt)
}

android {
    namespace = "com.jlee.experiment.core.analytics"
}

dependencies {
    implementation(libs.androidx.compose.runtime)
}