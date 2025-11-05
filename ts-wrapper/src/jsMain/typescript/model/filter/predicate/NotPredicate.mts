// auto-generated file
import {expectObject, extractEntry} from '../../../internal/JsonDecodeUtils.mjs';
import {Predicate} from './Predicate.mjs';


export class NotPredicate {

	predicate: Predicate;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.filter.predicate.NotPredicate' = 'com.icure.cardinal.sdk.model.filter.predicate.NotPredicate';

	constructor(partial: Partial<NotPredicate> & Pick<NotPredicate, "predicate">) {
		this.predicate = partial.predicate;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['predicate'] = this.predicate.toJSON()
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.filter.predicate.NotPredicate'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['NotPredicate']): NotPredicate {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.filter.predicate.NotPredicate') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.filter.predicate.NotPredicate". The provided json doesn't represent a NotPredicate`)
		const res = new NotPredicate({
			predicate: expectObject(extractEntry(jCpy, 'predicate', true, path), false, ignoreUnknownKeys, [...path, ".predicate"], Predicate.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object NotPredicate at path ${path.join("")}: ${unused}`)}
		return res
	}

}
