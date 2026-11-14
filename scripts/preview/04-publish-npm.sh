#!/usr/bin/env bash
# Stage 4: publishes the npm package built by stage 3 on the registry, with the preview dist-tag.
# Mirrors the publication step of the-forge (npm install for the lock, npm ci, build, publish).
#
# A published version can never be published again, even after it is unpublished: asks for a confirmation unless
# --yes is given.
#
# Usage: 04-publish-npm.sh <work-dir> [--yes] [--dry-run]
set -euo pipefail
. "$(dirname "${BASH_SOURCE[0]}")/lib.sh"
load_state "${1:-}"
shift
YES=false
# Only the options of this stage decide: a run prepared with --dry-run can then be published with --from publish.
DRY_RUN=false
while [ $# -gt 0 ]; do
	case "$1" in
		--yes) YES=true; shift ;;
		--dry-run) DRY_RUN=true; shift ;;
		*) die "unknown option $1" ;;
	esac
done

TS_PACKAGE="$SDK_DIR/ts-wrapper/build/tsPackage"
[ -f "$TS_PACKAGE/package.json" ] || die "no package in $TS_PACKAGE: run the ts stage first"
cd "$TS_PACKAGE"

# The dependencies come from the usual registry of the user: only the publication targets $REGISTRY.
log "Installing the dependencies of the package"
npm install --no-audit --no-fund
npm ci --no-audit --no-fund
npm run build --if-present

if [ "$DRY_RUN" = true ]; then
	log "Dry run: npm publish --dry-run on $REGISTRY with dist-tag $DIST_TAG"
	npm_registry publish --tag "$DIST_TAG" --dry-run
	log "Dry run done, nothing was published"
	exit 0
fi

if EXISTING="$(npm_registry view "$NPM_PACKAGE@$VERSION" version 2> /dev/null)" && [ -n "$EXISTING" ]; then
	die "$NPM_PACKAGE@$VERSION already exists on $REGISTRY"
fi

if [ "$YES" = false ]; then
	[ -t 0 ] || die "not a terminal: pass --yes to publish without a confirmation"
	printf 'Publish %s@%s on %s with dist-tag %s?\n  SDK %s (%s), kraken-cloud %s (%s)%s\nType the version to confirm: ' \
		"$NPM_PACKAGE" "$VERSION" "$REGISTRY" "$DIST_TAG" "$SDK_REF" "${SDK_SHA:0:10}" "$KRAKEN_BRANCH" "${KRAKEN_SHA:0:10}" \
		"$([ "$KRAKEN_DIRTY" = true ] && echo ' + uncommitted changes')" >&2
	read -r ANSWER
	[ "$ANSWER" = "$VERSION" ] || die "not confirmed, nothing was published"
fi

log "Publishing $NPM_PACKAGE@$VERSION on $REGISTRY (dist-tag $DIST_TAG)"
npm_registry publish --tag "$DIST_TAG"

PUBLISHED="$(npm_registry view "$NPM_PACKAGE@$VERSION" version 2> /dev/null || true)"
[ "$PUBLISHED" = "$VERSION" ] || warn "the registry does not show $NPM_PACKAGE@$VERSION yet"
log "Published. Install it with: npm install $NPM_PACKAGE@$VERSION --registry $REGISTRY"
