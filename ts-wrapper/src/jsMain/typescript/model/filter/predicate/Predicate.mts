// auto-generated file
import {AlwaysPredicate} from './AlwaysPredicate.mjs';
import {AndPredicate} from './AndPredicate.mjs';
import {KeyValuePredicate} from './KeyValuePredicate.mjs';
import {NotPredicate} from './NotPredicate.mjs';
import {OrPredicate} from './OrPredicate.mjs';


export type Predicate = AndPredicate | NotPredicate | OrPredicate | AlwaysPredicate | KeyValuePredicate;

export namespace Predicate {

	export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Predicate']): Predicate {
		switch ((json as Predicate).$ktClass) {
			case 'com.icure.cardinal.sdk.model.filter.predicate.AndPredicate': return AndPredicate.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.filter.predicate.NotPredicate': return NotPredicate.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.filter.predicate.OrPredicate': return OrPredicate.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate': return AlwaysPredicate.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate': return KeyValuePredicate.fromJSON(json, ignoreUnknownKeys)
			default: throw new Error('Unexpected discriminator for Predicate: ' + json.$ktClass)
		}
	}

}
