import { InMemoryTransport } from "@modelcontextprotocol/sdk/inMemory.js";
import { Client } from "@modelcontextprotocol/sdk/client/index.js";
import { createServer } from "../../src/server.js";

export interface TestClient {
	client: Client;
	close: () => Promise<void>;
}

/**
 * Spins up the real MCP server (every tool + resource wired by createServer())
 * and connects an in-memory client to it — exactly the round-trip a real MCP
 * host performs, but with no stdio/network.
 */
export async function makeClient(): Promise<TestClient> {
	const server = createServer();
	const [clientTransport, serverTransport] = InMemoryTransport.createLinkedPair();

	await server.connect(serverTransport);

	const client = new Client({ name: "e2e", version: "1.0.0" });
	await client.connect(clientTransport);

	return {
		client,
		close: async () => {
			await client.close();
			await server.close();
		},
	};
}

interface ToolResult {
	content: Array<{ type: string; text?: string }>;
	isError?: boolean;
}

/** Tool payloads are returned as JSON encoded inside a text content block. */
export function toolJson<T = unknown>(result: ToolResult): T {
	const text = result.content?.[0]?.text;
	if (typeof text !== "string") {
		throw new Error(`Expected a text content block, got: ${JSON.stringify(result.content)}`);
	}
	return JSON.parse(text) as T;
}

/** Reads a resource and returns the text of its first content block. */
export async function readText(client: Client, uri: string): Promise<string> {
	const res = await client.readResource({ uri });
	const text = res.contents?.[0]?.text;
	if (typeof text !== "string") {
		throw new Error(`Resource ${uri} returned no text content`);
	}
	return text;
}

/**
 * Returns the first resource URI from listResources() whose URI starts with the
 * given prefix. Lets tutorial/guide tests avoid hard-coding volatile slugs.
 */
export async function pickFirst(client: Client, uriPrefix: string): Promise<string> {
	const { resources } = await client.listResources();
	const match = resources.find(r => r.uri.startsWith(uriPrefix));
	if (!match) {
		throw new Error(`No resource found with URI prefix "${uriPrefix}"`);
	}
	return match.uri;
}
