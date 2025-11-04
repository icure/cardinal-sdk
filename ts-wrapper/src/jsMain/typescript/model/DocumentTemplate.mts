// auto-generated file
import {decodeBase64, encodeBase64} from '../internal/BytesEncoding.mjs';
import {expectArray, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {ReportVersion} from './base/ReportVersion.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DocumentGroup} from './embed/DocumentGroup.mjs';
import {DocumentType} from './embed/DocumentType.mjs';


export class DocumentTemplate implements StoredDocument, ICureDocument<string> {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	attachment: Int8Array | undefined = undefined;

	documentType: DocumentType | undefined = undefined;

	mainUti: string | undefined = undefined;

	name: string | undefined = undefined;

	otherUtis: Array<string> = [];

	attachmentId: string | undefined = undefined;

	version: ReportVersion | undefined = undefined;

	owner: string | undefined = undefined;

	guid: string | undefined = undefined;

	group: DocumentGroup | undefined = undefined;

	descr: string | undefined = undefined;

	disabled: string | undefined = undefined;

	specialty: CodeStub | undefined = undefined;

	constructor(partial: Partial<DocumentTemplate>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('attachment' in partial) this.attachment = partial.attachment;
		if ('documentType' in partial) this.documentType = partial.documentType;
		if ('mainUti' in partial) this.mainUti = partial.mainUti;
		if ('name' in partial) this.name = partial.name;
		if ('otherUtis' in partial && partial.otherUtis !== undefined) this.otherUtis = partial.otherUtis;
		if ('attachmentId' in partial) this.attachmentId = partial.attachmentId;
		if ('version' in partial) this.version = partial.version;
		if ('owner' in partial) this.owner = partial.owner;
		if ('guid' in partial) this.guid = partial.guid;
		if ('group' in partial) this.group = partial.group;
		if ('descr' in partial) this.descr = partial.descr;
		if ('disabled' in partial) this.disabled = partial.disabled;
		if ('specialty' in partial) this.specialty = partial.specialty;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.attachment != undefined) res['attachment'] = encodeBase64(this.attachment)
		if (this.documentType != undefined) res['documentType'] = this.documentType
		if (this.mainUti != undefined) res['mainUti'] = this.mainUti
		if (this.name != undefined) res['name'] = this.name
		res['otherUtis'] = this.otherUtis.map((x0) => x0 )
		if (this.attachmentId != undefined) res['attachmentId'] = this.attachmentId
		if (this.version != undefined) res['version'] = this.version
		if (this.owner != undefined) res['owner'] = this.owner
		if (this.guid != undefined) res['guid'] = this.guid
		if (this.group != undefined) res['group'] = this.group.toJSON()
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.disabled != undefined) res['disabled'] = this.disabled
		if (this.specialty != undefined) res['specialty'] = this.specialty.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DocumentTemplate']): DocumentTemplate {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DocumentTemplate({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy.created, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy.modified, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy.author, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy.responsible, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy.medicalLocationId, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			tags: expectArray(extractEntry(jCpy.tags, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy.codes, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy.endOfLife, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			attachment: decodeBase64(expectString(extractEntry(jCpy.attachment, 'attachment', false, path), true, [...path, ".attachment"]), [...path, ".attachment"]),
			documentType: expectStringEnum(extractEntry(jCpy.documentType, 'documentType', false, path), true, [...path, ".documentType"], DocumentType, 'DocumentType'),
			mainUti: expectString(extractEntry(jCpy.mainUti, 'mainUti', false, path), true, [...path, ".mainUti"]),
			name: expectString(extractEntry(jCpy.name, 'name', false, path), true, [...path, ".name"]),
			otherUtis: expectArray(extractEntry(jCpy.otherUtis, 'otherUtis', false, path), false, [...path, ".otherUtis"], (x0, p0) => expectString(x0, false, p0)),
			attachmentId: expectString(extractEntry(jCpy.attachmentId, 'attachmentId', false, path), true, [...path, ".attachmentId"]),
			version: expectStringEnum(extractEntry(jCpy.version, 'version', false, path), true, [...path, ".version"], ReportVersion, 'ReportVersion'),
			owner: expectString(extractEntry(jCpy.owner, 'owner', false, path), true, [...path, ".owner"]),
			guid: expectString(extractEntry(jCpy.guid, 'guid', false, path), true, [...path, ".guid"]),
			group: expectObject(extractEntry(jCpy.group, 'group', false, path), true, ignoreUnknownKeys, [...path, ".group"], DocumentGroup.fromJSON),
			descr: expectString(extractEntry(jCpy.descr, 'descr', false, path), true, [...path, ".descr"]),
			disabled: expectString(extractEntry(jCpy.disabled, 'disabled', false, path), true, [...path, ".disabled"]),
			specialty: expectObject(extractEntry(jCpy.specialty, 'specialty', false, path), true, ignoreUnknownKeys, [...path, ".specialty"], CodeStub.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DocumentTemplate at path ${path.join("")}: ${unused}`)}
		return res
	}

}
