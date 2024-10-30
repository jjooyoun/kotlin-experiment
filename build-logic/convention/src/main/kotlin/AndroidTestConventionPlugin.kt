import com.android.build.gradle.TestExtension
import com.jlee.experiment.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<TestExtension> {
                configureKotlinAndroid(commonExtension = this)
                defaultConfig.targetSdk = 34
//                configureGradleManagedDevices(this)
            }
        }
    }

}
