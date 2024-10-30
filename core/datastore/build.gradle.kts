plugins {
    alias(libs.plugins.experiment.android.library)
    alias(libs.plugins.experiment.android.hilt)
}

android {
    namespace = "com.jlee.experiment.core.datastore"
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    api(project(":core:common"))
    api(project(":core:datastore-proto"))
    api(project(":core:model"))
}