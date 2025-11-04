// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {AgreementAppendix} from './AgreementAppendix.mjs';


export class ParagraphAgreement {

	timestamp: number | undefined = undefined;

	paragraph: string | undefined = undefined;

	accepted: boolean | undefined = undefined;

	inTreatment: boolean | undefined = undefined;

	canceled: boolean | undefined = undefined;

	careProviderReference: string | undefined = undefined;

	decisionReference: string | undefined = undefined;

	start: number | undefined = undefined;

	end: number | undefined = undefined;

	cancelationDate: number | undefined = undefined;

	quantityValue: number | undefined = undefined;

	quantityUnit: string | undefined = undefined;

	ioRequestReference: string | undefined = undefined;

	responseType: string | undefined = undefined;

	refusalJustification: { [ key: string ]: string } | undefined = undefined;

	verses: Array<number> | undefined = undefined;

	coverageType: string | undefined = undefined;

	unitNumber: number | undefined = undefined;

	strength: number | undefined = undefined;

	strengthUnit: string | undefined = undefined;

	agreementAppendices: Array<AgreementAppendix> | undefined = undefined;

	documentId: string | undefined = undefined;

	constructor(partial: Partial<ParagraphAgreement>) {
		if ('timestamp' in partial) this.timestamp = partial.timestamp;
		if ('paragraph' in partial) this.paragraph = partial.paragraph;
		if ('accepted' in partial) this.accepted = partial.accepted;
		if ('inTreatment' in partial) this.inTreatment = partial.inTreatment;
		if ('canceled' in partial) this.canceled = partial.canceled;
		if ('careProviderReference' in partial) this.careProviderReference = partial.careProviderReference;
		if ('decisionReference' in partial) this.decisionReference = partial.decisionReference;
		if ('start' in partial) this.start = partial.start;
		if ('end' in partial) this.end = partial.end;
		if ('cancelationDate' in partial) this.cancelationDate = partial.cancelationDate;
		if ('quantityValue' in partial) this.quantityValue = partial.quantityValue;
		if ('quantityUnit' in partial) this.quantityUnit = partial.quantityUnit;
		if ('ioRequestReference' in partial) this.ioRequestReference = partial.ioRequestReference;
		if ('responseType' in partial) this.responseType = partial.responseType;
		if ('refusalJustification' in partial) this.refusalJustification = partial.refusalJustification;
		if ('verses' in partial) this.verses = partial.verses;
		if ('coverageType' in partial) this.coverageType = partial.coverageType;
		if ('unitNumber' in partial) this.unitNumber = partial.unitNumber;
		if ('strength' in partial) this.strength = partial.strength;
		if ('strengthUnit' in partial) this.strengthUnit = partial.strengthUnit;
		if ('agreementAppendices' in partial) this.agreementAppendices = partial.agreementAppendices;
		if ('documentId' in partial) this.documentId = partial.documentId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.timestamp != undefined) res['timestamp'] = this.timestamp
		if (this.paragraph != undefined) res['paragraph'] = this.paragraph
		if (this.accepted != undefined) res['accepted'] = this.accepted
		if (this.inTreatment != undefined) res['inTreatment'] = this.inTreatment
		if (this.canceled != undefined) res['canceled'] = this.canceled
		if (this.careProviderReference != undefined) res['careProviderReference'] = this.careProviderReference
		if (this.decisionReference != undefined) res['decisionReference'] = this.decisionReference
		if (this.start != undefined) res['start'] = this.start
		if (this.end != undefined) res['end'] = this.end
		if (this.cancelationDate != undefined) res['cancelationDate'] = this.cancelationDate
		if (this.quantityValue != undefined) res['quantityValue'] = this.quantityValue
		if (this.quantityUnit != undefined) res['quantityUnit'] = this.quantityUnit
		if (this.ioRequestReference != undefined) res['ioRequestReference'] = this.ioRequestReference
		if (this.responseType != undefined) res['responseType'] = this.responseType
		if (this.refusalJustification != undefined) res['refusalJustification'] = Object.fromEntries(Object.entries(this.refusalJustification).map(([k0, v0]) => [k0, v0]))
		if (this.verses != undefined) res['verses'] = this.verses.map((x0) => x0 )
		if (this.coverageType != undefined) res['coverageType'] = this.coverageType
		if (this.unitNumber != undefined) res['unitNumber'] = this.unitNumber
		if (this.strength != undefined) res['strength'] = this.strength
		if (this.strengthUnit != undefined) res['strengthUnit'] = this.strengthUnit
		if (this.agreementAppendices != undefined) res['agreementAppendices'] = this.agreementAppendices.map((x0) => x0.toJSON() )
		if (this.documentId != undefined) res['documentId'] = this.documentId
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ParagraphAgreement']): ParagraphAgreement {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ParagraphAgreement({
			timestamp: expectNumber(extractEntry(jCpy.timestamp, 'timestamp', false, path), true, true, [...path, ".timestamp"]),
			paragraph: expectString(extractEntry(jCpy.paragraph, 'paragraph', false, path), true, [...path, ".paragraph"]),
			accepted: expectBoolean(extractEntry(jCpy.accepted, 'accepted', false, path), true, [...path, ".accepted"]),
			inTreatment: expectBoolean(extractEntry(jCpy.inTreatment, 'inTreatment', false, path), true, [...path, ".inTreatment"]),
			canceled: expectBoolean(extractEntry(jCpy.canceled, 'canceled', false, path), true, [...path, ".canceled"]),
			careProviderReference: expectString(extractEntry(jCpy.careProviderReference, 'careProviderReference', false, path), true, [...path, ".careProviderReference"]),
			decisionReference: expectString(extractEntry(jCpy.decisionReference, 'decisionReference', false, path), true, [...path, ".decisionReference"]),
			start: expectNumber(extractEntry(jCpy.start, 'start', false, path), true, true, [...path, ".start"]),
			end: expectNumber(extractEntry(jCpy.end, 'end', false, path), true, true, [...path, ".end"]),
			cancelationDate: expectNumber(extractEntry(jCpy.cancelationDate, 'cancelationDate', false, path), true, true, [...path, ".cancelationDate"]),
			quantityValue: expectNumber(extractEntry(jCpy.quantityValue, 'quantityValue', false, path), true, false, [...path, ".quantityValue"]),
			quantityUnit: expectString(extractEntry(jCpy.quantityUnit, 'quantityUnit', false, path), true, [...path, ".quantityUnit"]),
			ioRequestReference: expectString(extractEntry(jCpy.ioRequestReference, 'ioRequestReference', false, path), true, [...path, ".ioRequestReference"]),
			responseType: expectString(extractEntry(jCpy.responseType, 'responseType', false, path), true, [...path, ".responseType"]),
			refusalJustification: expectMap(
				extractEntry(jCpy.refusalJustification, 'refusalJustification', false, path),
				true,
				[...path, ".refusalJustification"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			verses: expectArray(extractEntry(jCpy.verses, 'verses', false, path), true, [...path, ".verses"], (x0, p0) => expectNumber(x0, false, true, p0)),
			coverageType: expectString(extractEntry(jCpy.coverageType, 'coverageType', false, path), true, [...path, ".coverageType"]),
			unitNumber: expectNumber(extractEntry(jCpy.unitNumber, 'unitNumber', false, path), true, false, [...path, ".unitNumber"]),
			strength: expectNumber(extractEntry(jCpy.strength, 'strength', false, path), true, false, [...path, ".strength"]),
			strengthUnit: expectString(extractEntry(jCpy.strengthUnit, 'strengthUnit', false, path), true, [...path, ".strengthUnit"]),
			agreementAppendices: expectArray(extractEntry(jCpy.agreementAppendices, 'agreementAppendices', false, path), true, [...path, ".agreementAppendices"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, AgreementAppendix.fromJSON)),
			documentId: expectString(extractEntry(jCpy.documentId, 'documentId', false, path), true, [...path, ".documentId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ParagraphAgreement at path ${path.join("")}: ${unused}`)}
		return res
	}

}
