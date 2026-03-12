// auto-generated file
import {Delegation} from '../embed/Delegation.mjs';
import {SecurityMetadata} from '../embed/SecurityMetadata.mjs';
import {Versionable} from './Versionable.mjs';


/**
 *
 *
 *   Interface for entities that hold encryption metadata used for end-to-end encryption and access
 *  control.
 *   This includes delegation keys, encrypted foreign keys, and security metadata.
 */
export interface HasEncryptionMetadata extends Versionable<string> {

	secretForeignKeys: Array<string>;

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> };

	delegations: { [ key: string ]: Array<Delegation> };

	encryptionKeys: { [ key: string ]: Array<Delegation> };

	securityMetadata: SecurityMetadata | undefined;

}
