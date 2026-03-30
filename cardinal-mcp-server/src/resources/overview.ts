import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { getManifest } from "../helpers/docs-loader.js";

export function registerOverview(server: McpServer) {
	server.resource(
		"overview",
		"cardinal://docs/overview",
		{
			title: "Cardinal SDK Overview",
			description: "SDK architecture, available APIs, and initialization guide",
			mimeType: "text/markdown",
		},
		async (uri) => {
			const manifest = getManifest();
			const apiNames = Object.keys(manifest.apis).sort();
			const encryptable = apiNames.filter(n => manifest.apis[n].isEncryptable);
			const nonEncryptable = apiNames.filter(n => !manifest.apis[n].isEncryptable);

			const guidesByCategory = new Map<string, number>();
			for (const guide of manifest.guides) {
				guidesByCategory.set(guide.category, (guidesByCategory.get(guide.category) || 0) + 1);
			}
			const guideSummary = [...guidesByCategory.entries()].map(([cat, count]) => `${count} ${cat}`).join(", ");

			const content = `# Cardinal SDK Overview

## What is Cardinal SDK?
Cardinal SDK is a multi-language healthcare platform SDK with built-in end-to-end encryption.
It provides CRUD operations, filtering/querying, real-time event subscriptions, and cryptographic key management for medical data entities like Patients, Contacts, Services, HealthElements, Documents, and more.

## Initialization
\`\`\`typescript
import { CardinalSdk } from "@icure/cardinal-sdk/sdk/CardinalSdk.mjs";
import { AuthenticationMethod } from "@icure/cardinal-sdk/options/AuthenticationMethod.mjs";
import { StorageFacade } from "@icure/cardinal-sdk/storage/StorageFacade.mjs";

const sdk = await CardinalSdk.initialize(
  undefined,  // projectId
  "https://api.icure.cloud",
  new AuthenticationMethod.UsingCredentials.UsernamePassword(username, password),
  StorageFacade.usingFileSystem("./storage")
);
\`\`\`

Or via MCP: use the \`cardinal_init\` tool with baseUrl, username, and password.

## Available APIs (${apiNames.length} total)

### Encryptable Entity APIs (${encryptable.length})
These support encryption flavours (decrypted/encrypted/tryAndRecover):
${encryptable.map(n => `- **${n}Api** — ${manifest.apis[n].description}`).join("\n")}

### Non-Encryptable APIs (${nonEncryptable.length})
${nonEncryptable.map(n => `- **${n}Api** — ${manifest.apis[n].description}`).join("\n")}

## MCP Tools
- **cardinal_init** — Initialize SDK with credentials
- **cardinal_admin** — Group, User, Role, Permission, System operations
- **cardinal_data_owner** — Healthcare entity CRUD, filtering, sharing
- **cardinal_crypto** — Cryptography, key recovery, data owner management
- **cardinal_continue_iteration** — Fetch next page from paginated queries
- **search_documentation** — Search API methods, models, filters, and guides

## MCP Resources
- \`cardinal://docs/overview\` — This overview
- \`cardinal://docs/api/{apiName}\` — API reference for each API
- \`cardinal://docs/model/{modelName}\` — Model field documentation
- \`cardinal://docs/filter/{entityName}\` — Filter factory methods
- \`cardinal://docs/tutorial/{slug}\` — Tutorial sections (${manifest.tutorials.length} tutorials)
- \`cardinal://docs/guide/{slug}\` — How-to guides, encryption docs, quickstart, troubleshooting (${manifest.guides.length} guides: ${guideSummary})

## Encryptable Entity Pattern
Healthcare entities with sensitive data use sealed types:
- \`Patient\` (sealed) → \`DecryptedPatient\` + \`EncryptedPatient\`
- Each API has flavours: \`sdk.patient\` (decrypted), \`sdk.patient.encrypted\`, \`sdk.patient.tryAndRecover\`
- Creating requires: \`withEncryptionMetadata(base, patient)\` then \`createEntity(entity)\`

## Filters
Query entities using filter builders:
\`\`\`typescript
const patients = await sdk.patient.filterPatientsBy(
  PatientFilters.bySsinsForSelf(["123456789"])
);
\`\`\`
`;

			return {
				contents: [{ uri: uri.href, mimeType: "text/markdown", text: content }],
			};
		}
	);
}
