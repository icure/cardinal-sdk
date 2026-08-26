// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Map

/**
 *
 *  Request to create a piece of exchange data, for a certain recipient of a simple-type data owner
 * group.
 *  The id, recipient, delegator, delegate and exchange data group id of the created piece are not
 * part of this request:
 *  they come from the parameters of the request to create the pieces of an exchange data group, and
 * from the key this
 *  request is associated to.
 */
@Serializable
data class ExchangeDataPieceCreationRequest(
	public val exchangeKey: Map<KeypairFingerprintV2String, Base64String>,
	public val accessControlSecret: Map<KeypairFingerprintV2String, Base64String>,
	public val sharedSignatureKey: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 *
	 *  Must be empty except on the piece of exchange data where the recipient is the delegator. Empty
	 * there as well to
	 *  create exchange data that is already permanently invalidated: it will never be used to encrypt
	 * new data.
	 */
	@param:DefaultValue("emptyMap()")
	public val delegatorSignature: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	/**
	 * Must be empty except on the piece of exchange data where the recipient is the delegator. Empty
	 * there as well to
	 * create exchange data that is already permanently invalidated: it will never be used to encrypt
	 * new data.
	 * /
	 */
	public val sharedSignature: Base64String,
) {
	// region ExchangeDataPieceCreationRequest-ExchangeDataPieceCreationRequest
	// endregion
}
