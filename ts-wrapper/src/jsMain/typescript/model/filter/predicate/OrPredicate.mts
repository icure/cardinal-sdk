// auto-generated file
import {expectArray, expectObject, extractEntry} from '../../../internal/JsonDecodeUtils.mjs';
import {Predicate} from './Predicate.mjs';


export class OrPredicate {

	predicates: Array<Predicate> = [];

	readonly $ktClass: 'com.icure.cardinal.sdk.model.filter.predicate.OrPredicate' = 'com.icure.cardinal.sdk.model.filter.predicate.OrPredicate';

	constructor(partial: Partial<OrPredicate>) {
		if ('predicates' in partial && partial.predicates !== undefined) this.predicates = partial.predicates;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['predicates'] = this.predicates.map((x0) => x0.toJSON() )
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.filter.predicate.OrPredicate'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['OrPredicate']): OrPredicate {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.filter.predicate.OrPredicate') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.filter.predicate.OrPredicate". The provided json doesn't represent a OrPredicate`)
		const res = new OrPredicate({
			predicates: expectArray(extractEntry(jCpy, 'predicates', false, path), false, [...path, ".predicates"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Predicate.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object OrPredicate at path ${path.join("")}: ${unused}`)}
		return res
	}

}
