plugins {
    alias(libs.plugins.experiment.android.library)
}

android {
    namespace = "com.jlee.experiment.core.model"
}

dependencies {
    api(project(":core:datastore-proto"))
    api(libs.kotlinx.datetime)
}