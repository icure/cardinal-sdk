// auto-generated file
import {expectArray, expectObject, expectString, extractEntry} from '../../../../internal/JsonDecodeUtils.mjs';
import {StructureElement} from './StructureElement.mjs';


export class Section {

	section: string;

	fields: Array<StructureElement>;

	description: string | undefined = undefined;

	keywords: Array<string> | undefined = undefined;

	constructor(partial: Partial<Section> & Pick<Section, "section" | "fields">) {
		this.section = partial.section;
		this.fields = partial.fields;
		if ('description' in partial) this.description = partial.description;
		if ('keywords' in partial) this.keywords = partial.keywords;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['section'] = this.section
		res['fields'] = this.fields.map((x0) => x0.toJSON() )
		if (this.description != undefined) res['description'] = this.description
		if (this.keywords != undefined) res['keywords'] = this.keywords.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Section']): Section {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Section({
			section: expectString(extractEntry(jCpy, 'section', true, path), false, [...path, ".section"]),
			fields: expectArray(extractEntry(jCpy, 'fields', true, path), false, [...path, ".fields"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, StructureElement.fromJSON)),
			description: expectString(extractEntry(jCpy, 'description', false, path), true, [...path, ".description"]),
			keywords: expectArray(extractEntry(jCpy, 'keywords', false, path), true, [...path, ".keywords"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Section at path ${path.join("")}: ${unused}`)}
		return res
	}

}
