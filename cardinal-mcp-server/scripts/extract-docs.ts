/**
 * Parses Kotlin KDoc + TypeScript type declarations to produce a documentation manifest.
 * Sources:
 *   - Kotlin API files: cardinal-sdk/src/commonMain/kotlin/.../api/*.kt  (KDoc comments)
 *   - TypeScript API types: node_modules/@icure/cardinal-sdk/api/*.d.mts (method signatures)
 *   - TypeScript model types: node_modules/@icure/cardinal-sdk/model/**  (model fields)
 *   - TypeScript filter types: node_modules/@icure/cardinal-sdk/filters/* (filter factories)
 *   - DOCUMENTATION.md: tutorial content split by slug markers
 *
 * Output: generated/docs-manifest.json
 */
import * as fs from "node:fs";
import * as path from "node:path";

const CARDINAL_SDK_ROOT = process.env.CARDINAL_SDK_ROOT || path.resolve(import.meta.dirname!, "..", "..");
const NPM_SDK = path.resolve(import.meta.dirname!, "..", "node_modules", "@icure", "cardinal-sdk");
const OUT_FILE = path.resolve(import.meta.dirname!, "..", "generated", "docs-manifest.json");

interface ParamDoc {
	name: string;
	type: string;
	description: string;
	optional: boolean;
}

interface MethodDoc {
	name: string;
	description: string;
	params: ParamDoc[];
	returnType: string;
	throws?: string[];
	flavours: string[];
}

interface ApiDoc {
	name: string;
	description: string;
	isEncryptable: boolean;
	methods: MethodDoc[];
}

interface ModelField {
	name: string;
	type: string;
	description: string;
}

interface ModelDoc {
	name: string;
	variants?: string[];
	implements?: string[];
	fields: ModelField[];
}

interface FilterMethodDoc {
	name: string;
	description: string;
	params: Array<{ name: string; type: string }>;
}

interface FilterDoc {
	entityName: string;
	methods: FilterMethodDoc[];
}

interface TutorialDoc {
	slug: string;
	title: string;
	content: string;
}

interface DocsManifest {
	apis: Record<string, ApiDoc>;
	models: Record<string, ModelDoc>;
	filters: Record<string, FilterDoc>;
	tutorials: TutorialDoc[];
}

// --- Kotlin KDoc Parsing ---

function parseKDocComments(kotlinSource: string): Map<string, { description: string; params: Map<string, string>; returns: string; throws: string[] }> {
	const result = new Map<string, { description: string; params: Map<string, string>; returns: string; throws: string[] }>();

	const kdocPattern = /\/\*\*([\s\S]*?)\*\/\s*(?:(?:suspend\s+)?fun\s+(\w+))/g;
	let match;
	while ((match = kdocPattern.exec(kotlinSource)) !== null) {
		const [, rawDoc, methodName] = match;
		const lines = rawDoc.split("\n").map(l => l.replace(/^\s*\*\s?/, "").trim());

		let description = "";
		const params = new Map<string, string>();
		let returns = "";
		const throws: string[] = [];

		let currentTag: string | null = null;
		let currentTagName = "";

		for (const line of lines) {
			if (line.startsWith("@param")) {
				const paramMatch = line.match(/@param\s+(\w+)\s*(.*)/);
				if (paramMatch) {
					currentTag = "param";
					currentTagName = paramMatch[1];
					params.set(paramMatch[1], paramMatch[2]);
				}
			} else if (line.startsWith("@return")) {
				currentTag = "return";
				returns = line.replace(/@returns?\s*/, "");
			} else if (line.startsWith("@throws") || line.startsWith("@exception")) {
				currentTag = "throws";
				throws.push(line.replace(/@(?:throws|exception)\s*/, ""));
			} else if (line.startsWith("@")) {
				currentTag = null;
			} else if (currentTag === "param") {
				params.set(currentTagName, (params.get(currentTagName) || "") + " " + line);
			} else if (currentTag === "return") {
				returns += " " + line;
			} else if (!currentTag) {
				description += (description ? " " : "") + line;
			}
		}

		result.set(methodName, { description: description.trim(), params, returns: returns.trim(), throws });
	}

	return result;
}

// --- TypeScript API Parsing ---

const ENCRYPTABLE_ENTITIES = new Set([
	"AccessLog", "CalendarItem", "Classification", "Contact", "Document",
	"Form", "HealthElement", "Invoice", "MaintenanceTask", "Message",
	"Patient", "Receipt", "TimeTable", "Topic",
]);

function parseApiInterface(dtsContent: string, _apiName: string): MethodDoc[] {
	const methods: MethodDoc[] = [];

	const methodPattern = /^\s+(\w+)\(([^)]*)\):\s*Promise<([^>]+)>|^\s+(\w+)\(([^)]*)\):\s*([^;]+);/gm;
	let match;
	while ((match = methodPattern.exec(dtsContent)) !== null) {
		const name = match[1] || match[4];
		const rawParams = match[2] || match[5] || "";
		const returnType = match[3] || match[6] || "void";

		if (!name || name === "constructor") continue;

		const params = parseParams(rawParams);

		methods.push({
			name,
			description: "",
			params,
			returnType: returnType.trim(),
			flavours: ["none"],
		});
	}

	return methods;
}

function parseParams(rawParams: string): ParamDoc[] {
	if (!rawParams.trim()) return [];

	const params: ParamDoc[] = [];
	const parts = splitTopLevel(rawParams, ",");

	for (const part of parts) {
		const trimmed = part.trim();
		if (!trimmed) continue;

		const paramMatch = trimmed.match(/^(\w+)(\?)?:\s*(.+)$/);
		if (paramMatch) {
			params.push({
				name: paramMatch[1],
				type: paramMatch[3].trim(),
				description: "",
				optional: !!paramMatch[2],
			});
		}
	}

	return params;
}

function splitTopLevel(str: string, sep: string): string[] {
	const parts: string[] = [];
	let depth = 0;
	let current = "";

	for (const ch of str) {
		if (ch === "(" || ch === "{" || ch === "[" || ch === "<") depth++;
		else if (ch === ")" || ch === "}" || ch === "]" || ch === ">") depth--;

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

function extractApis(): Record<string, ApiDoc> {
	const apis: Record<string, ApiDoc> = {};
	const apiDir = path.join(NPM_SDK, "api");

	if (!fs.existsSync(apiDir)) {
		console.warn("API directory not found:", apiDir);
		return apis;
	}

	// Load Kotlin KDoc for enrichment
	const kotlinApiDir = path.join(CARDINAL_SDK_ROOT, "cardinal-sdk", "src", "commonMain", "kotlin", "com", "icure", "cardinal", "sdk", "api");
	const kotlinDocs = new Map<string, Map<string, { description: string; params: Map<string, string>; returns: string; throws: string[] }>>();

	if (fs.existsSync(kotlinApiDir)) {
		for (const file of fs.readdirSync(kotlinApiDir)) {
			if (!file.endsWith(".kt")) continue;
			const content = fs.readFileSync(path.join(kotlinApiDir, file), "utf-8");
			const baseName = file.replace(".kt", "");
			kotlinDocs.set(baseName, parseKDocComments(content));
		}
	}

	// We only want the main API files (not Basic, Flavoured, InGroup variants)
	const mainApiPattern = /^(\w+)Api\.d\.mts$/;
	const skipPatterns = [/Basic/, /Flavoured/, /InGroup/, /Anonymous/];

	for (const file of fs.readdirSync(apiDir).sort()) {
		const match = file.match(mainApiPattern);
		if (!match) continue;
		if (skipPatterns.some(p => p.test(file))) continue;

		const entityName = match[1];
		const dtsContent = fs.readFileSync(path.join(apiDir, file), "utf-8");
		const isEncryptable = ENCRYPTABLE_ENTITIES.has(entityName);

		const methods = parseApiInterface(dtsContent, entityName);

		if (isEncryptable) {
			for (const method of methods) {
				method.flavours = ["decrypted", "encrypted", "tryAndRecover"];
			}
		}

		// Enrich with Kotlin KDoc
		for (const kn of [entityName + "Api", entityName + "FlavouredApi", entityName + "BasicFlavourlessApi"]) {
			const kdoc = kotlinDocs.get(kn);
			if (!kdoc) continue;
			for (const method of methods) {
				const doc = kdoc.get(method.name);
				if (!doc) continue;
				if (doc.description) method.description = doc.description;
				if (doc.throws.length) method.throws = doc.throws;
				for (const param of method.params) {
					const paramDesc = doc.params.get(param.name);
					if (paramDesc) param.description = paramDesc.trim();
				}
			}
		}

		// Extract interface-level description from Kotlin
		let apiDescription = "";
		const ktFile = path.join(kotlinApiDir, entityName + "Api.kt");
		if (fs.existsSync(ktFile)) {
			const ktContent = fs.readFileSync(ktFile, "utf-8");
			const interfaceDocMatch = ktContent.match(/\/\*\*([\s\S]*?)\*\/\s*interface\s+\w+Api/);
			if (interfaceDocMatch) {
				apiDescription = interfaceDocMatch[1]
					.split("\n")
					.map(l => l.replace(/^\s*\*\s?/, "").trim())
					.filter(l => !l.startsWith("@"))
					.join(" ")
					.trim();
			}
		}

		apis[entityName] = {
			name: entityName + "Api",
			description: apiDescription || `API for ${entityName} operations`,
			isEncryptable,
			methods,
		};
	}

	return apis;
}

// --- TypeScript Model Parsing ---

function extractModels(): Record<string, ModelDoc> {
	const models: Record<string, ModelDoc> = {};
	const modelBase = path.join(NPM_SDK, "model");

	if (!fs.existsSync(modelBase)) {
		console.warn("Model directory not found:", modelBase);
		return models;
	}

	function walkDir(dir: string) {
		for (const entry of fs.readdirSync(dir, { withFileTypes: true })) {
			if (entry.isDirectory()) {
				walkDir(path.join(dir, entry.name));
			} else if (entry.name.endsWith(".d.mts")) {
				parseModelFile(path.join(dir, entry.name), models);
			}
		}
	}

	walkDir(modelBase);
	return models;
}

function parseModelFile(filePath: string, models: Record<string, ModelDoc>) {
	const content = fs.readFileSync(filePath, "utf-8");

	// Extract class declarations
	const classPattern = /export\s+declare\s+class\s+(\w+)(?:\s+extends\s+[\w.]+)?(?:\s+implements\s+([\w,\s.]+))?\s*\{/g;
	let match;
	while ((match = classPattern.exec(content)) !== null) {
		const className = match[1];
		const implements_ = match[2]?.split(",").map(s => s.trim()).filter(Boolean);
		const fields = extractClassFields(content, match.index + match[0].length);

		models[className] = {
			name: className,
			implements: implements_,
			fields,
		};
	}

	// Extract interface declarations
	const interfacePattern = /export\s+declare\s+interface\s+(\w+)(?:\s+extends\s+([\w,\s.<>]+))?\s*\{/g;
	while ((match = interfacePattern.exec(content)) !== null) {
		const interfaceName = match[1];
		const extends_ = match[2]?.split(",").map(s => s.trim()).filter(Boolean);

		if (interfaceName.includes("$metadata$")) continue;

		const fields = extractInterfaceFields(content, match.index + match[0].length);
		const isEncryptable = ENCRYPTABLE_ENTITIES.has(interfaceName);
		const variants = isEncryptable
			? [`Decrypted${interfaceName}`, `Encrypted${interfaceName}`]
			: undefined;

		if (!models[interfaceName]) {
			models[interfaceName] = {
				name: interfaceName,
				variants,
				implements: extends_,
				fields,
			};
		}
	}
}

function extractClassFields(content: string, startIdx: number): ModelField[] {
	const fields: ModelField[] = [];
	let depth = 1;
	let i = startIdx;

	while (i < content.length && depth > 0) {
		if (content[i] === "{") depth++;
		else if (content[i] === "}") depth--;
		i++;
	}

	const body = content.substring(startIdx, i - 1);
	const fieldPattern = /(?:readonly\s+)?(\w+)(\?)?:\s*([^;]+);/g;
	let match;
	while ((match = fieldPattern.exec(body)) !== null) {
		const name = match[1];
		const type = match[3].trim();
		if (name === "constructor" || name === "__doNotUseOrImplementIt") continue;
		fields.push({ name, type, description: "" });
	}

	return fields;
}

function extractInterfaceFields(content: string, startIdx: number): ModelField[] {
	return extractClassFields(content, startIdx);
}

// --- Filter Parsing ---

function extractFilters(): Record<string, FilterDoc> {
	const filters: Record<string, FilterDoc> = {};
	const filterDir = path.join(NPM_SDK, "filters");

	if (!fs.existsSync(filterDir)) {
		console.warn("Filters directory not found:", filterDir);
		return filters;
	}

	for (const file of fs.readdirSync(filterDir).sort()) {
		if (!file.endsWith(".d.mts")) continue;

		const content = fs.readFileSync(path.join(filterDir, file), "utf-8");
		const entityName = file.replace("Filters.d.mts", "").replace(".d.mts", "");

		if (!entityName || entityName === "index") continue;

		const methods: FilterMethodDoc[] = [];

		const methodPattern = /(\w+)\(([^)]*)\):\s*(?:Base)?(?:Sortable)?FilterOptions<\w+>/g;
		let match;
		while ((match = methodPattern.exec(content)) !== null) {
			const name = match[1];
			const rawParams = match[2];
			const params = rawParams
				.split(",")
				.map(p => p.trim())
				.filter(Boolean)
				.map(p => {
					const m = p.match(/^(\w+)\??:\s*(.+)$/);
					return m ? { name: m[1], type: m[2].trim() } : { name: p, type: "unknown" };
				});

			if (!methods.some(m => m.name === name)) {
				methods.push({ name, description: "", params });
			}
		}

		if (methods.length > 0) {
			filters[entityName] = { entityName, methods };
		}
	}

	return filters;
}

// --- Tutorial Parsing ---

function extractTutorials(): TutorialDoc[] {
	const tutorials: TutorialDoc[] = [];
	const docFile = path.join(CARDINAL_SDK_ROOT, "DOCUMENTATION.md");

	if (!fs.existsSync(docFile)) {
		console.warn("DOCUMENTATION.md not found:", docFile);
		return tutorials;
	}

	const content = fs.readFileSync(docFile, "utf-8");

	// Split by slug markers
	const sections = content.split(/^---\s*$/m);
	let currentSlug = "";

	for (const section of sections) {
		const slugMatch = section.match(/slug:\s*([\w-]+)/);

		if (slugMatch) {
			currentSlug = slugMatch[1];
			continue;
		}

		if (currentSlug && section.trim()) {
			const titleMatch = section.match(/^#\s+(.+)$/m);
			const currentTitle = titleMatch ? titleMatch[1] : currentSlug;

			// Extract TypeScript code blocks from TabItem sections
			const tsTabPattern = /<TabItem\s+value="typescript">([\s\S]*?)(?:<\/TabItem>|(?=<TabItem))/g;
			let tsMatch;
			const tsBlocks: string[] = [];

			while ((tsMatch = tsTabPattern.exec(section)) !== null) {
				tsBlocks.push(tsMatch[1].trim());
			}

			let tutorialContent: string;
			if (tsBlocks.length > 0) {
				tutorialContent = tsBlocks.join("\n\n");
			} else {
				tutorialContent = section
					.replace(/<LanguageTabs>/g, "")
					.replace(/<\/LanguageTabs>/g, "")
					.replace(/<TabItem\s+value="(?!typescript)[^"]*">[\s\S]*?<\/TabItem>/g, "")
					.replace(/<TabItem\s+value="typescript">/g, "")
					.replace(/<\/TabItem>/g, "")
					.replace(/import\s+.*from\s+["']@site.*["'];?\s*/g, "")
					.replace(/import\s+TabItem\s+from\s+.*\s*/g, "")
					.trim();
			}

			if (tutorialContent) {
				tutorials.push({
					slug: currentSlug,
					title: currentTitle,
					content: tutorialContent,
				});
			}

			currentSlug = "";
		}
	}

	return tutorials;
}

// --- Main ---

function main() {
	console.log("Extracting documentation...");
	console.log("  Cardinal SDK root:", CARDINAL_SDK_ROOT);
	console.log("  NPM SDK path:", NPM_SDK);

	const manifest: DocsManifest = {
		apis: extractApis(),
		models: extractModels(),
		filters: extractFilters(),
		tutorials: extractTutorials(),
	};

	console.log(`  APIs: ${Object.keys(manifest.apis).length}`);
	console.log(`  Models: ${Object.keys(manifest.models).length}`);
	console.log(`  Filters: ${Object.keys(manifest.filters).length}`);
	console.log(`  Tutorials: ${manifest.tutorials.length}`);

	fs.mkdirSync(path.dirname(OUT_FILE), { recursive: true });
	fs.writeFileSync(OUT_FILE, JSON.stringify(manifest, null, 2));
	console.log("  Written to:", OUT_FILE);
}

main();
