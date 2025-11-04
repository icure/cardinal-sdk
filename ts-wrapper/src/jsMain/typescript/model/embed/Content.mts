// auto-generated file
import {decodeBase64, encodeBase64} from '../../internal/BytesEncoding.mjs';
import {expectArray, expectBoolean, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
import {Measure} from './Measure.mjs';
import {Medication} from './Medication.mjs';
import {DecryptedService, EncryptedService, Service} from './Service.mjs';
import {TimeSeries} from './TimeSeries.mjs';


export interface Content {

	stringValue: string | undefined;

	numberValue: number | undefined;

	booleanValue: boolean | undefined;

	instantValue: number | undefined;

	fuzzyDateValue: number | undefined;

	binaryValue: Int8Array | undefined;

	documentId: string | undefined;

	measureValue: Measure | undefined;

	medicationValue: Medication | undefined;

	timeSeries: TimeSeries | undefined;

	compoundValue: Array<Service> | undefined;

	ratio: Array<Measure> | undefined;

	range: Array<Measure> | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedContent {

	stringValue: string | undefined = undefined;

	numberValue: number | undefined = undefined;

	booleanValue: boolean | undefined = undefined;

	instantValue: number | undefined = undefined;

	fuzzyDateValue: number | undefined = undefined;

	binaryValue: Int8Array | undefined = undefined;

	documentId: string | undefined = undefined;

	measureValue: Measure | undefined = undefined;

	medicationValue: Medication | undefined = undefined;

	timeSeries: TimeSeries | undefined = undefined;

	compoundValue: Array<DecryptedService> | undefined = undefined;

	ratio: Array<Measure> | undefined = undefined;

	range: Array<Measure> | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedContent>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('stringValue' in partial) this.stringValue = partial.stringValue;
		if ('numberValue' in partial) this.numberValue = partial.numberValue;
		if ('booleanValue' in partial) this.booleanValue = partial.booleanValue;
		if ('instantValue' in partial) this.instantValue = partial.instantValue;
		if ('fuzzyDateValue' in partial) this.fuzzyDateValue = partial.fuzzyDateValue;
		if ('binaryValue' in partial) this.binaryValue = partial.binaryValue;
		if ('documentId' in partial) this.documentId = partial.documentId;
		if ('measureValue' in partial) this.measureValue = partial.measureValue;
		if ('medicationValue' in partial) this.medicationValue = partial.medicationValue;
		if ('timeSeries' in partial) this.timeSeries = partial.timeSeries;
		if ('compoundValue' in partial) this.compoundValue = partial.compoundValue;
		if ('ratio' in partial) this.ratio = partial.ratio;
		if ('range' in partial) this.range = partial.range;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.stringValue != undefined) res['stringValue'] = this.stringValue
		if (this.numberValue != undefined) res['numberValue'] = this.numberValue
		if (this.booleanValue != undefined) res['booleanValue'] = this.booleanValue
		if (this.instantValue != undefined) res['instantValue'] = this.instantValue
		if (this.fuzzyDateValue != undefined) res['fuzzyDateValue'] = this.fuzzyDateValue
		if (this.binaryValue != undefined) res['binaryValue'] = encodeBase64(this.binaryValue)
		if (this.documentId != undefined) res['documentId'] = this.documentId
		if (this.measureValue != undefined) res['measureValue'] = this.measureValue.toJSON()
		if (this.medicationValue != undefined) res['medicationValue'] = this.medicationValue.toJSON()
		if (this.timeSeries != undefined) res['timeSeries'] = this.timeSeries.toJSON()
		if (this.compoundValue != undefined) res['compoundValue'] = this.compoundValue.map((x0) => x0.toJSON() )
		if (this.ratio != undefined) res['ratio'] = this.ratio.map((x0) => x0.toJSON() )
		if (this.range != undefined) res['range'] = this.range.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DecryptedContent']): DecryptedContent {
		return new DecryptedContent({
			stringValue: expectString(json.stringValue, true, [...path, ".stringValue"]),
			numberValue: expectNumber(json.numberValue, true, false, [...path, ".numberValue"]),
			booleanValue: expectBoolean(json.booleanValue, true, [...path, ".booleanValue"]),
			instantValue: expectNumber(json.instantValue, true, true, [...path, ".instantValue"]),
			fuzzyDateValue: expectNumber(json.fuzzyDateValue, true, true, [...path, ".fuzzyDateValue"]),
			binaryValue: decodeBase64(expectString(json.binaryValue, true, [...path, ".binaryValue"]), [...path, ".binaryValue"]),
			documentId: expectString(json.documentId, true, [...path, ".documentId"]),
			measureValue: Measure.fromJSON(json.measureValue, [...path, ".measureValue"]),
			medicationValue: Medication.fromJSON(json.medicationValue, [...path, ".medicationValue"]),
			timeSeries: TimeSeries.fromJSON(json.timeSeries, [...path, ".timeSeries"]),
			compoundValue: expectArray(json.compoundValue, true, [...path, ".compoundValue"], (x0, p0) => DecryptedService.fromJSON(x0, p0)),
			ratio: expectArray(json.ratio, true, [...path, ".ratio"], (x0, p0) => Measure.fromJSON(x0, p0)),
			range: expectArray(json.range, true, [...path, ".range"], (x0, p0) => Measure.fromJSON(x0, p0)),
		})
	}

}

export class EncryptedContent {

	stringValue: string | undefined = undefined;

	numberValue: number | undefined = undefined;

	booleanValue: boolean | undefined = undefined;

	instantValue: number | undefined = undefined;

	fuzzyDateValue: number | undefined = undefined;

	binaryValue: Int8Array | undefined = undefined;

	documentId: string | undefined = undefined;

	measureValue: Measure | undefined = undefined;

	medicationValue: Medication | undefined = undefined;

	timeSeries: TimeSeries | undefined = undefined;

	compoundValue: Array<EncryptedService> | undefined = undefined;

	ratio: Array<Measure> | undefined = undefined;

	range: Array<Measure> | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedContent>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('stringValue' in partial) this.stringValue = partial.stringValue;
		if ('numberValue' in partial) this.numberValue = partial.numberValue;
		if ('booleanValue' in partial) this.booleanValue = partial.booleanValue;
		if ('instantValue' in partial) this.instantValue = partial.instantValue;
		if ('fuzzyDateValue' in partial) this.fuzzyDateValue = partial.fuzzyDateValue;
		if ('binaryValue' in partial) this.binaryValue = partial.binaryValue;
		if ('documentId' in partial) this.documentId = partial.documentId;
		if ('measureValue' in partial) this.measureValue = partial.measureValue;
		if ('medicationValue' in partial) this.medicationValue = partial.medicationValue;
		if ('timeSeries' in partial) this.timeSeries = partial.timeSeries;
		if ('compoundValue' in partial) this.compoundValue = partial.compoundValue;
		if ('ratio' in partial) this.ratio = partial.ratio;
		if ('range' in partial) this.range = partial.range;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.stringValue != undefined) res['stringValue'] = this.stringValue
		if (this.numberValue != undefined) res['numberValue'] = this.numberValue
		if (this.booleanValue != undefined) res['booleanValue'] = this.booleanValue
		if (this.instantValue != undefined) res['instantValue'] = this.instantValue
		if (this.fuzzyDateValue != undefined) res['fuzzyDateValue'] = this.fuzzyDateValue
		if (this.binaryValue != undefined) res['binaryValue'] = encodeBase64(this.binaryValue)
		if (this.documentId != undefined) res['documentId'] = this.documentId
		if (this.measureValue != undefined) res['measureValue'] = this.measureValue.toJSON()
		if (this.medicationValue != undefined) res['medicationValue'] = this.medicationValue.toJSON()
		if (this.timeSeries != undefined) res['timeSeries'] = this.timeSeries.toJSON()
		if (this.compoundValue != undefined) res['compoundValue'] = this.compoundValue.map((x0) => x0.toJSON() )
		if (this.ratio != undefined) res['ratio'] = this.ratio.map((x0) => x0.toJSON() )
		if (this.range != undefined) res['range'] = this.range.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['EncryptedContent']): EncryptedContent {
		return new EncryptedContent({
			stringValue: expectString(json.stringValue, true, [...path, ".stringValue"]),
			numberValue: expectNumber(json.numberValue, true, false, [...path, ".numberValue"]),
			booleanValue: expectBoolean(json.booleanValue, true, [...path, ".booleanValue"]),
			instantValue: expectNumber(json.instantValue, true, true, [...path, ".instantValue"]),
			fuzzyDateValue: expectNumber(json.fuzzyDateValue, true, true, [...path, ".fuzzyDateValue"]),
			binaryValue: decodeBase64(expectString(json.binaryValue, true, [...path, ".binaryValue"]), [...path, ".binaryValue"]),
			documentId: expectString(json.documentId, true, [...path, ".documentId"]),
			measureValue: Measure.fromJSON(json.measureValue, [...path, ".measureValue"]),
			medicationValue: Medication.fromJSON(json.medicationValue, [...path, ".medicationValue"]),
			timeSeries: TimeSeries.fromJSON(json.timeSeries, [...path, ".timeSeries"]),
			compoundValue: expectArray(json.compoundValue, true, [...path, ".compoundValue"], (x0, p0) => EncryptedService.fromJSON(x0, p0)),
			ratio: expectArray(json.ratio, true, [...path, ".ratio"], (x0, p0) => Measure.fromJSON(x0, p0)),
			range: expectArray(json.range, true, [...path, ".range"], (x0, p0) => Measure.fromJSON(x0, p0)),
		})
	}

}
