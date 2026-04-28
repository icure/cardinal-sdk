// auto-generated file
import {expectArray, expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	/**
	 *
	 *
	 *   Algorithm used on the CLIENT SIDE to compress the data attachment.
	 *   Null means that the document was not compressed because the tried algorithms could not actually
	 *  compress the data
	 *   (because for example it was an already compressed format) or no algorithms were tried.
	 */
	compressionAlgorithm: string | undefined = undefined;

	/**
	 *
	 *
	 *   A string used by the SDK to mark which compression algorithms were tried.
	 *   Null means that no compression algorithms were tried.
	 *   If an SDK reads some data that is not compressed, if this value indicates that the data was
	 *  created with an older
	 *   version of the SDK then the SDK may try to use any newly available algorithms to compress the
	 *  data.
	 */
	triedCompressionAlgorithmsVersion: string | undefined = undefined;

	/**
	 *
	 *
	 *   Value computed by the backend, the actual size of the data stored for the attachment, in bytes.
	 */
	storedDataSize: number | undefined = undefined;

	/**
	 *
	 *
	 *   Value provided by the client, the real size of the data after it has been decrypted and
	 *  decompressed, in bytes.
	 *   This value is not used or verified by the backend.
	 */
	realDataSize: number | undefined = undefined;

	constructor(partial: Partial<DataAttachment>) {
		if ('couchDbAttachmentId' in partial) this.couchDbAttachmentId = partial.couchDbAttachmentId;
		if ('objectStoreAttachmentId' in partial) this.objectStoreAttachmentId = partial.objectStoreAttachmentId;
		if ('utis' in partial && partial.utis !== undefined) this.utis = partial.utis;
		if ('compressionAlgorithm' in partial) this.compressionAlgorithm = partial.compressionAlgorithm;
		if ('triedCompressionAlgorithmsVersion' in partial) this.triedCompressionAlgorithmsVersion = partial.triedCompressionAlgorithmsVersion;
		if ('storedDataSize' in partial) this.storedDataSize = partial.storedDataSize;
		if ('realDataSize' in partial) this.realDataSize = partial.realDataSize;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.couchDbAttachmentId != undefined) res['couchDbAttachmentId'] = this.couchDbAttachmentId
		if (this.objectStoreAttachmentId != undefined) res['objectStoreAttachmentId'] = this.objectStoreAttachmentId
		res['utis'] = this.utis.map((x0) => x0 )
		if (this.compressionAlgorithm != undefined) res['compressionAlgorithm'] = this.compressionAlgorithm
		if (this.triedCompressionAlgorithmsVersion != undefined) res['triedCompressionAlgorithmsVersion'] = this.triedCompressionAlgorithmsVersion
		if (this.storedDataSize != undefined) res['storedDataSize'] = this.storedDataSize
		if (this.realDataSize != undefined) res['realDataSize'] = this.realDataSize
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
			compressionAlgorithm: expectString(extractEntry(jCpy, 'compressionAlgorithm', false, path), true, [...path, ".compressionAlgorithm"]),
			triedCompressionAlgorithmsVersion: expectString(extractEntry(jCpy, 'triedCompressionAlgorithmsVersion', false, path), true, [...path, ".triedCompressionAlgorithmsVersion"]),
			storedDataSize: expectNumber(extractEntry(jCpy, 'storedDataSize', false, path), true, true, [...path, ".storedDataSize"]),
			realDataSize: expectNumber(extractEntry(jCpy, 'realDataSize', false, path), true, true, [...path, ".realDataSize"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DataAttachment at path ${path.join("")}: ${unused}`)}
		return res
	}

}
