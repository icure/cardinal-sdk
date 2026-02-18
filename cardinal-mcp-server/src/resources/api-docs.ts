import { McpServer, ResourceTemplate } from "@modelcontextprotocol/sdk/server/mcp.js";
import { getManifest } from "../helpers/docs-loader.js";

export function registerApiDocs(server: McpServer) {
	server.resource(
		"api-docs",
		new ResourceTemplate("cardinal://docs/api/{apiName}", {
			list: async () => {
				const manifest = getManifest();
				return {
					resources: Object.keys(manifest.apis).sort().map(name => ({
						uri: `cardinal://docs/api/${name}`,
						name: `${name}Api`,
						description: manifest.apis[name].description,
					})),
				};
			},
		}),
		{
			title: "API Documentation",
			description: "Full reference for a Cardinal SDK API",
			mimeType: "text/markdown",
		},
		async (uri, variables) => {
			const apiName = variables.apiName as string;
			const manifest = getManifest();
			const api = manifest.apis[apiName];

			if (!api) {
				const available = Object.keys(manifest.apis).sort().join(", ");
				return {
					contents: [{
						uri: uri.href,
						mimeType: "text/markdown",
						text: `# API Not Found: ${apiName}\n\nAvailable APIs: ${available}`,
					}],
				};
			}

			let md = `# ${api.name}\n\n${api.description}\n\n`;

			if (api.isEncryptable) {
				md += `> **Encryptable Entity** — Supports flavours: decrypted (default), encrypted, tryAndRecover\n\n`;
			}

			md += `## Methods (${api.methods.length})\n\n`;

			for (const method of api.methods) {
				md += `### ${method.name}\n\n`;
				if (method.description) {
					md += `${method.description}\n\n`;
				}

				if (method.params.length > 0) {
					md += `**Parameters:**\n`;
					for (const param of method.params) {
						const opt = param.optional ? " *(optional)*" : "";
						const desc = param.description ? ` — ${param.description}` : "";
						md += `- \`${param.name}\`: \`${param.type}\`${opt}${desc}\n`;
					}
					md += "\n";
				}

				md += `**Returns:** \`${method.returnType}\`\n\n`;

				if (method.throws && method.throws.length > 0) {
					md += `**Throws:** ${method.throws.join(", ")}\n\n`;
				}

				md += "---\n\n";
			}

			return {
				contents: [{ uri: uri.href, mimeType: "text/markdown", text: md }],
			};
		}
	);
}
