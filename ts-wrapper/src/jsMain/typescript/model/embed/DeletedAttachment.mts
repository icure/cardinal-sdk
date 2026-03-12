// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  Represents metadata about an attachment that has been deleted, preserving its former storage
 *  identifiers and deletion time.
 *  /
 */
export class DeletedAttachment {

	/**
	 *
	 *  The former CouchDB attachment identifier, if the attachment was stored as a CouchDB attachment.
	 */
	couchDbAttachmentId: string | undefined = undefined;

	/**
	 *
	 *  The former object storage identifier, if the attachment was stored using the object storage
	 *  service.
	 */
	objectStoreAttachmentId: string | undefined = undefined;

	/**
	 *
	 *  The key the attachment was associated to, or null for main attachments.
	 */
	key: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the attachment was deleted.
	 */
	deletionTime: number | undefined = undefined;

	constructor(partial: Partial<DeletedAttachment>) {
		if ('couchDbAttachmentId' in partial) this.couchDbAttachmentId = partial.couchDbAttachmentId;
		if ('objectStoreAttachmentId' in partial) this.objectStoreAttachmentId = partial.objectStoreAttachmentId;
		if ('key' in partial) this.key = partial.key;
		if ('deletionTime' in partial) this.deletionTime = partial.deletionTime;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.couchDbAttachmentId != undefined) res['couchDbAttachmentId'] = this.couchDbAttachmentId
		if (this.objectStoreAttachmentId != undefined) res['objectStoreAttachmentId'] = this.objectStoreAttachmentId
		if (this.key != undefined) res['key'] = this.key
		if (this.deletionTime != undefined) res['deletionTime'] = this.deletionTime
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DeletedAttachment']): DeletedAttachment {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DeletedAttachment({
			couchDbAttachmentId: expectString(extractEntry(jCpy, 'couchDbAttachmentId', false, path), true, [...path, ".couchDbAttachmentId"]),
			objectStoreAttachmentId: expectString(extractEntry(jCpy, 'objectStoreAttachmentId', false, path), true, [...path, ".objectStoreAttachmentId"]),
			key: expectString(extractEntry(jCpy, 'key', false, path), true, [...path, ".key"]),
			deletionTime: expectNumber(extractEntry(jCpy, 'deletionTime', false, path), true, true, [...path, ".deletionTime"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DeletedAttachment at path ${path.join("")}: ${unused}`)}
		return res
	}

}
