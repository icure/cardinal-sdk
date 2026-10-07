// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {AgreementAppendix} from './AgreementAppendix.mjs';


/**
 *
 *  Represents an agreement on a specific paragraph of a regulation, including approval status,
 *  validity period, quantities, and any refusal justification.
 *  /
 */
export class ParagraphAgreement {

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the agreement.
	 */
	timestamp: number | undefined = undefined;

	/**
	 *
	 *  The paragraph reference.
	 */
	paragraph: string | undefined = undefined;

	/**
	 *
	 *  Whether the agreement was accepted.
	 */
	accepted: boolean | undefined = undefined;

	/**
	 *
	 *  Whether the patient is currently in treatment.
	 */
	inTreatment: boolean | undefined = undefined;

	/**
	 *
	 *  Whether the agreement was canceled.
	 */
	canceled: boolean | undefined = undefined;

	/**
	 *
	 *  The care provider reference for this agreement.
	 */
	careProviderReference: string | undefined = undefined;

	/**
	 *
	 *  The decision reference.
	 */
	decisionReference: string | undefined = undefined;

	/**
	 *
	 *  The start date of the agreement period.
	 */
	start: number | undefined = undefined;

	/**
	 *
	 *  The end date of the agreement period.
	 */
	end: number | undefined = undefined;

	/**
	 *
	 *  The date of cancellation.
	 */
	cancelationDate: number | undefined = undefined;

	/**
	 *
	 *  The quantity value of the agreement.
	 */
	quantityValue: number | undefined = undefined;

	/**
	 *
	 *  The unit of the quantity.
	 */
	quantityUnit: string | undefined = undefined;

	/**
	 *
	 *  The IO request reference.
	 */
	ioRequestReference: string | undefined = undefined;

	/**
	 *
	 *  The type of response received.
	 */
	responseType: string | undefined = undefined;

	/**
	 *
	 *  Localized justification for refusal, keyed by language code.
	 */
	refusalJustification: { [ key: string ]: string } | undefined = undefined;

	/**
	 *
	 *  The set of verse numbers covered by this agreement.
	 */
	verses: Array<number> | undefined = undefined;

	/**
	 *
	 *  The type of coverage.
	 */
	coverageType: string | undefined = undefined;

	/**
	 *
	 *  The number of units.
	 */
	unitNumber: number | undefined = undefined;

	/**
	 *
	 *  The strength value.
	 */
	strength: number | undefined = undefined;

	/**
	 *
	 *  The unit of strength.
	 */
	strengthUnit: string | undefined = undefined;

	/**
	 *
	 *  The list of agreement appendices.
	 */
	agreementAppendices: Array<AgreementAppendix> | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated document.
	 */
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

	toJSON(): object {
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
			timestamp: expectNumber(extractEntry(jCpy, 'timestamp', false, path), true, true, [...path, ".timestamp"]),
			paragraph: expectString(extractEntry(jCpy, 'paragraph', false, path), true, [...path, ".paragraph"]),
			accepted: expectBoolean(extractEntry(jCpy, 'accepted', false, path), true, [...path, ".accepted"]),
			inTreatment: expectBoolean(extractEntry(jCpy, 'inTreatment', false, path), true, [...path, ".inTreatment"]),
			canceled: expectBoolean(extractEntry(jCpy, 'canceled', false, path), true, [...path, ".canceled"]),
			careProviderReference: expectString(extractEntry(jCpy, 'careProviderReference', false, path), true, [...path, ".careProviderReference"]),
			decisionReference: expectString(extractEntry(jCpy, 'decisionReference', false, path), true, [...path, ".decisionReference"]),
			start: expectNumber(extractEntry(jCpy, 'start', false, path), true, true, [...path, ".start"]),
			end: expectNumber(extractEntry(jCpy, 'end', false, path), true, true, [...path, ".end"]),
			cancelationDate: expectNumber(extractEntry(jCpy, 'cancelationDate', false, path), true, true, [...path, ".cancelationDate"]),
			quantityValue: expectNumber(extractEntry(jCpy, 'quantityValue', false, path), true, false, [...path, ".quantityValue"]),
			quantityUnit: expectString(extractEntry(jCpy, 'quantityUnit', false, path), true, [...path, ".quantityUnit"]),
			ioRequestReference: expectString(extractEntry(jCpy, 'ioRequestReference', false, path), true, [...path, ".ioRequestReference"]),
			responseType: expectString(extractEntry(jCpy, 'responseType', false, path), true, [...path, ".responseType"]),
			refusalJustification: expectMap(
				extractEntry(jCpy, 'refusalJustification', false, path),
				true,
				[...path, ".refusalJustification"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			verses: expectArray(extractEntry(jCpy, 'verses', false, path), true, [...path, ".verses"], (x0, p0) => expectNumber(x0, false, true, p0)),
			coverageType: expectString(extractEntry(jCpy, 'coverageType', false, path), true, [...path, ".coverageType"]),
			unitNumber: expectNumber(extractEntry(jCpy, 'unitNumber', false, path), true, false, [...path, ".unitNumber"]),
			strength: expectNumber(extractEntry(jCpy, 'strength', false, path), true, false, [...path, ".strength"]),
			strengthUnit: expectString(extractEntry(jCpy, 'strengthUnit', false, path), true, [...path, ".strengthUnit"]),
			agreementAppendices: expectArray(extractEntry(jCpy, 'agreementAppendices', false, path), true, [...path, ".agreementAppendices"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, AgreementAppendix.fromJSON)),
			documentId: expectString(extractEntry(jCpy, 'documentId', false, path), true, [...path, ".documentId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ParagraphAgreement at path ${path.join("")}: ${unused}`)}
		return res
	}

}
