import { describe, it, expect, beforeAll, afterAll } from "vitest";
import type { Client } from "@modelcontextprotocol/sdk/client/index.js";
import { makeClient, toolJson } from "./helpers/harness.js";

interface SearchResponse {
	query: string;
	resultCount: number;
	results: Array<{ type: string; name: string; description: string; uri: string }>;
}

let client: Client;
let close: () => Promise<void>;

async function search(args: Record<string, unknown>): Promise<SearchResponse> {
	const res = await client.callTool({ name: "search_documentation", arguments: args });
	return toolJson<SearchResponse>(res as { content: Array<{ type: string; text?: string }> });
}

beforeAll(async () => {
	({ client, close } = await makeClient());
});

afterAll(async () => {
	await close?.();
});

describe("search_documentation", () => {
	it("finds results for a common term and shapes them correctly", async () => {
		const out = await search({ query: "patient" });
		expect(out.resultCount).toBeGreaterThan(0);
		expect(out.results.length).toBe(out.resultCount);
		for (const r of out.results) {
			expect(typeof r.type).toBe("string");
			expect(typeof r.name).toBe("string");
			expect(typeof r.uri).toBe("string");
		}
	});

	it("restricts results to the requested category", async () => {
		const out = await search({ query: "patient", category: "models" });
		expect(out.resultCount).toBeGreaterThan(0);
		for (const r of out.results) {
			expect(["model", "model_field"]).toContain(r.type);
		}
	});

	it("honours the limit parameter", async () => {
		const out = await search({ query: "patient", limit: 1 });
		expect(out.results.length).toBeLessThanOrEqual(1);
	});

	it("returns zero results for an empty query", async () => {
		const out = await search({ query: "" });
		expect(out.resultCount).toBe(0);
		expect(out.results).toEqual([]);
	});

	it("handles multi-word queries (camelCase + space tokenization)", async () => {
		const out = await search({ query: "calendar item" });
		expect(out.resultCount).toBeGreaterThan(0);
		expect(out.results.some(r => /calendaritem/i.test(r.uri) || /calendaritem/i.test(r.name))).toBe(true);
	});

	it("filters can be discovered via search", async () => {
		const out = await search({ query: "filter", category: "filters" });
		expect(out.resultCount).toBeGreaterThan(0);
		for (const r of out.results) {
			expect(["filter", "filter_method"]).toContain(r.type);
		}
	});
});
