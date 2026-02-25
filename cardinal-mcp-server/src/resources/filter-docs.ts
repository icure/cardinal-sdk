import { McpServer, ResourceTemplate } from "@modelcontextprotocol/sdk/server/mcp.js";
import { getManifest } from "../helpers/docs-loader.js";

export function registerFilterDocs(server: McpServer) {
	server.resource(
		"filter-docs",
		new ResourceTemplate("cardinal://docs/filter/{entityName}", {
			list: async () => {
				const manifest = getManifest();
				return {
					resources: Object.keys(manifest.filters).sort().map(name => ({
						uri: `cardinal://docs/filter/${name}`,
						name: `${name}Filters`,
						description: `${manifest.filters[name].methods.length} filter methods for ${name}`,
					})),
				};
			},
		}),
		{
			title: "Filter Documentation",
			description: "Available filter factory methods for an entity type",
			mimeType: "text/markdown",
		},
		async (uri, variables) => {
			const entityName = variables.entityName as string;
			const manifest = getManifest();
			const filter = manifest.filters[entityName];

			if (!filter) {
				const available = Object.keys(manifest.filters).sort().join(", ");
				return {
					contents: [{
						uri: uri.href,
						mimeType: "text/markdown",
						text: `# Filters Not Found: ${entityName}\n\nAvailable: ${available}`,
					}],
				};
			}

			let md = `# ${entityName}Filters\n\n`;
			md += `Filter factory methods for querying ${entityName} entities.\n\n`;
			md += `## Usage with MCP tools\n\n`;
			md += `Pass filters as the \`filter\` parameter using the \`_factory\` format:\n`;
			md += `\`\`\`json\n`;
			md += `{\n`;
			md += `  "filter": {\n`;
			md += `    "_factory": "${entityName}Filters.methodName",\n`;
			md += `    "param1": "value1"\n`;
			md += `  }\n`;
			md += `}\n`;
			md += `\`\`\`\n\n`;
			md += `## Methods (${filter.methods.length})\n\n`;

			for (const method of filter.methods) {
				const paramStr = method.params.map(p => `${p.name}: ${p.type}`).join(", ");
				md += `### ${method.name}\n`;
				md += `\`\`\`typescript\n${entityName}Filters.${method.name}(${paramStr})\n\`\`\`\n\n`;
			}

			return {
				contents: [{ uri: uri.href, mimeType: "text/markdown", text: md }],
			};
		}
	);
}
