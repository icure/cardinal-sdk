import { describe, it, expect, beforeAll, afterAll } from "vitest";
import type { Client } from "@modelcontextprotocol/sdk/client/index.js";
import { makeClient, readText, pickFirst } from "./helpers/harness.js";

let client: Client;
let close: () => Promise<void>;

beforeAll(async () => {
	({ client, close } = await makeClient());
});

afterAll(async () => {
	await close?.();
});

describe("overview resource", () => {
	it("renders a markdown overview listing tools and resources", async () => {
		const md = await readText(client, "cardinal://docs/overview");
		expect(md).toMatch(/^#\s/m);
		expect(md.toLowerCase()).toContain("search_documentation");
		expect(md.toLowerCase()).toContain("cardinal://docs/");
	});
});

describe("api-docs resource", () => {
	it("documents the User API methods", async () => {
		const md = await readText(client, "cardinal://docs/api/User");
		expect(md).toContain("# UserApi");
		for (const method of ["enable2faForUser", "disable2faForUser", "getUserByEmail", "getUserByPhoneNumber"]) {
			expect(md).toContain(method);
		}
	});
});

describe("model-docs resource", () => {
	it("documents the User model fields", async () => {
		const md = await readText(client, "cardinal://docs/model/User");
		expect(md).toContain("# User");
		expect(md).toContain("systemMetadata");
	});
});

describe("filter-docs resource", () => {
	it("renders Service filter methods", async () => {
		const md = await readText(client, "cardinal://docs/filter/Service");
		expect(md).toMatch(/Service/);
		// At least one method section / table is rendered.
		expect(md).toMatch(/##\s/);
	});
});

describe("tutorial & guide resources (dynamic slugs)", () => {
	it("reads a real tutorial and renders its title heading", async () => {
		const uri = await pickFirst(client, "cardinal://docs/tutorial/");
		const md = await readText(client, uri);
		expect(md).toMatch(/^#\s/m);
		expect(md.length).toBeGreaterThan(20);
	});

	it("reads a real guide and renders its title + category", async () => {
		const uri = await pickFirst(client, "cardinal://docs/guide/");
		const md = await readText(client, uri);
		expect(md).toMatch(/^#\s/m);
		expect(md).toMatch(/Category:/i);
	});
});

describe("not-found paths return guidance content (not an error)", () => {
	const cases: Array<[string, string]> = [
		["cardinal://docs/api/__nope__", "# API Not Found: __nope__"],
		["cardinal://docs/model/__nope__", "# Model Not Found: __nope__"],
		["cardinal://docs/filter/__nope__", "# Filters Not Found: __nope__"],
		["cardinal://docs/tutorial/__nope__", "# Tutorial Not Found: __nope__"],
		["cardinal://docs/guide/__nope__", "# Guide Not Found: __nope__"],
	];

	it.each(cases)("%s -> %s", async (uri, expectedPrefix) => {
		const res = await client.readResource({ uri });
		const text = res.contents?.[0]?.text as string;
		expect(text.startsWith(expectedPrefix)).toBe(true);
		// These are informational responses, so they carry the "Available ..." hint.
		expect(text.toLowerCase()).toMatch(/available/);
	});
});
