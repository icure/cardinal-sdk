export type EncryptedFieldsOptions =
  typeof EncryptedFieldsOptions.Legacy |
  typeof EncryptedFieldsOptions.Default |
  EncryptedFieldsOptions.Custom


export namespace EncryptedFieldsOptions {
  export const Legacy = 'Legacy'
  export const Default = 'Default'
  export class Custom {
    constructor(public readonly manifestsJson: any) {}
  }
}
