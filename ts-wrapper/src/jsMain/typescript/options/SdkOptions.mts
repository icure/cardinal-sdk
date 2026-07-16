import {PartialXCryptoService} from "../crypto/CryptoService.mjs";
import {UserGroup} from "../model/UserGroup.mjs";
import {KeyStorageFacade} from "../storage/StorageFacade.mjs";
import {CryptoStrategies} from "../crypto/CryptoStrategies.mjs";
import {CardinalKeyStorageOptions} from "../cardinal-sdk-ts.mjs";

export interface SdkOptions {
  /**
   * Has only effect when logging in as an hcp user.
   *
   * If true the api will be initialized in a hierarchical mode, where each data owner is considered to have access
   * to all data of his parents (requires corresponding permission on the server side).
   * In this case the sdk will also expect to have access to at least a key for each parent data owner of the current
   * user.
   *
   * If false or undefined the api will ignore the data owner hierarchies.
   * Each data owner is considered to have access only to data shared explicitly with him, and has access only to his
   * own keys.
   */
  readonly useHierarchicalDataOwners?: boolean
  /**
   * If true (default) the sdk will automatically create the transfer keys for the current user if a new keypair is
   * created.
   */
  readonly createTransferKeys?: boolean
  /**
   * Service for encryption primitives.
   */
  readonly cryptoService?: PartialXCryptoService
  /**
   * An instance of iCure SDK is initialized for working as a specific user in a single group.
   * However, the user credentials may match multiple users in different groups (but at most one per group).
   * If that is the case, this function will be used to pick the actual user for which the sdk will be initialized.
   *
   * This is mandatory in multi-group applications, where a single user could exist in multiple groups.
   * If this parameter is null and the user credentials match multiple users the api initialisation will fail.
   * In single-group applications this parameter won't be used, so it can be left as null.
   */
  readonly groupSelector?: (availableGroups: Array<UserGroup>) => Promise<string>
  /**
   * Options to support the migration of data created using iCure versions from before 2018.
   * Leave it as false (default) unless explicitly instructed to set it to true by the iCure team.
   */
  readonly autoCreateEncryptionKeyForExistingLegacyData?: boolean
  /**
   * Implementation of key storage to use.
   * If not provided the sdk will store the keys in the StorageFacade provided to the api initialization method.
   */
  readonly keyStorage?: KeyStorageFacade | CardinalKeyStorageOptions
  /**
   * Custom crypto strategies. If not provided the sdk will use crypto strategies that:
   * - Allow for the creation of a new key of the data owner
   * - Do not use any custom key recovery solutions
   * - Considers any keys recovered using iCure's recovery methods as unverified
   * - Considers all public keys of other data owners as verified
   * - Considers patients as anonymous data owners
   */
  readonly cryptoStrategies?: CryptoStrategies
  /**
   * If true, on deserialization of data coming from the backend any field that is not present in the data model will
   * be ignored.
   *
   * If false any unknown field will cause the deserialization to fail. This can happen if:
   * - You are using data that was created using the legacy iCure typescript SDK (pre-cardinal).
   * - A new field has been added to the data model, and a new version of your application already uses the new field,
   *   but this instance still depends on an older version of the SDK.
   *
   * Note that updating an entity where some fields were ignored during deserialization will potentially result in
   * data loss.
   *
   * If a custom [HttpSdkOptions.httpClientJson] is provided, this option must be unconfigured (null) or match the
   * ignoreUnknownKeys configuration of that.
   * If no [HttpSdkOptions.httpClientJson] is configured the default for this behaviour is disabled by default (strict
   * by default).
   */
  readonly ignoreUnknownFields?: boolean
  /**
   * If not null the SDK will immediately set the data owner scope to the provided value after login.
   */
  readonly dataOwnerScope?: string
}

export interface BasicSdkOptions {
  /**
   * Service for encryption primitives.
   */
  readonly cryptoService?: PartialXCryptoService
  /**
   * An instance of iCure SDK is initialized for working as a specific user in a single group.
   * However, the user credentials may match multiple users in different groups (but at most one per group).
   * If that is the case, this function will be used to pick the actual user for which the sdk will be initialized.
   *
   * This is mandatory in multi-group applications, where a single user could exist in multiple groups.
   * If this parameter is null and the user credentials match multiple users the api initialisation will fail.
   * In single-group applications this parameter won't be used, so it can be left as null.
   */
  readonly groupSelector?: (availableGroups: Array<UserGroup>) => Promise<string>
  /**
   * If true, on deserialization of data coming from the backend any field that is not present in the data model will
   * be ignored.
   *
   * If false any unknown field will cause the deserialization to fail. This can happen if:
   * - You are using data that was created using the legacy iCure typescript SDK (pre-cardinal).
   * - A new field has been added to the data model, and a new version of your application already uses the new field,
   *   but this instance still depends on an older version of the SDK.
   *
   * Note that updating an entity where some fields were ignored during deserialization will potentially result in
   * data loss.
   *
   * If a custom [HttpSdkOptions.httpClientJson] is provided, this option must be unconfigured (null) or match the
   * ignoreUnknownKeys configuration of that.
   * If no [HttpSdkOptions.httpClientJson] is configured the default for this behaviour is disabled by default (strict
   * by default).
   */
  readonly ignoreUnknownFields?: boolean
  /**
   * If not null the SDK will immediately set the data owner scope to the provided value after login.
   */
  readonly dataOwnerScope?: string
}

/**
 * Optional parameters used in the conversion from a basic sdk to a full sdk.
 */
export interface BasicToFullSdkOptions {
  /**
   * Refer to {@link SdkOptions.useHierarchicalDataOwners }
   */
  readonly useHierarchicalDataOwners?: boolean
  /**
   * Refer to {@link SdkOptions.createTransferKeys }
   */
  readonly createTransferKeys?: boolean
  /**
   * Refer to {@link SdkOptions.autoCreateEncryptionKeyForExistingLegacyData }
   */
  readonly autoCreateEncryptionKeyForExistingLegacyData?: boolean
  /**
   * Refer to {@link SdkOptions.keyStorage }
   */
  readonly keyStorage?: KeyStorageFacade | CardinalKeyStorageOptions
  /**
   * Refer to {@link SdkOptions.cryptoStrategies }
   */
  readonly cryptoStrategies?: CryptoStrategies
}


export interface AnonymousSdkOptions {
  /**
   * If true, on deserialization of data coming from the backend or from the decrypted content of an entity any
   * field that is not present in the data model will be ignored.
   *
   * Note that updating an entity where some fields were ignored during deserialization will result in data loss.
   *
   * This behaviour is disabled by default (strict by default).
   */
  readonly ignoreUnknownFields?: boolean
}
