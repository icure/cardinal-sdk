// Repository facts for the release rules, read with plain git commands.
import { execFileSync } from 'node:child_process';

export function git(cwd, args) {
	return execFileSync('git', args, { cwd, encoding: 'utf8', stdio: ['ignore', 'pipe', 'pipe'] }).trim();
}

const lines = (out) => (out ? out.split('\n') : []);

export const listTags = (cwd) => lines(git(cwd, ['tag', '--list']));

// `--no-renames`: a moved file counts under its old and its new path, so moving a file out of commonMain is still
// a change to commonMain.
export const changedFiles = (cwd, from, to) => lines(git(cwd, ['diff', '--name-only', '--no-renames', from, to]));

export const mergeBase = (cwd, a, b) => git(cwd, ['merge-base', a, b]);

// CI checkouts only have remote-tracking branches; local runs and tests have local ones.
export function resolveBranch(cwd, branch) {
	for (const ref of [`refs/remotes/origin/${branch}`, `refs/heads/${branch}`]) {
		try {
			git(cwd, ['rev-parse', '--verify', '--quiet', ref]);
			return ref;
		} catch {
			// Try the next candidate.
		}
	}
	return null;
}

export function isOnBranch(cwd, commit, branch) {
	const ref = resolveBranch(cwd, branch);
	if (!ref) return false;
	try {
		git(cwd, ['merge-base', '--is-ancestor', commit, ref]);
		return true;
	} catch {
		return false;
	}
}
