#!/usr/bin/env bash
# Prints the release tags the-forge has accepted, one `cardinal-sdk-<tag>` per line. A release is accepted once
# release.yml has pushed its forge tag. Needs FORGE_TOKEN: a token that can read icure/the-forge (private).
set -euo pipefail

git ls-remote --tags "https://x-access-token:${FORGE_TOKEN:?FORGE_TOKEN is required}@github.com/icure/the-forge.git" \
	'refs/tags/cardinal-sdk-*' \
	| awk '{ print $2 }' \
	| sed -e 's#^refs/tags/##' -e 's#\^{}$##' \
	| sort -u
