// auto-generated file
import {EntityWithEncryptionMetadataTypeName} from '../crypto/entities/EntityWithEncryptionMetadataTypeName.mjs';
import {ExchangeDataInjectionDetails} from '../crypto/entities/ExchangeDataInjectionDetails.mjs';
import {RawDecryptedExchangeData} from '../crypto/entities/RawDecryptedExchangeData.mjs';
import {Pkcs8Bytes} from '../model/specializations/Pkcs8Bytes.mjs';
import {CryptoInGroupApi} from './CryptoInGroupApi.mjs';
import {ShamirKeysManagerApi} from './ShamirKeysManagerApi.mjs';


/**
 *
 *  Gives access to cryptographic operations that should be managed by the user, such as the creation of recovery data for keys.
 */
export interface CryptoApi {

	shamirKeysManager: ShamirKeysManagerApi;

	inGroup: CryptoInGroupApi;

	/**
	 *
	 *  @param entityType the type of entity to get access control keys for.
	 *  @return a List containing all the access control keys for an entity type in the current group. This method returns a non-empty list
	 *  only if the current data owner is not anonymous
	 */
	getAccessControlKeys(entityType: EntityWithEncryptionMetadataTypeName): Promise<Array<string>>;

	/**
	 *
	 *  Clears the cache of the api and reloads the user keys and exchange keys.
	 *  In some cases this method could allow users to retrieve and decrypt data that was shared with them after the api
	 *  instantiation or last reload.
	 */
	forceReload(): Promise<void>;

	/**
	 *
	 *  Get the available keys for the current data and his parents (if using hierarchical data owners).
	 *  The result is a map associating the current data owner or parent id to a map containing all the available keys
	 *  for that data owner.
	 *  The keys map associates the key fingerprint to the pkcs8 bytes of the private key.
	 *  @param filterTrustedKeys if true (default) only keys fully trusted by this instance of the sdk will be returned.
	 *  Otherwise, also unverified keys may be returned.
	 *  @return the available keys
	 */
	currentDataOwnerKeys(options?: { filterTrustedKeys?: boolean }): Promise<{ [ key: string ]: { [ key: string ]: Pkcs8Bytes } }>;

	keylessCreateExchangeDataTo(delegate: string): Promise<RawDecryptedExchangeData>;

	/**
	 *
	 *  Allows injecting exchange data that would not be readable or decryptable by the SDK otherwise.
	 *  IMPORTANT: the SDK will not check that the provided exchange data details are valid for the provided exchange data
	 *  id. Providing invalid details could cause permanent corruption of data.
	 *  @param details the details of the exchange data to inject. Set verified to true to allow this data to be used for
	 *  encryption of new entity.
	 *  @param reEncryptWithOwnKeys can only be true if the api wasn't initialized in keyless mode. If true the injected
	 *  data will be re-encrypted with also the current data owner key, allowing to access it in future instances without
	 *  having to re-inject it (as long as the instance has access to the current private key).
	 */
	injectExchangeData(groupId: string | undefined, details: Array<ExchangeDataInjectionDetails>,
			reEncryptWithOwnKeys: boolean): Promise<void>;

}
