# Cardinal MCP server

`@icure/cardinal-mcp-server` is a [Model Context Protocol](https://modelcontextprotocol.io) server for the
[Cardinal SDK](https://github.com/icure/cardinal-sdk). Once it is connected to an AI assistant such as Claude, the
assistant can:

- search and read the Cardinal SDK documentation (APIs, models, filters, tutorials and how-to guides), with no
  account needed;
- call the TypeScript SDK against a Cardinal backend on your behalf, after you log in with `cardinal_init`.

The server runs locally over stdio. Its version follows the SDK version it was generated from: install
`@icure/cardinal-mcp-server@2.13.3` to get the documentation and method surface of SDK 2.13.3.

## Requirements

- Node.js 20 or later (`npx` comes with it).
- For the operational tools only: the URL of a Cardinal backend (for example `https://api.icure.cloud`) and the
  login and password of a user in it.

## Install in Claude Code

From the project where you want the server available:

```bash
claude mcp add cardinal -- npx -y @icure/cardinal-mcp-server
```

The default scope is `local`: the server is available to you, in this project only. Two other scopes exist:

```bash
# Everyone who clones the repository: writes .mcp.json at the repository root, commit it
claude mcp add --scope project cardinal -- npx -y @icure/cardinal-mcp-server

# You, in every project
claude mcp add --scope user cardinal -- npx -y @icure/cardinal-mcp-server
```

The project scope produces this `.mcp.json`, which you can also write by hand:

```json
{
  "mcpServers": {
    "cardinal": {
      "command": "npx",
      "args": ["-y", "@icure/cardinal-mcp-server"]
    }
  }
}
```

To pin the SDK version the assistant sees, replace the package name with `@icure/cardinal-mcp-server@<version>`.
Check the connection with `claude mcp list`, or `/mcp` inside a Claude Code session.

## Install in Claude Desktop

Open the configuration file, add the same `mcpServers` entry, then restart Claude Desktop:

- macOS: `~/Library/Application Support/Claude/claude_desktop_config.json`
- Windows: `%APPDATA%\Claude\claude_desktop_config.json`

```json
{
  "mcpServers": {
    "cardinal": {
      "command": "npx",
      "args": ["-y", "@icure/cardinal-mcp-server"]
    }
  }
}
```

Claude Desktop starts the server with a minimal environment. If the server does not appear, replace `"npx"` with
the absolute path printed by `which npx` (macOS) or `where npx` (Windows).

## What the assistant gets

| Tool | Needs `cardinal_init` | Purpose |
| --- | --- | --- |
| `search_documentation` | no | Full-text search over the API, model, filter, tutorial and guide documentation |
| `cardinal_init` | – | Logs in to a Cardinal backend and keeps the SDK instance for the rest of the session |
| `cardinal_admin` | yes | Group, User, Role, Permission, System, Auth and Filter APIs |
| `cardinal_data_owner` | yes | HealthcareParty, Patient and Device APIs, with a `flavour` of `decrypted`, `encrypted` or `tryAndRecover` |
| `cardinal_crypto` | yes | Crypto, Recovery, ShamirKeysManager, DataOwner and CardinalMaintenanceTask APIs |
| `cardinal_continue_iteration` | yes | Fetches the next page of a paginated result |

The documentation is also exposed as MCP resources the assistant can read directly: `cardinal://docs/overview`,
`cardinal://docs/api/{apiName}`, `cardinal://docs/model/{modelName}`, `cardinal://docs/filter/{entityName}`,
`cardinal://docs/tutorial/{slug}` and `cardinal://docs/guide/{slug}`.

## Using it

Documentation questions work right away:

> How do I share a patient with another healthcare party in the Cardinal TypeScript SDK?

The assistant searches the documentation and reads `cardinal://docs/api/Patient` or the relevant how-to guide.

To run operations, ask the assistant to log in first:

> Initialise Cardinal against https://api.icure.cloud with the user alice@example.com and the password I will give you.

This calls `cardinal_init`, which takes `baseUrl`, `username`, `password`, an optional `projectId` and a `storageDir`
for the SDK's key storage (default `./cardinal-mcp-storage`, relative to the directory the server was started from).
From then on the assistant can, for instance, list the patients of the current data owner, create an entity or
inspect the keys of a data owner. Method parameters are passed by their declared name; a filter parameter is written
as `{ "_factory": "<Entity>Filters.<method>", "<param>": ... }` using the factories listed under
`cardinal://docs/filter/{entityName}`.

**Keep the credentials you hand over in mind.** Everything you type reaches the model, and the assistant can call any
method the SDK exposes with the rights of that user. Use a test group or a dedicated user with the least privileges
that get the job done, never a production administrator. The `storageDir` holds the user's private keys: point it
outside your repository and do not commit it.

## Running from source

```bash
git clone https://github.com/icure/cardinal-sdk.git
cd cardinal-sdk/cardinal-mcp-server
corepack enable
yarn install
yarn run build
claude mcp add cardinal-dev -- node "$PWD/dist/index.js"
```

`yarn test` runs the suite (an in-memory MCP client against the real server, no network). `yarn run generate`
regenerates the documentation manifest and the method registry in `generated/`; it needs the parent repository
checked out (for the Kotlin KDoc) and the matching `@icure/cardinal-sdk` in `node_modules`. `CLAUDE.md` describes
the code layout and the release automation.
