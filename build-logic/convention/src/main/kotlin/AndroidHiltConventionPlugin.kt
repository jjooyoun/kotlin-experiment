import com.android.build.gradle.api.AndroidBasePlugin
import com.jlee.experiment.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")
            dependencies {
                add(
                    configurationName = "ksp",
                    dependencyNotation = libs.findLibrary("hilt.compiler").get()
                )
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("hilt.core").get()
                )
            }

            /** Add support for Android modules, based on [AndroidBasePlugin] */
            pluginManager.withPlugin("com.android.base") {
                pluginManager.apply("dagger.hilt.android.plugin")
                dependencies {
                    add(
                        configurationName = "implementation",
                        dependencyNotation = libs.findLibrary("hilt.android").get()
                    )
                }
            }
        }
    }
}
