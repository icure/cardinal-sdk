// auto-generated file
import {decodeBase64, encodeBase64} from '../../internal/BytesEncoding.mjs';
import {expectArray, expectBoolean, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Measure} from './Measure.mjs';
import {Medication} from './Medication.mjs';
import {DecryptedService, EncryptedService, Service} from './Service.mjs';
import {TimeSeries} from './TimeSeries.mjs';


/**
 *
 *  Represents the value content of a medical service. A content can hold different types of values
 *  such as strings, numbers, dates, measurements, medications, time series, or compound
 *  sub-services.
 *  /
 */
export interface Content {

	/**
	 *
	 *  A string value.
	 */
	stringValue: string | undefined;

	/**
	 *
	 *  A numeric value.
	 */
	numberValue: number | undefined;

	/**
	 *
	 *  A boolean value.
	 */
	booleanValue: boolean | undefined;

	/**
	 *
	 *  An instant value.
	 */
	instantValue: number | undefined;

	/**
	 *
	 *  Value as a fuzzy date, which may contain day, month, and/or year components.
	 */
	fuzzyDateValue: number | undefined;

	/**
	 *
	 *  A binary value encoded as a byte array.
	 */
	binaryValue: Int8Array | undefined;

	/**
	 *
	 *  The identifier of a linked document.
	 */
	documentId: string | undefined;

	/**
	 *
	 *  Values of measurements recorded, including value, range, severity, and unit.
	 */
	measureValue: Measure | undefined;

	/**
	 *
	 *  The details of prescribed or suggested medication.
	 */
	medicationValue: Medication | undefined;

	/**
	 *
	 *  A high frequency time-series containing timestamps in ms and their values.
	 */
	timeSeries: TimeSeries | undefined;

	/**
	 *
	 *  A list of sub-services forming a compound value.
	 */
	compoundValue: Array<Service> | undefined;

	/**
	 *
	 *  A list of measures representing a ratio.
	 */
	ratio: Array<Measure> | undefined;

	/**
	 *
	 *  A list of measures representing a range.
	 */
	range: Array<Measure> | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents the value content of a medical service. A content can hold different types of values
 *  such as strings, numbers, dates, measurements, medications, time series, or compound
 *  sub-services.
 *  /
 */
export class DecryptedContent {

	/**
	 *
	 *  A string value.
	 */
	stringValue: string | undefined = undefined;

	/**
	 *
	 *  A numeric value.
	 */
	numberValue: number | undefined = undefined;

	/**
	 *
	 *  A boolean value.
	 */
	booleanValue: boolean | undefined = undefined;

	/**
	 *
	 *  An instant value.
	 */
	instantValue: number | undefined = undefined;

	/**
	 *
	 *  Value as a fuzzy date, which may contain day, month, and/or year components.
	 */
	fuzzyDateValue: number | undefined = undefined;

	/**
	 *
	 *  A binary value encoded as a byte array.
	 */
	binaryValue: Int8Array | undefined = undefined;

	/**
	 *
	 *  The identifier of a linked document.
	 */
	documentId: string | undefined = undefined;

	/**
	 *
	 *  Values of measurements recorded, including value, range, severity, and unit.
	 */
	measureValue: Measure | undefined = undefined;

	/**
	 *
	 *  The details of prescribed or suggested medication.
	 */
	medicationValue: Medication | undefined = undefined;

	/**
	 *
	 *  A high frequency time-series containing timestamps in ms and their values.
	 */
	timeSeries: TimeSeries | undefined = undefined;

	/**
	 *
	 *  A list of sub-services forming a compound value.
	 */
	compoundValue: Array<DecryptedService> | undefined = undefined;

	/**
	 *
	 *  A list of measures representing a ratio.
	 */
	ratio: Array<Measure> | undefined = undefined;

	/**
	 *
	 *  A list of measures representing a range.
	 */
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

	toJSON(): object {
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
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedContent']): DecryptedContent {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedContent`)
		const res = new DecryptedContent({
			stringValue: expectString(extractEntry(jCpy, 'stringValue', false, path), true, [...path, ".stringValue"]),
			numberValue: expectNumber(extractEntry(jCpy, 'numberValue', false, path), true, false, [...path, ".numberValue"]),
			booleanValue: expectBoolean(extractEntry(jCpy, 'booleanValue', false, path), true, [...path, ".booleanValue"]),
			instantValue: expectNumber(extractEntry(jCpy, 'instantValue', false, path), true, true, [...path, ".instantValue"]),
			fuzzyDateValue: expectNumber(extractEntry(jCpy, 'fuzzyDateValue', false, path), true, true, [...path, ".fuzzyDateValue"]),
			binaryValue: decodeBase64(expectString(extractEntry(jCpy, 'binaryValue', false, path), true, [...path, ".binaryValue"]), [...path, ".binaryValue"]),
			documentId: expectString(extractEntry(jCpy, 'documentId', false, path), true, [...path, ".documentId"]),
			measureValue: expectObject(extractEntry(jCpy, 'measureValue', false, path), true, ignoreUnknownKeys, [...path, ".measureValue"], Measure.fromJSON),
			medicationValue: expectObject(extractEntry(jCpy, 'medicationValue', false, path), true, ignoreUnknownKeys, [...path, ".medicationValue"], Medication.fromJSON),
			timeSeries: expectObject(extractEntry(jCpy, 'timeSeries', false, path), true, ignoreUnknownKeys, [...path, ".timeSeries"], TimeSeries.fromJSON),
			compoundValue: expectArray(extractEntry(jCpy, 'compoundValue', false, path), true, [...path, ".compoundValue"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedService.fromJSON)),
			ratio: expectArray(extractEntry(jCpy, 'ratio', false, path), true, [...path, ".ratio"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Measure.fromJSON)),
			range: expectArray(extractEntry(jCpy, 'range', false, path), true, [...path, ".range"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Measure.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedContent at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents the value content of a medical service. A content can hold different types of values
 *  such as strings, numbers, dates, measurements, medications, time series, or compound
 *  sub-services.
 *  /
 */
export class EncryptedContent {

	/**
	 *
	 *  A string value.
	 */
	stringValue: string | undefined = undefined;

	/**
	 *
	 *  A numeric value.
	 */
	numberValue: number | undefined = undefined;

	/**
	 *
	 *  A boolean value.
	 */
	booleanValue: boolean | undefined = undefined;

	/**
	 *
	 *  An instant value.
	 */
	instantValue: number | undefined = undefined;

	/**
	 *
	 *  Value as a fuzzy date, which may contain day, month, and/or year components.
	 */
	fuzzyDateValue: number | undefined = undefined;

	/**
	 *
	 *  A binary value encoded as a byte array.
	 */
	binaryValue: Int8Array | undefined = undefined;

	/**
	 *
	 *  The identifier of a linked document.
	 */
	documentId: string | undefined = undefined;

	/**
	 *
	 *  Values of measurements recorded, including value, range, severity, and unit.
	 */
	measureValue: Measure | undefined = undefined;

	/**
	 *
	 *  The details of prescribed or suggested medication.
	 */
	medicationValue: Medication | undefined = undefined;

	/**
	 *
	 *  A high frequency time-series containing timestamps in ms and their values.
	 */
	timeSeries: TimeSeries | undefined = undefined;

	/**
	 *
	 *  A list of sub-services forming a compound value.
	 */
	compoundValue: Array<EncryptedService> | undefined = undefined;

	/**
	 *
	 *  A list of measures representing a ratio.
	 */
	ratio: Array<Measure> | undefined = undefined;

	/**
	 *
	 *  A list of measures representing a range.
	 */
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

	toJSON(): object {
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
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedContent']): EncryptedContent {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedContent`)
		const res = new EncryptedContent({
			stringValue: expectString(extractEntry(jCpy, 'stringValue', false, path), true, [...path, ".stringValue"]),
			numberValue: expectNumber(extractEntry(jCpy, 'numberValue', false, path), true, false, [...path, ".numberValue"]),
			booleanValue: expectBoolean(extractEntry(jCpy, 'booleanValue', false, path), true, [...path, ".booleanValue"]),
			instantValue: expectNumber(extractEntry(jCpy, 'instantValue', false, path), true, true, [...path, ".instantValue"]),
			fuzzyDateValue: expectNumber(extractEntry(jCpy, 'fuzzyDateValue', false, path), true, true, [...path, ".fuzzyDateValue"]),
			binaryValue: decodeBase64(expectString(extractEntry(jCpy, 'binaryValue', false, path), true, [...path, ".binaryValue"]), [...path, ".binaryValue"]),
			documentId: expectString(extractEntry(jCpy, 'documentId', false, path), true, [...path, ".documentId"]),
			measureValue: expectObject(extractEntry(jCpy, 'measureValue', false, path), true, ignoreUnknownKeys, [...path, ".measureValue"], Measure.fromJSON),
			medicationValue: expectObject(extractEntry(jCpy, 'medicationValue', false, path), true, ignoreUnknownKeys, [...path, ".medicationValue"], Medication.fromJSON),
			timeSeries: expectObject(extractEntry(jCpy, 'timeSeries', false, path), true, ignoreUnknownKeys, [...path, ".timeSeries"], TimeSeries.fromJSON),
			compoundValue: expectArray(extractEntry(jCpy, 'compoundValue', false, path), true, [...path, ".compoundValue"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedService.fromJSON)),
			ratio: expectArray(extractEntry(jCpy, 'ratio', false, path), true, [...path, ".ratio"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Measure.fromJSON)),
			range: expectArray(extractEntry(jCpy, 'range', false, path), true, [...path, ".range"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Measure.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedContent at path ${path.join("")}: ${unused}`)}
		return res
	}

}
