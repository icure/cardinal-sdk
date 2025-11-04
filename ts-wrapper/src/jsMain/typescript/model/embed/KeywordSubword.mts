// auto-generated file
import {expectArray, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['KeywordSubword']): KeywordSubword {
		return new KeywordSubword({
			value: expectString(json.value, true, [...path, ".value"]),
			subWords: expectArray(json.subWords, true, [...path, ".subWords"], (x0, p0) => KeywordSubword.fromJSON(x0, p0)),
		})
	}

}
