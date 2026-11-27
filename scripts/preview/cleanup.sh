#!/usr/bin/env bash
# Removes the work directory of a preview run, including its SDK git worktree and the npm credentials file.
# The cached codegen jars and ktlint ($HOME/.cache/cardinal-preview) are kept.
#
# Usage: cleanup.sh <work-dir>
set -euo pipefail
. "$(dirname "${BASH_SOURCE[0]}")/lib.sh"
load_state "${1:-}"

if [ -d "$SDK_DIR" ]; then
	log "Removing the SDK worktree $SDK_DIR"
	git -C "$SDK_REPO" worktree remove --force "$SDK_DIR"
fi
log "Removing $WORK_DIR"
rm -rf "$WORK_DIR"
