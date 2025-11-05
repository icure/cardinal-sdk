// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class LetterValue {

	letter: string | undefined = undefined;

	index: string | undefined = undefined;

	coefficient: number | undefined = undefined;

	value: number | undefined = undefined;

	constructor(partial: Partial<LetterValue>) {
		if ('letter' in partial) this.letter = partial.letter;
		if ('index' in partial) this.index = partial.index;
		if ('coefficient' in partial) this.coefficient = partial.coefficient;
		if ('value' in partial) this.value = partial.value;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.letter != undefined) res['letter'] = this.letter
		if (this.index != undefined) res['index'] = this.index
		if (this.coefficient != undefined) res['coefficient'] = this.coefficient
		if (this.value != undefined) res['value'] = this.value
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['LetterValue']): LetterValue {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new LetterValue({
			letter: expectString(extractEntry(jCpy, 'letter', false, path), true, [...path, ".letter"]),
			index: expectString(extractEntry(jCpy, 'index', false, path), true, [...path, ".index"]),
			coefficient: expectNumber(extractEntry(jCpy, 'coefficient', false, path), true, false, [...path, ".coefficient"]),
			value: expectNumber(extractEntry(jCpy, 'value', false, path), true, false, [...path, ".value"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object LetterValue at path ${path.join("")}: ${unused}`)}
		return res
	}

}
