// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, path: Array<string> = ['LetterValue']): LetterValue {
		return new LetterValue({
			letter: expectString(json.letter, true, [...path, ".letter"]),
			index: expectString(json.index, true, [...path, ".index"]),
			coefficient: expectNumber(json.coefficient, true, false, [...path, ".coefficient"]),
			value: expectNumber(json.value, true, false, [...path, ".value"]),
		})
	}

}
