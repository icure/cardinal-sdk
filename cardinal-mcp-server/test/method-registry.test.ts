import { describe, it, expect } from "vitest";
import * as fs from "node:fs";
import * as path from "node:path";
import { fileURLToPath } from "node:url";
import { METHOD_REGISTRY } from "../generated/method-registry.js";

/**
 * Guards the checked-in registry against the two generator scripts drifting apart: the registry and the docs
 * manifest must list the same methods for an API, and no type may be cut in the middle.
 */

const here = path.dirname(fileURLToPath(import.meta.url));
const manifest = JSON.parse(
	fs.readFileSync(path.resolve(here, "..", "generated", "docs-manifest.json"), "utf-8"),
) as { apis: Record<string, { methods: Array<{ name: string }> }> };

function registryMethod(api: string, name: string) {
	return METHOD_REGISTRY[api]?.methods.find(m => m.name === name);
}

/** Angle brackets, braces and parentheses all close; `=>` does not count as a closing bracket. */
function isBalanced(type: string): boolean {
	let angle = 0;
	let brace = 0;
	let paren = 0;
	for (let i = 0; i < type.length; i++) {
		const ch = type[i];
		if (ch === "<") angle++;
		else if (ch === ">" && type[i - 1] !== "=") angle--;
		else if (ch === "{") brace++;
		else if (ch === "}") brace--;
		else if (ch === "(") paren++;
		else if (ch === ")") paren--;
	}
	return angle === 0 && brace === 0 && paren === 0;
}

describe("generated/method-registry.ts", () => {
	it("lists exactly the methods that docs-manifest.json documents for each API", () => {
		const undocumented: string[] = [];
		const notDispatchable: string[] = [];
		for (const [api, entry] of Object.entries(METHOD_REGISTRY)) {
			const doc = manifest.apis[api];
			if (!doc) continue;
			const documented = new Set(doc.methods.map(m => m.name));
			const dispatchable = new Set(entry.methods.map(m => m.name));
			for (const name of dispatchable) if (!documented.has(name)) undocumented.push(`${api}.${name}`);
			for (const name of documented) if (!dispatchable.has(name)) notDispatchable.push(`${api}.${name}`);
		}
		expect(undocumented).toEqual([]);
		expect(notDispatchable).toEqual([]);
	});

	it("includes the entity-creation, sharing and subscription methods that take an options object", () => {
		for (const [api, name] of [
			["Patient", "withEncryptionMetadata"],
			["Patient", "withEncryptionMetadataAndDelegates"],
			["Patient", "shareWith"],
			["Patient", "shareWithMany"],
			["Patient", "subscribeToEvents"],
			["Group", "createGroup"],
			["Document", "getAndDecryptMainAttachment"],
		]) {
			expect(registryMethod(api, name), `${api}.${name}`).toBeDefined();
		}
	});

	it("records the declared parameter order and optionality of Patient.withEncryptionMetadata", () => {
		const m = registryMethod("Patient", "withEncryptionMetadata")!;
		expect(m.params.map(p => p.name)).toEqual(["base", "options"]);
		expect(m.params[0]).toMatchObject({ type: "DecryptedPatient | undefined", optional: false });
		expect(m.params[1].optional).toBe(true);
		expect(m.params[1].type).toContain("user?: User | undefined");
	});

	it("never cuts a parameter or return type in the middle", () => {
		const cut: string[] = [];
		for (const [api, entry] of Object.entries(METHOD_REGISTRY)) {
			for (const m of entry.methods) {
				if (!isBalanced(m.returnType)) cut.push(`${api}.${m.name} returns ${m.returnType}`);
				for (const p of m.params) {
					if (!isBalanced(p.type)) cut.push(`${api}.${m.name}(${p.name}: ${p.type})`);
				}
			}
		}
		expect(cut).toEqual([]);
		expect(registryMethod("Patient", "getSecretIdsOf")!.returnType).toBe(
			"Promise<{ [key: string]: Array<EntityReferenceInGroup>; }>",
		);
	});
});
