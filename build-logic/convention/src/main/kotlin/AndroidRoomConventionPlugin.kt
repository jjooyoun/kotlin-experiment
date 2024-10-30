import androidx.room.gradle.RoomExtension
import com.google.devtools.ksp.gradle.KspExtension
import com.jlee.experiment.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("androidx.room")
            pluginManager.apply("com.google.devtools.ksp")

            extensions.configure<KspExtension> {
                arg(k = "room.generateKotlin", v = "true")
            }

            extensions.configure<RoomExtension> {
                // The schemas directory contains a schema file for each version of the Room database.
                // This is required to enable Room auto migrations.
                // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("room.runtime").get()
                )
                add(
                    configurationName = "implementation",
                    dependencyNotation = libs.findLibrary("room.ktx").get()
                )
                add(
                    configurationName = "ksp",
                    dependencyNotation = libs.findLibrary("room.compiler").get()
                )
            }
        }
    }
}
