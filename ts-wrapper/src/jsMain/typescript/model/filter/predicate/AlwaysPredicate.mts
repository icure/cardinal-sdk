// auto-generated file
import {extractEntry} from '../../../internal/JsonDecodeUtils.mjs';


export class AlwaysPredicate {

	readonly $ktClass: 'com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate' = 'com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate';

	constructor(partial: Partial<AlwaysPredicate>) {
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['AlwaysPredicate']): AlwaysPredicate {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate') throw new Error(`Unexpected value f+or ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate"`)
		const res = new AlwaysPredicate({
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object AlwaysPredicate at path ${path.join("")}: ${unused}`)}
		return res
	}

}
