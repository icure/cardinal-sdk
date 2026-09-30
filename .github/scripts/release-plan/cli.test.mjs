import { test } from 'node:test';
import assert from 'node:assert/strict';
import { execFileSync, spawnSync } from 'node:child_process';
import { mkdirSync, mkdtempSync, renameSync, writeFileSync } from 'node:fs';
import { tmpdir } from 'node:os';
import { dirname, join } from 'node:path';
import { fileURLToPath } from 'node:url';

const CLI = join(dirname(fileURLToPath(import.meta.url)), '..', 'release-plan.mjs');

// A repository with 2.14.10 released on main and its support branch, like the real one after a full release.
function fixture() {
	const dir = mkdtempSync(join(tmpdir(), 'release-plan-repo-'));
	const git = (...args) => execFileSync('git', args, { cwd: dir, encoding: 'utf8' }).trim();
	const write = (file, content = `${file}\n`) => {
		mkdirSync(dirname(join(dir, file)), { recursive: true });
		writeFileSync(join(dir, file), content);
	};
	const commit = (message, ...files) => {
		for (const f of files) write(f, `${message}\n`);
		git('add', '-A');
		git('commit', '-q', '-m', message);
		return git('rev-parse', 'HEAD');
	};
	git('init', '-q', '-b', 'main');
	git('config', 'user.email', 'ci@example.com');
	git('config', 'user.name', 'CI');
	git('config', 'commit.gpgsign', 'false');
	git('config', 'tag.gpgsign', 'false');
	commit('Initial', 'cardinal-sdk/src/commonMain/kotlin/A.kt', 'ts-wrapper/src/jsMain/typescript/a.mts');
	git('tag', '2.14.10');
	git('branch', 'support/2.14.10');
	git('branch', 'develop');
	return { dir, git, write, commit };
}

function run(dir, args, acceptedNames) {
	const acceptedFile = join(mkdtempSync(join(tmpdir(), 'release-plan-accepted-')), 'accepted.txt');
	writeFileSync(acceptedFile, acceptedNames.join('\n'));
	const r = spawnSync(process.execPath, [CLI, ...args, '--repo', dir, '--accepted-file', acceptedFile], { encoding: 'utf8' });
	return { code: r.status, res: r.stdout ? JSON.parse(r.stdout) : null, stderr: r.stderr };
}

const rules = (res) => res.violations.map((v) => v.rule);

test('pr mode accepts a TypeScript fix into its support branch', () => {
	const { dir, git, commit } = fixture();
	git('switch', '-q', '-c', 'fix/ts', 'support/2.14.10');
	const head = commit('Fix TS', 'ts-wrapper/src/jsMain/typescript/a.mts');
	const { code, res } = run(dir, ['pr', '--title', 'Release ts-2.14.11', '--base-ref', 'support/2.14.10',
		'--head-ref', 'fix/ts', '--head-sha', head], ['cardinal-sdk-2.14.10']);
	assert.equal(code, 0);
	assert.equal(res.releases[0].notesStartTag, '2.14.10');
});

test('pr mode rejects a commonMain change under a unit title', () => {
	const { dir, git, commit } = fixture();
	git('switch', '-q', '-c', 'fix/core', 'support/2.14.10');
	const head = commit('Fix core', 'cardinal-sdk/src/commonMain/kotlin/A.kt');
	const { code, res } = run(dir, ['pr', '--title', 'Release ts-2.14.11', '--base-ref', 'support/2.14.10',
		'--head-ref', 'fix/core', '--head-sha', head], ['cardinal-sdk-2.14.10']);
	assert.equal(code, 1);
	assert.deepEqual(rules(res), ['R10']);
});

test('pr mode rejects a file moved out of commonMain', () => {
	const { dir, git } = fixture();
	git('switch', '-q', '-c', 'fix/move', 'support/2.14.10');
	mkdirSync(join(dir, 'ts-wrapper/src/jsMain/kotlin'), { recursive: true });
	renameSync(join(dir, 'cardinal-sdk/src/commonMain/kotlin/A.kt'), join(dir, 'ts-wrapper/src/jsMain/kotlin/A.kt'));
	git('add', '-A');
	git('commit', '-q', '-m', 'Move A');
	const head = git('rev-parse', 'HEAD');
	const { code, res } = run(dir, ['pr', '--title', 'Release ts-2.14.11', '--base-ref', 'support/2.14.10',
		'--head-ref', 'fix/move', '--head-sha', head], ['cardinal-sdk-2.14.10']);
	assert.equal(code, 1);
	assert.deepEqual(rules(res), ['R10']);
	assert.match(res.violations[0].message, /commonMain\/kotlin\/A\.kt/);
});

test('pr mode only diffs the PR, not earlier patches on the support branch', () => {
	const { dir, git, commit } = fixture();
	git('switch', '-q', 'support/2.14.10');
	commit('Earlier TS patch', 'ts-wrapper/src/jsMain/typescript/a.mts');
	git('switch', '-q', '-c', 'fix/py');
	const head = commit('Fix Python', 'python-wrapper/src/python/cardinal_sdk/a.py');
	const { code } = run(dir, ['pr', '--title', 'Release python-2.14.11', '--base-ref', 'support/2.14.10',
		'--head-ref', 'fix/py', '--head-sha', head], ['cardinal-sdk-2.14.10', 'cardinal-sdk-ts-2.14.11']);
	assert.equal(code, 0);
});

test('tag mode validates merge commits and squash merges on the support branch', () => {
	const { dir, git, commit } = fixture();
	git('switch', '-q', '-c', 'fix/ts', 'support/2.14.10');
	commit('Fix TS 1', 'ts-wrapper/src/jsMain/typescript/a.mts');
	commit('Fix TS 2', 'ts-wrapper/src/jsMain/typescript/b.mts');
	git('switch', '-q', 'support/2.14.10');
	git('merge', '-q', '--no-ff', '-m', 'Merge fix/ts', 'fix/ts');
	const merge = git('rev-parse', 'HEAD');
	assert.equal(run(dir, ['tag', '--title', 'Release ts-2.14.11', '--commit', merge], ['cardinal-sdk-2.14.10']).code, 0);

	git('switch', '-q', '-c', 'fix/ts2', 'support/2.14.10');
	commit('Fix TS 3', 'ts-wrapper/src/jsMain/typescript/c.mts');
	git('switch', '-q', 'support/2.14.10');
	git('merge', '-q', '--squash', 'fix/ts2');
	git('commit', '-q', '-m', 'Release ts-2.14.12 (squash)');
	const squash = git('rev-parse', 'HEAD');
	const { code, res } = run(dir, ['tag', '--tag', 'ts-2.14.12', '--commit', squash],
		['cardinal-sdk-2.14.10', 'cardinal-sdk-ts-2.14.11']);
	assert.equal(code, 0);
	assert.equal(res.releases[0].notesStartTag, 'ts-2.14.11');
});

test('tag mode rejects a commit that is not on the support branch, unless dry run', () => {
	const { dir, git, commit } = fixture();
	git('switch', '-q', 'develop');
	const sha = commit('Develop work', 'ts-wrapper/src/jsMain/typescript/a.mts');
	const strict = run(dir, ['tag', '--tag', 'ts-2.14.11', '--commit', sha], ['cardinal-sdk-2.14.10']);
	assert.equal(strict.code, 1);
	assert.deepEqual(rules(strict.res), ['R5']);
	const dry = run(dir, ['tag', '--tag', 'ts-2.14.11', '--commit', sha, '--dry-run'], ['cardinal-sdk-2.14.10']);
	assert.equal(dry.code, 0);
	assert.deepEqual(dry.res.warnings.map((w) => w.rule), ['R5']);
});

test('forge re-run: the planned tag and its sibling are already accepted', () => {
	const { dir, git, commit } = fixture();
	git('switch', '-q', 'support/2.14.10');
	const sha = commit('TS and Python fixes', 'ts-wrapper/src/jsMain/typescript/a.mts', 'python-wrapper/src/python/a.py');
	const accepted = ['cardinal-sdk-2.14.10', 'cardinal-sdk-ts-2.14.11', 'cardinal-sdk-python-2.14.11'];
	const { code, res } = run(dir, ['tag', '--tag', 'ts-2.14.11', '--tag', 'python-2.14.11', '--commit', sha], accepted);
	assert.equal(code, 0);
	assert.deepEqual(res.releases.map((r) => r.tag), ['ts-2.14.11', 'python-2.14.11']);
});

test('usage errors exit with 2', () => {
	const { dir } = fixture();
	assert.equal(run(dir, ['pr', '--title', 'Release 2.14.20'], []).code, 2);
	assert.equal(run(dir, ['nope'], []).code, 2);
	assert.equal(run(dir, ['pr', '--title', 'Release 2.14.20', '--base-ref', 'nope', '--head-ref', 'develop',
		'--head-sha', 'HEAD'], []).code, 2);
});
