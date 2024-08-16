// auto-generated file
import {PropertyTypeStub} from './PropertyTypeStub.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {DecryptedTypedValue, EncryptedTypedValue, TypedValue} from './embed/TypedValue.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface PropertyStub extends Encryptable {

	id: string | undefined;

	type: PropertyTypeStub | undefined;

	typedValue: TypedValue | undefined;

	deletionDate: number | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedPropertyStub {

	id: string | undefined = undefined;

	type: PropertyTypeStub | undefined = undefined;

	typedValue: DecryptedTypedValue | undefined = undefined;

	deletionDate: number | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedPropertyStub>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('id' in partial) this.id = partial.id;
		if ('type' in partial) this.type = partial.type;
		if ('typedValue' in partial) this.typedValue = partial.typedValue;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

export class EncryptedPropertyStub {

	id: string | undefined = undefined;

	type: PropertyTypeStub | undefined = undefined;

	typedValue: EncryptedTypedValue | undefined = undefined;

	deletionDate: number | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedPropertyStub>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('id' in partial) this.id = partial.id;
		if ('type' in partial) this.type = partial.type;
		if ('typedValue' in partial) this.typedValue = partial.typedValue;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}
