import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

fun KotlinMultiplatformAndroidLibraryTarget.configureAndroidLibrary() {
	compileSdk = 34
	minSdk = 26
	namespace = "com.icure.cardinal.sdk"
	compilerOptions {
		jvmTarget.set(JvmTarget.JVM_1_8)
	}
	compilations.all {
		if (name == "hostTest") {
			compileTaskProvider.configure {
				compilerOptions.jvmTarget.set(JvmTarget.JVM_11) // Need 11 to launch tests, due to kotest version
			}
		}
	}
	withHostTest {

	}
	lint {
		checkReleaseBuilds = false
		abortOnError = false
	}
}