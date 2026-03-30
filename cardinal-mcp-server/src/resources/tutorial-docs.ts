import { McpServer, ResourceTemplate } from "@modelcontextprotocol/sdk/server/mcp.js";
import { getManifest } from "../helpers/docs-loader.js";

export function registerTutorialDocs(server: McpServer) {
	server.resource(
		"tutorial-docs",
		new ResourceTemplate("cardinal://docs/tutorial/{slug}", {
			list: async () => {
				const manifest = getManifest();
				return {
					resources: manifest.tutorials.map(t => ({
						uri: `cardinal://docs/tutorial/${t.slug}`,
						name: t.title,
						description: `Tutorial: ${t.title}`,
					})),
				};
			},
		}),
		{
			title: "Tutorial Documentation",
			description: "Step-by-step tutorial sections from SDK.md",
			mimeType: "text/markdown",
		},
		async (uri, variables) => {
			const slug = variables.slug as string;
			const manifest = getManifest();
			const tutorial = manifest.tutorials.find(t => t.slug === slug);

			if (!tutorial) {
				const available = manifest.tutorials.map(t => `- ${t.slug}: ${t.title}`).join("\n");
				return {
					contents: [{
						uri: uri.href,
						mimeType: "text/markdown",
						text: `# Tutorial Not Found: ${slug}\n\nAvailable tutorials:\n${available}`,
					}],
				};
			}

			return {
				contents: [{
					uri: uri.href,
					mimeType: "text/markdown",
					text: `# ${tutorial.title}\n\n${tutorial.content}`,
				}],
			};
		}
	);
}
