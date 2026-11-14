#!/usr/bin/env bash
# Stage 1: validates the inputs, resolves the codegen versions and credentials, downloads the tools and creates a
# clean worktree of the SDK. Writes everything the next stages need to <work-dir>/state.env.
#
# Options: see publish-preview.sh --help.
set -euo pipefail
. "$(dirname "${BASH_SOURCE[0]}")/lib.sh"

VERSION=""
KRAKEN_DIR=""
SDK_REF="origin/develop"
FLAVOUR="standard"
CODEGEN_VERSION=""
WRAPPER_CODEGEN_VERSION=""
REGISTRY="https://npm.icure.cloud"
DIST_TAG="preview"
WORK_DIR=""
ALLOW_SUBMODULE_DRIFT=false
SKIP_AUTH_CHECK=false
DRY_RUN=false

while [ $# -gt 0 ]; do
	case "$1" in
		--version) VERSION="$2"; shift 2 ;;
		--kraken-dir) KRAKEN_DIR="$2"; shift 2 ;;
		--sdk-ref) SDK_REF="$2"; shift 2 ;;
		--flavour) FLAVOUR="$2"; shift 2 ;;
		--codegen-version) CODEGEN_VERSION="$2"; shift 2 ;;
		--wrapper-codegen-version) WRAPPER_CODEGEN_VERSION="$2"; shift 2 ;;
		--registry) REGISTRY="${2%/}"; shift 2 ;;
		--dist-tag) DIST_TAG="$2"; shift 2 ;;
		--work-dir) WORK_DIR="$2"; shift 2 ;;
		--allow-submodule-drift) ALLOW_SUBMODULE_DRIFT=true; shift ;;
		--skip-auth-check) SKIP_AUTH_CHECK=true; shift ;;
		--dry-run) DRY_RUN=true; shift ;;
		*) die "unknown option $1 (see publish-preview.sh --help)" ;;
	esac
done

require_cmd git gh java node npm tsc rsync curl

# --- Inputs ---------------------------------------------------------------------------------------------------------

[ -n "$VERSION" ] || die "--version is required, e.g. --version 2.15.0-PREVIEW.$(date +%Y%m%d%H%M) (see the README for the numbering)"
is_preview_version "$VERSION" || die "$VERSION is not a preview version (X.Y.Z-PREVIEW.N)"
case "$FLAVOUR" in standard|legacy) ;; *) die "--flavour must be standard or legacy" ;; esac
[ "$DIST_TAG" != "latest" ] || die "a preview must never take the 'latest' dist-tag"

# The SDK repository is the one this script lives in; its main checkout holds local.properties.
SDK_REPO="$(cd "$(git -C "$PREVIEW_SCRIPTS_DIR" rev-parse --path-format=absolute --git-common-dir)/.." && pwd)"
KRAKEN_DIR="${KRAKEN_DIR:-$SDK_REPO/../kraken-cloud}"
[ -f "$KRAKEN_DIR/.github/workflows/generate.yml" ] || die "$KRAKEN_DIR is not a kraken-cloud checkout (use --kraken-dir)"
KRAKEN_DIR="$(cd "$KRAKEN_DIR" && pwd)"
WORK_DIR="${WORK_DIR:-$PREVIEW_CACHE_DIR/runs/$VERSION}"
ensure_private_dir "$WORK_DIR"
WORK_DIR="$(cd "$WORK_DIR" && pwd)"
log "Work directory: $WORK_DIR"

# --- kraken-cloud ---------------------------------------------------------------------------------------------------

# Submodules not at the commit recorded by kraken-cloud generate models that mix two versions of the code, or do not
# compile at all.
DRIFT="$(git -C "$KRAKEN_DIR" submodule status | grep -E '^[-+U]' || true)"
if [ -n "$DRIFT" ]; then
	if [ "$ALLOW_SUBMODULE_DRIFT" = true ]; then
		warn "kraken-cloud submodules are not at the recorded commits:"$'\n'"$DRIFT"
	else
		die "kraken-cloud submodules are not at the recorded commits (git submodule update --init, or --allow-submodule-drift):"$'\n'"$DRIFT"
	fi
fi
KRAKEN_SHA="$(git -C "$KRAKEN_DIR" rev-parse HEAD)"
KRAKEN_BRANCH="$(git -C "$KRAKEN_DIR" rev-parse --abbrev-ref HEAD)"
KRAKEN_DIRTY=false
[ -z "$(git -C "$KRAKEN_DIR" status --porcelain --ignore-submodules=none)" ] || KRAKEN_DIRTY=true
log "kraken-cloud: $KRAKEN_BRANCH at ${KRAKEN_SHA:0:10}$([ "$KRAKEN_DIRTY" = true ] && echo ' (with uncommitted changes)')"

# --- Codegen versions: the ones pinned by the workflows of the checkouts in use --------------------------------------

if [ -z "$CODEGEN_VERSION" ]; then
	CODEGEN_VERSION="$(workflow_env_value CODEGEN_VERSION < "$KRAKEN_DIR/.github/workflows/generate.yml")"
	[ -n "$CODEGEN_VERSION" ] || die "cannot read CODEGEN_VERSION from kraken-cloud generate.yml, use --codegen-version"
fi
log "Fetching $SDK_REF"
git_https -C "$SDK_REPO" fetch --quiet origin
SDK_SHA="$(git -C "$SDK_REPO" rev-parse --verify "$SDK_REF^{commit}")" || die "unknown SDK ref $SDK_REF"
if [ -z "$WRAPPER_CODEGEN_VERSION" ]; then
	WRAPPER_CODEGEN_VERSION="$(git -C "$SDK_REPO" show "$SDK_SHA:.github/workflows/generate_typescript.yml" | workflow_env_value SDK_CODEGEN_VERSION)"
	[ -n "$WRAPPER_CODEGEN_VERSION" ] || die "cannot read SDK_CODEGEN_VERSION from generate_typescript.yml at $SDK_REF, use --wrapper-codegen-version"
fi
MULTIPLATFORM_JAR="$(codegen_jar "$CODEGEN_VERSION" multiplatformsdk-codegen.jar)"
WRAPPER_JAR="$(codegen_jar "$WRAPPER_CODEGEN_VERSION" wrapper-codegen.jar)"
KTLINT="$(ktlint_bin)"
log "Codegen: models and APIs $CODEGEN_VERSION, TypeScript wrapper $WRAPPER_CODEGEN_VERSION"

# --- npm registry ---------------------------------------------------------------------------------------------------

# Credentials from the environment go to a private userconfig of the run, never to a file of the repository.
NPM_USERCONFIG=""
REGISTRY_HOST="${REGISTRY#*://}"
if [ -n "${ICURE_NPM_USERNAME:-}" ] && [ -n "${ICURE_NPM_PASSWORD:-}" ]; then
	NPM_USERCONFIG="$WORK_DIR/npmrc"
	check_own_file "$NPM_USERCONFIG"
	rm -f "$NPM_USERCONFIG"
	( umask 077; set -o noclobber
	  {
		  printf '//%s/:username=%s\n' "$REGISTRY_HOST" "$ICURE_NPM_USERNAME"
		  printf '//%s/:_password=%s\n' "$REGISTRY_HOST" "$(printf '%s' "$ICURE_NPM_PASSWORD" | base64)"
		  printf '//%s/:always-auth=true\n' "$REGISTRY_HOST"
	  } > "$NPM_USERCONFIG" )
	log "npm credentials for $REGISTRY_HOST taken from ICURE_NPM_USERNAME / ICURE_NPM_PASSWORD"
else
	log "ICURE_NPM_USERNAME / ICURE_NPM_PASSWORD not set: using the npm configuration of the user for $REGISTRY_HOST"
fi

if [ "$SKIP_AUTH_CHECK" = false ]; then
	if WHO="$(npm_registry whoami 2> /dev/null)"; then
		log "Authenticated on $REGISTRY as $WHO"
	elif [ "$DRY_RUN" = true ]; then
		warn "not authenticated on $REGISTRY: fine for a dry run, a real publication will fail"
	else
		die "not authenticated on $REGISTRY: set ICURE_NPM_USERNAME and ICURE_NPM_PASSWORD (or --skip-auth-check)"
	fi
fi

# The-forge publishes official previews (X.Y.Z-PREVIEW.N) of the same package on the same registry: a version taken
# here would make the official publication fail later, and a published version can never be reused.
if EXISTING="$(npm_registry view "$NPM_PACKAGE@$VERSION" version 2> /dev/null)" && [ -n "$EXISTING" ]; then
	die "$NPM_PACKAGE@$VERSION already exists on $REGISTRY"
fi

# --- SDK worktree ---------------------------------------------------------------------------------------------------

SDK_DIR="$WORK_DIR/sdk"
if [ -d "$SDK_DIR" ]; then
	# A previous run of the same work directory: its stages committed on top of $SDK_SHA.
	git -C "$SDK_DIR" merge-base --is-ancestor "$SDK_SHA" HEAD 2> /dev/null \
		|| die "$SDK_DIR exists but is not based on $SDK_REF ($SDK_SHA): remove it with cleanup.sh or use another --work-dir"
	[ -z "$(git -C "$SDK_DIR" status --porcelain)" ] \
		|| warn "$SDK_DIR has leftovers of an interrupted stage: the stage that owns them resets them when it runs again"
	log "Reusing the SDK worktree $SDK_DIR ($(git -C "$SDK_DIR" rev-list --count "$SDK_SHA..HEAD") generated commits)"
else
	log "Creating an SDK worktree at $SDK_REF ($(git -C "$SDK_REPO" log -1 --format='%h %s' "$SDK_SHA"))"
	git -C "$SDK_REPO" worktree add --quiet --detach "$SDK_DIR" "$SDK_SHA"
fi
git_https -C "$SDK_DIR" submodule update --quiet --init --recursive

# Private Gradle dependencies (icure/charix) need GitHub credentials, read from local.properties by the builds.
if [ ! -f "$SDK_DIR/local.properties" ]; then
	[ -f "$SDK_REPO/local.properties" ] || die "$SDK_REPO/local.properties is missing (needs githubUsername and githubPassword)"
	cp "$SDK_REPO/local.properties" "$SDK_DIR/local.properties"
fi
grep -q '^githubUsername=' "$SDK_DIR/local.properties" || die "$SDK_DIR/local.properties has no githubUsername"
if [ ! -f "$SDK_DIR/ksp-json-processor/local.properties" ]; then
	grep -E '^github(Username|Password)=' "$SDK_DIR/local.properties" > "$SDK_DIR/ksp-json-processor/local.properties"
fi

save_state
log "Prepared $NPM_PACKAGE@$VERSION ($FLAVOUR flavour) in $WORK_DIR"
