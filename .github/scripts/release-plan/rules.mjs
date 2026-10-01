// Release rules R1–R10 of the per-unit release scheme, see RELEASING.md. Pure functions: the caller gathers the
// repository facts (tags, branches, changed files) and passes them in.
import { affectedUnits, unitsForPath } from './paths.mjs';
import {
	compareVersions, decadeBase, isFull, isGrandfathered, parseTag, UNIT_NAMES, UNITS, unitsOf,
} from './version.mjs';

const violation = (rule, message) => ({ rule, message });

const TITLE_RE = /^Release\s+(\S.*)$/;

// "Release <tag>[ <tag>…]" → the tags, or null when the title is not a release title.
export function parseTitle(title) {
	const m = TITLE_RE.exec(title.trim());
	return m ? m[1].trim().split(/\s+/) : null;
}

// The version a release title ships for `unit`: its unit tag, else its full tag. Null when the title is not a
// release title or does not release that unit. Nothing is validated here, release-check does that.
export function releaseVersionFor(title, unit) {
	const tags = (parseTitle(title) ?? []).map(parseTag).filter(Boolean);
	return (tags.find((p) => p.unit === unit) ?? tags.find(isFull))?.version ?? null;
}

// Accepted releases, from the-forge's `cardinal-sdk-<tag>` tags (one per line, possibly noisy). Tags outside the
// grammar (older conventions, other projects) are ignored. `exclude` removes the releases being planned, so a
// re-run of an accepted release does not collide with itself.
export function parseAccepted(names, exclude = []) {
	const skip = new Set(exclude);
	return names
		.map((name) => name.trim().replace(/^cardinal-sdk-/, ''))
		.filter((tag) => tag && !skip.has(tag))
		.map(parseTag)
		.filter(Boolean);
}

// R1 and R9: every tag parses, and the tags form one valid release.
function checkShape(tags) {
	const violations = [];
	const parsed = [];
	if (tags.length === 0) violations.push(violation('R9', 'The title declares no release tag.'));
	for (const tag of tags) {
		const p = parseTag(tag);
		if (p) parsed.push(p);
		else violations.push(violation('R1', `${tag}: not a release tag (expected [kotlin-|ts-|python-]X.Y.Z[-PREVIEW.N]).`));
	}
	if (new Set(tags).size !== tags.length) violations.push(violation('R9', 'A tag is declared twice.'));
	if (parsed.some(isFull) && tags.length > 1) {
		violations.push(violation('R9', 'A full release PR declares exactly one tag.'));
	}
	const unitTags = parsed.filter((p) => !isFull(p));
	for (const unit of new Set(unitTags.map((p) => p.unit))) {
		if (unitTags.filter((p) => p.unit === unit).length > 1) violations.push(violation('R9', `${unit} is declared twice.`));
	}
	if (new Set(unitTags.map(decadeBase)).size > 1) {
		violations.push(violation('R9', 'All unit tags of one release must share the same decade base.'));
	}
	return { parsed, violations };
}

// R2, R3, R8: numbering. Independent of the repository state.
function checkNumbering(p) {
	const out = [];
	const grandfathered = isGrandfathered(p);
	if (grandfathered && !isFull(p)) {
		out.push(violation('R8', `${p.tag}: unit releases start with 2.14.0, ${p.version} uses the old scheme (bare tag only).`));
	}
	if (isFull(p) && !grandfathered && p.patch % 10 !== 0) {
		out.push(violation('R2', `${p.tag}: a full release needs a patch number ending in 0 (a unit patch is tagged like ts-${p.version}).`));
	}
	if (!isFull(p) && p.patch % 10 === 0) {
		out.push(violation('R3', `${p.tag}: a unit release needs a patch number not ending in 0, ${p.patch} is a full release number.`));
	}
	return out;
}

// R4: a unit patch builds on a released full version.
function checkDecadeBase(p, accepted) {
	if (isFull(p) || isGrandfathered(p)) return [];
	const base = decadeBase(p);
	const released = accepted.some((a) => isFull(a) && a.preview === null && a.version === base);
	return released ? [] : [violation('R4', `${p.tag}: its decade base ${base} has not been released.`)];
}

const peersOf = (p, accepted) => accepted.filter((a) => (isFull(p)
	? isFull(a)
	: a.unit === p.unit && decadeBase(a) === decadeBase(p)));

// R7: strictly greater than every accepted peer (full releases, or the same unit in the same decade).
function checkMonotonic(p, accepted) {
	const blocking = peersOf(p, accepted).filter((a) => compareVersions(a, p) >= 0).sort(compareVersions).at(-1);
	return blocking ? [violation('R7', `${p.tag}: must be greater than ${blocking.tag}, already released.`)] : [];
}

const expectedBranch = (p) => (isFull(p) ? 'main' : `support/${decadeBase(p)}`);

// R5, R6 on a PR: where it comes from and where it goes.
function checkBranchNames(p, baseRef, headRef) {
	if (!isFull(p)) {
		const expected = expectedBranch(p);
		return baseRef === expected ? [] : [violation('R5', `${p.tag}: a unit release PR must target ${expected}, not ${baseRef}.`)];
	}
	const out = [];
	if (baseRef !== 'main') out.push(violation('R6', `${p.tag}: a full release PR must target main, not ${baseRef}.`));
	if (headRef !== 'develop') out.push(violation('R6', `${p.tag}: a full release PR must come from develop, not ${headRef}.`));
	return out;
}

// R5, R6 after the merge: the tagged commit is on the right branch.
function checkReachability(p, isOnBranch) {
	const branch = expectedBranch(p);
	if (isOnBranch(branch)) return [];
	return [violation(isFull(p) ? 'R6' : 'R5', `${p.tag}: the commit is not on ${branch}.`)];
}

const MAX_LISTED_FILES = 20;

const listFiles = (files) => (files.length > MAX_LISTED_FILES
	? `${files.slice(0, MAX_LISTED_FILES).join(', ')} and ${files.length - MAX_LISTED_FILES} more`
	: files.join(', '));

// R10: the changes of a unit release only affect the declared units. A change for every unit (the "all" row of the
// mapping, including unknown paths) needs a full release (+10), even when the title declares every unit.
function checkDiff(parsed, changedFiles) {
	const unitTags = parsed.filter((p) => !isFull(p) && !isGrandfathered(p));
	if (unitTags.length === 0) return [];
	const declared = new Set(unitTags.map((p) => p.unit));
	const forEveryUnit = (f) => UNITS.every((u) => unitsForPath(f).includes(u));
	const shared = changedFiles.filter(forEveryUnit);
	const partial = changedFiles.filter((f) => !forEveryUnit(f));
	const extra = affectedUnits(partial).filter((u) => !declared.has(u));
	const out = [];
	if (shared.length > 0) {
		out.push(violation('R10', 'These changes affect every unit, which needs a full release (+10) whatever units this '
			+ `release declares. Files: ${listFiles(shared)}`));
	}
	if (extra.length > 0) {
		const files = partial.filter((f) => unitsForPath(f).some((u) => extra.includes(u)));
		out.push(violation('R10', `The changes also affect ${extra.join(', ')}, which this release does not declare. `
			+ `Files: ${listFiles(files)}`));
	}
	return out;
}

function buildRelease(p, accepted) {
	const full = isFull(p);
	const final = p.preview === null;
	const previous = peersOf(p, accepted)
		.filter((a) => (!final || a.preview === null) && compareVersions(a, p) < 0)
		.sort(compareVersions)
		.at(-1);
	return {
		tag: p.tag,
		unit: p.unit,
		version: p.version,
		full,
		prerelease: !final,
		units: unitsOf(p),
		decadeBase: full ? null : decadeBase(p),
		supportBranch: full && final && !isGrandfathered(p) ? `support/${p.version}` : null,
		latest: full && final,
		notesStartTag: previous?.tag ?? (full ? null : decadeBase(p)),
		releaseTitle: full ? p.version : `${p.version} (${UNIT_NAMES[p.unit]})`,
	};
}

function result(violations, warnings, parsed, accepted) {
	const ok = violations.length === 0;
	return { ok, violations, warnings, releases: ok ? parsed.map((p) => buildRelease(p, accepted)) : [] };
}

export function validatePr({ title, baseRef, headRef, accepted, existingTags, changedFiles }) {
	const tags = parseTitle(title);
	if (!tags) {
		return result([violation('R9', `Title "${title}" must be "Release <tag> [<tag>…]", `
			+ 'for example "Release 2.14.20" or "Release ts-2.14.11".')], [], [], accepted);
	}
	const { parsed, violations } = checkShape(tags);
	const existing = new Set(existingTags);
	for (const p of parsed) {
		if (existing.has(p.tag)) violations.push(violation('R9', `${p.tag}: this tag already exists.`));
		violations.push(
			...checkNumbering(p),
			...checkDecadeBase(p, accepted),
			...checkMonotonic(p, accepted),
			...checkBranchNames(p, baseRef, headRef),
		);
	}
	violations.push(...checkDiff(parsed, changedFiles));
	return result(violations, [], parsed, accepted);
}

export function validateTag({ tags, accepted, isOnBranch, changedFiles, dryRun }) {
	const { parsed, violations } = checkShape(tags);
	const warnings = [];
	// A dry run plans an arbitrary, unmerged commit: only the shape and numbering of the tags can be enforced.
	const stateful = (list) => {
		if (!dryRun) return list;
		warnings.push(...list);
		return [];
	};
	for (const p of parsed) {
		violations.push(
			...checkNumbering(p),
			...stateful(checkDecadeBase(p, accepted)),
			...stateful(checkMonotonic(p, accepted)),
			...stateful(checkReachability(p, isOnBranch)),
		);
	}
	violations.push(...stateful(checkDiff(parsed, changedFiles)));
	return result(violations, warnings, parsed, accepted);
}

export function renderSummary({ ok, violations, warnings, releases }) {
	const lines = [ok ? '### ✅ Release plan' : '### ❌ Release rejected', ''];
	for (const v of violations) lines.push(`- **${v.rule}** ${v.message}`);
	for (const w of warnings) lines.push(`- ⚠️ **${w.rule}** ${w.message} (dry run: not blocking)`);
	if (releases.length > 0) {
		lines.push('', '| Tag | Version | Units | Pre-release | Latest | Support branch |', '|---|---|---|---|---|---|');
		for (const r of releases) {
			lines.push(`| \`${r.tag}\` | ${r.version} | ${r.units.join(', ')} | ${r.prerelease ? 'yes' : 'no'} `
				+ `| ${r.latest ? 'yes' : 'no'} | ${r.supportBranch ?? '—'} |`);
		}
	}
	return `${lines.join('\n')}\n`;
}
