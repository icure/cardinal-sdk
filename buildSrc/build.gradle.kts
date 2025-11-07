import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
	gradlePluginPortal()
	google()
}

dependencies {
	implementation(libs.kotlinMultiplatformPlugin)
	implementation(libs.kotlinSerializationPlugin)
	implementation(libs.kotestPlugin)
	implementation(libs.kspPlugin)
	implementation(libs.androidLibraryPlugin)
	implementation(libs.coroutinesCore)
	implementation(libs.ktorClientCore)
	implementation(libs.ktorClientEngineCio)
	implementation(libs.ktorContentNegotiation)
	implementation(libs.ktorSerializationJson)
}