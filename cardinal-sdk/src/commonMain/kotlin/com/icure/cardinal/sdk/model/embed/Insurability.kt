package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Insurability : Encryptable {
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
	// region Insurability-Insurability

	// endregion
}

@Serializable
data class DecryptedInsurability(
	@param:DefaultValue("emptyMap()")
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
) : Insurability {
	// region Insurability-DecryptedInsurability

	// endregion
}

@Serializable
data class EncryptedInsurability(
	@param:DefaultValue("emptyMap()")
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
) : Insurability {
	// region Insurability-EncryptedInsurability

	// endregion
}
