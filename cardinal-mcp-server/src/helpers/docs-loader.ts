import * as fs from "node:fs";
import * as path from "node:path";
import { fileURLToPath } from "node:url";

const __dirname = path.dirname(fileURLToPath(import.meta.url));

export interface ParamDoc {
	name: string;
	type: string;
	description: string;
	optional: boolean;
}

export interface MethodDoc {
	name: string;
	description: string;
	params: ParamDoc[];
	returnType: string;
	throws?: string[];
	flavours: string[];
}

export interface ApiDoc {
	name: string;
	description: string;
	isEncryptable: boolean;
	methods: MethodDoc[];
}

export interface ModelField {
	name: string;
	type: string;
	description: string;
}

export interface ModelDoc {
	name: string;
	description?: string;
	variants?: string[];
	implements?: string[];
	fields: ModelField[];
}

export interface FilterMethodDoc {
	name: string;
	description: string;
	params: Array<{ name: string; type: string }>;
	returnType?: string;
	sortable?: boolean;
	sortOrder?: string;
}

export interface FilterDoc {
	entityName: string;
	description?: string;
	methods: FilterMethodDoc[];
}

export interface TutorialDoc {
	slug: string;
	title: string;
	content: string;
}

export interface GuideDoc {
	slug: string;
	title: string;
	content: string;
	category: "how-to" | "quickstart" | "encryption" | "troubleshooting";
}

export interface DocsManifest {
	apis: Record<string, ApiDoc>;
	models: Record<string, ModelDoc>;
	filters: Record<string, FilterDoc>;
	tutorials: TutorialDoc[];
	guides: GuideDoc[];
	filterReference: string;
}

let cachedManifest: DocsManifest | null = null;

export function getManifest(): DocsManifest {
	if (!cachedManifest) {
		const manifestPath = path.resolve(__dirname, "..", "..", "generated", "docs-manifest.json");
		const raw = fs.readFileSync(manifestPath, "utf-8");
		cachedManifest = JSON.parse(raw) as DocsManifest;
	}
	return cachedManifest;
}
