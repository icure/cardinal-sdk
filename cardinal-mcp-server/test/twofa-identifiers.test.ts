import { describe, it, expect, beforeAll, afterAll } from "vitest";
import type { Client } from "@modelcontextprotocol/sdk/client/index.js";
import { makeClient, toolJson, readText } from "./helpers/harness.js";

/**
 * Focused safety net for the 2FA + verified-identifier surface that was the point of the
 * preceding doc re-sync. Intentionally overlaps the generic resource/search tests so a
 * regression here fails loudly and specifically.
 */

interface SearchResponse {
	resultCount: number;
	results: Array<{ type: string; name: string; uri: string }>;
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

describe("2FA / verified identifiers — discoverable via search", () => {
	it("surfaces the 2FA guide or the enable2faForUser method for '2fa'", async () => {
		const out = await search({ query: "2fa" });
		expect(out.resultCount).toBeGreaterThan(0);
		const hit = out.results.some(
			r => /2fa/i.test(r.name) || /2fa/i.test(r.uri) || /two.?factor/i.test(r.name),
		);
		expect(hit).toBe(true);
	});

	it("surfaces verified-email related results for 'verified email'", async () => {
		const out = await search({ query: "verified email" });
		expect(out.resultCount).toBeGreaterThan(0);
		const hit = out.results.some(
			r => /verifiedEmail/i.test(r.name) || /modifyUserEmail/i.test(r.name) || /verified/i.test(r.name),
		);
		expect(hit).toBe(true);
	});
});

describe("2FA / verified identifiers — model docs", () => {
	it("Enable2faRequest documents secret, otpLength, otp and algorithm", async () => {
		const md = await readText(client, "cardinal://docs/model/Enable2faRequest");
		for (const field of ["secret", "otpLength", "otp", "algorithm"]) {
			expect(md).toContain(field);
		}
	});

	it("Enable2faRequest.Algorithm is an enum with the three TOTP hash algorithms", async () => {
		const md = await readText(client, "cardinal://docs/model/Enable2faRequest.Algorithm");
		expect(md.toLowerCase()).toContain("enum");
		for (const constant of ["Sha1", "Sha256", "Sha512"]) {
			expect(md).toContain(constant);
		}
	});

	it("User.SystemMetadata exposes login identifiers, verified flags and the 2FA flag", async () => {
		const md = await readText(client, "cardinal://docs/model/User.SystemMetadata");
		for (const field of ["loginIdentifiers", "verifiedEmail", "verifiedMobilePhone", "uses2fa"]) {
			expect(md).toContain(field);
		}
	});
});

describe("2FA / verified identifiers — User API", () => {
	it("exposes the 2FA and identifier-management methods", async () => {
		const md = await readText(client, "cardinal://docs/api/User");
		for (const method of [
			"enable2faForUser",
			"disable2faForUser",
			"getUserByEmail",
			"getUserByPhoneNumber",
			"modifyUserEmail",
			"modifyUserMobilePhone",
		]) {
			expect(md).toContain(method);
		}
	});
});
