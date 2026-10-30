import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { z } from "zod";
import { setSdk } from "./sdk-state.js";

export function registerInitTool(server: McpServer) {
	server.tool(
		"cardinal_init",
		"Initialize the Cardinal SDK with credentials. Required before using operational tools.",
		{
			baseUrl: z.string().describe("Cardinal API URL (e.g., https://api.icure.cloud)"),
			username: z.string().describe("User login (User.id, Group:User.id, User.login, or User.email)"),
			password: z.string().describe("User password"),
			projectId: z.string().optional().describe("ID of the user's own project, from Cockpit: pass it whenever the user has it. Never use another application's project ID, and never leave it out to make a failing login succeed (see cardinal://docs/guide/policy-agents)."),
			storageDir: z.string().optional().default("./cardinal-mcp-storage")
				.describe("Directory for crypto key storage"),
		},
		async ({ baseUrl, username, password, projectId, storageDir }) => {
			try {
				// Dynamic import to avoid loading the SDK until needed
				const { CardinalSdk } = await import("@icure/cardinal-sdk/sdk/CardinalSdk.mjs");
				const { AuthenticationMethod } = await import("@icure/cardinal-sdk/options/AuthenticationMethod.mjs");
				const { StorageFacade } = await import("@icure/cardinal-sdk/storage/StorageFacade.mjs");

				const authMethod = new AuthenticationMethod.UsingCredentials.UsernamePassword(username, password);
				const storage = StorageFacade.usingFileSystem(storageDir);

				const sdk = await CardinalSdk.initialize(
					projectId || undefined,
					baseUrl,
					authMethod,
					storage,
				);

				setSdk(sdk);

				return {
					content: [{
						type: "text" as const,
						text: JSON.stringify({
							status: "initialized",
							baseUrl,
							username,
							message: "Cardinal SDK initialized successfully. You can now use operational tools.",
						}, null, 2),
					}],
				};
			} catch (err: unknown) {
				const message = err instanceof Error ? err.message : String(err);
				return {
					content: [{
						type: "text" as const,
						text: JSON.stringify({ error: `Failed to initialize SDK: ${message}` }),
					}],
					isError: true,
				};
			}
		}
	);
}
