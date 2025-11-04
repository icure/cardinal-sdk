// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {ReferenceRange} from './ReferenceRange.mjs';
import {ValueWithPrecision} from './ValueWithPrecision.mjs';


export class Measure {

	value: number | undefined = undefined;

	ref: number | undefined = undefined;

	severity: number | undefined = undefined;

	severityCode: string | undefined = undefined;

	evolution: number | undefined = undefined;

	unit: string | undefined = undefined;

	unitCodes: Array<CodeStub> | undefined = undefined;

	comment: string | undefined = undefined;

	comparator: string | undefined = undefined;

	sign: string | undefined = undefined;

	referenceRanges: Array<ReferenceRange> = [];

	valueWithPrecision: ValueWithPrecision | undefined = undefined;

	constructor(partial: Partial<Measure>) {
		if ('value' in partial) this.value = partial.value;
		if ('ref' in partial) this.ref = partial.ref;
		if ('severity' in partial) this.severity = partial.severity;
		if ('severityCode' in partial) this.severityCode = partial.severityCode;
		if ('evolution' in partial) this.evolution = partial.evolution;
		if ('unit' in partial) this.unit = partial.unit;
		if ('unitCodes' in partial) this.unitCodes = partial.unitCodes;
		if ('comment' in partial) this.comment = partial.comment;
		if ('comparator' in partial) this.comparator = partial.comparator;
		if ('sign' in partial) this.sign = partial.sign;
		if ('referenceRanges' in partial && partial.referenceRanges !== undefined) this.referenceRanges = partial.referenceRanges;
		if ('valueWithPrecision' in partial) this.valueWithPrecision = partial.valueWithPrecision;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.value != undefined) res['value'] = this.value
		if (this.ref != undefined) res['ref'] = this.ref
		if (this.severity != undefined) res['severity'] = this.severity
		if (this.severityCode != undefined) res['severityCode'] = this.severityCode
		if (this.evolution != undefined) res['evolution'] = this.evolution
		if (this.unit != undefined) res['unit'] = this.unit
		if (this.unitCodes != undefined) res['unitCodes'] = this.unitCodes.map((x0) => x0.toJSON() )
		if (this.comment != undefined) res['comment'] = this.comment
		if (this.comparator != undefined) res['comparator'] = this.comparator
		if (this.sign != undefined) res['sign'] = this.sign
		res['referenceRanges'] = this.referenceRanges.map((x0) => x0.toJSON() )
		if (this.valueWithPrecision != undefined) res['valueWithPrecision'] = this.valueWithPrecision.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Measure']): Measure {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Measure({
			value: expectNumber(extractEntry(jCpy.value, 'value', false, path), true, false, [...path, ".value"]),
			ref: expectNumber(extractEntry(jCpy.ref, 'ref', false, path), true, false, [...path, ".ref"]),
			severity: expectNumber(extractEntry(jCpy.severity, 'severity', false, path), true, true, [...path, ".severity"]),
			severityCode: expectString(extractEntry(jCpy.severityCode, 'severityCode', false, path), true, [...path, ".severityCode"]),
			evolution: expectNumber(extractEntry(jCpy.evolution, 'evolution', false, path), true, true, [...path, ".evolution"]),
			unit: expectString(extractEntry(jCpy.unit, 'unit', false, path), true, [...path, ".unit"]),
			unitCodes: expectArray(extractEntry(jCpy.unitCodes, 'unitCodes', false, path), true, [...path, ".unitCodes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			comment: expectString(extractEntry(jCpy.comment, 'comment', false, path), true, [...path, ".comment"]),
			comparator: expectString(extractEntry(jCpy.comparator, 'comparator', false, path), true, [...path, ".comparator"]),
			sign: expectString(extractEntry(jCpy.sign, 'sign', false, path), true, [...path, ".sign"]),
			referenceRanges: expectArray(extractEntry(jCpy.referenceRanges, 'referenceRanges', false, path), false, [...path, ".referenceRanges"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, ReferenceRange.fromJSON)),
			valueWithPrecision: expectObject(extractEntry(jCpy.valueWithPrecision, 'valueWithPrecision', false, path), true, ignoreUnknownKeys, [...path, ".valueWithPrecision"], ValueWithPrecision.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Measure at path ${path.join("")}: ${unused}`)}
		return res
	}

}
