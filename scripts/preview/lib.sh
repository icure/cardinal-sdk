# Shared helpers of the preview publication scripts. Sourced, not executed.
# Compatible with the bash 3.2 shipped with macOS: no associative arrays, no ${var,,}, no mapfile.

PREVIEW_SCRIPTS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PREVIEW_CACHE_DIR="${CARDINAL_PREVIEW_CACHE:-$HOME/.cache/cardinal-preview}"
NPM_PACKAGE="@icure/cardinal-sdk"
KTLINT_VERSION="1.2.1"

log() { printf '\033[1;34m==>\033[0m %s\n' "$*" >&2; }
warn() { printf '\033[1;33mwarning:\033[0m %s\n' "$*" >&2; }
die() { printf '\033[1;31merror:\033[0m %s\n' "$*" >&2; exit 1; }

require_cmd() {
	local cmd
	for cmd in "$@"; do
		command -v "$cmd" > /dev/null 2>&1 || die "'$cmd' is required but was not found in PATH"
	done
}

# A preview version, as accepted by buildSrc/src/main/kotlin/ReleaseVersion.kt (restricted to previews).
is_preview_version() {
	[[ "$1" =~ ^(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)-PREVIEW\.[1-9][0-9]*$ ]]
}

# Git with ssh GitHub URLs rewritten to https: the ksp-json-processor submodule uses an ssh URL, which does not work
# everywhere (hardware-backed ssh keys, CI-like shells). Credentials then come from the git credential helper / gh.
git_https() {
	GIT_CONFIG_COUNT=1 GIT_CONFIG_KEY_0="url.https://github.com/.insteadOf" GIT_CONFIG_VALUE_0="git@github.com:" git "$@"
}

# Reads `KEY: value` (optionally quoted) from a workflow file content on stdin.
workflow_env_value() {
	grep -E "^[[:space:]]*$1:" | head -1 | sed -E "s/^[^:]*:[[:space:]]*['\"]?([^'\" ]+)['\"]?.*$/\1/"
}

# Downloads a jar attached to an icure/sdk-codegen release into the cache, prints its path.
codegen_jar() {
	local version="$1" jar="$2"
	local dir="$PREVIEW_CACHE_DIR/codegen/$version"
	if [ ! -s "$dir/$jar" ]; then
		gh release view "$version" --repo icure/sdk-codegen --json assets --jq '.assets[].name' | grep -qx "$jar" \
			|| die "$jar is not attached to the icure/sdk-codegen release $version"
		mkdir -p "$dir"
		log "Downloading $jar from icure/sdk-codegen $version"
		gh release download "$version" --repo icure/sdk-codegen --pattern "$jar" --output "$dir/$jar.part" --clobber
		mv "$dir/$jar.part" "$dir/$jar"
	fi
	printf '%s\n' "$dir/$jar"
}

ktlint_bin() {
	local bin="$PREVIEW_CACHE_DIR/ktlint/$KTLINT_VERSION/ktlint"
	if [ ! -x "$bin" ]; then
		mkdir -p "$(dirname "$bin")"
		log "Downloading ktlint $KTLINT_VERSION"
		curl -fsSL -o "$bin.part" "https://github.com/pinterest/ktlint/releases/download/$KTLINT_VERSION/ktlint"
		chmod a+x "$bin.part"
		mv "$bin.part" "$bin"
	fi
	printf '%s\n' "$bin"
}

# The work directory holds the npm credentials of the run and the state the stages read: it must be private to the
# user. Refuses a symlink or a directory owned by someone else, and makes it mode 700.
ensure_private_dir() {
	local dir="$1"
	[ ! -L "$dir" ] || die "$dir is a symlink: refusing to use it"
	( umask 077; mkdir -p "$dir" )
	[ -O "$dir" ] || die "$dir is not owned by $(id -un): refusing to use it"
	chmod 700 "$dir"
}

# A regular file of the user, not a symlink (for the files of the work directory that are read back).
check_own_file() {
	[ ! -L "$1" ] || die "$1 is a symlink: refusing to use it"
	[ ! -e "$1" ] || [ -O "$1" ] || die "$1 is not owned by $(id -un): refusing to use it"
}

STATE_KEYS="VERSION KRAKEN_DIR KRAKEN_SHA KRAKEN_BRANCH KRAKEN_DIRTY SDK_REPO SDK_REF SDK_SHA SDK_DIR FLAVOUR \
CODEGEN_VERSION WRAPPER_CODEGEN_VERSION MULTIPLATFORM_JAR WRAPPER_JAR KTLINT REGISTRY DIST_TAG NPM_USERCONFIG DRY_RUN"

# The state of a run is kept in $WORK_DIR/state.env so that each stage can be (re)run on its own. Plain KEY=value
# lines, read back by load_state without being executed.
save_state() {
	local file="$WORK_DIR/state.env" tmp name value
	check_own_file "$file"
	tmp="$(mktemp "$WORK_DIR/.state.XXXXXX")"
	for name in $STATE_KEYS; do
		value="${!name}"
		case "$value" in *$'\n'*) die "$name contains a newline" ;; esac
		printf '%s=%s\n' "$name" "$value" >> "$tmp"
	done
	mv -f "$tmp" "$file"
}

load_state() {
	local key value
	WORK_DIR="${1:-}"
	[ -n "$WORK_DIR" ] || die "usage: $(basename "$0") <work-dir>"
	[ -f "$WORK_DIR/state.env" ] || die "$WORK_DIR/state.env not found: run the prepare stage first"
	WORK_DIR="$(cd "$WORK_DIR" && pwd)"
	[ -O "$WORK_DIR" ] || die "$WORK_DIR is not owned by $(id -un): refusing to use it"
	check_own_file "$WORK_DIR/state.env"
	while IFS='=' read -r key value; do
		case " $STATE_KEYS " in
			*" $key "*) printf -v "$key" '%s' "$value" ;;
			*) die "unexpected key '$key' in $WORK_DIR/state.env" ;;
		esac
	done < "$WORK_DIR/state.env"
}

# Discards the uncommitted changes an interrupted stage left in some paths of the SDK worktree (each stage commits its
# output, so the last commit is the state of the previous stage).
reset_sdk_paths() {
	local path
	for path in "$@"; do
		git -C "$SDK_DIR" checkout --quiet HEAD -- "$path"
		git -C "$SDK_DIR" clean --quiet -fd -- "$path"
	done
}

# Runs npm with the registry credentials of this run, without touching the user's ~/.npmrc.
npm_registry() {
	if [ -n "${NPM_USERCONFIG:-}" ]; then
		npm --userconfig "$NPM_USERCONFIG" --registry "$REGISTRY" "$@"
	else
		npm --registry "$REGISTRY" "$@"
	fi
}
