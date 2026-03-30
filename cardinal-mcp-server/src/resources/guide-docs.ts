import { McpServer, ResourceTemplate } from "@modelcontextprotocol/sdk/server/mcp.js";
import { getManifest } from "../helpers/docs-loader.js";

export function registerGuideDocs(server: McpServer) {
	server.resource(
		"guide-docs",
		new ResourceTemplate("cardinal://docs/guide/{slug}", {
			list: async () => {
				const manifest = getManifest();
				return {
					resources: manifest.guides.map(g => ({
						uri: `cardinal://docs/guide/${g.slug}`,
						name: g.title,
						description: `[${g.category}] ${g.title}`,
					})),
				};
			},
		}),
		{
			title: "Guide Documentation",
			description: "How-to guides, quickstart, encryption explanations, and troubleshooting from SDK.md",
			mimeType: "text/markdown",
		},
		async (uri, variables) => {
			const slug = variables.slug as string;
			const manifest = getManifest();
			const guide = manifest.guides.find(g => g.slug === slug);

			if (!guide) {
				const available = manifest.guides.map(g => `- ${g.slug} [${g.category}]: ${g.title}`).join("\n");
				return {
					contents: [{
						uri: uri.href,
						mimeType: "text/markdown",
						text: `# Guide Not Found: ${slug}\n\nAvailable guides:\n${available}`,
					}],
				};
			}

			return {
				contents: [{
					uri: uri.href,
					mimeType: "text/markdown",
					text: `# ${guide.title}\n\n*Category: ${guide.category}*\n\n${guide.content}`,
				}],
			};
		}
	);
}
