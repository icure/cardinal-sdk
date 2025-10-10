// noinspection TypeScriptCheckImport
// @ts-ignore
export enum AesKeySize {
  Aes128 = 128,
  Aes256 = 256,
}
export enum AesAlgorithm {
  AesCbcPkcs7 = "AesCbcPkcs7"
}
export interface XAesService {
  generateKey(algorithm: AesAlgorithm, size: AesKeySize): Promise<XAesKey>;
  exportKey(key: XAesKey): Promise<Int8Array>;
  loadKey(algorithm: AesAlgorithm, bytes: Int8Array): Promise<XAesKey>;
  encrypt(data: Int8Array, key: XAesKey, iv?: Int8Array): Promise<Int8Array>;
  decrypt(ivAndEncryptedData: Int8Array, key: XAesKey): Promise<Int8Array>;
}
export interface XAesKey {
  readonly aesKey?: any;
  readonly algorithm: string;
}
export interface XCryptoService {
  readonly aes: XAesService;
  readonly digest: XDigestService;
  readonly rsa: XRsaService;
  readonly strongRandom: XStrongRandom;
  readonly hmac: XHmacService;
}
export interface XDigestService {
  sha256(data: Int8Array): Promise<Int8Array>;
}
export enum HmacAlgorithm {
  HmacSha512 = "HmacSha512",
  HmacSha256 = "HmacSha256",
}
export interface XHmacService {
  generateKey(algorithm: HmacAlgorithm, keySize?: number): Promise<XHmacKey>;
  exportKey(key: XHmacKey): Promise<Int8Array>;
  loadKey(algorithm: HmacAlgorithm, bytes: Int8Array): Promise<XHmacKey>;
  sign(data: Int8Array, key: XHmacKey): Promise<Int8Array>;
  verify(signature: Int8Array, data: Int8Array, key: XHmacKey): Promise<boolean>;
}
export interface XHmacKey {
  readonly hmacKey?: any;
  readonly keySize: number;
  readonly algorithm: string;
}
export enum RsaKeySize {
  Rsa2048 = 2048,
  Rsa4096 = 4096,
}
export enum RsaEncryptionAlgorithm {
  OaepWithSha1 = "OaepWithSha1",
  OaepWithSha256 = "OaepWithSha256"
}
export enum RsaSignatureAlgorithm {
  PssWithSha256 = "PssWithSha256"
}
export type RsaAlgorithm = RsaEncryptionAlgorithm | RsaSignatureAlgorithm
export interface XRsaService {
  generateKeyPair(algorithm: RsaAlgorithm, keySize: RsaKeySize): Promise<XRsaKeypair>;
  exportPrivateKeyPkcs8(key: XPrivateRsaKey): Promise<Int8Array>;
  exportPublicKeySpki(key: XPublicRsaKey): Promise<Int8Array>;
  loadKeyPairPkcs8(algorithm: RsaAlgorithm, privateKeyPkcs8: Int8Array): Promise<XRsaKeypair>;
  loadPrivateKeyPkcs8(algorithm: RsaAlgorithm, privateKeyPkcs8: Int8Array): Promise<XPrivateRsaKey>;
  loadPublicKeySpki(algorithm: RsaAlgorithm, publicKeySpki: Int8Array): Promise<XPublicRsaKey>;
  encrypt(data: Int8Array, publicKey: XPublicRsaKey): Promise<Int8Array>;
  decrypt(data: Int8Array, privateKey: XPrivateRsaKey): Promise<Int8Array>;
  sign(data: Int8Array, privateKey: XPrivateRsaKey): Promise<Int8Array>;
  verifySignature(signature: Int8Array, data: Int8Array, publicKey: XPublicRsaKey): Promise<boolean>;
  exportPrivateKeyJwk(key: XPrivateRsaKey): Promise<JsonWebKey>
  exportPublicKeyJwk(key: XPublicRsaKey): Promise<JsonWebKey>
  loadPrivateKeyJwk(privateKeyJwk: JsonWebKey): Promise<XPrivateRsaKey>
  loadPublicKeyJwk(publicKeyJwk: JsonWebKey): Promise<XPublicRsaKey>
}
export interface XRsaKeypair {
  readonly private: XPrivateRsaKey;
  readonly public: XPublicRsaKey;
}
export interface XPrivateRsaKey {
  readonly privateKey?: any;
  readonly algorithm: string;
}
export interface XPublicRsaKey {
  readonly publicKey?: any;
  readonly algorithm: string;
}
export interface XStrongRandom {
  randomBytes(length: number): Int8Array;
  randomUUID(): string;
}
