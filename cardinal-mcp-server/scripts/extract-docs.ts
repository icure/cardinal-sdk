/**
 * Parses Kotlin KDoc + TypeScript type declarations + SDK.md to produce a documentation manifest.
 * Sources:
 *   - Kotlin API files: cardinal-sdk/src/commonMain/kotlin/.../api/*.kt  (KDoc comments)
 *   - TypeScript API types: node_modules/@icure/cardinal-sdk/api/*.d.mts (method signatures)
 *   - TypeScript model types: node_modules/@icure/cardinal-sdk/model/**  (model fields)
 *   - TypeScript filter types: node_modules/@icure/cardinal-sdk/filters/* (filter factories)
 *   - SDK.md: tutorials, how-to guides, data model docs, filter reference, encryption docs
 *
 * Output: generated/docs-manifest.json
 */
import * as fs from "node:fs";
import * as path from "node:path";

const CARDINAL_SDK_ROOT = process.env.CARDINAL_SDK_ROOT || path.resolve(import.meta.dirname!, "..", "..");
const NPM_SDK = path.resolve(import.meta.dirname!, "..", "node_modules", "@icure", "cardinal-sdk");
const SDK_MD = path.resolve(import.meta.dirname!, "..", "SDK.md");
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
	description?: string;
	variants?: string[];
	implements?: string[];
	fields: ModelField[];
}

interface FilterMethodDoc {
	name: string;
	description: string;
	params: Array<{ name: string; type: string }>;
	returnType?: string;
	sortable?: boolean;
	sortOrder?: string;
}

interface FilterDoc {
	entityName: string;
	description?: string;
	methods: FilterMethodDoc[];
}

interface TutorialDoc {
	slug: string;
	title: string;
	content: string;
}

interface GuideDoc {
	slug: string;
	title: string;
	content: string;
	category: "how-to" | "quickstart" | "encryption" | "troubleshooting";
}

interface DocsManifest {
	apis: Record<string, ApiDoc>;
	models: Record<string, ModelDoc>;
	filters: Record<string, FilterDoc>;
	tutorials: TutorialDoc[];
	guides: GuideDoc[];
	filterReference: string;
}

// =============================================================================
// SDK.md Parsing
// =============================================================================

interface SdkSection {
	source: string;
	title: string;
	body: string;
}

function parseSdkMdSections(): Map<string, SdkSection> {
	if (!fs.existsSync(SDK_MD)) {
		console.warn("SDK.md not found:", SDK_MD);
		return new Map();
	}

	const content = fs.readFileSync(SDK_MD, "utf-8");
	const sections = new Map<string, SdkSection>();

	// Split on <!-- Source: ... --> markers
	const sourcePattern = /<!-- Source: (.*?) -->/g;
	const matches = [...content.matchAll(sourcePattern)];

	for (let i = 0; i < matches.length; i++) {
		const source = matches[i][1];
		const startIdx = matches[i].index! + matches[i][0].length;
		const endIdx = i + 1 < matches.length ? matches[i + 1].index! : content.length;
		const body = content.substring(startIdx, endIdx).trim();

		const titleMatch = body.match(/^#\s+(.+)$/m);
		const title = titleMatch ? titleMatch[1].trim() : source;

		sections.set(source, { source, title, body });
	}

	return sections;
}

/**
 * Filter content to keep only TypeScript code examples and general prose.
 * Removes kotlin/python/dart language-specific blocks.
 */
function filterToTypescript(body: string): string {
	const lines = body.split("\n");
	const result: string[] = [];
	let skipLang = false;
	let inCodeBlock = false;

	for (let i = 0; i < lines.length; i++) {
		const line = lines[i];
		const trimmed = line.trim();

		// Track code blocks
		if (trimmed.startsWith("```")) {
			if (!inCodeBlock) {
				inCodeBlock = true;
				if (skipLang) {
					continue;
				}
			} else {
				inCodeBlock = false;
				if (skipLang) {
					continue;
				}
			}
		}

		if (inCodeBlock && skipLang) {
			continue;
		}

		// Detect language markers: **kotlin:**, **python:**, **dart:**
		if (/^\*\*(kotlin|python|dart):\*\*\s*$/i.test(trimmed)) {
			skipLang = true;
			continue;
		}

		// Detect TypeScript marker — keep it but mark as active language
		if (/^\*\*typescript:\*\*\s*$/i.test(trimmed)) {
			skipLang = false;
			// Don't emit the marker itself, just keep the content that follows
			continue;
		}

		// If we're in a non-TS language block (prose between language marker and code block), skip
		if (skipLang && !inCodeBlock) {
			// Check if this line is a heading or another section start — stop skipping
			if (/^#{1,4}\s/.test(trimmed) || /^<!-- Source:/.test(trimmed)) {
				skipLang = false;
			} else {
				continue;
			}
		}

		result.push(line);
	}

	return result.join("\n").trim();
}

// =============================================================================
// Kotlin KDoc Parsing
// =============================================================================

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

// =============================================================================
// TypeScript API Parsing
// =============================================================================

const ENCRYPTABLE_ENTITIES = new Set([
	"AccessLog", "CalendarItem", "Contact", "Document",
	"Form", "HealthElement", "Invoice", "MaintenanceTask", "Message",
	"Patient", "Receipt", "Topic",
]);

/**
 * Only APIs explicitly listed in tool registrations (admin-tools, data-owner-tools, crypto-tools)
 * should be included in the manifest. This excludes deprecated or internal APIs.
 */
const ALLOWED_APIS = new Set([
	// data-owner-tools
	"HealthcareParty", "Patient", "Device",
	// admin-tools
	"Group", "User", "Role", "Permission", "System", "Auth",
	// crypto-tools
	"Crypto", "Recovery", "ShamirKeysManager", "DataOwner", "CardinalMaintenanceTask",
	// Supporting entities
	"CalendarItemType", "FormTemplate", "DocumentTemplate",
	// Encryptable entity APIs (used via dispatch)
	"AccessLog", "Agenda", "CalendarItem", "Code", "Contact",
	"Document", "Form", "HealthElement", "Insurance", "Invoice",
	"MaintenanceTask", "Message", "Receipt", "Topic",
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
		if (!ALLOWED_APIS.has(entityName)) continue;
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

		apis[entityName] = {
			name: entityName + "Api",
			description: `API for ${entityName} operations`,
			isEncryptable,
			methods,
		};
	}

	return apis;
}

// =============================================================================
// TypeScript Model Parsing
// =============================================================================

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

// =============================================================================
// Filter Parsing (from TypeScript declarations)
// =============================================================================

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

// =============================================================================
// SDK.md Content Extraction
// =============================================================================

function extractTutorials(sections: Map<string, SdkSection>): TutorialDoc[] {
	const tutorials: TutorialDoc[] = [];

	for (const [source, section] of sections) {
		if (!source.startsWith("sdk/tutorial/")) continue;

		const slug = deriveSlug(source, "tutorial");
		const content = filterToTypescript(section.body);

		if (content.length > 50) {
			tutorials.push({
				slug,
				title: section.title,
				content,
			});
		}
	}

	return tutorials;
}

function extractGuides(sections: Map<string, SdkSection>): GuideDoc[] {
	const guides: GuideDoc[] = [];

	for (const [source, section] of sections) {
		let category: GuideDoc["category"] | null = null;

		if (source.startsWith("sdk/how-to/")) {
			category = "how-to";
		} else if (source.startsWith("sdk/quickstart/")) {
			category = "quickstart";
		} else if (source.startsWith("sdk/explanations/end-to-end-encryption/")) {
			category = "encryption";
		} else if (source.startsWith("sdk/troubleshooting/")) {
			category = "troubleshooting";
		}

		if (!category) continue;

		const slug = deriveSlug(source, category === "encryption" ? "encryption" : category === "quickstart" ? "quickstart" : category === "troubleshooting" ? "troubleshooting" : "how-to");
		const content = (category === "encryption" || category === "troubleshooting")
			? section.body
			: filterToTypescript(section.body);

		if (content.length > 50) {
			guides.push({
				slug,
				title: section.title,
				content,
				category,
			});
		}
	}

	return guides;
}

function deriveSlug(source: string, prefix: string): string {
	let slug = source
		.replace(/^sdk\/tutorial\//, "")
		.replace(/^sdk\/how-to\//, "")
		.replace(/^sdk\/quickstart\//, "")
		.replace(/^sdk\/explanations\/end-to-end-encryption\//, "")
		.replace(/^sdk\/troubleshooting\//, "")
		.replace(/\.mdx?$/, "")
		.replace(/\/modules\/\d+_/, "-")
		.replace(/\/index$/, "")
		.replace(/\//g, "-")
		.replace(/_/g, "-");

	// Remove leading number prefix if any
	slug = slug.replace(/^\d+-/, "");

	return `${prefix}-${slug}`.replace(/--+/g, "-").replace(/-$/, "");
}

// =============================================================================
// SDK.md Enrichment
// =============================================================================

const DATA_MODEL_TO_ENTITY: Record<string, string> = {
	"patient": "Patient",
	"contact": "Contact",
	"service": "Service",
	"content": "Content",
	"subcontact": "SubContact",
	"healthelement": "HealthElement",
	"document": "Document",
	"message": "Message",
	"topic": "Topic",
	"healthcareparty": "HealthcareParty",
	"device": "Device",
	"user": "User",
	"code": "Code",
	"codestub": "CodeStub",
	"identfier": "Identifier",
	"agenda": "Agenda",
	"calendaritem": "CalendarItem",
};

function enrichApiDescriptions(apis: Record<string, ApiDoc>, sections: Map<string, SdkSection>): void {
	for (const [source, section] of sections) {
		if (!source.startsWith("sdk/explanations/data-model/") || source.endsWith("index.mdx")) continue;

		const baseName = path.basename(source, ".mdx");
		const entityName = DATA_MODEL_TO_ENTITY[baseName];
		if (!entityName || !apis[entityName]) continue;

		const firstParagraph = extractFirstParagraph(section.body);
		if (firstParagraph) {
			apis[entityName].description = firstParagraph;
		}
	}
}

function extractFirstParagraph(body: string): string {
	const lines = body.split("\n");
	let inParagraph = false;
	const paragraphLines: string[] = [];

	for (const line of lines) {
		const trimmed = line.trim();

		if (trimmed.startsWith("# ")) continue;
		if (!inParagraph && !trimmed) continue;

		if (!inParagraph && trimmed && !trimmed.startsWith("#") && !trimmed.startsWith(">") && !trimmed.startsWith("-") && !trimmed.startsWith("```")) {
			inParagraph = true;
		}

		if (inParagraph) {
			if (!trimmed) break;
			paragraphLines.push(trimmed);
		}
	}

	return paragraphLines.join(" ")
		.replace(/\[([^\]]+)\]\([^)]+\)/g, "$1")
		.trim();
}

function enrichModelFieldDescriptions(models: Record<string, ModelDoc>, sections: Map<string, SdkSection>): void {
	for (const [source, section] of sections) {
		if (!source.startsWith("sdk/explanations/data-model/") || source.endsWith("index.mdx")) continue;

		const baseName = path.basename(source, ".mdx");
		const entityName = DATA_MODEL_TO_ENTITY[baseName];
		if (!entityName) continue;

		const entityDescription = extractFirstParagraph(section.body);
		const fieldDocs = parseFieldDocs(section.body);
		if (fieldDocs.size === 0 && !entityDescription) continue;

		const modelKeys = getModelKeysForEntity(entityName, models);
		for (const modelKey of modelKeys) {
			const model = models[modelKey];
			if (!model) continue;

			if (entityDescription) {
				model.description = entityDescription;
			}

			for (const field of model.fields) {
				const doc = fieldDocs.get(field.name);
				if (doc) {
					field.description = doc;
				}
			}
		}
	}
}

function parseFieldDocs(body: string): Map<string, string> {
	const fields = new Map<string, string>();
	const lines = body.split("\n");

	let currentField: string | null = null;
	const descLines: string[] = [];

	for (const line of lines) {
		const trimmed = line.trim();

		const fieldMatch = trimmed.match(/^###\s+(\w+)\s*$/);
		if (fieldMatch) {
			if (currentField && descLines.length > 0) {
				fields.set(currentField, descLines.join(" ").trim());
			}
			currentField = fieldMatch[1];
			descLines.length = 0;
			continue;
		}

		if (/^##\s/.test(trimmed) && currentField) {
			if (descLines.length > 0) {
				fields.set(currentField, descLines.join(" ").trim());
			}
			currentField = null;
			descLines.length = 0;
			continue;
		}

		if (currentField) {
			if (trimmed.startsWith(">")) continue;
			if (trimmed.startsWith("```")) { currentField = null; continue; }
			if (trimmed) {
				descLines.push(trimmed);
			}
		}
	}

	if (currentField && descLines.length > 0) {
		fields.set(currentField, descLines.join(" ").trim());
	}

	for (const [key, value] of fields) {
		fields.set(key, value.replace(/\[([^\]]+)\]\([^)]+\)/g, "$1"));
	}

	return fields;
}

function getModelKeysForEntity(entityName: string, models: Record<string, ModelDoc>): string[] {
	const keys: string[] = [];
	if (ENCRYPTABLE_ENTITIES.has(entityName)) {
		if (models[`Decrypted${entityName}`]) keys.push(`Decrypted${entityName}`);
		if (models[`Encrypted${entityName}`]) keys.push(`Encrypted${entityName}`);
	}
	if (models[entityName]) keys.push(entityName);
	return keys;
}

function enrichFilterDescriptions(filters: Record<string, FilterDoc>, sections: Map<string, SdkSection>): void {
	const filterSection = sections.get("sdk/explanations/everything-about-filters.mdx");
	if (!filterSection) return;

	const body = filterSection.body;

	const entityFilterPattern = /#{3,4}\s+(\w+)Filters\s*\n/g;
	let match;
	const entityPositions: Array<{ entityName: string; startIdx: number }> = [];

	while ((match = entityFilterPattern.exec(body)) !== null) {
		entityPositions.push({ entityName: match[1], startIdx: match.index + match[0].length });
	}

	for (let i = 0; i < entityPositions.length; i++) {
		const { entityName, startIdx } = entityPositions[i];
		const endIdx = i + 1 < entityPositions.length ? entityPositions[i + 1].startIdx : body.length;
		const sectionBody = body.substring(startIdx, endIdx);

		const filterKey = entityName;
		if (!filters[filterKey]) continue;

		const tableRows = parseFilterTable(sectionBody);
		for (const row of tableRows) {
			const method = filters[filterKey].methods.find(m => m.name === row.method);
			if (method) {
				method.description = row.keyParams !== "—" ? `Key parameters: ${row.keyParams}` : "";
				method.returnType = row.returnType;
				method.sortable = row.sortable;
				method.sortOrder = row.sortOrder;
			}
		}

		const introLines = sectionBody.split("\n").filter(l => l.trim() && !l.startsWith("|") && !l.startsWith(">")).slice(0, 2);
		if (introLines.length > 0 && !introLines[0].startsWith("#")) {
			filters[filterKey].description = introLines.join(" ").trim();
		}
	}

	// Propagate enrichment from ForSelf to ForDataOwner and ForDataOwnerInGroup variants
	for (const filter of Object.values(filters)) {
		const enrichedByBase = new Map<string, FilterMethodDoc>();
		for (const method of filter.methods) {
			if (method.returnType) {
				// Strip suffix to get base name
				const baseName = method.name
					.replace(/ForSelf$/, "")
					.replace(/ForDataOwner$/, "")
					.replace(/ForDataOwnerInGroup$/, "");
				if (!enrichedByBase.has(baseName)) {
					enrichedByBase.set(baseName, method);
				}
			}
		}

		for (const method of filter.methods) {
			if (method.returnType) continue; // Already enriched
			const baseName = method.name
				.replace(/ForSelf$/, "")
				.replace(/ForDataOwner$/, "")
				.replace(/ForDataOwnerInGroup$/, "");
			const source = enrichedByBase.get(baseName);
			if (source) {
				method.description = source.description;
				method.returnType = source.returnType;
				method.sortable = source.sortable;
				method.sortOrder = source.sortOrder;
			}
		}
	}
}

interface FilterTableRow {
	method: string;
	keyParams: string;
	returnType: string;
	sortable: boolean;
	sortOrder: string;
}

function parseFilterTable(sectionBody: string): FilterTableRow[] {
	const rows: FilterTableRow[] = [];
	const lines = sectionBody.split("\n");

	for (const line of lines) {
		const trimmed = line.trim();
		if (!trimmed.startsWith("|")) continue;

		const cells = trimmed.split("|").map(c => c.trim()).filter(Boolean);
		if (cells.length < 4) continue;
		if (cells[0].startsWith("-") || cells[0] === "Method") continue;

		const method = cells[0].replace(/`/g, "").trim();
		const keyParams = cells[1].trim();
		const returnType = cells[2].replace(/`/g, "").trim();
		const sortable = cells[3].trim().toLowerCase() === "yes";
		const sortOrder = cells.length > 4 ? cells[4].trim() : "—";

		if (method) {
			rows.push({ method, keyParams, returnType, sortable, sortOrder: sortOrder === "—" ? "" : sortOrder });
		}
	}

	return rows;
}

function extractFilterReference(sections: Map<string, SdkSection>): string {
	const filterSection = sections.get("sdk/explanations/everything-about-filters.mdx");
	if (!filterSection) return "";

	const body = filterSection.body;

	const entityRefIdx = body.indexOf("## Entity filter reference");
	if (entityRefIdx === -1) return filterToTypescript(body);

	return filterToTypescript(body.substring(0, entityRefIdx).trim());
}

// =============================================================================
// Main
// =============================================================================

function main() {
	console.log("Extracting documentation...");
	console.log("  Cardinal SDK root:", CARDINAL_SDK_ROOT);
	console.log("  NPM SDK path:", NPM_SDK);
	console.log("  SDK.md path:", SDK_MD);

	const sections = parseSdkMdSections();
	console.log(`  SDK.md sections: ${sections.size}`);

	const apis = extractApis();
	const models = extractModels();
	const filters = extractFilters();

	// Enrich from SDK.md
	enrichApiDescriptions(apis, sections);
	enrichModelFieldDescriptions(models, sections);
	enrichFilterDescriptions(filters, sections);

	const manifest: DocsManifest = {
		apis,
		models,
		filters,
		tutorials: extractTutorials(sections),
		guides: extractGuides(sections),
		filterReference: extractFilterReference(sections),
	};

	console.log(`  APIs: ${Object.keys(manifest.apis).length}`);
	console.log(`  Models: ${Object.keys(manifest.models).length}`);
	console.log(`  Filters: ${Object.keys(manifest.filters).length}`);
	console.log(`  Tutorials: ${manifest.tutorials.length}`);
	console.log(`  Guides: ${manifest.guides.length}`);
	console.log(`  Filter reference length: ${manifest.filterReference.length} chars`);

	let modelsWithDesc = 0, fieldsWithDesc = 0, totalFields = 0;
	for (const model of Object.values(manifest.models)) {
		if (model.description) modelsWithDesc++;
		for (const field of model.fields) {
			totalFields++;
			if (field.description) fieldsWithDesc++;
		}
	}
	console.log(`  Models with descriptions: ${modelsWithDesc}/${Object.keys(manifest.models).length}`);
	console.log(`  Fields with descriptions: ${fieldsWithDesc}/${totalFields}`);

	let filtersWithDesc = 0;
	for (const filter of Object.values(manifest.filters)) {
		for (const method of filter.methods) {
			if (method.returnType) filtersWithDesc++;
		}
	}
	console.log(`  Filter methods with enrichment: ${filtersWithDesc}`);

	fs.mkdirSync(path.dirname(OUT_FILE), { recursive: true });
	fs.writeFileSync(OUT_FILE, JSON.stringify(manifest, null, 2));
	console.log("  Written to:", OUT_FILE);
}

main();
