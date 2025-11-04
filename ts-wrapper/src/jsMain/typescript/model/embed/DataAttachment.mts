// auto-generated file
import {expectArray, expectString} from '../../internal/JsonDecodeUtils.mjs';


export class DataAttachment {

	couchDbAttachmentId: string | undefined = undefined;

	objectStoreAttachmentId: string | undefined = undefined;

	utis: Array<string> = [];

	constructor(partial: Partial<DataAttachment>) {
		if ('couchDbAttachmentId' in partial) this.couchDbAttachmentId = partial.couchDbAttachmentId;
		if ('objectStoreAttachmentId' in partial) this.objectStoreAttachmentId = partial.objectStoreAttachmentId;
		if ('utis' in partial && partial.utis !== undefined) this.utis = partial.utis;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.couchDbAttachmentId != undefined) res['couchDbAttachmentId'] = this.couchDbAttachmentId
		if (this.objectStoreAttachmentId != undefined) res['objectStoreAttachmentId'] = this.objectStoreAttachmentId
		res['utis'] = this.utis.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DataAttachment']): DataAttachment {
		return new DataAttachment({
			couchDbAttachmentId: expectString(json.couchDbAttachmentId, true, [...path, ".couchDbAttachmentId"]),
			objectStoreAttachmentId: expectString(json.objectStoreAttachmentId, true, [...path, ".objectStoreAttachmentId"]),
			utis: expectArray(json.utis, false, [...path, ".utis"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}
