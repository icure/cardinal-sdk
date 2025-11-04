// auto-generated file
import {expectArray, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Annotation} from './Annotation.mjs';
import {Range} from './Range.mjs';


export class ReferenceRange {

	low: number | undefined = undefined;

	high: number | undefined = undefined;

	stringValue: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	notes: Array<Annotation> = [];

	age: Range | undefined = undefined;

	constructor(partial: Partial<ReferenceRange>) {
		if ('low' in partial) this.low = partial.low;
		if ('high' in partial) this.high = partial.high;
		if ('stringValue' in partial) this.stringValue = partial.stringValue;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('age' in partial) this.age = partial.age;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.low != undefined) res['low'] = this.low
		if (this.high != undefined) res['high'] = this.high
		if (this.stringValue != undefined) res['stringValue'] = this.stringValue
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		if (this.age != undefined) res['age'] = this.age.toJSON()
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['ReferenceRange']): ReferenceRange {
		return new ReferenceRange({
			low: expectNumber(json.low, true, false, [...path, ".low"]),
			high: expectNumber(json.high, true, false, [...path, ".high"]),
			stringValue: expectString(json.stringValue, true, [...path, ".stringValue"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
			age: Range.fromJSON(json.age, [...path, ".age"]),
		})
	}

}
