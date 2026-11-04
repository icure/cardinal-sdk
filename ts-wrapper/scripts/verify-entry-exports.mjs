// Verifies that every value declared by the entry `.d.mts` of the distribution package is actually exported at runtime by
// the entry `.mjs`.
//
// Kotlin/JS declares every `@JsExport` of the whole linked program in the entry `.d.mts`, but only emits each declaration
// from the `.mjs` of the Kotlin module that defines it. Anything declared in the entry but defined in another Kotlin
// module (cardinal-sdk, or a dependency) type-checks for consumers and then fails at load time, unless the build either
// re-exports it from the entry or removes its declaration.
//
// Usage: node verify-entry-exports.mjs <packageDir> <entryName> <kotlinDistDir> <nodeModulesDir>
//  - packageDir: the distribution package (contains <entryName>.mjs and <entryName>.d.mts)
//  - kotlinDistDir: the Kotlin/JS production library output, used to report which module exports a missing name
//  - nodeModulesDir: where the npm dependencies of the package (ws, @js-joda/core, ...) can be resolved from
import { readFileSync, readdirSync } from 'node:fs'
import { register } from 'node:module'
import { join, resolve } from 'node:path'
import { pathToFileURL } from 'node:url'

const [packageDir, entryName, kotlinDistDir, nodeModulesDir] = process.argv.slice(2)
if (!nodeModulesDir) {
	console.error('Usage: node verify-entry-exports.mjs <packageDir> <entryName> <kotlinDistDir> <nodeModulesDir>')
	process.exit(2)
}

// The package is not installed anywhere, so its bare dependencies cannot be resolved from its own location: fall back
// to resolving them as if imported from a module next to `nodeModulesDir`.
const fallbackParentUrl = pathToFileURL(join(resolve(nodeModulesDir), '..', '__verify-entry-exports__.mjs')).href
register('data:text/javascript,' + encodeURIComponent(`
	const fallbackParentUrl = ${JSON.stringify(fallbackParentUrl)}
	export async function resolve(specifier, context, nextResolve) {
		try {
			return await nextResolve(specifier, context)
		} catch (e) {
			const isBare = !/^(\\.|\\/|[a-zA-Z][a-zA-Z0-9+.-]*:)/.test(specifier)
			if (e?.code !== 'ERR_MODULE_NOT_FOUND' || !isBare) throw e
			return nextResolve(specifier, { ...context, parentURL: fallbackParentUrl })
		}
	}
`))

// Only declarations with a runtime counterpart: `interface` and `type` are type-only. Nested declarations are indented,
// so anchoring at the start of the line only matches top-level ones.
const declarationRegex = /^export declare (?:abstract )?(?:class|function|const|let|var|namespace|enum) ([A-Za-z_$][\w$]*)/gm
const declarations = readFileSync(join(packageDir, `${entryName}.d.mts`), 'utf8')
const declared = new Set([...declarations.matchAll(declarationRegex)].map((m) => m[1]))
if (declared.size === 0) {
	console.error(`No value declaration found in ${entryName}.d.mts: the declaration format changed, update this script`)
	process.exit(1)
}

const entry = await import(pathToFileURL(resolve(packageDir, `${entryName}.mjs`)).href)
const exported = new Set(Object.keys(entry))
const missing = [...declared].filter((name) => !exported.has(name)).sort()

if (missing.length === 0) {
	console.log(`${entryName}: all ${declared.size} values declared in ${entryName}.d.mts are exported by ${entryName}.mjs`)
	process.exit(0)
}

// Name -> Kotlin modules that export it, from the `export { local as exported, ... };` blocks.
const exportedBy = new Map()
for (const file of readdirSync(kotlinDistDir).filter((f) => f.endsWith('.mjs')).sort()) {
	const source = readFileSync(join(kotlinDistDir, file), 'utf8')
	for (const block of source.matchAll(/^export \{([^}]*)\};/gm)) {
		for (const item of block[1].split(',').map((s) => s.trim()).filter(Boolean)) {
			const name = item.split(/\s+as\s+/).pop()
			if (!exportedBy.has(name)) exportedBy.set(name, [])
			exportedBy.get(name).push(file)
		}
	}
}

console.error(`${entryName}.d.mts declares ${missing.length} value(s) that ${entryName}.mjs does not export at runtime:`)
for (const name of missing) {
	const modules = exportedBy.get(name)
	console.error(`  - ${name}: ${modules ? `exported by ${modules.join(', ')}` : 'not exported by any Kotlin module'}`)
}
console.error(
	'Consumers would type-check against these names and then fail at load time. In ts-wrapper/build.gradle.kts, ' +
	're-export them from the entry (if they are SDK API) or remove their declaration from the entry .d.mts.'
)
process.exit(1)
