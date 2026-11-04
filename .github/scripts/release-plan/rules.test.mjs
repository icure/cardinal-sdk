import { test } from 'node:test';
import assert from 'node:assert/strict';
import { parseAccepted, parseTitle, releaseVersionFor, renderSummary, validatePr, validateTag } from './rules.mjs';

const accepted = (...names) => parseAccepted(names);
const rules = (res) => res.violations.map((v) => v.rule);
const TS_FILE = 'ts-wrapper/src/jsMain/typescript/a.mts';

const pr = (overrides = {}) => validatePr({
	title: 'Release ts-2.14.11',
	baseRef: 'support/2.14.10',
	headRef: 'fix/websocket',
	accepted: accepted('2.13.5', '2.14.0', '2.14.10'),
	existingTags: ['2.13.5', '2.14.0', '2.14.10'],
	changedFiles: [TS_FILE],
	...overrides,
});
const fullPr = (title, overrides = {}) => pr({ title, baseRef: 'main', headRef: 'develop', ...overrides });

const tagCheck = (overrides = {}) => validateTag({
	tags: ['ts-2.14.11'],
	accepted: accepted('2.14.10'),
	isOnBranch: (branch) => branch === 'support/2.14.10',
	changedFiles: [TS_FILE],
	dryRun: false,
	...overrides,
});

test('a valid unit release PR produces its plan', () => {
	const res = pr();
	assert.deepEqual(res.violations, []);
	assert.equal(res.ok, true);
	assert.deepEqual(res.releases, [{
		tag: 'ts-2.14.11',
		unit: 'ts',
		version: '2.14.11',
		full: false,
		prerelease: false,
		units: ['ts'],
		decadeBase: '2.14.10',
		supportBranch: null,
		latest: false,
		notesStartTag: '2.14.10',
		releaseTitle: '2.14.11 (TypeScript)',
	}]);
});

test('a valid full release PR produces its plan', () => {
	const res = fullPr('Release 2.14.20', { accepted: accepted('2.14.10', 'ts-2.14.11'), changedFiles: ['cardinal-sdk/src/commonMain/A.kt'] });
	assert.equal(res.ok, true);
	assert.deepEqual(res.releases[0], {
		tag: '2.14.20',
		unit: null,
		version: '2.14.20',
		full: true,
		prerelease: false,
		units: ['kotlin', 'ts', 'python'],
		decadeBase: null,
		supportBranch: 'support/2.14.20',
		latest: true,
		notesStartTag: '2.14.10',
		releaseTitle: '2.14.20',
	});
});

test('R1: tags outside the grammar', () => {
	assert.deepEqual(rules(pr({ title: 'Release ts-2.14.11-PREVIEW-1' })), ['R1']);
	assert.deepEqual(rules(pr({ title: 'Release 2.14.11-ts' })), ['R1']);
});

test('R2: a bare tag needs a patch ending in 0', () => {
	assert.ok(rules(fullPr('Release 2.14.11')).includes('R2'));
});

test('R3: a unit tag needs a patch not ending in 0', () => {
	assert.ok(rules(pr({ title: 'Release ts-2.14.20', baseRef: 'support/2.14.20' })).includes('R3'));
});

test('R4: the decade base must be released', () => {
	assert.deepEqual(rules(pr({ title: 'Release ts-2.14.21', baseRef: 'support/2.14.20' })), ['R4']);
	// A preview of the base does not count.
	assert.deepEqual(
		rules(pr({ title: 'Release ts-2.14.21', baseRef: 'support/2.14.20', accepted: accepted('2.14.20-PREVIEW.1') })),
		['R4'],
	);
});

test('R5: a unit release PR targets the support branch of its decade', () => {
	assert.deepEqual(rules(pr({ baseRef: 'main' })), ['R5']);
	assert.deepEqual(rules(pr({ baseRef: 'support/2.14.0' })), ['R5']);
});

test('R6: a full release PR goes from develop to main', () => {
	assert.deepEqual(rules(fullPr('Release 2.14.20', { headRef: 'feat/x' })), ['R6']);
	assert.deepEqual(rules(fullPr('Release 2.14.20', { baseRef: 'support/2.14.10' })), ['R6']);
});

test('R7: versions only go up, per unit and decade', () => {
	assert.deepEqual(rules(pr({ accepted: accepted('2.14.10', 'ts-2.14.12') })), ['R7']);
	assert.deepEqual(rules(pr({ title: 'Release ts-2.14.11-PREVIEW.1', accepted: accepted('2.14.10', 'ts-2.14.11') })), ['R7']);
	assert.deepEqual(rules(fullPr('Release 2.15.0-PREVIEW.2', { accepted: accepted('2.15.0') })), ['R7']);
	// Other units, and the same unit in another decade, do not count.
	assert.deepEqual(rules(pr({ accepted: accepted('2.14.10', 'python-2.14.15', 'ts-2.14.3') })), []);
	// A gap is fine.
	assert.deepEqual(rules(pr({ title: 'Release ts-2.14.13', accepted: accepted('2.14.10', 'ts-2.14.11') })), []);
});

test('R8: versions below 2.14.0 follow the old scheme', () => {
	const old = fullPr('Release 2.13.6', { accepted: accepted('2.13.5') });
	assert.equal(old.ok, true);
	assert.equal(old.releases[0].supportBranch, null);
	assert.equal(old.releases[0].latest, true);
	assert.ok(rules(pr({ title: 'Release ts-2.13.6', baseRef: 'support/2.13.0' })).includes('R8'));
});

test('R9: title shape', () => {
	assert.deepEqual(rules(pr({ title: 'release ts-2.14.11' })), ['R9']);
	assert.deepEqual(rules(pr({ title: 'Release' })), ['R9']);
	assert.ok(rules(fullPr('Release 2.14.20 ts-2.14.21')).includes('R9'));
	assert.deepEqual(rules(pr({ title: 'Release ts-2.14.11 ts-2.14.12' })), ['R9']);
	assert.ok(rules(pr({ title: 'Release ts-2.14.11 python-2.14.21' })).includes('R9'));
	assert.deepEqual(rules(pr({ existingTags: ['2.14.10', 'ts-2.14.11'] })), ['R9']);
	assert.match(pr({ title: 'release ts-2.14.11' }).violations[0].message, /Release <tag>/);
});

test('title whitespace is tolerated', () => {
	assert.deepEqual(parseTitle('  Release   ts-2.14.11   python-2.14.11 '), ['ts-2.14.11', 'python-2.14.11']);
	assert.equal(pr({ title: '  Release   ts-2.14.11 ' }).ok, true);
	assert.equal(parseTitle('Releases 2.14.20'), null);
});

test('the version a release title ships for a unit', () => {
	assert.equal(releaseVersionFor('Release 2.13.6', 'kotlin'), '2.13.6');
	assert.equal(releaseVersionFor('Release 2.15.0-PREVIEW.2', 'python'), '2.15.0-PREVIEW.2');
	assert.equal(releaseVersionFor('Release ts-2.14.12 python-2.14.11', 'python'), '2.14.11');
	assert.equal(releaseVersionFor('Release ts-2.14.12 python-2.14.11', 'kotlin'), null);
	assert.equal(releaseVersionFor('Release 2.13.6-rc1', 'kotlin'), null);
	assert.equal(releaseVersionFor('Bump ktor', 'ts'), null);
	assert.equal(releaseVersionFor('', 'ts'), null);
});

test('R10: a unit release only touches its units', () => {
	assert.deepEqual(rules(pr({ changedFiles: [TS_FILE, 'cardinal-sdk/src/commonMain/A.kt'] })), ['R10']);
	assert.match(pr({ changedFiles: ['cardinal-sdk/src/commonMain/A.kt'] }).violations[0].message, /commonMain\/A\.kt/);
	assert.deepEqual(rules(pr({ changedFiles: ['cardinal-sdk/src/appleMain/A.kt'] })), ['R10']);
	assert.deepEqual(rules(pr({ changedFiles: ['README.md', 'docs/x.md'] })), []);
	assert.deepEqual(
		rules(pr({ title: 'Release ts-2.14.11 python-2.14.11', changedFiles: [TS_FILE, 'python-wrapper/src/python/a.py'] })),
		[],
	);
	// Full releases are not diff-checked.
	assert.deepEqual(rules(fullPr('Release 2.14.20', { changedFiles: ['cardinal-sdk/src/commonMain/A.kt'] })), []);
});

test('R10: a change for every unit needs a full release, whatever units are declared', () => {
	const allUnits = 'Release kotlin-2.14.11 ts-2.14.11 python-2.14.11';
	const shared = pr({ title: allUnits, changedFiles: [TS_FILE, 'cardinal-sdk/src/commonMain/A.kt'] });
	assert.deepEqual(rules(shared), ['R10']);
	assert.match(shared.violations[0].message, /commonMain\/A\.kt/);
	assert.match(shared.violations[0].message, /full release/);
	assert.doesNotMatch(shared.violations[0].message, /a\.mts/);
	// A path that matches no row of the mapping belongs to every unit too.
	assert.deepEqual(rules(pr({ title: allUnits, changedFiles: ['gradle/libs.versions.toml'] })), ['R10']);
	// The same holds in tag mode.
	assert.deepEqual(
		rules(tagCheck({ tags: allUnits.split(' ').slice(1), changedFiles: ['cardinal-sdk/src/commonMain/A.kt'] })),
		['R10'],
	);
	// Each unit's own paths, and a path shared by some units only, are fine when those units are declared.
	const perUnit = [TS_FILE, 'python-wrapper/src/python/a.py', 'cardinal-sdk/src/jvmMain/kotlin/A.kt', 'cardinal-sdk/src/appleMain/A.kt'];
	assert.deepEqual(pr({ title: allUnits, changedFiles: perUnit }).violations, []);
	assert.deepEqual(rules(pr({ title: 'Release kotlin-2.14.11 python-2.14.11', changedFiles: ['cardinal-sdk/src/appleMain/A.kt'] })), []);
});

test('R10: both kinds of violation name their files', () => {
	const res = pr({ changedFiles: ['cardinal-sdk/src/commonMain/A.kt', 'cardinal-sdk/src/appleMain/B.kt'] });
	assert.ok(res.violations.length > 0 && res.violations.every((v) => v.rule === 'R10'));
	const message = res.violations.map((v) => v.message).join('\n');
	assert.match(message, /commonMain\/A\.kt/);
	assert.match(message, /appleMain\/B\.kt/);
	assert.match(message, /kotlin, python/);
});

test('R10: the listed files are capped', () => {
	const files = Array.from({ length: 25 }, (_, i) => `cardinal-sdk/src/commonMain/F${i}.kt`);
	const { message } = pr({ changedFiles: files }).violations[0];
	assert.match(message, /F19\.kt/);
	assert.doesNotMatch(message, /F20\.kt/);
	assert.match(message, /and 5 more/);
	assert.doesNotMatch(pr({ changedFiles: files.slice(0, 20) }).violations[0].message, /more/);
});

test('release notes start from the previous peer', () => {
	const unit = pr({ title: 'Release ts-2.14.12', accepted: accepted('2.14.10', 'ts-2.14.11', 'python-2.14.11') });
	assert.equal(unit.releases[0].notesStartTag, 'ts-2.14.11');
	const final = fullPr('Release 2.15.0', { accepted: accepted('2.14.20', '2.15.0-PREVIEW.1', '2.15.0-PREVIEW.2') });
	assert.equal(final.releases[0].notesStartTag, '2.14.20');
	const preview = fullPr('Release 2.15.0-PREVIEW.3', { accepted: accepted('2.14.20', '2.15.0-PREVIEW.2') });
	assert.equal(preview.releases[0].notesStartTag, '2.15.0-PREVIEW.2');
	assert.equal(preview.releases[0].prerelease, true);
	assert.equal(preview.releases[0].latest, false);
	assert.equal(preview.releases[0].supportBranch, null);
	assert.equal(fullPr('Release 2.14.0', { accepted: [], existingTags: [] }).releases[0].notesStartTag, null);
});

test('parseAccepted ignores noise', () => {
	const tags = parseAccepted([
		'cardinal-sdk-2.14.10\r', '', '   ', 'cardinal-sdk-2.0.0-PREVIEW-16', 'kraken-lite-26.09.1', 'cardinal-sdk-ts-2.14.11',
	]).map((p) => p.tag);
	assert.deepEqual(tags, ['2.14.10', 'ts-2.14.11']);
});

test('tag mode checks reachability instead of branch names', () => {
	assert.equal(tagCheck().ok, true);
	assert.deepEqual(rules(tagCheck({ isOnBranch: () => false })), ['R5']);
	assert.deepEqual(rules(tagCheck({ tags: ['2.14.20'], isOnBranch: (b) => b === 'support/2.14.10' })), ['R6']);
	assert.equal(tagCheck({ tags: ['2.14.20'], isOnBranch: (b) => b === 'main' }).ok, true);
});

test('tag mode excludes the planned tags from the accepted ones', () => {
	const names = ['cardinal-sdk-2.14.10', 'cardinal-sdk-ts-2.14.11', 'cardinal-sdk-python-2.14.11'];
	const res = tagCheck({
		tags: ['ts-2.14.11', 'python-2.14.11'],
		accepted: parseAccepted(names, ['ts-2.14.11', 'python-2.14.11']),
		changedFiles: [TS_FILE, 'python-wrapper/src/python/a.py'],
	});
	assert.deepEqual(res.violations, []);
	assert.deepEqual(res.releases.map((r) => r.tag), ['ts-2.14.11', 'python-2.14.11']);
});

test('tag mode dry run downgrades repository-state checks to warnings', () => {
	const res = tagCheck({
		accepted: [],
		isOnBranch: () => false,
		changedFiles: ['cardinal-sdk/src/commonMain/A.kt'],
		dryRun: true,
	});
	assert.equal(res.ok, true);
	assert.deepEqual(res.warnings.map((w) => w.rule).sort(), ['R10', 'R4', 'R5']);
	assert.deepEqual(rules(tagCheck({ tags: ['ts-2.14.20'], dryRun: true })), ['R3']);
});

test('renderSummary lists violations or the plan', () => {
	assert.match(renderSummary(pr({ baseRef: 'main' })), /❌[\s\S]*\*\*R5\*\*/);
	assert.match(renderSummary(pr()), /✅[\s\S]*\| `ts-2\.14\.11` \| 2\.14\.11 \| ts \|/);
});
