#!/usr/bin/env bash
# Builds a preview of the Cardinal SDK from a local kraken-cloud checkout and publishes its TypeScript package on
# npm.icure.cloud. Runs locally, in one go, the chain that CI spreads over several workflows and pull requests:
#
#   1. prepare   checks, codegen versions, credentials, clean SDK worktree       (01-prepare.sh)
#   2. kraken    kraken-cloud KSP JSON -> models / raw APIs / filter serializer  (02-generate-from-kraken.sh)
#                merged into the SDK, as kraken-cloud generate.yml does
#   3. ts        TypeScript wrapper + npm package, as generate_typescript.yml    (03-build-ts-package.sh)
#                and the-forge do
#   4. publish   npm publish --tag preview on npm.icure.cloud                    (04-publish-npm.sh)
#
# See scripts/preview/README.md.
set -euo pipefail
. "$(dirname "${BASH_SOURCE[0]}")/lib.sh"

usage() {
	cat <<'EOF'
Usage: scripts/preview/publish-preview.sh --version X.Y.Z-PREVIEW.N [options]

Required:
  --version V                  Preview version to publish, e.g. 2.15.0-PREVIEW.202611141030

Sources:
  --kraken-dir PATH            kraken-cloud checkout to generate from, uncommitted changes included
                               (default: ../kraken-cloud next to the main checkout of this repository)
  --sdk-ref REF                SDK commit the generated code is merged into (default: origin/develop)
  --flavour standard|legacy    standard: models, raw APIs and filter serializer (kraken-cloud generate.yml);
                               legacy: models only, deprecated fields kept (what the-forge publishes on
                               npm.icure.cloud for a release) (default: standard)
  --codegen-version V          icure/sdk-codegen release for models and APIs
                               (default: CODEGEN_VERSION of kraken-cloud generate.yml)
  --wrapper-codegen-version V  icure/sdk-codegen release for the TypeScript wrapper
                               (default: SDK_CODEGEN_VERSION of generate_typescript.yml at --sdk-ref)
  --allow-submodule-drift      Accept kraken-cloud submodules that are not at their recorded commits

Publication:
  --registry URL               npm registry (default: https://npm.icure.cloud)
  --dist-tag TAG               npm dist-tag (default: preview; latest is refused)
  --dry-run                    Build everything, run npm publish --dry-run
  --yes                        Publish without asking for a confirmation
  --skip-auth-check            Do not check the registry credentials before building

Runs:
  --work-dir DIR               Work directory, private to the user (default: ~/.cache/cardinal-preview/runs/<version>)
  --from STAGE                 Resume a run at kraken, ts or publish. Pass the same --version and --work-dir; the
                               prepare stage always runs again (cheap), so other options such as the codegen
                               versions can be changed

Credentials: ICURE_NPM_USERNAME and ICURE_NPM_PASSWORD (else the npm configuration of the user), gh logged in
(codegen jars), githubUsername/githubPassword in local.properties (private Gradle dependencies).
EOF
}

FROM="prepare"
YES=false
VERSION=""
WORK_DIR=""
DRY_RUN=false
PREPARE_ARGS=()
while [ $# -gt 0 ]; do
	case "$1" in
		-h|--help) usage; exit 0 ;;
		--from) FROM="$2"; shift 2 ;;
		--yes) YES=true; shift ;;
		--dry-run) DRY_RUN=true; PREPARE_ARGS+=("$1"); shift ;;
		--version) VERSION="$2"; PREPARE_ARGS+=("$1" "$2"); shift 2 ;;
		--work-dir) WORK_DIR="$2"; PREPARE_ARGS+=("$1" "$2"); shift 2 ;;
		--allow-submodule-drift|--skip-auth-check) PREPARE_ARGS+=("$1"); shift ;;
		--kraken-dir|--sdk-ref|--flavour|--codegen-version|--wrapper-codegen-version|--registry|--dist-tag)
			[ $# -ge 2 ] || die "$1 needs a value"
			PREPARE_ARGS+=("$1" "$2"); shift 2 ;;
		*) usage >&2; die "unknown option $1" ;;
	esac
done

case "$FROM" in
	prepare) START=1 ;; kraken) START=2 ;; ts) START=3 ;; publish) START=4 ;;
	*) die "--from must be prepare, kraken, ts or publish" ;;
esac
[ -n "$VERSION" ] || { usage >&2; die "--version is required"; }
WORK_DIR="${WORK_DIR:-$PREVIEW_CACHE_DIR/runs/$VERSION}"

PUBLISH_ARGS=()
[ "$YES" = false ] || PUBLISH_ARGS+=(--yes)
[ "$DRY_RUN" = false ] || PUBLISH_ARGS+=(--dry-run)

SECONDS=0
"$PREVIEW_SCRIPTS_DIR/01-prepare.sh" "${PREPARE_ARGS[@]}"
[ "$START" -gt 2 ] || "$PREVIEW_SCRIPTS_DIR/02-generate-from-kraken.sh" "$WORK_DIR"
[ "$START" -gt 3 ] || "$PREVIEW_SCRIPTS_DIR/03-build-ts-package.sh" "$WORK_DIR"
"$PREVIEW_SCRIPTS_DIR/04-publish-npm.sh" "$WORK_DIR" ${PUBLISH_ARGS[@]+"${PUBLISH_ARGS[@]}"}
log "Done in $((SECONDS / 60))m$((SECONDS % 60))s. Remove the work directory with: scripts/preview/cleanup.sh $WORK_DIR"
