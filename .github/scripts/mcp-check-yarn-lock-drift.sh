#!/usr/bin/env bash
# Run from cardinal-mcp-server/ after a (mutable) `yarn install`.
#
# yarn.lock is allowed to lag package.json for exactly one entry: @icure/cardinal-sdk. The sync PR bumps the
# dependency to an SDK version that is not on npm yet, so the lockfile cannot be refreshed until the SDK is
# published. Any other difference between the committed lockfile and what `yarn install` resolved means the
# lockfile was out of date when it was committed, and the run stops here.
set -euo pipefail

# Working tree against the index: what `yarn install` itself changed.
CHANGED=$(git diff --name-only -- .)
if [ -z "$CHANGED" ]; then
	echo "yarn.lock is up to date."
	exit 0
fi

UNEXPECTED_FILES=$(echo "$CHANGED" | grep -vE '(^|/)yarn\.lock$' || true)
if [ -n "$UNEXPECTED_FILES" ]; then
	echo "::error::yarn install changed tracked files other than yarn.lock:"
	echo "$UNEXPECTED_FILES"
	exit 1
fi

LOCK_DIFF=$(git diff -U0 -- yarn.lock)
# Entry headers (`"pkg@npm:range":`) that were added or removed must all belong to @icure/cardinal-sdk...
FOREIGN_HEADERS=$(echo "$LOCK_DIFF" | grep -E '^[+-]"' | grep -vE '^[+-]"@icure/cardinal-sdk@' || true)
# ...and so must every changed `resolution:` line.
FOREIGN_RESOLUTIONS=$(echo "$LOCK_DIFF" | grep -E '^[+-][[:space:]]+resolution:' | grep -v '@icure/cardinal-sdk@' || true)
if [ -n "$FOREIGN_HEADERS" ] || [ -n "$FOREIGN_RESOLUTIONS" ]; then
	echo "::error::yarn.lock drifted beyond the @icure/cardinal-sdk entry. Run 'yarn install' locally and commit yarn.lock."
	echo "$FOREIGN_HEADERS"
	echo "$FOREIGN_RESOLUTIONS"
	exit 1
fi

echo "yarn.lock only moved the @icure/cardinal-sdk entry (expected after a sync PR):"
echo "$LOCK_DIFF" | grep -E '^[+-]' | grep -vE '^(\+\+\+|---)' || true
