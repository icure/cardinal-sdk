package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public data class RecoveryData(
	override val id: String,
	override val rev: String? = null,
	public val recipient: String,
	public val encryptedSelf: Base64String,
	public val type: Type,
	public val expirationInstant: Long? = null,
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
