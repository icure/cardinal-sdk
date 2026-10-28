// auto-generated file
import {HasEncryptionMetadata} from '../../model/base/HasEncryptionMetadata.mjs';
import {Delegation} from '../../model/embed/Delegation.mjs';
import {SecurityMetadata} from '../../model/embed/SecurityMetadata.mjs';
import {randomUuid} from '../../utils/Id.mjs';


export class EntityWithEncryptionMetadataStub implements HasEncryptionMetadata {

	id: string;

	rev: string | undefined;

	secretForeignKeys: Array<string>;

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> };

	delegations: { [ key: string ]: Array<Delegation> };

	encryptionKeys: { [ key: string ]: Array<Delegation> };

	securityMetadata: SecurityMetadata | undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub' = 'com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub';

	constructor(partial: Partial<EntityWithEncryptionMetadataStub> & Pick<EntityWithEncryptionMetadataStub, "rev" | "secretForeignKeys" | "cryptedForeignKeys" | "delegations" | "encryptionKeys" | "securityMetadata">) {
		this.id = partial.id ?? randomUuid();
		this.rev = partial.rev;
		this.secretForeignKeys = partial.secretForeignKeys;
		this.cryptedForeignKeys = partial.cryptedForeignKeys;
		this.delegations = partial.delegations;
		this.encryptionKeys = partial.encryptionKeys;
		this.securityMetadata = partial.securityMetadata;
	}

}
