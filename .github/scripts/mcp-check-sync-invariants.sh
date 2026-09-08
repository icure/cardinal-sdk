#!/usr/bin/env bash
# Run from cardinal-mcp-server/ after the sync agent has finished: mcp-check-sync-invariants.sh <sdk-version>
#
# The agent may edit anything inside cardinal-mcp-server/ except the dependency set and the Yarn setup: the version
# lines are fixed by the workflow, the lockfile by `yarn install`. This check is what makes the "edit-only, no package
# manager" boundary of .claude/skills/mcp-sync/SKILL.md enforceable.
set -euo pipefail

SDK_VERSION="${1:?usage: $0 <sdk-version>}"

# yarn.lock may differ from the committed one for the @icure/cardinal-sdk entry only (install-time lag), nothing else.
"$(dirname "$0")/mcp-check-yarn-lock-drift.sh" --lockfile-only

if ! git diff --quiet HEAD -- .yarnrc.yml; then
	echo "::error::.yarnrc.yml changed during the sync."
	exit 1
fi

node - "$SDK_VERSION" <<'JS'
const fs = require("fs");
const { execSync } = require("child_process");
const version = process.argv[2];
const before = JSON.parse(execSync("git show HEAD:./package.json", { encoding: "utf8" }));
const after = JSON.parse(fs.readFileSync("package.json", "utf8"));
const fail = (message) => { console.error(`::error::${message}`); process.exit(1); };

if (after.version !== version) fail(`package.json version is ${after.version}, expected ${version}.`);
if (after.dependencies?.["@icure/cardinal-sdk"] !== `^${version}`) {
	fail(`package.json must depend on @icure/cardinal-sdk ^${version}, found ${after.dependencies?.["@icure/cardinal-sdk"]}.`);
}
before.dependencies["@icure/cardinal-sdk"] = after.dependencies["@icure/cardinal-sdk"];
for (const field of ["dependencies", "devDependencies", "peerDependencies", "packageManager"]) {
	if (JSON.stringify(before[field]) !== JSON.stringify(after[field])) fail(`package.json ${field} changed during the sync.`);
}
console.log(`package.json at ${version}, dependencies unchanged, .yarnrc.yml untouched.`);
JS
