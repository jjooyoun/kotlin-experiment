plugins {
    alias(libs.plugins.experiment.android.library)
    alias(libs.plugins.experiment.android.hilt)
}

android {
    namespace = "com.jlee.experiment.sync"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
}