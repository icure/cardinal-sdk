/**
 * Parses method signatures out of the TypeScript declaration files (`.d.mts`) shipped by `@icure/cardinal-sdk`.
 * Pure functions, no I/O: used by generate-registry.ts and unit-tested in test/dts-signatures.test.ts.
 *
 * The declarations are `export interface <Name>Api { ... }` blocks whose members are properties (`encrypted: ...;`),
 * KDoc comments and method signatures. Parameter and return types may be object literals spread over several lines
 * and containing their own `;` separators, so members cannot be split line by line: comments are removed first,
 * then the interface body is cut at the `;` that sit at nesting depth zero of `{}` and `()`.
 */

export interface ParamInfo {
	name: string;
	type: string;
	optional: boolean;
}

export interface MethodInfo {
	name: string;
	params: ParamInfo[];
	returnType: string;
}

/** Returns the methods declared by every `interface` in a `.d.mts` file, in declaration order. */
export function parseMethodSignatures(dtsContent: string): MethodInfo[] {
	const methods: MethodInfo[] = [];
	const source = stripBlockComments(dtsContent);

	const interfacePattern = /\binterface\s+\w+[^{]*\{/g;
	let match: RegExpExecArray | null;
	while ((match = interfacePattern.exec(source)) !== null) {
		const openBrace = match.index + match[0].length - 1;
		const closeBrace = matchingBracket(source, openBrace, "{", "}");
		const body = source.slice(openBrace + 1, closeBrace < 0 ? source.length : closeBrace);
		for (const member of splitMembers(body)) {
			const method = parseMember(member);
			if (method) methods.push(method);
		}
		if (closeBrace < 0) break;
		interfacePattern.lastIndex = closeBrace + 1;
	}

	return methods;
}

/** Splits a comma-separated parameter list into `name?: type` entries. */
export function parseParams(rawParams: string): ParamInfo[] {
	if (!rawParams.trim()) return [];

	const params: ParamInfo[] = [];
	for (const part of splitTopLevel(rawParams, ",")) {
		const trimmed = part.trim();
		if (!trimmed) continue;

		const paramMatch = trimmed.match(/^(\w+)(\?)?:\s*(.+)$/);
		if (paramMatch) {
			params.push({
				name: paramMatch[1],
				type: paramMatch[3].trim(),
				optional: !!paramMatch[2],
			});
		}
	}

	return params;
}

/** Splits on `sep` outside of `()`, `{}`, `[]` and `<>`; the `>` of a `=>` arrow is not a closing bracket. */
export function splitTopLevel(str: string, sep: string): string[] {
	const parts: string[] = [];
	let depth = 0;
	let current = "";

	for (let i = 0; i < str.length; i++) {
		const ch = str[i];
		if (ch === "(" || ch === "{" || ch === "[" || ch === "<") depth++;
		else if (ch === ")" || ch === "}" || ch === "]" || (ch === ">" && str[i - 1] !== "=")) depth--;

		if (depth === 0 && ch === sep) {
			parts.push(current);
			current = "";
		} else {
			current += ch;
		}
	}
	if (current.trim()) parts.push(current);
	return parts;
}

function stripBlockComments(source: string): string {
	return source.replace(/\/\*[\s\S]*?\*\//g, "");
}

/** Index of the bracket closing the one at `openIndex`, or -1 when the text ends first. */
function matchingBracket(text: string, openIndex: number, open: string, close: string): number {
	let depth = 0;
	for (let i = openIndex; i < text.length; i++) {
		if (text[i] === open) depth++;
		else if (text[i] === close && --depth === 0) return i;
	}
	return -1;
}

/** Cuts an interface body into member declarations at the `;` that are not nested in `{}` or `()`. */
function splitMembers(body: string): string[] {
	const members: string[] = [];
	let depth = 0;
	let current = "";

	for (const ch of body) {
		if (ch === "{" || ch === "(") depth++;
		else if (ch === "}" || ch === ")") depth--;

		if (ch === ";" && depth === 0) {
			members.push(current);
			current = "";
		} else {
			current += ch;
		}
	}
	if (current.trim()) members.push(current);
	return members;
}

/** Parses `name(params): ReturnType`; returns null for properties and anything else that is not a method. */
function parseMember(member: string): MethodInfo | null {
	const text = member.replace(/\s+/g, " ").trim();
	const head = text.match(/^(\w+)\s*\(/);
	if (!head || head[1] === "constructor") return null;

	const openParen = head[0].length - 1;
	const closeParen = matchingBracket(text, openParen, "(", ")");
	if (closeParen < 0) return null;

	const tail = text.slice(closeParen + 1).match(/^\s*:\s*(.+)$/);
	if (!tail) return null;

	return {
		name: head[1],
		params: parseParams(text.slice(openParen + 1, closeParen)),
		returnType: tail[1].trim(),
	};
}
