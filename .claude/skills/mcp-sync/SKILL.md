---
name: mcp-sync
description: Sync cardinal-mcp-server with a new Cardinal SDK version after the generated files were refreshed. Reconciles the API allow-lists and tool enums with the SDK's API surface, fixes generate/build/test breakage, patches SDK.md snippets for removed or renamed APIs and writes the PR description. Used by .github/workflows/update_mcp_server.yml; also runnable by hand.
---

# MCP server sync

You bring `cardinal-mcp-server/` in line with the Cardinal SDK version that is about to be released. The mechanical
part is already done when you start: the unreleased TypeScript SDK is installed in `node_modules/@icure/cardinal-sdk`,
`package.json` carries the new version, and `yarn run generate`, `yarn run build` and `yarn test` have been run once.
Your job is the part that needs judgment.

Read `cardinal-mcp-server/CLAUDE.md` first. It describes the architecture and the generated files.

## Arguments

The prompt passes `KEY=VALUE` pairs:

- `SDK_VERSION` — the SDK version the server must target.
- `PREVIOUS_SDK_VERSION` — the version it targeted before this sync.
- `SYNC_DIR` — directory holding `generate.log`, `build.log`, `test.log` and `outcomes.txt` from the first pass.
  `outcomes.txt` lists the commands that failed, one `name=failed` per line, and is empty when everything passed.
- `PR_BODY_PATH` — where to write the PR description (Markdown).

When run by hand without arguments, follow the **Running locally** section first.

## Boundaries

- **Edit only inside `cardinal-mcp-server/`**, plus the file at `PR_BODY_PATH`. Anything else is discarded by the
  workflow and fails verification.
- **Never edit `generated/` by hand.** Fix the generator scripts and rerun `yarn run generate`.
- **Do not run `git commit`, `git push`, `gh`, `yarn add`, `yarn remove` or `yarn install`.** The workflow commits
  and opens the PR. Dependencies do not change during a sync; if one must, say so in the PR body and stop.
- **Do not change `version` or `dependencies["@icure/cardinal-sdk"]` in `package.json`**, nor `.yarnrc.yml`,
  nor `yarn.lock`. The lockfile lags `package.json` by one SDK version on purpose (see the note at the end).
- **Do not widen the server's scope.** It is TypeScript-only by design: `extract-docs.ts` strips Kotlin, Python and
  Dart snippets from `SDK.md`, and the tools call the TypeScript SDK. Keep it that way.

## Procedure

1. **Read the state.** `cat` the logs and `outcomes.txt` in `SYNC_DIR`, then run `git diff --stat -- cardinal-mcp-server`
   and read the diff of `generated/method-registry.ts` at API level (which `"<Name>": {` blocks were added or removed,
   which methods changed).

2. **Compute the API surface diff.** List the API declaration files: `ls node_modules/@icure/cardinal-sdk/api/*.d.mts`.
   Each `<Name>Api.d.mts` is a candidate, **except the variants**: `<Name>BasicApi`, `<Name>FlavouredApi`,
   `<Name>InGroupApi`, `<Name>BasicInGroupApi`, `<Name>FlavouredInGroupApi` and `Anonymous<Name>Api`. Those are the
   flavour and multi-group views of `<Name>Api`, reached through the `flavour` argument of the tools and never listed
   on their own. Only top-level `<Name>Api` files count. Compare the candidates against:
   - `ALLOWED_APIS` and `ENCRYPTABLE_ENTITIES` in `scripts/generate-registry.ts`,
   - `ADMIN_APIS` in `src/tools/admin-tools.ts`, `DATA_OWNER_APIS` in `src/tools/data-owner-tools.ts`,
     `CRYPTO_APIS` in `src/tools/crypto-tools.ts`,
   - the `toPropertyName` map in `scripts/generate-registry.ts`.

   Then decide, API by API:
   - **New API, not deprecated** → add it to `ALLOWED_APIS`, to `toPropertyName` if camel-casing the name is not the
     SDK property name (check `node_modules/@icure/cardinal-sdk/sdk/CardinalSdk.d.mts`), and to `ENCRYPTABLE_ENTITIES`
     if its entity has `Decrypted*`/`Encrypted*` variants. Add it to the matching tool enum only if it belongs to that
     tool's domain (admin, data-owner, crypto); entity APIs are reached through dispatch and need no enum entry.
   - **New API marked deprecated** in KDoc or in the `.d.mts` → leave it out, as the existing comment on
     `ALLOWED_APIS` says.
   - **Removed API** → remove it from every list above and from any hand-written mention in `src/`.
   - **Renamed API or method** → treat as removed + new, and check `src/` for hard-coded names (search for the old
     name across `src/` and `test/`).

3. **Make `generate`, `build` and `test` pass.** After each edit round run, from `cardinal-mcp-server/`:

   ```bash
   yarn run generate && yarn run build && yarn test
   ```

   Typical breakage and where it lives:
   - `generate` fails or drops entries → a `.d.mts` shape changed; fix the regexes in `scripts/extract-docs.ts` or
     `scripts/generate-registry.ts`. Confirm by checking the count of APIs, models and filters the script prints
     against the previous run.
   - `build` fails → a type imported from `@icure/cardinal-sdk` in `src/` was renamed or removed; follow the new
     declaration.
   - `test` fails → `test/*.test.ts` assert on tool names, resource URIs and search results. Update the expectation
     only when the behaviour change is intended by the SDK change; otherwise fix the server.

4. **Patch `SDK.md` for removed or renamed APIs.** Search `SDK.md` for each removed or renamed API and method name.
   Update the TypeScript snippets and the prose around them so they match the new SDK. Do not rewrite sections that
   still apply, and do not reformat the file. `SDK.md` is stitched from the docs repository (`<!-- Source: ... -->`
   markers); keep those markers intact. Rerun `yarn run generate` after editing it.

5. **Update `cardinal-mcp-server/CLAUDE.md`** if you added or removed a tool, a resource or a helper, so the file
   stays an accurate map of the code.

6. **Write the PR description** to `PR_BODY_PATH`, in Markdown, with these sections:
   - A first line: `Syncs \`cardinal-mcp-server\` to SDK **<SDK_VERSION>** (previously <PREVIOUS_SDK_VERSION>).`
   - **API surface**: APIs added to or removed from the server, and APIs you deliberately left out (deprecated) with
     the reason.
   - **Fixes**: what broke in `generate`, `build` or `test` and what you changed.
   - **SDK.md**: sections you patched, or `No change needed.`
   - **Needs a human**: anything you could not resolve, or an empty section. Be specific: file, symbol, why.
   - A last line: `_Opened by the Update MCP server workflow._`

   Keep it factual and short. Reviewers read the diff; the body tells them where to look.

If you cannot make the three commands pass, still write the PR body with the **Needs a human** section filled in and
stop. The workflow's verification step fails the run and attaches your partial diff; nothing is lost.

## Running locally

To do a sync by hand, from the repository root:

```bash
./gradlew :ts-wrapper:prepareDistributionPackage
cd cardinal-mcp-server
corepack enable
yarn install
rm -rf node_modules/@icure/cardinal-sdk
cp -R ../ts-wrapper/build/tsPackage node_modules/@icure/cardinal-sdk
SDK_VERSION=$(grep -E '^val version = "' ../cardinal-sdk/build.gradle.kts | sed -E 's/.*"(.*)".*/\1/')
npm pkg set "version=$SDK_VERSION" "dependencies.@icure/cardinal-sdk=^$SDK_VERSION"
mkdir -p /tmp/mcp-sync && : > /tmp/mcp-sync/outcomes.txt
yarn run generate > /tmp/mcp-sync/generate.log 2>&1 || echo generate=failed >> /tmp/mcp-sync/outcomes.txt
yarn run build    > /tmp/mcp-sync/build.log    2>&1 || echo build=failed    >> /tmp/mcp-sync/outcomes.txt
yarn test         > /tmp/mcp-sync/test.log     2>&1 || echo test=failed     >> /tmp/mcp-sync/outcomes.txt
```

Then invoke `/mcp-sync SDK_VERSION=<v> PREVIOUS_SDK_VERSION=<v> SYNC_DIR=/tmp/mcp-sync PR_BODY_PATH=/tmp/mcp-sync/pr-body.md`
and follow the procedure above.

## Note on yarn.lock

The sync bumps `dependencies["@icure/cardinal-sdk"]` to a version that is not on npm yet, so `yarn install` cannot
refresh the lockfile entry for it. The committed `yarn.lock` therefore keeps the previous SDK resolution until the
next sync, and both workflows run a mutable `yarn install` followed by `.github/scripts/mcp-check-yarn-lock-drift.sh`,
which allows that single entry to move and fails on anything else. Do not try to fix this in a sync.
