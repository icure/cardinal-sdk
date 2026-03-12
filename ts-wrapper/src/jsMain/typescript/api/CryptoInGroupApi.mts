// auto-generated file
import {EntityWithEncryptionMetadataTypeName} from '../crypto/entities/EntityWithEncryptionMetadataTypeName.mjs';
import {RawDecryptedExchangeData} from '../crypto/entities/RawDecryptedExchangeData.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';


export interface CryptoInGroupApi {

	keylessCreateExchangeDataTo(groupId: string | undefined,
			delegate: EntityReferenceInGroup): Promise<RawDecryptedExchangeData>;

	/**
	 *
	 *  @param groupId the id of the group where the access control keys will be used.
	 *  @param entityType the type of entity to get access control keys for.
	 *  @return a List containing all the access control keys for an entity type in a specific group. This method returns a non-empty list
	 *  only if the current data owner is not anonymous
	 */
	getAccessControlKeys(groupId: string | undefined,
			entityType: EntityWithEncryptionMetadataTypeName): Promise<Array<string>>;

}
