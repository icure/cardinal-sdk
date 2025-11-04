// auto-generated file
import {decodeBase64, encodeBase64} from '../internal/BytesEncoding.mjs';
import {expectArray, expectNumber, expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DocumentGroup} from './embed/DocumentGroup.mjs';
import {FormTemplateLayout} from './embed/form/template/FormTemplateLayout.mjs';


export class FormTemplate implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	templateLayout: FormTemplateLayout | undefined = undefined;

	rawTemplateLayout: Int8Array | undefined = undefined;

	name: string | undefined = undefined;

	guid: string | undefined = undefined;

	group: DocumentGroup | undefined = undefined;

	descr: string | undefined = undefined;

	disabled: string | undefined = undefined;

	specialty: CodeStub | undefined = undefined;

	author: string | undefined = undefined;

	formInstancePreferredLocation: string | undefined = undefined;

	keyboardShortcut: string | undefined = undefined;

	shortReport: string | undefined = undefined;

	mediumReport: string | undefined = undefined;

	longReport: string | undefined = undefined;

	reports: Array<string> = [];

	tags: Array<CodeStub> = [];

	layoutAttachmentId: string | undefined = undefined;

	templateLayoutAttachmentId: string | undefined = undefined;

	constructor(partial: Partial<FormTemplate>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('templateLayout' in partial) this.templateLayout = partial.templateLayout;
		if ('rawTemplateLayout' in partial) this.rawTemplateLayout = partial.rawTemplateLayout;
		if ('name' in partial) this.name = partial.name;
		if ('guid' in partial) this.guid = partial.guid;
		if ('group' in partial) this.group = partial.group;
		if ('descr' in partial) this.descr = partial.descr;
		if ('disabled' in partial) this.disabled = partial.disabled;
		if ('specialty' in partial) this.specialty = partial.specialty;
		if ('author' in partial) this.author = partial.author;
		if ('formInstancePreferredLocation' in partial) this.formInstancePreferredLocation = partial.formInstancePreferredLocation;
		if ('keyboardShortcut' in partial) this.keyboardShortcut = partial.keyboardShortcut;
		if ('shortReport' in partial) this.shortReport = partial.shortReport;
		if ('mediumReport' in partial) this.mediumReport = partial.mediumReport;
		if ('longReport' in partial) this.longReport = partial.longReport;
		if ('reports' in partial && partial.reports !== undefined) this.reports = partial.reports;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('layoutAttachmentId' in partial) this.layoutAttachmentId = partial.layoutAttachmentId;
		if ('templateLayoutAttachmentId' in partial) this.templateLayoutAttachmentId = partial.templateLayoutAttachmentId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.templateLayout != undefined) res['templateLayout'] = this.templateLayout.toJSON()
		if (this.rawTemplateLayout != undefined) res['rawTemplateLayout'] = encodeBase64(this.rawTemplateLayout)
		if (this.name != undefined) res['name'] = this.name
		if (this.guid != undefined) res['guid'] = this.guid
		if (this.group != undefined) res['group'] = this.group.toJSON()
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.disabled != undefined) res['disabled'] = this.disabled
		if (this.specialty != undefined) res['specialty'] = this.specialty.toJSON()
		if (this.author != undefined) res['author'] = this.author
		if (this.formInstancePreferredLocation != undefined) res['formInstancePreferredLocation'] = this.formInstancePreferredLocation
		if (this.keyboardShortcut != undefined) res['keyboardShortcut'] = this.keyboardShortcut
		if (this.shortReport != undefined) res['shortReport'] = this.shortReport
		if (this.mediumReport != undefined) res['mediumReport'] = this.mediumReport
		if (this.longReport != undefined) res['longReport'] = this.longReport
		res['reports'] = this.reports.map((x0) => x0 )
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		if (this.layoutAttachmentId != undefined) res['layoutAttachmentId'] = this.layoutAttachmentId
		if (this.templateLayoutAttachmentId != undefined) res['templateLayoutAttachmentId'] = this.templateLayoutAttachmentId
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['FormTemplate']): FormTemplate {
		return new FormTemplate({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			templateLayout: FormTemplateLayout.fromJSON(json.templateLayout, [...path, ".templateLayout"]),
			rawTemplateLayout: decodeBase64(expectString(json.rawTemplateLayout, true, [...path, ".rawTemplateLayout"]), [...path, ".rawTemplateLayout"]),
			name: expectString(json.name, true, [...path, ".name"]),
			guid: expectString(json.guid, true, [...path, ".guid"]),
			group: DocumentGroup.fromJSON(json.group, [...path, ".group"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			disabled: expectString(json.disabled, true, [...path, ".disabled"]),
			specialty: CodeStub.fromJSON(json.specialty, [...path, ".specialty"]),
			author: expectString(json.author, true, [...path, ".author"]),
			formInstancePreferredLocation: expectString(json.formInstancePreferredLocation, true, [...path, ".formInstancePreferredLocation"]),
			keyboardShortcut: expectString(json.keyboardShortcut, true, [...path, ".keyboardShortcut"]),
			shortReport: expectString(json.shortReport, true, [...path, ".shortReport"]),
			mediumReport: expectString(json.mediumReport, true, [...path, ".mediumReport"]),
			longReport: expectString(json.longReport, true, [...path, ".longReport"]),
			reports: expectArray(json.reports, false, [...path, ".reports"], (x0, p0) => expectString(x0, false, p0)),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			layoutAttachmentId: expectString(json.layoutAttachmentId, true, [...path, ".layoutAttachmentId"]),
			templateLayoutAttachmentId: expectString(json.templateLayoutAttachmentId, true, [...path, ".templateLayoutAttachmentId"]),
		})
	}

}
