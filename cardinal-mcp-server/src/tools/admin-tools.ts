import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { z } from "zod";
import { dispatch } from "./dispatch.js";

const ADMIN_APIS = ["Group", "User", "Role", "Permission", "System", "Auth"] as const;

export function registerAdminTools(server: McpServer) {
	server.tool(
		"cardinal_admin",
		`Execute admin operations. Covers: ${ADMIN_APIS.join(", ")} APIs. Use search_documentation to discover available methods.`,
		{
			api: z.enum(ADMIN_APIS).describe("Which admin API to use"),
			method: z.string().describe("Method name (e.g., listGroups, getUser, createGroup)"),
			params: z.record(z.unknown()).optional().default({}).describe("Method parameters as key-value pairs"),
		},
		async ({ api, method, params }) => {
			return dispatch({ api, method, params });
		}
	);
}
