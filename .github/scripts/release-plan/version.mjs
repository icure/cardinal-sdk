// Release tag grammar and ordering, see RELEASING.md.
//
//   tag = [ unit "-" ] X "." Y "." P [ "-PREVIEW." N ]
//
// A bare tag is a full release (every unit), a unit-prefixed tag releases that unit only.

export const UNITS = ['kotlin', 'ts', 'python'];
export const UNIT_NAMES = { kotlin: 'Kotlin', ts: 'TypeScript', python: 'Python' };

// First version released under the per-unit scheme: anything lower is grandfathered (R8).
const SCHEME_START = { major: 2, minor: 14, patch: 0 };

const TAG_RE = /^(?:(kotlin|ts|python)-)?(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:-PREVIEW\.([1-9]\d*))?$/;

export function parseTag(tag) {
	const m = TAG_RE.exec(tag);
	if (!m) return null;
	const [, unit, major, minor, patch, preview] = m;
	const parsed = {
		tag,
		unit: unit ?? null,
		major: Number(major),
		minor: Number(minor),
		patch: Number(patch),
		preview: preview === undefined ? null : Number(preview),
	};
	parsed.version = formatVersion(parsed);
	return parsed;
}

export function formatVersion({ major, minor, patch, preview }) {
	return `${major}.${minor}.${patch}${preview === null ? '' : `-PREVIEW.${preview}`}`;
}

function compareTriple(a, b) {
	return a.major - b.major || a.minor - b.minor || a.patch - b.patch;
}

// A final version ranks above every preview of the same X.Y.Z.
const previewRank = (p) => (p.preview === null ? Number.MAX_SAFE_INTEGER : p.preview);

export function compareVersions(a, b) {
	return compareTriple(a, b) || previewRank(a) - previewRank(b);
}

export const isFull = (p) => p.unit === null;

export const isGrandfathered = (p) => compareTriple(p, SCHEME_START) < 0;

export const decadeBase = (p) => `${p.major}.${p.minor}.${p.patch - (p.patch % 10)}`;

export const unitsOf = (p) => (isFull(p) ? [...UNITS] : [p.unit]);
