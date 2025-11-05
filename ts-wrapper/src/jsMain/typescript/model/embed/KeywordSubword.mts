// auto-generated file
import {expectArray, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {KeywordSubword as KeywordSubword_} from './KeywordSubword.mjs';


export class KeywordSubword {

	value: string | undefined = undefined;

	subWords: Array<KeywordSubword_> | undefined = undefined;

	constructor(partial: Partial<KeywordSubword>) {
		if ('value' in partial) this.value = partial.value;
		if ('subWords' in partial) this.subWords = partial.subWords;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.value != undefined) res['value'] = this.value
		if (this.subWords != undefined) res['subWords'] = this.subWords.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['KeywordSubword']): KeywordSubword {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new KeywordSubword({
			value: expectString(extractEntry(jCpy, 'value', false, path), true, [...path, ".value"]),
			subWords: expectArray(extractEntry(jCpy, 'subWords', false, path), true, [...path, ".subWords"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, KeywordSubword.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object KeywordSubword at path ${path.join("")}: ${unused}`)}
		return res
	}

}
