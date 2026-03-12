package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents metadata which allows a data owner to recover cryptographic secrets meant for them.
 * The id of recovery data should be derived from the encryption key the data was encrypted with,
 * so that only the encryption key is needed to find and use the recovery data.
 * /
 */
@Serializable
public data class RecoveryData(
	/**
	 * The unique identifier of the recovery data, derived from the encryption key.
	 */
	override val id: String,
	/**
	 * The revision of the recovery data in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The id of the data owner that this recovery data is meant for.
	 */
	public val recipient: String,
	/**
	 * The encrypted content of the recovery data.
	 */
	public val encryptedSelf: Base64String,
	/**
	 * The type of recovery data (keypair recovery or exchange key recovery).
	 */
	public val type: Type,
	/**
	 * The expiration timestamp (unix epoch in ms) after which this recovery data is no longer valid.
	 */
	public val expirationInstant: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
) : StoredDocument {
	@Serializable
	public enum class Type(
		internal val dtoSerialName: String,
	) {
		@SerialName("KEYPAIR_RECOVERY")
		KeypairRecovery("KEYPAIR_RECOVERY"),

		@SerialName("EXCHANGE_KEY_RECOVERY")
		ExchangeKeyRecovery("EXCHANGE_KEY_RECOVERY"),
	}
}
