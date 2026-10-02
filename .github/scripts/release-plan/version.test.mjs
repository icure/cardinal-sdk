import { test } from 'node:test';
import assert from 'node:assert/strict';
import { compareVersions, decadeBase, isFull, isGrandfathered, parseTag, unitsOf } from './version.mjs';

test('parses full, unit and preview tags', () => {
	assert.deepEqual(parseTag('2.14.10'), {
		tag: '2.14.10', unit: null, major: 2, minor: 14, patch: 10, preview: null, version: '2.14.10',
	});
	assert.deepEqual(parseTag('ts-2.14.11-PREVIEW.2'), {
		tag: 'ts-2.14.11-PREVIEW.2', unit: 'ts', major: 2, minor: 14, patch: 11, preview: 2, version: '2.14.11-PREVIEW.2',
	});
	assert.equal(parseTag('python-2.14.1').unit, 'python');
	assert.equal(parseTag('kotlin-3.0.5').version, '3.0.5');
});

test('rejects anything outside the grammar', () => {
	for (const tag of [
		'ts2.14.11', '2.14.11-ts', 'dart-2.14.11', '2.14', '2.14.11.1', '02.14.0', '2.014.0',
		'2.15.0-PREVIEW-1', '2.15.0-PREVIEW.0', '2.15.0-PREVIEW.x', '2.15.0-preview.1', 'v2.14.0', ' 2.14.0', '',
	]) {
		assert.equal(parseTag(tag), null, tag);
	}
});

test('orders versions numerically, previews before their final version', () => {
	const sorted = ['2.15.0', '2.14.9', '2.15.0-PREVIEW.10', '2.14.10', '2.15.0-PREVIEW.9', '2.14.11']
		.map(parseTag)
		.sort(compareVersions)
		.map((p) => p.tag);
	assert.deepEqual(sorted, ['2.14.9', '2.14.10', '2.14.11', '2.15.0-PREVIEW.9', '2.15.0-PREVIEW.10', '2.15.0']);
	assert.equal(compareVersions(parseTag('2.14.10'), parseTag('ts-2.14.10')), 0);
});

test('computes the decade base', () => {
	assert.equal(decadeBase(parseTag('ts-2.14.13')), '2.14.10');
	assert.equal(decadeBase(parseTag('ts-2.14.1')), '2.14.0');
	assert.equal(decadeBase(parseTag('python-2.14.29-PREVIEW.1')), '2.14.20');
});

test('knows full releases, units and the grandfathered range', () => {
	assert.equal(isFull(parseTag('2.14.10')), true);
	assert.equal(isFull(parseTag('ts-2.14.11')), false);
	assert.deepEqual(unitsOf(parseTag('2.14.10')), ['kotlin', 'ts', 'python']);
	assert.deepEqual(unitsOf(parseTag('python-2.14.11')), ['python']);
	assert.equal(isGrandfathered(parseTag('2.13.99')), true);
	assert.equal(isGrandfathered(parseTag('1.9.0')), true);
	assert.equal(isGrandfathered(parseTag('2.14.0-PREVIEW.1')), false);
	assert.equal(isGrandfathered(parseTag('2.14.0')), false);
});
