// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any,
			path: Array<string> = ['IdentityDocumentReader']): IdentityDocumentReader {
		return new IdentityDocumentReader({
			justificatifDocumentNumber: expectString(json.justificatifDocumentNumber, true, [...path, ".justificatifDocumentNumber"]),
			supportSerialNumber: expectString(json.supportSerialNumber, true, [...path, ".supportSerialNumber"]),
			timeReadingEIdDocument: expectNumber(json.timeReadingEIdDocument, true, true, [...path, ".timeReadingEIdDocument"]),
			eidDocumentSupportType: expectNumber(json.eidDocumentSupportType, false, true, [...path, ".eidDocumentSupportType"]),
			reasonManualEncoding: expectNumber(json.reasonManualEncoding, false, true, [...path, ".reasonManualEncoding"]),
			reasonUsingVignette: expectNumber(json.reasonUsingVignette, false, true, [...path, ".reasonUsingVignette"]),
		})
	}

}
