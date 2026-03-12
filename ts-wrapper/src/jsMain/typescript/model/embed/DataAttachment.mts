// auto-generated file
import {expectArray, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  Represents a data attachment that can be stored either as a CouchDB attachment or via object
 *  storage.
 *  /
 */
export class DataAttachment {

	/**
	 *
	 *  The identifier of the attachment if stored as a CouchDB attachment.
	 */
	couchDbAttachmentId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the attachment if stored using the object storage service.
	 */
	objectStoreAttachmentId: string | undefined = undefined;

	/**
	 *
	 *  The Uniform Type Identifiers of the attachment, ordered by priority.
	 */
	utis: Array<string> = [];

	constructor(partial: Partial<DataAttachment>) {
		if ('couchDbAttachmentId' in partial) this.couchDbAttachmentId = partial.couchDbAttachmentId;
		if ('objectStoreAttachmentId' in partial) this.objectStoreAttachmentId = partial.objectStoreAttachmentId;
		if ('utis' in partial && partial.utis !== undefined) this.utis = partial.utis;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.couchDbAttachmentId != undefined) res['couchDbAttachmentId'] = this.couchDbAttachmentId
		if (this.objectStoreAttachmentId != undefined) res['objectStoreAttachmentId'] = this.objectStoreAttachmentId
		res['utis'] = this.utis.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DataAttachment']): DataAttachment {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DataAttachment({
			couchDbAttachmentId: expectString(extractEntry(jCpy, 'couchDbAttachmentId', false, path), true, [...path, ".couchDbAttachmentId"]),
			objectStoreAttachmentId: expectString(extractEntry(jCpy, 'objectStoreAttachmentId', false, path), true, [...path, ".objectStoreAttachmentId"]),
			utis: expectArray(extractEntry(jCpy, 'utis', false, path), false, [...path, ".utis"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DataAttachment at path ${path.join("")}: ${unused}`)}
		return res
	}

}
