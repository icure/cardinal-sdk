// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../../../internal/JsonDecodeUtils.mjs';
import {Operator} from './Operator.mjs';


export class KeyValuePredicate {

	key: string | undefined = undefined;

	operator: Operator | undefined = undefined;

	value: any | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate' = 'com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate';

	constructor(partial: Partial<KeyValuePredicate>) {
		if ('key' in partial) this.key = partial.key;
		if ('operator' in partial) this.operator = partial.operator;
		if ('value' in partial) this.value = partial.value;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.key != undefined) res['key'] = this.key
		if (this.operator != undefined) res['operator'] = this.operator
		if (this.value != undefined) res['value'] = this.value
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['KeyValuePredicate']): KeyValuePredicate {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate') throw new Error(`Unexpected value f+or ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate"`)
		const res = new KeyValuePredicate({
			key: expectString(extractEntry(jCpy, 'key', false, path), true, [...path, ".key"]),
			operator: expectStringEnum(extractEntry(jCpy, 'operator', false, path), true, [...path, ".operator"], Operator, 'Operator'),
			value: extractEntry(jCpy, 'value', false, path),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object KeyValuePredicate at path ${path.join("")}: ${unused}`)}
		return res
	}

}
