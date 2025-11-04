// auto-generated file
import {expectArray} from '../../../internal/JsonDecodeUtils.mjs';
import {Predicate} from './Predicate.mjs';


export class OrPredicate {

	predicates: Array<Predicate> = [];

	readonly $ktClass: 'com.icure.cardinal.sdk.model.filter.predicate.OrPredicate' = 'com.icure.cardinal.sdk.model.filter.predicate.OrPredicate';

	constructor(partial: Partial<OrPredicate>) {
		if ('predicates' in partial && partial.predicates !== undefined) this.predicates = partial.predicates;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['predicates'] = this.predicates.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['OrPredicate']): OrPredicate {
		return new OrPredicate({
			predicates: expectArray(json.predicates, false, [...path, ".predicates"], (x0, p0) => Predicate.fromJSON(x0, p0)),
		})
	}

}
