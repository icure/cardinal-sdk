// auto-generated file
import {Tagged} from '../../internal/TaggedType.mjs';


/**
 *
 *  A string that represents the keypair used for the encryption of an aes exchange key entry. This should usually be
 *  a fingerprint v1, but due to bugs in older iCure version it may also be a public key in hex-encoded spki format, or
 *  due to corruption of some healthcare parties public key it may also be an empty string, to represent the fact that
 *  the key used for the encryption is unknown.
 */
export type AesExchangeKeyEncryptionKeypairIdentifier = Tagged<string, 'com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier'>;
