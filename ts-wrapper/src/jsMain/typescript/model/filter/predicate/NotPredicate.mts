// auto-generated file
import {requireEntry} from '../../../internal/JsonDecodeUtils.mjs';
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['NotPredicate']): NotPredicate {
		return new NotPredicate({
			predicate: Predicate.fromJSON(requireEntry(json.predicate, 'predicate', path), [...path, ".predicate"]),
		})
	}

}
