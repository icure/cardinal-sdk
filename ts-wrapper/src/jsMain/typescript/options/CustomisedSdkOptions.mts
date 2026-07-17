import {EncryptedFieldsOptions} from "./EncryptedFieldsOptions.mjs";

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
}