import {EncryptedFieldsOptions} from "./EncryptedFieldsOptions.mjs";
import {EntityWithEncryptionMetadataTypeName} from "../crypto/entities/EntityWithEncryptionMetadataTypeName.mjs";

/**
 * Options for the creation of a CardinalSdk that are normally passed automatically by the
 * customized SDK initializer.
 */
export interface CustomisedSdkOptions {
  /**
   * Specifies which fields should be encrypted for each entity, root or embedded.
   * Normally this parameter should be automatically filled by the generated customized SDK.
   */
  readonly encryptedFieldsOptions?: EncryptedFieldsOptions
  /**
   * The ids of all the custom entity types that this customised SDK uses with access control keys.
   * Normally this parameter should be automatically filled by the generated customized SDK.
   */
  readonly knownCustomEntityTypes?: Array<string>
  /**
   * All the builtin entity types that this customised SDK does not use.
   * Normally this parameter should be automatically filled by the generated customized SDK.
   */
  readonly hiddenBuiltinEntityTypes?: Array<EntityWithEncryptionMetadataTypeName.Builtin>
}