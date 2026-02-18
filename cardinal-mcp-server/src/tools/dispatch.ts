/**
 * Generic method dispatch logic.
 * Resolves API, flavour, method, builds params, calls method, serializes result.
 */
import type { CardinalSdk } from "@icure/cardinal-sdk";
import { getSdk } from "./sdk-state.js";
import { collectFirstPage, type PaginatedListIterator } from "../helpers/pagination.js";
import { formatResponse } from "../helpers/serialization.js";
import { buildFilter } from "../helpers/filter-builder.js";
import { buildModel } from "../helpers/model-builder.js";
import * as fs from "node:fs";
import * as path from "node:path";
import { fileURLToPath } from "node:url";

const __dirname = path.dirname(fileURLToPath(import.meta.url));

interface ParamInfo {
	name: string;
	type: string;
	optional: boolean;
}

interface MethodInfo {
	name: string;
	params: ParamInfo[];
	returnType: string;
}

interface ApiInfo {
	apiName: string;
	propertyName: string;
	isEncryptable: boolean;
	methods: MethodInfo[];
}

let registryCache: Record<string, ApiInfo> | null = null;

function getRegistry(): Record<string, ApiInfo> {
	if (!registryCache) {
		const registryPath = path.resolve(__dirname, "..", "..", "generated", "method-registry.ts");
		const content = fs.readFileSync(registryPath, "utf-8");
		// Extract the JSON from the generated TS file
		const jsonMatch = content.match(/=\s*(\{[\s\S]*\})\s*;\s*$/);
		if (!jsonMatch) throw new Error("Could not parse method registry");
		registryCache = JSON.parse(jsonMatch[1]) as Record<string, ApiInfo>;
	}
	return registryCache;
}

export interface DispatchRequest {
	api: string;
	method: string;
	flavour?: "decrypted" | "encrypted" | "tryAndRecover";
	params: Record<string, unknown>;
}

export interface DispatchResult {
	[key: string]: unknown;
	content: Array<{ type: "text"; text: string }>;
	isError?: boolean;
}

export async function dispatch(request: DispatchRequest): Promise<DispatchResult> {
	const sdk = getSdk();
	const registry = getRegistry();

	// Look up API info
	const apiInfo = registry[request.api];
	if (!apiInfo) {
		return errorResult(`Unknown API: "${request.api}". Available: ${Object.keys(registry).join(", ")}`);
	}

	// Look up method info
	const methodInfo = apiInfo.methods.find(m => m.name === request.method);
	if (!methodInfo) {
		const available = apiInfo.methods.map(m => m.name).join(", ");
		return errorResult(`Unknown method "${request.method}" on ${request.api}Api. Available: ${available}`);
	}

	// Resolve API object from SDK
	const apiObj = resolveApi(sdk, apiInfo.propertyName, request.flavour, apiInfo.isEncryptable);
	if (!apiObj) {
		return errorResult(`Could not resolve API "${apiInfo.propertyName}" on SDK instance.`);
	}

	// Resolve method function
	const methodFn = (apiObj as Record<string, unknown>)[request.method];
	if (typeof methodFn !== "function") {
		return errorResult(`Method "${request.method}" is not a function on ${apiInfo.propertyName}${request.flavour ? "." + request.flavour : ""}.`);
	}

	// Build arguments in the correct order
	const args = buildArgs(methodInfo.params, request.params);

	try {
		const result = await (methodFn as (...args: unknown[]) => Promise<unknown>).apply(apiObj, args);
		return handleResult(result);
	} catch (err: unknown) {
		const message = err instanceof Error ? err.message : String(err);
		return errorResult(`Error calling ${request.api}.${request.method}: ${message}`);
	}
}

function resolveApi(
	sdk: CardinalSdk,
	propertyName: string,
	flavour: string | undefined,
	isEncryptable: boolean
): unknown {
	const baseApi = (sdk as unknown as Record<string, unknown>)[propertyName];
	if (!baseApi) return null;

	if (isEncryptable && flavour && flavour !== "decrypted") {
		const flavouredApi = (baseApi as Record<string, unknown>)[flavour];
		return flavouredApi || baseApi;
	}

	return baseApi;
}

function buildArgs(paramDefs: Array<{ name: string; type: string; optional: boolean }>, params: Record<string, unknown>): unknown[] {
	return paramDefs.map(def => {
		const value = params[def.name];
		if (value === undefined) {
			return undefined;
		}

		// Transform special parameter types
		if (def.type.includes("FilterOptions")) {
			if (value && typeof value === "object" && "_factory" in (value as Record<string, unknown>)) {
				return buildFilter(value as Record<string, unknown>);
			}
		}

		// Build model instances from plain objects
		if (value && typeof value === "object" && !Array.isArray(value)) {
			const typeName = extractTypeName(def.type);
			if (typeName) {
				return buildModel(typeName, value as Record<string, unknown>);
			}
		}

		// Handle arrays of models
		if (Array.isArray(value) && def.type.includes("Array<")) {
			const innerType = extractArrayInnerType(def.type);
			if (innerType) {
				return value.map(item => {
					if (item && typeof item === "object" && !Array.isArray(item)) {
						return buildModel(innerType, item as Record<string, unknown>);
					}
					return item;
				});
			}
		}

		return value;
	});
}

function extractTypeName(typeStr: string): string | null {
	// Match simple type names like "DecryptedPatient", "Group", etc.
	const match = typeStr.match(/^(Decrypted|Encrypted)?(\w+)$/);
	if (match) return typeStr;

	// Handle union types - take the first non-primitive
	const parts = typeStr.split("|").map(s => s.trim());
	for (const part of parts) {
		if (part !== "undefined" && part !== "null" && part !== "string" && part !== "number" && part !== "boolean") {
			const inner = part.match(/^(\w+)$/);
			if (inner) return inner[1];
		}
	}

	return null;
}

function extractArrayInnerType(typeStr: string): string | null {
	const match = typeStr.match(/Array<(\w+)>/);
	return match ? match[1] : null;
}

async function handleResult(result: unknown): Promise<DispatchResult> {
	// Handle PaginatedListIterator
	if (result && typeof result === "object" && "hasNext" in result && "next" in result) {
		const iterator = result as PaginatedListIterator<unknown>;
		const page = await collectFirstPage(iterator);
		return {
			content: [{ type: "text", text: formatResponse(page) }],
		};
	}

	return {
		content: [{ type: "text", text: formatResponse(result) }],
	};
}

function errorResult(message: string): DispatchResult {
	return {
		content: [{ type: "text", text: JSON.stringify({ error: message }) }],
		isError: true,
	};
}
