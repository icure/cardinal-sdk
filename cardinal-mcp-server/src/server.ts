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
