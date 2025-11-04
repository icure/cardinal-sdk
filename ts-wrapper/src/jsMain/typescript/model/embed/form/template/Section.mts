// auto-generated file
import {expectArray, expectString, requireEntry} from '../../../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['section'] = this.section
		res['fields'] = this.fields.map((x0) => x0.toJSON() )
		if (this.description != undefined) res['description'] = this.description
		if (this.keywords != undefined) res['keywords'] = this.keywords.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Section']): Section {
		return new Section({
			section: expectString(requireEntry(json.section, 'section', path), false, [...path, ".section"]),
			fields: expectArray(requireEntry(json.fields, 'fields', path), false, [...path, ".fields"], (x0, p0) => StructureElement.fromJSON(x0, p0)),
			description: expectString(json.description, true, [...path, ".description"]),
			keywords: expectArray(json.keywords, true, [...path, ".keywords"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}
