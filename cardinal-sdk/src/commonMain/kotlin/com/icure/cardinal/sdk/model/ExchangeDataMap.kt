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
 * Links the public keys of a data owner to their exchange data. This entity associates secure
 * delegation keys
 * to the encrypted id of the exchange data used for the creation of the secure delegation.
 * /
 */
@Serializable
public data class ExchangeDataMap(
	/**
	 * The id of this entity, which is the Secure Delegation Key.
	 */
	override val id: String,
	/**
	 * The revision of the exchange data map in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * A map where each key is a public key fingerprint and the value is an encrypted exchange data id.
	 *
	 */
	@param:DefaultValue("emptyMap()")
	public val encryptedExchangeDataIds: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
) : StoredDocument
