import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { z } from "zod";
import { dispatch } from "./dispatch.js";

const CRYPTO_APIS = ["Crypto", "Recovery", "ShamirKeysManager", "DataOwner", "CardinalMaintenanceTask"] as const;

export function registerCryptoTools(server: McpServer) {
	server.tool(
		"cardinal_crypto",
		`Execute cryptography and key management operations. Covers: ${CRYPTO_APIS.join(", ")} APIs. Use search_documentation to discover available methods.`,
		{
			api: z.enum(CRYPTO_APIS).describe("Which crypto API to use"),
			method: z.string().describe("Method name (e.g., getCurrentDataOwner, forceReload)"),
			params: z.record(z.unknown()).optional().default({}).describe("Method parameters as key-value pairs"),
		},
		async ({ api, method, params }) => {
			return dispatch({ api, method, params });
		}
	);
}
