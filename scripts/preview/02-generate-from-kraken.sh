#!/usr/bin/env bash
# Stage 2: generates the models, raw APIs and filter serializer from kraken-cloud and merges them into the SDK worktree.
#
# standard flavour: the steps of kraken-cloud .github/workflows/generate.yml (models, raw APIs, AbstractFilterSerializer)
# legacy flavour:   the steps of the-forge .github/actions/legacy-codegen (models only, deprecated fields kept): what
#                   the-forge publishes on npm.icure.cloud for a release
# v3 flavour:       the steps of sdk-codegen local-generate-sdk.sh, for the Cardinal 3 SDK branches (custom entities):
#                   standard plus the entity encryptors, deprecated fields kept, --custom-entities-support
#
# The kraken-cloud checkout is only built: the KSP JSON is copied to the work directory and everything is generated
# there. The working tree of kraken-cloud, including uncommitted changes, is what gets generated.
#
# Usage: 02-generate-from-kraken.sh <work-dir>
set -euo pipefail
. "$(dirname "${BASH_SOURCE[0]}")/lib.sh"
load_state "${1:-}"

reset_sdk_paths cardinal-sdk/src/commonMain

# --- KSP JSON of kraken-cloud ---------------------------------------------------------------------------------------

# --rerun on each KSP task: the JSON must reflect the current sources even when Gradle thinks the task is up to date.
log "Generating the JSON representation of kraken-cloud (KSP)"
( cd "$KRAKEN_DIR" && ./gradlew \
	:kraken-common:dto:kspKotlin --rerun \
	:kraken-common:core:kspKotlin --rerun \
	:cloud-core:kspKotlin --rerun \
	-x :kraken-common:mapper:kspKotlin -x :cloud-mapper:kspKotlin \
	--no-build-cache -PrepoUsername= -PrepoPassword= )

JSON="$WORK_DIR/json"
GEN="$WORK_DIR/generated"
rm -rf "$JSON" "$GEN"
mkdir -p "$JSON/dto" "$JSON/common-api" "$JSON/cloud-api" "$GEN"
rsync -a "$KRAKEN_DIR/kraken-common/dto/build/generated/ksp/main/resources/" "$JSON/dto/"
rsync -a "$KRAKEN_DIR/kraken-common/core/build/generated/ksp/main/resources/" "$JSON/common-api/"
rsync -a "$KRAKEN_DIR/cloud-core/build/generated/ksp/main/resources/" "$JSON/cloud-api/"

EDITORCONFIG="$KRAKEN_DIR/ci/.editorConfig"
COMMON_MAIN="$SDK_DIR/cardinal-sdk/src/commonMain"
codegen() { java -jar "$MULTIPLATFORM_JAR" "$@"; }
# ktlint takes its argument as a glob: an absolute path below a hidden directory (the default work directory is under
# ~/.cache) makes it walk the whole home directory. Pass a relative path, as CI does.
lint() { (cd "$(dirname "$1")" && "$KTLINT" -F "$(basename "$1")" --editorconfig="$EDITORCONFIG"); }

# The generator writes its output in a `com` directory next to its input: remove it between the passes.
GEN_OPTS=()
[ "$FLAVOUR" = v3 ] && GEN_OPTS=(--exclude-deprecated=false --custom-entities-support)
if [ "$FLAVOUR" = standard ] || [ "$FLAVOUR" = v3 ]; then
	log "Generating the AbstractFilterSerializer"
	rm -rf "$JSON/dto/com"
	codegen generate --serializer ${GEN_OPTS[@]+"${GEN_OPTS[@]}"} --input="$JSON/dto"
	mkdir -p "$GEN/filters/kotlin"
	mv "$JSON/dto/com" "$GEN/filters/kotlin/"
	lint "$GEN/filters"

	if [ "$FLAVOUR" = v3 ]; then
		log "Generating the entity encryptors and decryptors"
		rm -rf "$JSON/dto/com"
		codegen generate --encryptor ${GEN_OPTS[@]+"${GEN_OPTS[@]}"} --input="$JSON/dto"
		mkdir -p "$GEN/encryptors/kotlin"
		mv "$JSON/dto/com" "$GEN/encryptors/kotlin/"
		lint "$GEN/encryptors"
	fi

	log "Generating the models"
	rm -rf "$JSON/dto/com"
	codegen generate --dto ${GEN_OPTS[@]+"${GEN_OPTS[@]}"} --input="$JSON/dto"
	codegen process --dto --input="$JSON/dto/com/icure/cardinal/sdk/model" --output="$GEN/dto/main/kotlin/com/icure/cardinal/sdk/model"
	lint "$GEN/dto"

	log "Generating the raw APIs"
	rm -rf "$JSON/dto/com"
	codegen generate --sdk ${GEN_OPTS[@]+"${GEN_OPTS[@]}"} --input="$JSON/common-api" --input="$JSON/cloud-api" --context="$JSON/dto"
	codegen merge --sdk --dst="$JSON/cloud-api/com/icure/cardinal/sdk/api/raw" --src="$JSON/common-api/com/icure/cardinal/sdk/api/raw"
	mkdir -p "$GEN/api/kotlin"
	mv "$JSON/cloud-api/com" "$GEN/api/kotlin/"
	lint "$GEN/api"

	log "Merging into the SDK ($SDK_REF)"
	codegen merge --dto --dst="$GEN/dto/main" --src="$COMMON_MAIN/"
	rsync -a "$GEN/dto/main/" "$COMMON_MAIN/"
	rsync -a "$GEN/api/" "$COMMON_MAIN/"
	rsync -a "$GEN/filters/" "$COMMON_MAIN/"
	if [ "$FLAVOUR" = v3 ]; then rsync -a "$GEN/encryptors/" "$COMMON_MAIN/"; fi
else
	log "Generating the models with their deprecated fields (legacy flavour)"
	rm -rf "$JSON/dto/com"
	codegen generate --dto --exclude-deprecated=false --input="$JSON/dto"
	codegen process --dto --input="$JSON/dto/com/icure/cardinal/sdk/model" --output="$GEN/dto/main/kotlin/com/icure/cardinal/sdk/model"
	lint "$GEN/dto"
	grep -q picture "$GEN/dto/main/kotlin/com/icure/cardinal/sdk/model/Patient.kt" \
		|| die "the deprecated field 'picture' is missing from the generated Patient.kt: --exclude-deprecated=false did not apply"

	log "Merging the models into the SDK ($SDK_REF)"
	codegen merge --dto --dst="$GEN/dto/main" --src="$COMMON_MAIN/"
	rsync -a "$GEN/dto/main/kotlin/com/icure/cardinal/sdk/model/" "$COMMON_MAIN/kotlin/com/icure/cardinal/sdk/model/"
fi

# A local commit (never pushed) records what was generated: `git -C <work-dir>/sdk show --stat` to review it.
# Only the generated paths: the worktree also holds local.properties, with credentials.
git -C "$SDK_DIR" add -A -- cardinal-sdk/src/commonMain
if git -C "$SDK_DIR" diff --cached --quiet; then
	warn "kraken-cloud generated no change to the SDK at $SDK_REF"
else
	git -C "$SDK_DIR" -c user.name="cardinal-preview" -c user.email="dev@icure.com" -c commit.gpgsign=false \
		commit --quiet -m "Preview $VERSION: models and APIs from kraken-cloud ${KRAKEN_SHA:0:10}$([ "$KRAKEN_DIRTY" = true ] && echo ' + uncommitted changes')"
	git -C "$SDK_DIR" show --stat --format='%s' HEAD | tail -1 >&2
fi
log "Generated from kraken-cloud $KRAKEN_BRANCH (${KRAKEN_SHA:0:10})"
