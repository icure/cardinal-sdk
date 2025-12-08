import {PartialXCryptoService} from "../crypto/CryptoService.mjs";
import {UserGroup} from "../model/UserGroup.mjs";
import {KeyStorageFacade} from "../storage/StorageFacade.mjs";
import {CryptoStrategies} from "../crypto/CryptoStrategies.mjs";
import {CardinalKeyStorageOptions} from "../cardinal-sdk-ts.mjs";

export interface SdkOptions {
  /**
   * Configure which fields of entities should be encrypted
   */
  readonly encryptedFields?: EncryptedFieldsConfiguration
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
   * Patcher for the decrypted entities json.
   * This allows adapting to changes in the data model of entities even if the changes are done to the encrypted part
   * of the entity.
   */
  readonly jsonPatcher?: JsonPatcher
  /**
   * If true the SDK will use lenient deserialization of the entities coming from the backend.
   *
   * This could be helpful when developing using the nightly deployments of the backend, as the SDK will ignore minor changes to the data model.
   *
   * This option however could cause loss of data when connecting with incompatible versions of the backend, and should be disabled in production.
   */
  readonly lenientJson?: boolean
  /**
   * If not null the SDK will immediately set the data owner scope to the provided value after login.
   */
  readonly dataOwnerScope?: string
}

export interface BasicSdkOptions {
  /**
   * Configure which fields of entities should be encrypted
   */
  readonly encryptedFields?: EncryptedFieldsConfiguration
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
   * If true the SDK will use lenient deserialization of the entities coming from the backend.
   *
   * This could be helpful when developing using the nightly deployments of the backend, as the SDK will ignore minor changes to the data model.
   *
   * This option however could cause loss of data when connecting with incompatible versions of the backend, and should be disabled in production.
   */
  readonly lenientJson?: boolean
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
  /**
   * Refer to {@link SdkOptions.jsonPatcher }
   */
  readonly jsonPatcher?: JsonPatcher
}


export interface AnonymousSdkOptions {
  /**
   * If true the SDK will use lenient deserialization of the entities coming from the backend.
   *
   * This could be helpful when developing using the nightly deployments of the backend, as the SDK will ignore minor changes to the data model.
   *
   * This option however could cause loss of data when connecting with incompatible versions of the backend, and should be disabled in production.
   */
  readonly lenientJson?: boolean
}

export interface EncryptedFieldsConfiguration {
  readonly accessLog?: Array<string>
  readonly calendarItem?: Array<string>
  readonly contact?: Array<string>
  readonly service?: Array<string>
  readonly healthElement?: Array<string>
  readonly maintenanceTask?: Array<string>
  readonly patient?: Array<string>
  readonly message?: Array<string>
  readonly topic?: Array<string>
  readonly document?: Array<string>
  readonly form?: Array<string>
  readonly receipt?: Array<string>
  readonly classification?: Array<string>
  readonly timeTable?: Array<string>
  readonly invoice?: Array<string>
}

/**
 * Provides methods to patch the json representing a certain type of entity after decryption and before validation and
 * proper deserialization.
 * Each of these methods takes in input the parsed json of the decrypted entity and must return the patched json.
 * All the patchers are optional, if you don't define a patcher the json of the entity will be used by the sdk as is
 * without any patching.
 *
 *
 */
export interface JsonPatcher {
  /**
   * Patches the decrypted json of an AccessLog
   */
  readonly patchAccessLog?: ((json: any) => any)
  /**
   * Patches the decrypted json of a CalendarItem
   */
  readonly patchCalendarItem?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Contact
   */
  readonly patchContact?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Service.
   * This method is used only when a service is retrieved by itself, without the rest of the contact.
   * Services retrieved as part of a contact should be patched as part of {@link patchContact}
   */
  readonly patchIndividualService?: ((json: any) => any)
  /**
   * Patches the decrypted json of a HealthElement
   */
  readonly patchHealthElement?: ((json: any) => any)
  /**
   * Patches the decrypted json of a MaintenanceTask
   */
  readonly patchMaintenanceTask?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Patient
   */
  readonly patchPatient?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Message
   */
  readonly patchMessage?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Topic
   */
  readonly patchTopic?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Document
   */
  readonly patchDocument?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Form
   */
  readonly patchForm?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Receipt
   */
  readonly patchReceipt?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Classification
   */
  readonly patchClassification?: ((json: any) => any)
  /**
   * Patches the decrypted json of a TimeTable
   */
  readonly patchTimeTable?: ((json: any) => any)
  /**
   * Patches the decrypted json of a Invoice
   */
  readonly patchInvoice?: ((json: any) => any)
}
