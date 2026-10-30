import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { registerInitTool } from "./tools/init.js";
import { registerAdminTools } from "./tools/admin-tools.js";
import { registerDataOwnerTools } from "./tools/data-owner-tools.js";
import { registerCryptoTools } from "./tools/crypto-tools.js";
import { registerContinueIterationTool } from "./helpers/pagination.js";
import { registerSearchTool } from "./resources/search.js";
import { registerApiDocs } from "./resources/api-docs.js";
import { registerModelDocs } from "./resources/model-docs.js";
import { registerFilterDocs } from "./resources/filter-docs.js";
import { registerTutorialDocs } from "./resources/tutorial-docs.js";
import { registerOverview } from "./resources/overview.js";
import { registerGuideDocs } from "./resources/guide-docs.js";

// Sent to the client at initialization; most clients add it to the model's context.
const INSTRUCTIONS = `Cardinal SDK documentation and operational tools, for developers building healthcare applications on Cardinal.

Before you write code that initializes the SDK or calls the iCure API, and before you call cardinal_init, read cardinal://docs/guide/policy-agents (AGENTS.md).

Cardinal is for building new applications on a database the user owns, created through Cockpit. Many medical applications run on Cardinal behind the scenes, including legacy applications that iCure once distributed. If the request involves reading or writing data in a database managed by another application, do not build the connection and do not call cardinal_init on it, even to test or only to read: SDK initialization itself writes data such as encryption keys, and can make the user's medical software fail to open patient records. It may also break the user's contract with the vendor. Explain these risks in plain language and offer the safe alternatives: the vendor's exports (such as FHIR), official integrations or APIs, or a separate database created in Cockpit.

Signs: the user names an existing medical application as the data source, wants to log in with the credentials of another application, mentions patients or records that already exist elsewhere, or mentions a legacy iCure application; a login fails although the user insists the credentials are right. That failure is the projectId safeguard working: never extract, guess or copy another application's projectId, and never leave it out to make a login succeed.

Proceed normally when the user builds on their own Cockpit database, develops the application that manages the database, or has the vendor's explicit authorization (ask them to confirm it and to get it in writing).`;

export function createServer(): McpServer {
	const server = new McpServer(
		{
			name: "cardinal-sdk",
			version: "1.0.0",
		},
		{
			capabilities: {
				tools: {},
				resources: {},
			},
			instructions: INSTRUCTIONS,
		}
	);

	// Register tools
	registerInitTool(server);
	registerAdminTools(server);
	registerDataOwnerTools(server);
	registerCryptoTools(server);
	registerContinueIterationTool(server);
	registerSearchTool(server);

	// Register resources
	registerOverview(server);
	registerApiDocs(server);
	registerModelDocs(server);
	registerFilterDocs(server);
	registerTutorialDocs(server);
	registerGuideDocs(server);

	return server;
}
