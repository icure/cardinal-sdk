/**
 * Serializes SDK results to JSON-safe objects.
 * Handles special types and strips internal properties.
 */

export function serializeResult(value: unknown): unknown {
	if (value === null || value === undefined) return value;
	if (typeof value === "string" || typeof value === "number" || typeof value === "boolean") return value;

	if (Array.isArray(value)) {
		return value.map(serializeResult);
	}

	if (value instanceof Date) {
		return value.toISOString();
	}

	if (typeof value === "object") {
		// If the object has a toJSON method, use it
		if ("toJSON" in value && typeof (value as { toJSON: unknown }).toJSON === "function") {
			return (value as { toJSON: () => unknown }).toJSON();
		}

		// Otherwise serialize each property
		const result: Record<string, unknown> = {};
		for (const [key, val] of Object.entries(value)) {
			// Skip internal properties
			if (key.startsWith("__") || key.startsWith("$")) continue;
			result[key] = serializeResult(val);
		}
		return result;
	}

	return String(value);
}

export function formatResponse(data: unknown): string {
	return JSON.stringify(serializeResult(data), null, 2);
}
