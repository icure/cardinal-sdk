// auto-generated file
import {EntityWithEncryptionMetadataTypeName} from '../crypto/entities/EntityWithEncryptionMetadataTypeName.mjs';
import {ExchangeDataInjectionDetails} from '../crypto/entities/ExchangeDataInjectionDetails.mjs';
import {RawDecryptedExchangeData} from '../crypto/entities/RawDecryptedExchangeData.mjs';
import {Pkcs8Bytes} from '../model/specializations/Pkcs8Bytes.mjs';
import {CryptoInGroupApi} from './CryptoInGroupApi.mjs';
import {ShamirKeysManagerApi} from './ShamirKeysManagerApi.mjs';


export interface CryptoApi {

	shamirKeysManager: ShamirKeysManagerApi;

	inGroup: CryptoInGroupApi;

	getAccessControlKeys(entityType: EntityWithEncryptionMetadataTypeName): Promise<Array<string>>;

	forceReload(): Promise<void>;

	currentDataOwnerKeys(options?: { filterTrustedKeys?: boolean }): Promise<{ [ key: string ]: { [ key: string ]: Pkcs8Bytes } }>;

	keylessCreateExchangeDataTo(delegate: string): Promise<RawDecryptedExchangeData>;

	injectExchangeData(groupId: string | undefined, details: Array<ExchangeDataInjectionDetails>,
			reEncryptWithOwnKeys: boolean): Promise<void>;

}
