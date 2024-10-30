import com.jlee.experiment.ExperimentBuildType

plugins {
    alias(libs.plugins.experiment.android.application)
    alias(libs.plugins.experiment.android.application.compose)
    alias(libs.plugins.experiment.android.application.flavors)
    alias(libs.plugins.experiment.android.application.jacoco)
    alias(libs.plugins.experiment.android.application.firebase)
    alias(libs.plugins.experiment.android.hilt)
//    id("com.google.android.gms.oss-licenses-plugin")
//    alias(libs.plugins.baselineprofile)
//    alias(libs.plugins.roborazzi)
//    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.jlee.experiment"

    defaultConfig {
        applicationId = "com.jlee.experiment"
        versionCode = 1
        versionName = "1.0"

        // Custom test runner to set up Hilt dependency graph
//        testInstrumentationRunner = "com.jlee.experiment.core.testing.NiaTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ExperimentBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = true
            applicationIdSuffix = ExperimentBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.named("debug").get()
            // Ensure Baseline Profile is fresh for release builds.
//            baselineProfile.automaticGenerationDuringBuild = true
        }
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.profileinstaller)
//    implementation(libs.androidx.tracing.ktx)
//    implementation(libs.androidx.window.core)
    implementation(libs.kotlinx.coroutines.guava)
//    implementation(libs.coil.kt)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.compose.material3) // need to remove

    ksp(libs.hilt.compiler)

//    debugImplementation(libs.androidx.compose.ui.testManifest)
//    debugImplementation(projects.uiTestHiltManifest)

//    kspTest(libs.hilt.compiler)

//    testImplementation(projects.core.dataTest)
//    testImplementation(projects.core.datastoreTest)
//    testImplementation(libs.hilt.android.testing)
//    testImplementation(projects.sync.syncTest)
//    testImplementation(libs.kotlin.test)

//    testDemoImplementation(libs.robolectric)
//    testDemoImplementation(libs.roborazzi)
//    testDemoImplementation(projects.core.screenshotTesting)

//    androidTestImplementation(kotlin("test"))
//    androidTestImplementation(projects.core.testing)
//    androidTestImplementation(projects.core.dataTest)
//    androidTestImplementation(projects.core.datastoreTest)
//    androidTestImplementation(libs.androidx.test.espresso.core)
//    androidTestImplementation(libs.androidx.navigation.testing)
//    androidTestImplementation(libs.androidx.compose.ui.test)
//    androidTestImplementation(libs.hilt.android.testing)
}