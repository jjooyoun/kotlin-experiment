import com.jlee.experiment.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidJvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
                apply("experiment.android.lint")
            }
            configureKotlinJvm()
        }
    }
}
