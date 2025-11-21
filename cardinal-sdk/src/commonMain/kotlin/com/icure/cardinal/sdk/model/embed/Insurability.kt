package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

public sealed interface Insurability : Encryptable {
	public val parameters: Map<String, String>

	public val hospitalisation: Boolean?

	public val ambulatory: Boolean?

	public val dental: Boolean?

	public val identificationNumber: String?

	public val insuranceId: String?

	public val startDate: Long?

	public val endDate: Long?

	public val titularyId: String?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedInsurability(
	@DefaultValue("emptyMap()")
	override val parameters: Map<String, String> = emptyMap(),
	override val hospitalisation: Boolean? = null,
	override val ambulatory: Boolean? = null,
	override val dental: Boolean? = null,
	override val identificationNumber: String? = null,
	override val insuranceId: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val titularyId: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Insurability

@Serializable
public data class EncryptedInsurability(
	@DefaultValue("emptyMap()")
	override val parameters: Map<String, String> = emptyMap(),
	override val hospitalisation: Boolean? = null,
	override val ambulatory: Boolean? = null,
	override val dental: Boolean? = null,
	override val identificationNumber: String? = null,
	override val insuranceId: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val titularyId: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Insurability
