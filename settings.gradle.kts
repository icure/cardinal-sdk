import java.util.Properties

rootProject.name = "cardinal-multiplatform-sdk"

include("cardinal-sdk")
include("ts-wrapper")
include("python-wrapper")
include("dart-wrapper:lib")
include("dart-wrapper:cardinal_sdk")
include("dart-wrapper")

includeBuild("ksp-json-processor") {
	dependencySubstitution {
		substitute(module("com.icure:ksp-json-processor"))
			.using(project(":library"))
	}
}

pluginManagement {
	repositories {
		google()
		gradlePluginPortal()
		mavenCentral()
		maven { url = uri("https://maven.taktik.be/content/groups/public") }
	}
}

dependencyResolutionManagement {
	repositories {
		google()
		mavenCentral()
		maven { url = uri("https://maven.taktik.be/content/groups/public") }
		mavenLocal()
	}
}
