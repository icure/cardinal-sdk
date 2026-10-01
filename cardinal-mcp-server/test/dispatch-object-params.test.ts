import { describe, it, expect, beforeAll, afterAll } from "vitest";
import type { Client } from "@modelcontextprotocol/sdk/client/index.js";
import type { CardinalSdk } from "@icure/cardinal-sdk";
import { makeClient, toolJson } from "./helpers/harness.js";
import { setSdk, resetSdk } from "../src/tools/sdk-state.js";

/**
 * Runs the dispatch layer against a stub SDK (the approach the DEFERRED note in protocol.test.ts describes) for the
 * argument shape the registry gained once multi-line signatures were parsed: a trailing `options` object literal
 * after the positional parameters. The stub records what the SDK method receives; nothing touches the network.
 * This is the only test file that mutates the sdk-state singleton, and it resets it when done.
 */

const received: Record<string, unknown[][]> = { withEncryptionMetadata: [], createGroup: [] };

const stubSdk = {
	patient: {
		withEncryptionMetadata: async (...args: unknown[]) => {
			received.withEncryptionMetadata.push(args);
			return { id: "p-1" };
		},
	},
	group: {
		createGroup: async (...args: unknown[]) => {
			received.createGroup.push(args);
			return { id: args[0] };
		},
	},
} as unknown as CardinalSdk;

type ToolResult = { content: Array<{ type: string; text?: string }>; isError?: boolean };

let client: Client;
let close: () => Promise<void>;

beforeAll(async () => {
	setSdk(stubSdk);
	({ client, close } = await makeClient());
});

afterAll(async () => {
	await close?.();
	resetSdk();
});

describe("dispatch of a method with a trailing options object", () => {
	it("builds Patient.withEncryptionMetadata's base as a model and passes its options through untouched", async () => {
		const options = {
			user: { id: "u-1", login: "ada" },
			delegates: { "hcp-1": "WRITE" },
			alternateRootDelegateId: "root-1",
		};
		const res = (await client.callTool({
			name: "cardinal_data_owner",
			arguments: { api: "Patient", method: "withEncryptionMetadata", params: { base: { firstName: "Ada" }, options } },
		})) as ToolResult;

		expect(res.isError).toBeFalsy();
		expect(toolJson(res)).toEqual({ id: "p-1" });
		const args = received.withEncryptionMetadata.at(-1)!;
		expect(args).toHaveLength(2);
		expect((args[0] as { firstName?: string }).firstName).toBe("Ada");
		expect(args[1]).toEqual(options);
	});

	it("passes undefined, not an empty object, when the options argument is omitted", async () => {
		const res = (await client.callTool({
			name: "cardinal_data_owner",
			arguments: { api: "Patient", method: "withEncryptionMetadata", params: { base: { firstName: "Ada" } } },
		})) as ToolResult;

		expect(res.isError).toBeFalsy();
		const args = received.withEncryptionMetadata.at(-1)!;
		expect(args).toHaveLength(2);
		expect(args[1]).toBeUndefined();
	});

	it("keeps the declared positional order for Group.createGroup and puts options last", async () => {
		const res = (await client.callTool({
			name: "cardinal_admin",
			arguments: {
				api: "Group",
				method: "createGroup",
				params: {
					options: { type: "ROOT", server: "https://db.example" },
					initialisationData: { users: [] },
					password: "pw",
					name: "Test group",
					id: "g-1",
				},
			},
		})) as ToolResult;

		expect(res.isError).toBeFalsy();
		const args = received.createGroup.at(-1)!;
		expect(args).toHaveLength(5);
		expect(args.slice(0, 3)).toEqual(["g-1", "Test group", "pw"]);
		expect(args[3]).toMatchObject({ users: [] });
		expect(args[4]).toEqual({ type: "ROOT", server: "https://db.example" });
	});
});
