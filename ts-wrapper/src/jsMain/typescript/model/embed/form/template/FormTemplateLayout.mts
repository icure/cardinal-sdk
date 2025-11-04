// auto-generated file
import {expectArray, expectString, requireEntry} from '../../../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['FormTemplateLayout']): FormTemplateLayout {
		return new FormTemplateLayout({
			form: expectString(requireEntry(json.form, 'form', path), false, [...path, ".form"]),
			actions: expectArray(json.actions, false, [...path, ".actions"], (x0, p0) => Action.fromJSON(x0, p0)),
			sections: expectArray(json.sections, false, [...path, ".sections"], (x0, p0) => Section.fromJSON(x0, p0)),
			description: expectString(json.description, true, [...path, ".description"]),
			keywords: expectArray(json.keywords, true, [...path, ".keywords"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}
