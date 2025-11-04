// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ReferenceRange']): ReferenceRange {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ReferenceRange({
			low: expectNumber(extractEntry(jCpy.low, 'low', false, path), true, false, [...path, ".low"]),
			high: expectNumber(extractEntry(jCpy.high, 'high', false, path), true, false, [...path, ".high"]),
			stringValue: expectString(extractEntry(jCpy.stringValue, 'stringValue', false, path), true, [...path, ".stringValue"]),
			tags: expectArray(extractEntry(jCpy.tags, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy.codes, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			notes: expectArray(extractEntry(jCpy.notes, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			age: expectObject(extractEntry(jCpy.age, 'age', false, path), true, ignoreUnknownKeys, [...path, ".age"], Range.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ReferenceRange at path ${path.join("")}: ${unused}`)}
		return res
	}

}
