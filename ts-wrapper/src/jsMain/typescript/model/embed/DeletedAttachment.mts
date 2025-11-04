// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';


export class DeletedAttachment {

	couchDbAttachmentId: string | undefined = undefined;

	objectStoreAttachmentId: string | undefined = undefined;

	key: string | undefined = undefined;

	deletionTime: number | undefined = undefined;

	constructor(partial: Partial<DeletedAttachment>) {
		if ('couchDbAttachmentId' in partial) this.couchDbAttachmentId = partial.couchDbAttachmentId;
		if ('objectStoreAttachmentId' in partial) this.objectStoreAttachmentId = partial.objectStoreAttachmentId;
		if ('key' in partial) this.key = partial.key;
		if ('deletionTime' in partial) this.deletionTime = partial.deletionTime;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.couchDbAttachmentId != undefined) res['couchDbAttachmentId'] = this.couchDbAttachmentId
		if (this.objectStoreAttachmentId != undefined) res['objectStoreAttachmentId'] = this.objectStoreAttachmentId
		if (this.key != undefined) res['key'] = this.key
		if (this.deletionTime != undefined) res['deletionTime'] = this.deletionTime
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DeletedAttachment']): DeletedAttachment {
		return new DeletedAttachment({
			couchDbAttachmentId: expectString(json.couchDbAttachmentId, true, [...path, ".couchDbAttachmentId"]),
			objectStoreAttachmentId: expectString(json.objectStoreAttachmentId, true, [...path, ".objectStoreAttachmentId"]),
			key: expectString(json.key, true, [...path, ".key"]),
			deletionTime: expectNumber(json.deletionTime, true, true, [...path, ".deletionTime"]),
		})
	}

}
