import { describe, it, expect, beforeAll, afterAll } from "vitest";
import type { Client } from "@modelcontextprotocol/sdk/client/index.js";
import * as fs from "node:fs";
import * as path from "node:path";
import { fileURLToPath } from "node:url";
import { makeClient, readText } from "./helpers/harness.js";

/**
 * The API documentation is read from the same `.d.mts` files as the method registry. These tests pin what the
 * rendered `cardinal://docs/api/{apiName}` pages must show for the declaration shapes that used to be misread:
 * nested generics in return types, object-literal parameters spread over several lines, function-typed options.
 */

const here = path.dirname(fileURLToPath(import.meta.url));
const manifest = JSON.parse(
	fs.readFileSync(path.resolve(here, "..", "generated", "docs-manifest.json"), "utf-8"),
) as { apis: Record<string, { methods: Array<{ name: string; returnType: string; params: Array<{ type: string }> }> }> };

let client: Client;
let close: () => Promise<void>;

beforeAll(async () => {
	({ client, close } = await makeClient());
});

afterAll(async () => {
	await close?.();
});

describe("api-docs resource, method signatures", () => {
	it("shows the whole return type of Patient.decrypt", async () => {
		const md = await readText(client, "cardinal://docs/api/Patient");
		expect(md).toContain("### decrypt\n");
		expect(md).toContain("**Returns:** `Array<DecryptedPatient>`");
	});

	it("shows the options parameter of Patient.withEncryptionMetadata as one optional object", async () => {
		const md = await readText(client, "cardinal://docs/api/Patient");
		const section = md.slice(md.indexOf("### withEncryptionMetadata\n"), md.indexOf("### withEncryptionMetadataAndDelegates\n"));
		expect(section).toContain("- `base`: `DecryptedPatient | undefined`");
		expect(section).toContain("- `options`: `{ user?: User | undefined; delegates?: { [key: string]: AccessLevel; }; alternateRootDelegateId?: string | undefined; }` *(optional)*");
		expect(section).toContain("**Returns:** `DecryptedPatient`");
	});

	it("documents the Document attachment methods whose options hold a function type", async () => {
		const md = await readText(client, "cardinal://docs/api/Document");
		expect(md).toContain("### getAndDecryptMainAttachment\n");
		expect(md).toContain("- `options`: `{ decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean>; }` *(optional)*");
	});
});

describe("generated/docs-manifest.json, api methods", () => {
	it("reports what a call resolves to, without the Promise wrapper", () => {
		const wrapped: string[] = [];
		for (const [api, doc] of Object.entries(manifest.apis)) {
			for (const m of doc.methods) {
				if (m.returnType.startsWith("Promise<")) wrapped.push(`${api}.${m.name}`);
			}
		}
		expect(wrapped).toEqual([]);
		expect(manifest.apis.Patient.methods.find(m => m.name === "hasWriteAccess")!.returnType).toBe("boolean");
	});

	it("never cuts a type in the middle nor keeps line breaks inside it", () => {
		const bad: string[] = [];
		for (const [api, doc] of Object.entries(manifest.apis)) {
			for (const m of doc.methods) {
				for (const type of [m.returnType, ...m.params.map(p => p.type)]) {
					if (!isBalanced(type) || type.includes("\n")) bad.push(`${api}.${m.name}: ${JSON.stringify(type)}`);
				}
			}
		}
		expect(bad).toEqual([]);
	});
});

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
