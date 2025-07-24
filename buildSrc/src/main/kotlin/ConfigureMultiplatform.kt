import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.internal.config.JVMConfigurationKeys.JVM_TARGET
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import org.jetbrains.kotlin.gradle.targets.js.ir.JsIrBinary
import java.util.Properties

fun Project.configureKotlinJs(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension,
    overrideModuleName: String? = null
) = with(kotlinMultiplatformExtension) {
    js(IR) {
        outputModuleName.set(overrideModuleName ?: project.name)
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    useFirefoxHeadless()
                }
            }
        }
        nodejs { }
        binaries.library()
        generateTypeScriptDefinitions()
        useEsModules()

        binaries.withType<JsIrBinary>().all {
            this.linkTask.configure {
                compilerOptions {
                    sourceMap.set(false)
                }
            }
        }

    }
}

fun Project.configureKotlinLinux(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension
) = with(kotlinMultiplatformExtension) {
    val localProperties = getLocalProperties()
//	val linuxArm64Target = linuxArm64() currently have to disable since we have no good ktor engine implementation
    val linuxX64Target = linuxX64()
    listOf(
//		linuxArm64Target,
        linuxX64Target
    ).onEach { target ->
        target.binaries {
            all {
                freeCompilerArgs += listOf("-linker-option", "--allow-shlib-undefined")
                localProperties["cinteropsLibsDir"]?.also { allDirs ->
                    (allDirs as String).split(";").forEach {
                        linkerOpts.add(0, "-L$it")
                    }
                }
            }
        }
    }
}

/**
 * Configures targets and source sets for multiplatform modules.
 */
fun Project.configureMultiplatform(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension,
    jvm: Boolean = true,
    android: Boolean = true,
    ios: Boolean = true,
    macos: Boolean = true,
    mingw: Boolean = true,
    linux: Boolean = true,
    js: Boolean = true,
    xcFrameworkName: String? = null
) = with(kotlinMultiplatformExtension) {

    compilerOptions {
        freeCompilerArgs.addAll("-opt-in=kotlin.time.ExperimentalTime")
    }

    val localProperties = getLocalProperties()
    val frameworkName = xcFrameworkName ?: project.name.replaceFirstChar { it.uppercase() }
    val xcf = XCFramework(frameworkName)

    if (jvm) {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
        jvm {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_1_8)
            }
        }
    }
    if (js) {
        configureKotlinJs(this)
    }
    if (android) {
        androidTarget {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_1_8)
            }
            // Important: otherwise android will use the jvm library and it will not work...
            publishLibraryVariants("release", "debug")
        }
    }
    if (ios) {
        val iosSimulators = listOf(
            iosX64(),
            iosSimulatorArm64()
        )
        val iosAll = iosSimulators + iosArm64()
        iosAll.forEach { target ->
            target.binaries.framework {
                baseName = frameworkName
                xcf.add(this)
            }
        }
        iosSimulators.forEach { target ->
            target.testRuns.forEach { testRun ->
                (localProperties["ios.simulator"] as? String)?.let { testRun.deviceId = it }
            }
        }
    }
    if (macos) {
        macosX64()
        macosArm64()
    }
    if (linux) {
        configureKotlinLinux(kotlinMultiplatformExtension)
    }
    if (mingw) {
        mingwX64()
    }

    applyDefaultHierarchyTemplate()

    if (jvm && android) {
        with(sourceSets) {
            val commonMain = get("commonMain")
            val jvmAndAndroidMain = create("jvmAndAndroidMain").apply {
                dependsOn(commonMain)
            }
            get("jvmMain").dependsOn(jvmAndAndroidMain)
            get("androidMain").dependsOn(jvmAndAndroidMain)
        }
    }
}

private fun Project.getLocalProperties() =
    Properties().apply {
        kotlin.runCatching {
            load(rootProject.file("local.properties").reader())
        }
    }
