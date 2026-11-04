// Which units a changed file affects, for the diff check (R10) of unit releases.
// The first matching row wins. A path that matches no row affects every unit: an unknown file forces a full
// release rather than slipping through a unit patch.
import { UNITS } from './version.mjs';

const RULES = [
	{
		units: [],
		globs: [
			'*.md', 'docs/**', 'readme-resources/**', 'LICENSE', '.github/**', '.claude/**', 'dart-wrapper/**',
			'**/src/*Test/**', 'ts-wrapper/test/**', 'python-wrapper/test/**',
		],
	},
	{ units: ['ts'], globs: ['ts-wrapper/**', 'cardinal-mcp-server/**'] },
	{
		units: ['python'],
		globs: [
			'python-wrapper/**', 'cardinal-sdk/src/linux*Main/**', 'cardinal-sdk/src/mingw*Main/**',
			'cardinal-sdk/src/macos*Main/**',
		],
	},
	{
		units: ['kotlin'],
		globs: [
			'cardinal-sdk/src/jvmMain/**', 'cardinal-sdk/src/androidMain/**', 'cardinal-sdk/src/jvmAndAndroidMain/**',
			'cardinal-sdk/src/ios*Main/**',
		],
	},
	// The JS target of the KMP SDK: built into the npm package, and published on Maven for Kotlin/JS consumers.
	{ units: ['kotlin', 'ts'], globs: ['cardinal-sdk/src/jsMain/**'] },
	// Shared by the iOS targets (Kotlin) and the native targets the Python wheels are built from: nativeMain is the
	// parent of appleMain, linuxMain and mingwMain, appleMain the parent of iosMain and macosMain.
	{ units: ['kotlin', 'python'], globs: ['cardinal-sdk/src/nativeMain/**', 'cardinal-sdk/src/appleMain/**'] },
];

export function globToRegExp(glob) {
	let re = '';
	for (let i = 0; i < glob.length; i++) {
		const c = glob[i];
		if (c !== '*') {
			re += c.replace(/[.+?^${}()|[\]\\]/g, '\\$&');
		} else if (glob[i + 1] !== '*') {
			re += '[^/]*';
		} else if (glob[i + 2] === '/') {
			// `**/` matches zero or more leading directories.
			re += '(?:.*/)?';
			i += 2;
		} else {
			// A trailing `**` matches everything below.
			re += '.*';
			i += 1;
		}
	}
	return new RegExp(`^${re}$`);
}

const COMPILED = RULES.map(({ units, globs }) => ({ units, regexps: globs.map(globToRegExp) }));

export function unitsForPath(path) {
	const rule = COMPILED.find(({ regexps }) => regexps.some((r) => r.test(path)));
	return rule ? [...rule.units] : [...UNITS];
}

export function affectedUnits(paths) {
	const affected = new Set(paths.flatMap(unitsForPath));
	return UNITS.filter((u) => affected.has(u));
}
