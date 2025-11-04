// auto-generated file
import {expectString, expectStringEnum} from '../../../internal/JsonDecodeUtils.mjs';
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['KeyValuePredicate']): KeyValuePredicate {
		return new KeyValuePredicate({
			key: expectString(json.key, true, [...path, ".key"]),
			operator: expectStringEnum(json.operator, true, [...path, ".operator"], Operator, 'Operator'),
			value: json.value,
		})
	}

}
