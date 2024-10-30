import com.android.build.gradle.LibraryExtension
import com.jlee.experiment.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(receiver = target) {
            pluginManager.apply {
                apply("experiment.android.library")
                apply("experiment.android.hilt")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }
            extensions.configure<LibraryExtension> {
                testOptions.animationsDisabled = true
//                configureGradleManagedDevices(this)
            }

            dependencies {
                add(configurationName = "implementation", dependencyNotation = project(":core:ui"))
                add(
                    configurationName = "implementation",
                    dependencyNotation = project(":core:designsystem")
                )
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("androidx.hilt.navigation.compose").get()
                )
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("androidx.lifecycle.runtimeCompose").get()
                )
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("androidx.lifecycle.viewModelCompose")
                        .get()
                )
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("androidx.navigation.compose").get()
                )
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("androidx.tracing.ktx").get()
                )
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("kotlinx.serialization.json").get()
                )
                add(
                    configurationName = "testImplementation",
                    dependencyNotation = libs.findLibrary("androidx.navigation.testing").get()
                )
                add(
                    configurationName = "androidTestImplementation",
                    dependencyNotation = libs.findLibrary("androidx.lifecycle.runtimeTesting").get()
                )
            }
        }
    }
}
