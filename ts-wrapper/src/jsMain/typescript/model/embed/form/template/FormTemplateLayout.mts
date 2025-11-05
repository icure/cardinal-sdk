// auto-generated file
import {expectArray, expectObject, expectString, extractEntry} from '../../../../internal/JsonDecodeUtils.mjs';
import {Action} from './Action.mjs';
import {Section} from './Section.mjs';


export class FormTemplateLayout {

	form: string;

	actions: Array<Action> = [];

	sections: Array<Section> = [];

	description: string | undefined = undefined;

	keywords: Array<string> | undefined = undefined;

	constructor(partial: Partial<FormTemplateLayout> & Pick<FormTemplateLayout, "form">) {
		this.form = partial.form;
		if ('actions' in partial && partial.actions !== undefined) this.actions = partial.actions;
		if ('sections' in partial && partial.sections !== undefined) this.sections = partial.sections;
		if ('description' in partial) this.description = partial.description;
		if ('keywords' in partial) this.keywords = partial.keywords;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['form'] = this.form
		res['actions'] = this.actions.map((x0) => x0.toJSON() )
		res['sections'] = this.sections.map((x0) => x0.toJSON() )
		if (this.description != undefined) res['description'] = this.description
		if (this.keywords != undefined) res['keywords'] = this.keywords.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['FormTemplateLayout']): FormTemplateLayout {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new FormTemplateLayout({
			form: expectString(extractEntry(jCpy, 'form', true, path), false, [...path, ".form"]),
			actions: expectArray(extractEntry(jCpy, 'actions', false, path), false, [...path, ".actions"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Action.fromJSON)),
			sections: expectArray(extractEntry(jCpy, 'sections', false, path), false, [...path, ".sections"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Section.fromJSON)),
			description: expectString(extractEntry(jCpy, 'description', false, path), true, [...path, ".description"]),
			keywords: expectArray(extractEntry(jCpy, 'keywords', false, path), true, [...path, ".keywords"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object FormTemplateLayout at path ${path.join("")}: ${unused}`)}
		return res
	}

}
