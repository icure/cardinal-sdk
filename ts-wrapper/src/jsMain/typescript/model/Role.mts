// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';


export class Role implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: string | undefined = undefined;

	inheritableUpTo: number | undefined = undefined;

	permissions: Array<string> = [];

	constructor(partial: Partial<Role>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('inheritableUpTo' in partial) this.inheritableUpTo = partial.inheritableUpTo;
		if ('permissions' in partial && partial.permissions !== undefined) this.permissions = partial.permissions;
	}

}
