plugins {
    alias(libs.plugins.experiment.android.library)
    alias(libs.plugins.experiment.android.library.compose)
    alias(libs.plugins.experiment.android.library.jacoco)
}

android {
    namespace = "com.jlee.experiment.core.ui"
}

dependencies {
}