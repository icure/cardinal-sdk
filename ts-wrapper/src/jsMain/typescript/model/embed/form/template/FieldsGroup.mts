// auto-generated file
import {expectArray, expectObject, expectString, extractEntry} from '../../../../internal/JsonDecodeUtils.mjs';
import {StructureElement} from './StructureElement.mjs';


export class FieldsGroup {

	group: string;

	fields: Array<StructureElement> | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup' = 'com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup';

	constructor(partial: Partial<FieldsGroup> & Pick<FieldsGroup, "group">) {
		this.group = partial.group;
		if ('fields' in partial) this.fields = partial.fields;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['group'] = this.group
		if (this.fields != undefined) res['fields'] = this.fields.map((x0) => x0.toJSON() )
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['FieldsGroup']): FieldsGroup {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup". The provided json doesn't represent a FieldsGroup`)
		const res = new FieldsGroup({
			group: expectString(extractEntry(jCpy, 'group', true, path), false, [...path, ".group"]),
			fields: expectArray(extractEntry(jCpy, 'fields', false, path), true, [...path, ".fields"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, StructureElement.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object FieldsGroup at path ${path.join("")}: ${unused}`)}
		return res
	}

}
