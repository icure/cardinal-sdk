#!/usr/bin/env node
/**
 * Entry point of the typescript SDK tests.
 *
 * Run with `npm test` after building the sources (`npm run build`) and installing the SDK
 * (`npm install <the packed tarball>`). All the configuration is passed through environment
 * variables, see README.md.
 *
 * Usage:
 *     npm test                       # runs everything
 *     npm test -- patient            # runs a single module
 *     npm test -- patient sharing    # runs two modules
 *
 * A single test can be selected with `CARDINAL_TEST_NAME_PATTERN`, which is passed to node as
 * `--test-name-pattern`.
 */
import {spawnSync} from 'node:child_process'
import {existsSync, readdirSync} from 'node:fs'
import {dirname, join} from 'node:path'
import {fileURLToPath, pathToFileURL} from 'node:url'

const TEST_DIR = dirname(fileURLToPath(import.meta.url))
const BUILD_DIR = join(TEST_DIR, 'build')

if (!existsSync(BUILD_DIR)) {
	console.error(`${BUILD_DIR} does not exist, run \`npm run build\` first`)
	process.exit(2)
}

const env = await import(pathToFileURL(join(BUILD_DIR, 'cardinalTestEnv.mjs')).href)
try {
	env.checkConfiguration()
} catch (e) {
	console.error(
		`Invalid test configuration: ${e.message}\nSee ${join(TEST_DIR, 'README.md')}`,
	)
	process.exit(2)
}

function resolveModule(name) {
	const candidates = [name, `${name}.test.mjs`, `${name}.mjs`]
	for (const candidate of candidates) {
		const asPath = join(BUILD_DIR, candidate)
		if (existsSync(asPath)) return asPath
	}
	if (existsSync(name)) return name
	console.error(`No test module matching "${name}" in ${BUILD_DIR}`)
	process.exit(2)
}

const requested = process.argv.slice(2).filter((it) => it.length > 0)
const files = requested.length > 0
	? requested.map(resolveModule)
	: readdirSync(BUILD_DIR).filter((it) => it.endsWith('.test.mjs')).sort().map((it) => join(BUILD_DIR, it))

if (files.length === 0) {
	console.error(`No test module found in ${BUILD_DIR}`)
	process.exit(2)
}

console.log(`Running the typescript SDK tests against ${env.cardinalUrl()}`)

const nodeArgs = [
	'--test',
	// The tests share a single, long-lived environment: running the files one at a time keeps the
	// load on it predictable and avoids several processes registering a key for the same user at
	// the same time.
	'--test-concurrency=1',
	`--test-reporter=${process.env.CARDINAL_TEST_REPORTER || 'spec'}`,
	'--test-reporter-destination=stdout',
]
if (process.env.CARDINAL_TEST_NAME_PATTERN) {
	nodeArgs.push(`--test-name-pattern=${process.env.CARDINAL_TEST_NAME_PATTERN}`)
}

const result = spawnSync(process.execPath, [...nodeArgs, ...files], {stdio: 'inherit'})
process.exit(result.status === null ? 1 : result.status)
