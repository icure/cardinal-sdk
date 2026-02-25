import { McpServer, ResourceTemplate } from "@modelcontextprotocol/sdk/server/mcp.js";
import { getManifest } from "../helpers/docs-loader.js";

export function registerModelDocs(server: McpServer) {
	server.resource(
		"model-docs",
		new ResourceTemplate("cardinal://docs/model/{modelName}", {
			list: async () => {
				const manifest = getManifest();
				return {
					resources: Object.keys(manifest.models).sort().map(name => ({
						uri: `cardinal://docs/model/${name}`,
						name,
						description: manifest.models[name].variants
							? `Encryptable: ${manifest.models[name].variants!.join(", ")}`
							: `Model with ${manifest.models[name].fields.length} fields`,
					})),
				};
			},
		}),
		{
			title: "Model Documentation",
			description: "Model fields, types, variants, and parent interfaces",
			mimeType: "text/markdown",
		},
		async (uri, variables) => {
			const modelName = variables.modelName as string;
			const manifest = getManifest();
			const model = manifest.models[modelName];

			if (!model) {
				const available = Object.keys(manifest.models).sort().join(", ");
				return {
					contents: [{
						uri: uri.href,
						mimeType: "text/markdown",
						text: `# Model Not Found: ${modelName}\n\nAvailable models: ${available}`,
					}],
				};
			}

			let md = `# ${model.name}\n\n`;

			if (model.variants) {
				md += `**Encryptable entity** with variants: ${model.variants.map(v => `\`${v}\``).join(", ")}\n\n`;
			}

			if (model.implements && model.implements.length > 0) {
				md += `**Implements:** ${model.implements.map(i => `\`${i}\``).join(", ")}\n\n`;
			}

			if (model.fields.length > 0) {
				md += `## Fields (${model.fields.length})\n\n`;
				md += "| Field | Type | Description |\n";
				md += "|-------|------|-------------|\n";
				for (const field of model.fields) {
					const desc = field.description || "";
					md += `| \`${field.name}\` | \`${field.type}\` | ${desc} |\n`;
				}
			} else {
				md += "*No fields documented.*\n";
			}

			return {
				contents: [{ uri: uri.href, mimeType: "text/markdown", text: md }],
			};
		}
	);
}
