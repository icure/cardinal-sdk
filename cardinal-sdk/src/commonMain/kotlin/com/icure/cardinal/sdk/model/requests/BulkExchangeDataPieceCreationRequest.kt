// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

/**
 *
 *  Request to create a piece of exchange data, for a certain recipient of a simple-type data owner
 * group.
 *  Unlike [ExchangeDataPieceCreationRequestDto], which is a piece of a group named by the request
 * that carries it, this
 *  request stands on its own: it names the group the piece belongs to and all of its participants,
 * so that a single
 *  bulk request can create pieces for many exchange data groups at once.
 */
@Serializable
data class BulkExchangeDataPieceCreationRequest(
	public val exchangeKey: Map<KeypairFingerprintV2String, Base64String>,
	public val accessControlSecret: Map<KeypairFingerprintV2String, Base64String>,
	public val sharedSignatureKey: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 *
	 *  Id of the exchange data group this piece belongs to. The piece where the recipient is the
	 * delegator anchors the
	 *  group and has this as its own id; every other piece of the group has a derived id.
	 */
	public val exchangeDataGroupId: String,
	/**
	 * Id of the exchange data group this piece belongs to. The piece where the recipient is the
	 * delegator anchors the
	 * group and has this as its own id; every other piece of the group has a derived id.
	 * /
	 */
	public val delegator: String,
	/**
	 * Id of the exchange data group this piece belongs to. The piece where the recipient is the
	 * delegator anchors the
	 * group and has this as its own id; every other piece of the group has a derived id.
	 * /
	 */
	public val `delegate`: String,
	/**
	 *
	 *  The member of the delegate group this piece is for. All the pieces of a group must agree on the
	 * delegator and
	 *  the delegate, and no two pieces of the same request may share a group and a recipient.
	 */
	public val recipient: String,
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
	 *
	 *  Must be null except on the piece of exchange data where the recipient is the delegator: this
	 * signature is only
	 *  used to decide if the exchange data can be trusted for encryption, and that decision is taken
	 * on the delegator
	 *  piece alone.
	 */
	public val sharedSignature: Base64String? = null,
) {
	// region BulkExchangeDataPieceCreationRequest-BulkExchangeDataPieceCreationRequest
	// endregion
}
