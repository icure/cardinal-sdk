package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

/**
 * Holds the cryptographic data necessary for the secure sharing of entities between data owners.
 * Exchange data enables a delegator to share encrypted medical data with a delegate.
 * /
 */
@Serializable
public data class ExchangeData(
	/**
	 * The Id of the exchange data.
	 */
	override val id: String,
	/**
	 * The revision of the exchange data in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The id of the data owner who created this exchange data to share data with the delegate.
	 */
	public val delegator: String,
	/**
	 * The id of the data owner who can use this exchange data to access shared data.
	 */
	public val `delegate`: String,
	/**
	 * AES key for sharing data, encrypted with the public keys of both delegate and delegator.
	 */
	public val exchangeKey: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 * Key used for access control, encrypted with the public keys of both delegate and delegator.
	 */
	public val accessControlSecret: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 * Signature by the delegator to ensure key data has not been tampered with by third parties.
	 */
	@param:DefaultValue("emptyMap()")
	public val delegatorSignature: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	/**
	 * Encrypted HMAC-SHA256 signature key shared between delegate and delegator.
	 */
	public val sharedSignatureKey: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 * Base64 signature of the exchange data to ensure it was not tampered by third parties.
	 */
	public val sharedSignature: Base64String,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
) : StoredDocument
