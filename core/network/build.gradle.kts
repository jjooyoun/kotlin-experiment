plugins {
    alias(libs.plugins.experiment.android.library)
    alias(libs.plugins.experiment.android.hilt)
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.jlee.experiment.core.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    api(project(":core:common"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.kotlinx.serialization.json)
}