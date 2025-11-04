// auto-generated file
import {expectArray, expectObject, extractEntry} from '../../../internal/JsonDecodeUtils.mjs';
import {Predicate} from './Predicate.mjs';


export class AndPredicate {

	predicates: Array<Predicate> = [];

	readonly $ktClass: 'com.icure.cardinal.sdk.model.filter.predicate.AndPredicate' = 'com.icure.cardinal.sdk.model.filter.predicate.AndPredicate';

	constructor(partial: Partial<AndPredicate>) {
		if ('predicates' in partial && partial.predicates !== undefined) this.predicates = partial.predicates;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['predicates'] = this.predicates.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['AndPredicate']): AndPredicate {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new AndPredicate({
			predicates: expectArray(extractEntry(jCpy.predicates, 'predicates', false, path), false, [...path, ".predicates"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Predicate.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object AndPredicate at path ${path.join("")}: ${unused}`)}
		return res
	}

}
