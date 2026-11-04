#!/usr/bin/env bash
# Prints the release tags the-forge has accepted, one `cardinal-sdk-<tag>` per line. A release is accepted once
# release.yml has pushed its forge tag. Needs FORGE_TOKEN: a token that can read icure/the-forge (private).
set -euo pipefail

# actions/checkout persists its token as an http.extraheader for github.com, which git sends instead of the
# credentials in the URL. With the default GITHUB_TOKEN, the-forge is then "not found": clear the header.
git -c http.https://github.com/.extraheader= ls-remote --tags "https://x-access-token:${FORGE_TOKEN:?FORGE_TOKEN is required}@github.com/icure/the-forge.git" \
	'refs/tags/cardinal-sdk-*' \
	| awk '{ print $2 }' \
	| sed -e 's#^refs/tags/##' -e 's#\^{}$##' \
	| sort -u
