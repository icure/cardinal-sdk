import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.named
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType

fun Project.configureJvmTest() {
	tasks.named<Test>("jvmTest") {
		useJUnitPlatform()
		filter {
			isFailOnNoMatchingTests = false
		}
		testLogging {
			showExceptions = true
			showStandardStreams = true
			events = setOf(
				org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
				org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
			)
			exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
		}
	}


	tasks.withType<Test>().configureEach {
		useJUnitPlatform()
	}
}
