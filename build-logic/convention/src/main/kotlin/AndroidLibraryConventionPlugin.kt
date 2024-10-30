import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import com.jlee.experiment.configureFlavors
import com.jlee.experiment.configureKotlinAndroid
import com.jlee.experiment.disableUnnecessaryAndroidTests
import com.jlee.experiment.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(receiver = target) {
            with(receiver = pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("experiment.android.lint")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(commonExtension = this)
                defaultConfig.targetSdk = 34
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                testOptions.animationsDisabled = true
                configureFlavors(commonExtension = this)
//                configureGradleManagedDevices(this)
                // The resource prefix is derived from the module name,
                // so resources inside ":core:module1" must be prefixed with "core_module1_"
                resourcePrefix = path.split(regex = """\W""".toRegex()).drop(n = 1).distinct()
                    .joinToString(separator = "_").lowercase() + "_"
            }
            extensions.configure<LibraryAndroidComponentsExtension> {
//                configurePrintApksTask(this)
                disableUnnecessaryAndroidTests(project = target)
            }
            dependencies {
                add(
                    configurationName = "androidTestImplementation",
                    dependencyNotation = kotlin("test")
                )
                add(configurationName = "testImplementation", dependencyNotation = kotlin("test"))
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("androidx.tracing.ktx").get()
                )
            }
        }
    }
}
