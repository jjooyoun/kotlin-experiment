plugins {
    alias(libs.plugins.experiment.android.library)
    alias(libs.plugins.experiment.android.hilt)
}

android {
    namespace = "com.jlee.experiment.core.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    api(project(":core:common"))
    api(project(":core:database"))
    api(project(":core:datastore"))
    api(project(":core:network"))
}