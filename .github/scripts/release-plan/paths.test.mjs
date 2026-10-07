import { test } from 'node:test';
import assert from 'node:assert/strict';
import { affectedUnits, globToRegExp, unitsForPath } from './paths.mjs';

test('globToRegExp handles *, ** and **/', () => {
	assert.ok(globToRegExp('docs/**').test('docs/a/b.md'));
	assert.ok(!globToRegExp('docs/**').test('docsx/a'));
	assert.ok(globToRegExp('*.md').test('README.md'));
	assert.ok(!globToRegExp('*.md').test('cardinal-mcp-server/SDK.md'));
	assert.ok(globToRegExp('**/src/*Test/**').test('cardinal-sdk/src/commonTest/kotlin/A.kt'));
	assert.ok(globToRegExp('cardinal-sdk/src/linux*Main/**').test('cardinal-sdk/src/linuxX64Main/kotlin/A.kt'));
	assert.ok(globToRegExp('a.b').test('a.b') && !globToRegExp('a.b').test('axb'));
});

test('classifies every row of the spec mapping', () => {
	const cases = {
		'README.md': [],
		'docs/adr/0001.md': [],
		'.github/workflows/release.yml': [],
		'dart-wrapper/lib/build.gradle.kts': [],
		'cardinal-sdk/src/commonTest/kotlin/A.kt': [],
		'ts-wrapper/src/jsTest/typescript/a.mts': [],
		'ts-wrapper/test/a.test.mts': [],
		'python-wrapper/test/test_a.py': [],
		'ts-wrapper/src/jsMain/typescript/a.mts': ['ts'],
		'ts-wrapper/build.gradle.kts': ['ts'],
		'cardinal-mcp-server/SDK.md': ['ts'],
		'python-wrapper/src/python/cardinal_sdk/a.py': ['python'],
		'cardinal-sdk/src/linuxX64Main/kotlin/A.kt': ['python'],
		'cardinal-sdk/src/mingwMain/kotlin/A.kt': ['python'],
		'cardinal-sdk/src/macosArm64Main/kotlin/A.kt': ['python'],
		'cardinal-sdk/src/jvmMain/kotlin/A.kt': ['kotlin'],
		'cardinal-sdk/src/androidMain/kotlin/A.kt': ['kotlin'],
		'cardinal-sdk/src/jvmAndAndroidMain/kotlin/A.kt': ['kotlin'],
		'cardinal-sdk/src/iosSimulatorArm64Main/kotlin/A.kt': ['kotlin'],
		// The JS target of the KMP SDK is also published on Maven, for Kotlin/JS consumers.
		'cardinal-sdk/src/jsMain/kotlin/A.kt': ['kotlin', 'ts'],
		'cardinal-sdk/src/appleMain/kotlin/A.kt': ['kotlin', 'python'],
		// nativeMain is the parent of appleMain, hence of iosMain (Kotlin), and of the Linux, Windows and macOS targets.
		'cardinal-sdk/src/nativeMain/kotlin/A.kt': ['kotlin', 'python'],
		'cardinal-sdk/src/commonMain/kotlin/A.kt': ['kotlin', 'ts', 'python'],
		'buildSrc/src/main/kotlin/ReleaseVersion.kt': ['kotlin', 'ts', 'python'],
		'cardinal-sdk/build.gradle.kts': ['kotlin', 'ts', 'python'],
		'gradle/libs.versions.toml': ['kotlin', 'ts', 'python'],
		'ksp-json-processor': ['kotlin', 'ts', 'python'],
		'some-new-module/Main.kt': ['kotlin', 'ts', 'python'],
	};
	for (const [path, units] of Object.entries(cases)) {
		assert.deepEqual(unitsForPath(path), units, path);
	}
});

test('affectedUnits unions and orders the units', () => {
	assert.deepEqual(affectedUnits([]), []);
	assert.deepEqual(affectedUnits(['README.md']), []);
	assert.deepEqual(affectedUnits(['python-wrapper/a.py', 'ts-wrapper/a.mts', 'docs/x.md']), ['ts', 'python']);
	assert.deepEqual(affectedUnits(['cardinal-sdk/src/appleMain/A.kt', 'ts-wrapper/a.mts']), ['kotlin', 'ts', 'python']);
});
