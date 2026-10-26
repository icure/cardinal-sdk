export type EncryptedFieldsOptions =
  typeof EncryptedFieldsOptions.Legacy |
  typeof EncryptedFieldsOptions.Default |
  EncryptedFieldsOptions.Custom


export namespace EncryptedFieldsOptions {
  export const Legacy = 'Legacy'
  export const Default = 'Default'
  export class Custom {
    /**
     * @param manifestsJson the json representation of the EntitiesEncryptionManifests: root entities without a
     * manifest are not supported by the SDK.
     * @param useLegacyServiceContentEncryption if true use the legacy encryption of the service content.
     * @param serializeEncryptedSelfUsingLegacyNames if true the content of encrypted self uses the legacy field names.
     */
    constructor(
      public readonly manifestsJson: any,
      public readonly useLegacyServiceContentEncryption: boolean = false,
      public readonly serializeEncryptedSelfUsingLegacyNames: boolean = false,
    ) {}
  }
}
