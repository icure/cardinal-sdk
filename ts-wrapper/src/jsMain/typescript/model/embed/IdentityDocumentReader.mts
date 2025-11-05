// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class IdentityDocumentReader {

	justificatifDocumentNumber: string | undefined = undefined;

	supportSerialNumber: string | undefined = undefined;

	timeReadingEIdDocument: number | undefined = undefined;

	eidDocumentSupportType: number = 0;

	reasonManualEncoding: number = 0;

	reasonUsingVignette: number = 0;

	constructor(partial: Partial<IdentityDocumentReader>) {
		if ('justificatifDocumentNumber' in partial) this.justificatifDocumentNumber = partial.justificatifDocumentNumber;
		if ('supportSerialNumber' in partial) this.supportSerialNumber = partial.supportSerialNumber;
		if ('timeReadingEIdDocument' in partial) this.timeReadingEIdDocument = partial.timeReadingEIdDocument;
		if ('eidDocumentSupportType' in partial && partial.eidDocumentSupportType !== undefined) this.eidDocumentSupportType = partial.eidDocumentSupportType;
		if ('reasonManualEncoding' in partial && partial.reasonManualEncoding !== undefined) this.reasonManualEncoding = partial.reasonManualEncoding;
		if ('reasonUsingVignette' in partial && partial.reasonUsingVignette !== undefined) this.reasonUsingVignette = partial.reasonUsingVignette;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.justificatifDocumentNumber != undefined) res['justificatifDocumentNumber'] = this.justificatifDocumentNumber
		if (this.supportSerialNumber != undefined) res['supportSerialNumber'] = this.supportSerialNumber
		if (this.timeReadingEIdDocument != undefined) res['timeReadingEIdDocument'] = this.timeReadingEIdDocument
		res['eidDocumentSupportType'] = this.eidDocumentSupportType
		res['reasonManualEncoding'] = this.reasonManualEncoding
		res['reasonUsingVignette'] = this.reasonUsingVignette
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['IdentityDocumentReader']): IdentityDocumentReader {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new IdentityDocumentReader({
			justificatifDocumentNumber: expectString(extractEntry(jCpy, 'justificatifDocumentNumber', false, path), true, [...path, ".justificatifDocumentNumber"]),
			supportSerialNumber: expectString(extractEntry(jCpy, 'supportSerialNumber', false, path), true, [...path, ".supportSerialNumber"]),
			timeReadingEIdDocument: expectNumber(extractEntry(jCpy, 'timeReadingEIdDocument', false, path), true, true, [...path, ".timeReadingEIdDocument"]),
			eidDocumentSupportType: expectNumber(extractEntry(jCpy, 'eidDocumentSupportType', false, path), false, true, [...path, ".eidDocumentSupportType"]),
			reasonManualEncoding: expectNumber(extractEntry(jCpy, 'reasonManualEncoding', false, path), false, true, [...path, ".reasonManualEncoding"]),
			reasonUsingVignette: expectNumber(extractEntry(jCpy, 'reasonUsingVignette', false, path), false, true, [...path, ".reasonUsingVignette"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object IdentityDocumentReader at path ${path.join("")}: ${unused}`)}
		return res
	}

}
