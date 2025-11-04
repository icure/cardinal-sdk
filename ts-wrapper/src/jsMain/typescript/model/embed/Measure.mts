// auto-generated file
import {expectArray, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['Measure']): Measure {
		return new Measure({
			value: expectNumber(json.value, true, false, [...path, ".value"]),
			ref: expectNumber(json.ref, true, false, [...path, ".ref"]),
			severity: expectNumber(json.severity, true, true, [...path, ".severity"]),
			severityCode: expectString(json.severityCode, true, [...path, ".severityCode"]),
			evolution: expectNumber(json.evolution, true, true, [...path, ".evolution"]),
			unit: expectString(json.unit, true, [...path, ".unit"]),
			unitCodes: expectArray(json.unitCodes, true, [...path, ".unitCodes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			comment: expectString(json.comment, true, [...path, ".comment"]),
			comparator: expectString(json.comparator, true, [...path, ".comparator"]),
			sign: expectString(json.sign, true, [...path, ".sign"]),
			referenceRanges: expectArray(json.referenceRanges, false, [...path, ".referenceRanges"], (x0, p0) => ReferenceRange.fromJSON(x0, p0)),
			valueWithPrecision: ValueWithPrecision.fromJSON(json.valueWithPrecision, [...path, ".valueWithPrecision"]),
		})
	}

}
