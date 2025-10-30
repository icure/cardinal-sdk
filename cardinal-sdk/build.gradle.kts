import com.vanniktech.maven.publish.SonatypeHost
import tasks.InitializeTestEnvironment

plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
	signing
	id("com.vanniktech.maven.publish") apply true
	id("com.google.devtools.ksp") version "2.2.20-2.0.4"
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

group = "com.icure"

val version = "2.0.0-PREVIEW-19"
project.version = version

kotlin {
	configureMultiplatform(this)

	sourceSets {
		val commonMain by getting {
			dependencies {
				api(libs.ktorClientCore)
				implementation(libs.ktorContentNegotiation)
				implementation(libs.ktorSerializationJson)
				implementation(libs.ktorClientWebsocket)
				api(libs.kotlinSerialization)
				api(libs.kotlinDateTime)
				implementation(libs.kermit)
				api(libs.kryptom)
				api(libs.kerberus)
				implementation(libs.coroutinesCore)
				implementation(libs.okio)
				implementation(kotlin("reflect"))
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(libs.kotestAssertions)
				implementation(libs.kotestEngine)
				implementation(libs.kotp)
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
		val jvmMain by getting {
			dependencies {
				implementation(libs.ktorClientEngineOkhttp)
				implementation(libs.bouncyCastle)
			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
				implementation(libs.ktorClientEngineCio) // Currently needed by test setup, remove later
				implementation(libs.mockk)
				implementation(libs.bundles.ktorServer)
			}
		}
		val jsMain by getting {
			dependencies {
				implementation(libs.ktorClientEngineJs)
			}
		}
		val androidMain by getting {
			dependencies {
				implementation(libs.ktorClientEngineOkhttp)
				compileOnly(libs.androidx.datastore)
			}
		}
		val androidUnitTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
			}
		}
		appleMain {
			dependencies {
				implementation(libs.ktorClientEngineDarwin)
			}
		}
		linuxMain {
			dependencies {
				implementation(libs.ktorClientEngineCurl)
			}
		}
		mingwMain {
			dependencies {
				implementation(libs.ktorClientEngineWinhttp)
			}
		}
	}
}

android {
	namespace = "com.icure.cardinal.sdk"
	configureAndroidLibrary()
}

configureJvmTest()

dependencies {
	add("kspJvm", "com.icure:ksp-json-processor")
}

publishing {
	repositories {
		mavenLocal()
		maven {
			name = "Taktik"
			url = uri(mavenReleasesRepository)
			credentials {
				username = repoUsername
				password = repoPassword
			}
		}
	}
}

tasks.register<InitializeTestEnvironment>("initializeTestEnvironment")

tasks.named("allTests") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("iosSimulatorArm64Test") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("iosX64Test") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("jsBrowserTest") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("jsNodeTest") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("jsTest") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("jvmTest") {
	dependsOn("initializeTestEnvironment")
}


//tasks.named("jsNodeDevelopmentRun") { dependsOn("jsProductionExecutableCompileSync") }
//tasks.named("jsNodeProductionRun") { dependsOn("jsProductionExecutableCompileSync") }

fun projectHasSignatureProperties() =
	project.hasProperty("signingInMemoryKeyId") && project.hasProperty("signingInMemoryKeyPassword") && project.hasProperty("signingInMemoryKey")
//
//if (projectHasSignatureProperties()) {
//	signing {
//		useInMemoryPgpKeys(
//			file(project.property("signing.secretKeyRingFile") as String).readText(),
//			project.property("signing.password") as String
//		)
//		sign(publishing.publications)
//	}
//}

mavenPublishing {
	coordinates(group as String, project.name, project.version as String)

	pom {
		name.set("CardinalSDK")
		url.set("https://github.com/icure/icure-multiplatform-sdk")
		description.set("""
			Cardinal SDK is a multiplatform SDK for the iCure platform.
		""".trimIndent())

		licenses {
			license {
				name.set("MIT License")
				url.set("https://choosealicense.com/licenses/mit/")
				distribution.set("https://choosealicense.com/licenses/mit/")
			}
		}
		developers {
			developer {
				id.set("icure")
				name.set("iCure")
				url.set("https://github.com/iCure/")
			}
		}
		scm {
			url.set("https://github.com/icure/icure-multiplatform-sdk")
			connection.set("scm:git:git://github.com/icure/icure-multiplatform-sdk.git")
			developerConnection.set("scm:git:ssh://git@github.com:icure/icure-multiplatform-sdk.git")
		}
	}

	publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)

	if (projectHasSignatureProperties()) {
		signAllPublications()
	}
}

// Configure all publishing tasks
if (!projectHasSignatureProperties()) {
	tasks.withType<PublishToMavenRepository> {
		doFirst {
			throw IllegalStateException("Cannot publish to Maven Central without signing properties")
		}
	}
}
