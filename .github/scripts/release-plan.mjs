#!/usr/bin/env node
// Validates a release PR (`pr`) or the release tags of a merged commit (`tag`) and prints the release plan as JSON.
// Used by release-check.yml, release.yml and the-forge's release-cardinal-sdk.yml, see RELEASING.md.
// `version` prints the version a release title ships for one unit, or nothing: the test workflows build with it.
import { appendFileSync, readFileSync } from 'node:fs';
import { parseArgs } from 'node:util';
import * as repoFacts from './release-plan/git.mjs';
import {
	parseAccepted, parseTitle, releaseVersionFor, renderSummary, validatePr, validateTag,
} from './release-plan/rules.mjs';
import { UNITS } from './release-plan/version.mjs';

const USAGE = `usage:
  release-plan.mjs pr  --title <title> --base-ref <branch> --head-ref <branch> --head-sha <sha>
                       --accepted-file <file> [--repo <dir>] [--summary-file <file>]
  release-plan.mjs tag (--title <title> | --tag <tag> [--tag <tag>…]) --commit <sha>
                       --accepted-file <file> [--dry-run] [--repo <dir>] [--summary-file <file>]
  release-plan.mjs version --title <title> --unit <kotlin|ts|python>`;

const OPTIONS = {
	title: { type: 'string' },
	'base-ref': { type: 'string' },
	'head-ref': { type: 'string' },
	'head-sha': { type: 'string' },
	tag: { type: 'string', multiple: true },
	commit: { type: 'string' },
	'dry-run': { type: 'boolean', default: false },
	'accepted-file': { type: 'string' },
	repo: { type: 'string', default: '.' },
	'summary-file': { type: 'string' },
	unit: { type: 'string' },
};

function usage(message) {
	if (message) console.error(`error: ${message}`);
	console.error(USAGE);
	return 2;
}

function planPr(values, acceptedNames) {
	const { repo } = values;
	const base = repoFacts.resolveBranch(repo, values['base-ref']);
	if (!base) return usage(`unknown base branch ${values['base-ref']}`);
	return validatePr({
		title: values.title,
		baseRef: values['base-ref'],
		headRef: values['head-ref'],
		accepted: parseAccepted(acceptedNames),
		existingTags: repoFacts.listTags(repo),
		changedFiles: repoFacts.changedFiles(repo, repoFacts.mergeBase(repo, base, values['head-sha']), values['head-sha']),
	});
}

function planTag(values, acceptedNames) {
	const { repo, commit } = values;
	const tags = values.tag ?? parseTitle(values.title) ?? [];
	return validateTag({
		tags,
		accepted: parseAccepted(acceptedNames, tags),
		isOnBranch: (branch) => repoFacts.isOnBranch(repo, commit, branch),
		changedFiles: repoFacts.changedFiles(repo, `${commit}^1`, commit),
		dryRun: values['dry-run'],
	});
}

function main(argv) {
	const [mode, ...args] = argv;
	let values;
	try {
		({ values } = parseArgs({ args, options: OPTIONS }));
	} catch (e) {
		return usage(e.message);
	}
	if (mode === 'version') {
		if (values.title === undefined || !UNITS.includes(values.unit)) return usage();
		const version = releaseVersionFor(values.title, values.unit);
		if (version) process.stdout.write(`${version}\n`);
		return 0;
	}
	if (!values['accepted-file']) return usage('--accepted-file is required');
	const acceptedNames = readFileSync(values['accepted-file'], 'utf8').split('\n');

	let res;
	if (mode === 'pr' && values.title !== undefined && values['base-ref'] && values['head-ref'] && values['head-sha']) {
		res = planPr(values, acceptedNames);
	} else if (mode === 'tag' && (values.tag || values.title !== undefined) && values.commit) {
		res = planTag(values, acceptedNames);
	} else {
		return usage();
	}
	if (typeof res === 'number') return res;

	process.stdout.write(`${JSON.stringify(res, null, 2)}\n`);
	if (values['summary-file']) appendFileSync(values['summary-file'], renderSummary(res));
	for (const v of res.violations) console.error(`::error::${v.rule} ${v.message}`);
	for (const w of res.warnings) console.error(`::warning::${w.rule} ${w.message}`);
	return res.ok ? 0 : 1;
}

process.exitCode = main(process.argv.slice(2));
