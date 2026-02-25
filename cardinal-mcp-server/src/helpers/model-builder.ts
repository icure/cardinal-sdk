/**
 * Constructs SDK model instances from plain JSON objects.
 * Most TypeScript model classes accept Partial<T> in constructors.
 */
import * as cardinalSdk from "@icure/cardinal-sdk";

// Access model namespace
const model = (cardinalSdk as Record<string, unknown>).model as Record<string, unknown> | undefined;

/**
 * Tries to construct a model instance from a plain JSON object.
 * Falls back to returning the plain object if no constructor is found.
 */
export function buildModel(typeName: string, data: Record<string, unknown>): unknown {
	// Try to find the class in the SDK exports
	const Constructor = resolveConstructor(typeName);

	if (Constructor) {
		try {
			return new (Constructor as new (partial: Record<string, unknown>) => unknown)(data);
		} catch {
			// Some constructors may have different signatures, fall back to plain object
			return data;
		}
	}

	return data;
}

function resolveConstructor(typeName: string): (new (...args: unknown[]) => unknown) | null {
	// Try direct lookup in top-level exports
	const directExport = (cardinalSdk as Record<string, unknown>)[typeName];
	if (typeof directExport === "function") {
		return directExport as new (...args: unknown[]) => unknown;
	}

	// Try in model namespace
	if (model) {
		const modelExport = model[typeName];
		if (typeof modelExport === "function") {
			return modelExport as new (...args: unknown[]) => unknown;
		}

		// Try nested namespaces (e.g., model.embed, model.base)
		for (const ns of Object.values(model)) {
			if (ns && typeof ns === "object") {
				const nested = (ns as Record<string, unknown>)[typeName];
				if (typeof nested === "function") {
					return nested as new (...args: unknown[]) => unknown;
				}
			}
		}
	}

	return null;
}

/**
 * Resolves a type name with "Decrypted" or "Encrypted" prefix.
 */
export function buildEntityModel(typeName: string, data: Record<string, unknown>, flavour?: string): unknown {
	if (flavour === "encrypted") {
		return buildModel("Encrypted" + typeName, data);
	}
	// Default to Decrypted for encryptable entities
	const decrypted = buildModel("Decrypted" + typeName, data);
	if (decrypted !== data) return decrypted;
	// Fallback to plain type name
	return buildModel(typeName, data);
}
