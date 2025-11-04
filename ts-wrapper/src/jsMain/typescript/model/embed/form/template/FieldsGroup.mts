// auto-generated file
import {expectArray, expectString, requireEntry} from '../../../../internal/JsonDecodeUtils.mjs';
import {StructureElement} from './StructureElement.mjs';


export class FieldsGroup {

	group: string;

	fields: Array<StructureElement> | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup' = 'com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup';

	constructor(partial: Partial<FieldsGroup> & Pick<FieldsGroup, "group">) {
		this.group = partial.group;
		if ('fields' in partial) this.fields = partial.fields;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['group'] = this.group
		if (this.fields != undefined) res['fields'] = this.fields.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['FieldsGroup']): FieldsGroup {
		return new FieldsGroup({
			group: expectString(requireEntry(json.group, 'group', path), false, [...path, ".group"]),
			fields: expectArray(json.fields, true, [...path, ".fields"], (x0, p0) => StructureElement.fromJSON(x0, p0)),
		})
	}

}
