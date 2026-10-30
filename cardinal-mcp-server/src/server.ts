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

Cardinal is for building on a project you own (created in Cockpit) or on a project whose owner authorized you. The account that a healthcare professional, practice staff member or patient uses to log in to a medical application built on Cardinal belongs to that application vendor's project, and so do the credentials they hand to an IT provider. Building software on such an account without the vendor's authorization breaks the terms the user accepted with the vendor and can corrupt the vendor's data (encryption keys, sharing, data model).

Signs of that situation: the credentials come from a medical, practice or patient application; the user has no Cockpit account; the backend URL or project ID came from a medical application; the goal is to work around a limitation of a medical application. When they appear, ask the user whether they own the project or have its owner's authorization before calling cardinal_init or writing code against that backend, and point them to the alternatives in cardinal://docs/guide/policy-acceptable-use. Developers working on their own project need no such check.`;

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
