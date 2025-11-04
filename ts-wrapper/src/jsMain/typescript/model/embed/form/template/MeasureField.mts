// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, requireEntry} from '../../../../internal/JsonDecodeUtils.mjs';


export class MeasureField {

	field: string;

	shortLabel: string | undefined = undefined;

	rows: number | undefined = undefined;

	columns: number | undefined = undefined;

	grows: boolean | undefined = undefined;

	multiline: boolean | undefined = undefined;

	schema: string | undefined = undefined;

	tags: Array<string> | undefined = undefined;

	codifications: Array<string> | undefined = undefined;

	options: { [ key: string ]: string } | undefined = undefined;

	labels: { [ key: string ]: string } | undefined = undefined;

	value: string | undefined = undefined;

	unit: string | undefined = undefined;

	required: boolean | undefined = undefined;

	hideCondition: string | undefined = undefined;

	now: boolean | undefined = undefined;

	translate: boolean | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.embed.form.template.MeasureField' = 'com.icure.cardinal.sdk.model.embed.form.template.MeasureField';

	constructor(partial: Partial<MeasureField> & Pick<MeasureField, "field">) {
		this.field = partial.field;
		if ('shortLabel' in partial) this.shortLabel = partial.shortLabel;
		if ('rows' in partial) this.rows = partial.rows;
		if ('columns' in partial) this.columns = partial.columns;
		if ('grows' in partial) this.grows = partial.grows;
		if ('multiline' in partial) this.multiline = partial.multiline;
		if ('schema' in partial) this.schema = partial.schema;
		if ('tags' in partial) this.tags = partial.tags;
		if ('codifications' in partial) this.codifications = partial.codifications;
		if ('options' in partial) this.options = partial.options;
		if ('labels' in partial) this.labels = partial.labels;
		if ('value' in partial) this.value = partial.value;
		if ('unit' in partial) this.unit = partial.unit;
		if ('required' in partial) this.required = partial.required;
		if ('hideCondition' in partial) this.hideCondition = partial.hideCondition;
		if ('now' in partial) this.now = partial.now;
		if ('translate' in partial) this.translate = partial.translate;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['field'] = this.field
		if (this.shortLabel != undefined) res['shortLabel'] = this.shortLabel
		if (this.rows != undefined) res['rows'] = this.rows
		if (this.columns != undefined) res['columns'] = this.columns
		if (this.grows != undefined) res['grows'] = this.grows
		if (this.multiline != undefined) res['multiline'] = this.multiline
		if (this.schema != undefined) res['schema'] = this.schema
		if (this.tags != undefined) res['tags'] = this.tags.map((x0) => x0 )
		if (this.codifications != undefined) res['codifications'] = this.codifications.map((x0) => x0 )
		if (this.options != undefined) res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
		if (this.labels != undefined) res['labels'] = Object.fromEntries(Object.entries(this.labels).map(([k0, v0]) => [k0, v0]))
		if (this.value != undefined) res['value'] = this.value
		if (this.unit != undefined) res['unit'] = this.unit
		if (this.required != undefined) res['required'] = this.required
		if (this.hideCondition != undefined) res['hideCondition'] = this.hideCondition
		if (this.now != undefined) res['now'] = this.now
		if (this.translate != undefined) res['translate'] = this.translate
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['MeasureField']): MeasureField {
		return new MeasureField({
			field: expectString(requireEntry(json.field, 'field', path), false, [...path, ".field"]),
			shortLabel: expectString(json.shortLabel, true, [...path, ".shortLabel"]),
			rows: expectNumber(json.rows, true, true, [...path, ".rows"]),
			columns: expectNumber(json.columns, true, true, [...path, ".columns"]),
			grows: expectBoolean(json.grows, true, [...path, ".grows"]),
			multiline: expectBoolean(json.multiline, true, [...path, ".multiline"]),
			schema: expectString(json.schema, true, [...path, ".schema"]),
			tags: expectArray(json.tags, true, [...path, ".tags"], (x0, p0) => expectString(x0, false, p0)),
			codifications: expectArray(json.codifications, true, [...path, ".codifications"], (x0, p0) => expectString(x0, false, p0)),
			options: expectMap(
				json.options,
				true,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			labels: expectMap(
				json.labels,
				true,
				[...path, ".labels"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			value: expectString(json.value, true, [...path, ".value"]),
			unit: expectString(json.unit, true, [...path, ".unit"]),
			required: expectBoolean(json.required, true, [...path, ".required"]),
			hideCondition: expectString(json.hideCondition, true, [...path, ".hideCondition"]),
			now: expectBoolean(json.now, true, [...path, ".now"]),
			translate: expectBoolean(json.translate, true, [...path, ".translate"]),
		})
	}

}
