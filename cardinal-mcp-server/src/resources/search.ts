import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { z } from "zod";
import { getManifest } from "../helpers/docs-loader.js";

interface SearchResult {
	type: string;
	name: string;
	description: string;
	uri: string;
	score: number;
}

/**
 * Tokenize a query into lowercase words, splitting on spaces and camelCase boundaries.
 * "filterContactsBy" -> ["filter", "contacts", "by"]
 * "contact filter" -> ["contact", "filter"]
 */
function tokenize(text: string): string[] {
	return text
		// Split camelCase: "filterContactsBy" -> "filter Contacts By"
		.replace(/([a-z])([A-Z])/g, "$1 $2")
		.toLowerCase()
		.split(/[\s_\-./]+/)
		.filter(w => w.length > 0);
}

/**
 * Score how well a text matches the query tokens.
 * Returns 0 if any token has no match at all.
 * Higher scores = better matches. Exact substring match of full query scores highest.
 */
function scoreMatch(text: string, queryTokens: string[], fullQueryLower: string): number {
	const textLower = text.toLowerCase();
	const textTokens = tokenize(text);

	// Exact full-query substring match gets highest score
	if (textLower.includes(fullQueryLower)) return 100;

	// Check each query token against the text
	let totalScore = 0;
	let allMatched = true;

	for (const qt of queryTokens) {
		// Direct substring match in full text
		if (textLower.includes(qt)) {
			totalScore += 10;
			// Bonus for matching a whole token exactly
			if (textTokens.includes(qt)) totalScore += 5;
			continue;
		}

		// Prefix match on any text token (e.g., "form" matches "formId")
		const prefixMatch = textTokens.some(tt => tt.startsWith(qt) || qt.startsWith(tt));
		if (prefixMatch) {
			totalScore += 5;
			continue;
		}

		allMatched = false;
	}

	// If not all query tokens matched, heavily penalize but don't zero out
	// (allows partial matches to still appear, ranked lower)
	if (!allMatched) {
		totalScore = Math.floor(totalScore / 3);
	}

	return totalScore;
}

/**
 * Build a searchable text blob for an item, combining all relevant fields.
 */
function apiSearchText(apiKey: string, apiName: string, description: string): string {
	return `${apiKey} ${apiName} ${description}`;
}

function methodSearchText(apiKey: string, methodName: string, description: string, paramNames: string[]): string {
	return `${apiKey} ${methodName} ${description} ${paramNames.join(" ")}`;
}

function filterSearchText(entityName: string, methodName: string, paramNames: string[]): string {
	return `${entityName} ${entityName}Filters ${methodName} filter ${paramNames.join(" ")}`;
}

export function registerSearchTool(server: McpServer) {
	server.tool(
		"search_documentation",
		"Search Cardinal SDK documentation: API methods, models, and filters. No SDK initialization required. Supports multi-word queries (e.g., 'contact filter', 'form patient', 'filter by date').",
		{
			query: z.string().describe("Search term (e.g., 'patient', 'createCalendarItem', 'contact filter', 'filter forms by patient')"),
			category: z.enum(["all", "apis", "models", "filters", "tutorials", "guides"]).optional().default("all")
				.describe("Limit search to a category"),
			limit: z.number().optional().default(20).describe("Max results to return"),
		},
		async ({ query, category, limit }) => {
			const manifest = getManifest();
			const queryTokens = tokenize(query);
			const fullQueryLower = query.toLowerCase();

			if (queryTokens.length === 0) {
				return {
					content: [{ type: "text" as const, text: JSON.stringify({ query, resultCount: 0, results: [] }) }],
				};
			}

			const results: SearchResult[] = [];

			// Search APIs
			if (category === "all" || category === "apis") {
				for (const [key, api] of Object.entries(manifest.apis)) {
					const score = scoreMatch(apiSearchText(key, api.name, api.description), queryTokens, fullQueryLower);
					if (score > 0) {
						results.push({
							type: "api",
							name: api.name,
							description: api.description,
							uri: `cardinal://docs/api/${key}`,
							score,
						});
					}

					for (const method of api.methods) {
						const paramNames = method.params.map(p => p.name);
						const score = scoreMatch(
							methodSearchText(key, method.name, method.description, paramNames),
							queryTokens,
							fullQueryLower,
						);
						if (score > 0) {
							results.push({
								type: "method",
								name: `${api.name}.${method.name}`,
								description: method.description || `${method.name}(${paramNames.join(", ")}): ${method.returnType}`,
								uri: `cardinal://docs/api/${key}`,
								score,
							});
						}
					}
				}
			}

			// Search models
			if (category === "all" || category === "models") {
				for (const [key, model] of Object.entries(manifest.models)) {
					const modelText = `${key} ${model.name} ${(model.variants || []).join(" ")} ${(model.implements || []).join(" ")}`;
					const score = scoreMatch(modelText, queryTokens, fullQueryLower);
					if (score > 0) {
						results.push({
							type: "model",
							name: model.name,
							description: model.variants ? `Encryptable: ${model.variants.join(", ")}` : `${model.fields.length} fields`,
							uri: `cardinal://docs/model/${key}`,
							score,
						});
					}

					for (const field of model.fields) {
						const fieldText = `${key} ${model.name} ${field.name} ${field.type}`;
						const score = scoreMatch(fieldText, queryTokens, fullQueryLower);
						if (score > 0) {
							results.push({
								type: "model_field",
								name: `${model.name}.${field.name}`,
								description: `${field.type}${field.description ? " — " + field.description : ""}`,
								uri: `cardinal://docs/model/${key}`,
								score,
							});
						}
					}
				}
			}

			// Search filters
			if (category === "all" || category === "filters") {
				for (const [key, filter] of Object.entries(manifest.filters)) {
					const filterText = `${key} ${key}Filters filter`;
					const score = scoreMatch(filterText, queryTokens, fullQueryLower);
					if (score > 0) {
						results.push({
							type: "filter",
							name: `${key}Filters`,
							description: `${filter.methods.length} filter methods for ${key}`,
							uri: `cardinal://docs/filter/${key}`,
							score,
						});
					}

					for (const method of filter.methods) {
						const paramNames = method.params.map(p => p.name);
						const score = scoreMatch(
							filterSearchText(key, method.name, paramNames),
							queryTokens,
							fullQueryLower,
						);
						if (score > 0) {
							results.push({
								type: "filter_method",
								name: `${key}Filters.${method.name}`,
								description: `(${method.params.map(p => `${p.name}: ${p.type}`).join(", ")})`,
								uri: `cardinal://docs/filter/${key}`,
								score,
							});
						}
					}
				}
			}

			// Search tutorials
			if (category === "all" || category === "tutorials") {
				for (const tutorial of manifest.tutorials) {
					const tutorialText = `${tutorial.title} ${tutorial.slug} ${tutorial.content}`;
					const score = scoreMatch(tutorialText, queryTokens, fullQueryLower);
					if (score > 0) {
						results.push({
							type: "tutorial",
							name: tutorial.title,
							description: `Tutorial: ${tutorial.slug}`,
							uri: `cardinal://docs/tutorial/${tutorial.slug}`,
							score,
						});
					}
				}
			}

			// Search guides
			if (category === "all" || category === "guides") {
				for (const guide of manifest.guides) {
					const guideText = `${guide.title} ${guide.slug} ${guide.category} ${guide.content}`;
					const score = scoreMatch(guideText, queryTokens, fullQueryLower);
					if (score > 0) {
						results.push({
							type: "guide",
							name: guide.title,
							description: `[${guide.category}] ${guide.title}`,
							uri: `cardinal://docs/guide/${guide.slug}`,
							score,
						});
					}
				}
			}

			// Sort by score descending, deduplicate, limit
			results.sort((a, b) => b.score - a.score);
			const seen = new Set<string>();
			const unique = results.filter(r => {
				const key = `${r.type}:${r.name}`;
				if (seen.has(key)) return false;
				seen.add(key);
				return true;
			}).slice(0, limit);

			// Strip score from output
			const output = unique.map(({ score: _score, ...rest }) => rest);

			return {
				content: [{
					type: "text" as const,
					text: JSON.stringify({
						query,
						resultCount: output.length,
						results: output,
					}, null, 2),
				}],
			};
		}
	);
}
