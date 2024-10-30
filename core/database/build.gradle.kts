plugins {
    alias(libs.plugins.experiment.android.library)
    alias(libs.plugins.experiment.android.hilt)
    alias(libs.plugins.experiment.android.room)
}

android {
    namespace = "com.jlee.experiment.core.database"
}

dependencies {
    api(project(":core:model"))
}