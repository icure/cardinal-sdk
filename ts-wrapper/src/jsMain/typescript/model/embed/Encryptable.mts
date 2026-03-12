// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';


/**
 *
 *
 *   Interface for DTOs that support end-to-end encryption. Implementing classes carry an encrypted
 *  payload
 *   that can be decrypted using the appropriate encryption keys.
 */
export interface Encryptable {

	encryptedSelf: Base64String | undefined;

}
