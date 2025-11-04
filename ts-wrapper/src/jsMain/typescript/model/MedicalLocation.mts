// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {Named} from './base/Named.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress} from './embed/Address.mjs';


export class MedicalLocation implements StoredDocument, Named {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: string | undefined = undefined;

	description: string | undefined = undefined;

	responsible: string | undefined = undefined;

	guardPost: boolean | undefined = undefined;

	cbe: string | undefined = undefined;

	bic: string | undefined = undefined;

	bankAccount: string | undefined = undefined;

	nihii: string | undefined = undefined;

	ssin: string | undefined = undefined;

	address: DecryptedAddress | undefined = undefined;

	agendaIds: Array<string> = [];

	options: { [ key: string ]: string } = {};

	publicInformations: { [ key: string ]: string } = {};

	constructor(partial: Partial<MedicalLocation>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('description' in partial) this.description = partial.description;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('guardPost' in partial) this.guardPost = partial.guardPost;
		if ('cbe' in partial) this.cbe = partial.cbe;
		if ('bic' in partial) this.bic = partial.bic;
		if ('bankAccount' in partial) this.bankAccount = partial.bankAccount;
		if ('nihii' in partial) this.nihii = partial.nihii;
		if ('ssin' in partial) this.ssin = partial.ssin;
		if ('address' in partial) this.address = partial.address;
		if ('agendaIds' in partial && partial.agendaIds !== undefined) this.agendaIds = partial.agendaIds;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('publicInformations' in partial && partial.publicInformations !== undefined) this.publicInformations = partial.publicInformations;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.name != undefined) res['name'] = this.name
		if (this.description != undefined) res['description'] = this.description
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.guardPost != undefined) res['guardPost'] = this.guardPost
		if (this.cbe != undefined) res['cbe'] = this.cbe
		if (this.bic != undefined) res['bic'] = this.bic
		if (this.bankAccount != undefined) res['bankAccount'] = this.bankAccount
		if (this.nihii != undefined) res['nihii'] = this.nihii
		if (this.ssin != undefined) res['ssin'] = this.ssin
		if (this.address != undefined) res['address'] = this.address.toJSON()
		res['agendaIds'] = this.agendaIds.map((x0) => x0 )
		res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
		res['publicInformations'] = Object.fromEntries(Object.entries(this.publicInformations).map(([k0, v0]) => [k0, v0]))
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['MedicalLocation']): MedicalLocation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new MedicalLocation({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			name: expectString(extractEntry(jCpy.name, 'name', false, path), true, [...path, ".name"]),
			description: expectString(extractEntry(jCpy.description, 'description', false, path), true, [...path, ".description"]),
			responsible: expectString(extractEntry(jCpy.responsible, 'responsible', false, path), true, [...path, ".responsible"]),
			guardPost: expectBoolean(extractEntry(jCpy.guardPost, 'guardPost', false, path), true, [...path, ".guardPost"]),
			cbe: expectString(extractEntry(jCpy.cbe, 'cbe', false, path), true, [...path, ".cbe"]),
			bic: expectString(extractEntry(jCpy.bic, 'bic', false, path), true, [...path, ".bic"]),
			bankAccount: expectString(extractEntry(jCpy.bankAccount, 'bankAccount', false, path), true, [...path, ".bankAccount"]),
			nihii: expectString(extractEntry(jCpy.nihii, 'nihii', false, path), true, [...path, ".nihii"]),
			ssin: expectString(extractEntry(jCpy.ssin, 'ssin', false, path), true, [...path, ".ssin"]),
			address: expectObject(extractEntry(jCpy.address, 'address', false, path), true, ignoreUnknownKeys, [...path, ".address"], DecryptedAddress.fromJSON),
			agendaIds: expectArray(extractEntry(jCpy.agendaIds, 'agendaIds', false, path), false, [...path, ".agendaIds"], (x0, p0) => expectString(x0, false, p0)),
			options: expectMap(
				extractEntry(jCpy.options, 'options', false, path),
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			publicInformations: expectMap(
				extractEntry(jCpy.publicInformations, 'publicInformations', false, path),
				false,
				[...path, ".publicInformations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object MedicalLocation at path ${path.join("")}: ${unused}`)}
		return res
	}

}
