import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { z } from "zod";
import { dispatch } from "./dispatch.js";

const DATA_OWNER_APIS = [
	"HealthcareParty", "Patient", "Device"
] as const;

const FLAVOUR_VALUES = ["decrypted", "encrypted", "tryAndRecover"] as const;

export function registerDataOwnerTools(server: McpServer) {
	server.tool(
		"cardinal_data_owner",
		`Execute data operations on healthcare entities. Covers: ${DATA_OWNER_APIS.join(", ")} APIs. Encryptable entities support the 'flavour' parameter for encrypted/decrypted/tryAndRecover variants. Use search_documentation to discover available methods.`,
		{
			api: z.enum(DATA_OWNER_APIS).describe("Which API to use"),
			method: z.string().describe("Method name (e.g., getPatient, createCalendarItem, filterPatientsBy)"),
			flavour: z.enum(FLAVOUR_VALUES).optional().describe("For encryptable entities: decrypted (default), encrypted, or tryAndRecover"),
			params: z.record(z.unknown()).optional().default({}).describe("Method parameters as key-value pairs"),
		},
		async ({ api, method, flavour, params }) => {
			return dispatch({ api, method, flavour, params });
		}
	);
}
