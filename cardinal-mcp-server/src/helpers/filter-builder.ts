/**
 * Constructs filter objects from JSON descriptions.
 * Input format: { "_factory": "PatientFilters.bySsinsForSelf", "ssins": ["123456"] }
 * Maps to actual SDK filter factory calls.
 */
import * as cardinalSdk from "@icure/cardinal-sdk";

const filters = (cardinalSdk as Record<string, unknown>).filters as Record<string, unknown> | undefined;

/**
 * Build a filter from a JSON description.
 * If the input has a _factory property, it's resolved to a filter factory function.
 * Otherwise, the object is returned as-is (may already be a filter instance).
 */
export function buildFilter(filterDesc: Record<string, unknown>): unknown {
	const factory = filterDesc._factory;
	if (typeof factory !== "string") {
		return filterDesc;
	}

	// Parse "EntityFilters.methodName" format
	const [factoryObject, methodName] = factory.split(".");
	if (!factoryObject || !methodName) {
		throw new Error(`Invalid filter factory format: "${factory}". Expected "EntityFilters.methodName".`);
	}

	// Resolve the filter factory object
	const factoryObj = resolveFilterFactory(factoryObject);
	if (!factoryObj) {
		throw new Error(`Filter factory "${factoryObject}" not found in SDK.`);
	}

	const factoryFn = (factoryObj as Record<string, unknown>)[methodName];
	if (typeof factoryFn !== "function") {
		throw new Error(`Method "${methodName}" not found on "${factoryObject}".`);
	}

	// Extract params (everything except _factory)
	const params = { ...filterDesc };
	delete params._factory;

	// Call the factory function with the params spread as arguments
	// Most filter factories use positional args matching param names
	const paramValues = Object.values(params);
	return (factoryFn as (...args: unknown[]) => unknown)(...paramValues);
}

function resolveFilterFactory(name: string): unknown {
	// Try in filters namespace
	if (filters) {
		const factory = filters[name];
		if (factory) return factory;
	}

	// Try in top-level exports
	const topLevel = (cardinalSdk as Record<string, unknown>)[name];
	if (topLevel) return topLevel;

	return null;
}
