// auto-generated file
import {EntityWithEncryptionMetadataTypeName} from '../crypto/entities/EntityWithEncryptionMetadataTypeName.mjs';
import {RawDecryptedExchangeData} from '../crypto/entities/RawDecryptedExchangeData.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';


export interface CryptoInGroupApi {

	keylessCreateExchangeDataTo(groupId: string | undefined,
			delegate: EntityReferenceInGroup): Promise<RawDecryptedExchangeData>;

	getAccessControlKeys(groupId: string | undefined,
			entityType: EntityWithEncryptionMetadataTypeName): Promise<Array<string>>;

}
