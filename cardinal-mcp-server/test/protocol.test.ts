import { describe, it, expect, beforeAll, afterAll } from "vitest";
import type { Client } from "@modelcontextprotocol/sdk/client/index.js";
import { makeClient } from "./helpers/harness.js";

let client: Client;
let close: () => Promise<void>;

beforeAll(async () => {
	({ client, close } = await makeClient());
});

afterAll(async () => {
	await close?.();
});

describe("server identity & capabilities", () => {
	it("reports its name and exposes tools + resources capabilities", () => {
		expect(client.getServerVersion()?.name).toBe("cardinal-sdk");
		const caps = client.getServerCapabilities();
		expect(caps?.tools).toBeDefined();
		expect(caps?.resources).toBeDefined();
	});
});

describe("tools/list", () => {
	it("registers all six tools", async () => {
		const { tools } = await client.listTools();
		const names = tools.map(t => t.name).sort();
		expect(names).toEqual(
			[
				"cardinal_admin",
				"cardinal_continue_iteration",
				"cardinal_crypto",
				"cardinal_data_owner",
				"cardinal_init",
				"search_documentation",
			].sort(),
		);
	});

	it("exposes a well-formed schema for the stable search_documentation tool", async () => {
		const { tools } = await client.listTools();
		const search = tools.find(t => t.name === "search_documentation");
		expect(search).toBeDefined();
		expect(search!.description).toMatch(/search/i);

		const schema = search!.inputSchema;
		expect(schema.type).toBe("object");
		expect(schema.properties).toHaveProperty("query");
		expect(schema.properties).toHaveProperty("category");
		expect(schema.properties).toHaveProperty("limit");
		// query is the only required field
		expect(schema.required).toContain("query");
	});

	// Operational tools are present (registered) but their *behaviour* is deferred — see below.
	it("registers the four operational tools by name", async () => {
		const { tools } = await client.listTools();
		const names = new Set(tools.map(t => t.name));
		for (const name of ["cardinal_init", "cardinal_admin", "cardinal_data_owner", "cardinal_crypto"]) {
			expect(names.has(name)).toBe(true);
		}
	});
});

describe("resources/list", () => {
	it("lists the fixed overview resource plus templated list entries", async () => {
		const { resources } = await client.listResources();
		const uris = resources.map(r => r.uri);

		expect(uris).toContain("cardinal://docs/overview");
		// Each templated resource contributes a list of concrete URIs.
		for (const prefix of [
			"cardinal://docs/api/",
			"cardinal://docs/model/",
			"cardinal://docs/filter/",
			"cardinal://docs/tutorial/",
			"cardinal://docs/guide/",
		]) {
			expect(uris.some(u => u.startsWith(prefix))).toBe(true);
		}
	});
});

describe("resources/templates/list", () => {
	it("exposes the five templated resource URIs", async () => {
		const { resourceTemplates } = await client.listResourceTemplates();
		const templates = resourceTemplates.map(t => t.uriTemplate);

		expect(templates).toContain("cardinal://docs/api/{apiName}");
		expect(templates).toContain("cardinal://docs/model/{modelName}");
		expect(templates).toContain("cardinal://docs/filter/{entityName}");
		expect(templates).toContain("cardinal://docs/tutorial/{slug}");
		expect(templates).toContain("cardinal://docs/guide/{slug}");
	});
});

/**
 * DEFERRED — the operational tools (cardinal_init / cardinal_admin / cardinal_data_owner /
 * cardinal_crypto) and the generic dispatch layer are not finalized yet, so their runtime
 * behaviour is intentionally NOT tested here. When they settle, add a file that injects a
 * stub SDK via `setSdk()` (src/tools/sdk-state.ts) and asserts, through the in-memory client:
 *   - calling an operational tool before init -> isError, text === "SDK not initialized. Call cardinal_init first."
 *   - unknown API           -> isError, JSON {"error":"Unknown API: ..."}
 *   - unknown method        -> isError, JSON {"error":"Unknown method ..."}
 *   - method not a function -> isError, JSON {"error":"Method ... is not a function ..."}
 *   - a stub that returns a value -> serialized JSON payload
 *   - a stub that returns a {hasNext,next} iterator -> first page + cardinal_continue_iteration paging
 * (Error shapes verified: dispatch.ts errorResult vs. McpServer createToolError for thrown errors.)
 */
describe.skip("operational tool behaviour — DEFERRED (tools not finalized)", () => {
	it("placeholder", () => {});
});
