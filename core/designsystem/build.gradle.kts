plugins {
    alias(libs.plugins.experiment.android.library)
    alias(libs.plugins.experiment.android.library.compose)
    alias(libs.plugins.experiment.android.library.jacoco)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jlee.experiment.core.designsystem"
}

dependencies {
}