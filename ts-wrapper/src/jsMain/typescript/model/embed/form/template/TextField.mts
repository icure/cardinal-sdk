// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, extractEntry} from '../../../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  A text input field in a form template.
 *  /
 */
export class TextField {

	/**
	 *
	 *  The field identifier.
	 */
	field: string;

	/**
	 *
	 *  A short label for the field.
	 */
	shortLabel: string | undefined = undefined;

	/**
	 *
	 *  The number of rows for display.
	 */
	rows: number | undefined = undefined;

	/**
	 *
	 *  The number of columns for display.
	 */
	columns: number | undefined = undefined;

	/**
	 *
	 *  Whether the field grows dynamically.
	 */
	grows: boolean | undefined = undefined;

	/**
	 *
	 *  Whether the field supports multiline input.
	 */
	multiline: boolean | undefined = undefined;

	/**
	 *
	 *  The schema reference for validation.
	 */
	schema: string | undefined = undefined;

	/**
	 *
	 *  Tags associated with this field.
	 */
	tags: Array<string> | undefined = undefined;

	/**
	 *
	 *  Codification references for this field.
	 */
	codifications: Array<string> | undefined = undefined;

	/**
	 *
	 *  Additional options as key-value pairs.
	 */
	options: { [ key: string ]: string } | undefined = undefined;

	/**
	 *
	 *  Localized labels keyed by language code.
	 */
	labels: { [ key: string ]: string } | undefined = undefined;

	/**
	 *
	 *  The default value.
	 */
	value: string | undefined = undefined;

	/**
	 *
	 *  The unit of measurement.
	 */
	unit: string | undefined = undefined;

	/**
	 *
	 *  Whether the field is required.
	 */
	required: boolean | undefined = undefined;

	/**
	 *
	 *  A condition expression for hiding the field.
	 */
	hideCondition: string | undefined = undefined;

	/**
	 *
	 *  Whether to default to the current date/time.
	 */
	now: boolean | undefined = undefined;

	/**
	 *
	 *  Whether the field value should be translated.
	 */
	translate: boolean | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.embed.form.template.TextField' = 'com.icure.cardinal.sdk.model.embed.form.template.TextField';

	constructor(partial: Partial<TextField> & Pick<TextField, "field">) {
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

	toJSON(): object {
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
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.embed.form.template.TextField'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['TextField']): TextField {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.embed.form.template.TextField') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.embed.form.template.TextField". The provided json doesn't represent a TextField`)
		const res = new TextField({
			field: expectString(extractEntry(jCpy, 'field', true, path), false, [...path, ".field"]),
			shortLabel: expectString(extractEntry(jCpy, 'shortLabel', false, path), true, [...path, ".shortLabel"]),
			rows: expectNumber(extractEntry(jCpy, 'rows', false, path), true, true, [...path, ".rows"]),
			columns: expectNumber(extractEntry(jCpy, 'columns', false, path), true, true, [...path, ".columns"]),
			grows: expectBoolean(extractEntry(jCpy, 'grows', false, path), true, [...path, ".grows"]),
			multiline: expectBoolean(extractEntry(jCpy, 'multiline', false, path), true, [...path, ".multiline"]),
			schema: expectString(extractEntry(jCpy, 'schema', false, path), true, [...path, ".schema"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), true, [...path, ".tags"], (x0, p0) => expectString(x0, false, p0)),
			codifications: expectArray(extractEntry(jCpy, 'codifications', false, path), true, [...path, ".codifications"], (x0, p0) => expectString(x0, false, p0)),
			options: expectMap(
				extractEntry(jCpy, 'options', false, path),
				true,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			labels: expectMap(
				extractEntry(jCpy, 'labels', false, path),
				true,
				[...path, ".labels"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			value: expectString(extractEntry(jCpy, 'value', false, path), true, [...path, ".value"]),
			unit: expectString(extractEntry(jCpy, 'unit', false, path), true, [...path, ".unit"]),
			required: expectBoolean(extractEntry(jCpy, 'required', false, path), true, [...path, ".required"]),
			hideCondition: expectString(extractEntry(jCpy, 'hideCondition', false, path), true, [...path, ".hideCondition"]),
			now: expectBoolean(extractEntry(jCpy, 'now', false, path), true, [...path, ".now"]),
			translate: expectBoolean(extractEntry(jCpy, 'translate', false, path), true, [...path, ".translate"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object TextField at path ${path.join("")}: ${unused}`)}
		return res
	}

}
