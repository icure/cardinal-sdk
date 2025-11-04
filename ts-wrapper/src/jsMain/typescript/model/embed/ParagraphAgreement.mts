// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['ParagraphAgreement']): ParagraphAgreement {
		return new ParagraphAgreement({
			timestamp: expectNumber(json.timestamp, true, true, [...path, ".timestamp"]),
			paragraph: expectString(json.paragraph, true, [...path, ".paragraph"]),
			accepted: expectBoolean(json.accepted, true, [...path, ".accepted"]),
			inTreatment: expectBoolean(json.inTreatment, true, [...path, ".inTreatment"]),
			canceled: expectBoolean(json.canceled, true, [...path, ".canceled"]),
			careProviderReference: expectString(json.careProviderReference, true, [...path, ".careProviderReference"]),
			decisionReference: expectString(json.decisionReference, true, [...path, ".decisionReference"]),
			start: expectNumber(json.start, true, true, [...path, ".start"]),
			end: expectNumber(json.end, true, true, [...path, ".end"]),
			cancelationDate: expectNumber(json.cancelationDate, true, true, [...path, ".cancelationDate"]),
			quantityValue: expectNumber(json.quantityValue, true, false, [...path, ".quantityValue"]),
			quantityUnit: expectString(json.quantityUnit, true, [...path, ".quantityUnit"]),
			ioRequestReference: expectString(json.ioRequestReference, true, [...path, ".ioRequestReference"]),
			responseType: expectString(json.responseType, true, [...path, ".responseType"]),
			refusalJustification: expectMap(
				json.refusalJustification,
				true,
				[...path, ".refusalJustification"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			verses: expectArray(json.verses, true, [...path, ".verses"], (x0, p0) => expectNumber(x0, false, true, p0)),
			coverageType: expectString(json.coverageType, true, [...path, ".coverageType"]),
			unitNumber: expectNumber(json.unitNumber, true, false, [...path, ".unitNumber"]),
			strength: expectNumber(json.strength, true, false, [...path, ".strength"]),
			strengthUnit: expectString(json.strengthUnit, true, [...path, ".strengthUnit"]),
			agreementAppendices: expectArray(json.agreementAppendices, true, [...path, ".agreementAppendices"], (x0, p0) => AgreementAppendix.fromJSON(x0, p0)),
			documentId: expectString(json.documentId, true, [...path, ".documentId"]),
		})
	}

}
