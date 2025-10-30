package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.PropertyStub
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface PatientHealthCareParty : Encryptable {
	public val type: PatientHealthCarePartyType?

	public val healthcarePartyId: String?

	public val sendFormats: Map<TelecomType, String>

	public val referralPeriods: List<ReferralPeriod>

	public val referral: Boolean

	public val properties: Set<PropertyStub>?

	override val encryptedSelf: Base64String?
	// region PatientHealthCareParty-PatientHealthCareParty

	// endregion
}

@Serializable
data class DecryptedPatientHealthCareParty(
	override val type: PatientHealthCarePartyType? = null,
	override val healthcarePartyId: String? = null,
	@DefaultValue("emptyMap()")
	override val sendFormats: Map<TelecomType, String> = emptyMap(),
	@DefaultValue("emptyList()")
	override val referralPeriods: List<ReferralPeriod> = emptyList(),
	@DefaultValue("false")
	override val referral: Boolean = false,
	override val properties: Set<DecryptedPropertyStub>? = null,
	override val encryptedSelf: Base64String? = null,
) : PatientHealthCareParty {
	// region PatientHealthCareParty-DecryptedPatientHealthCareParty

	// endregion
}

@Serializable
data class EncryptedPatientHealthCareParty(
	override val type: PatientHealthCarePartyType? = null,
	override val healthcarePartyId: String? = null,
	@DefaultValue("emptyMap()")
	override val sendFormats: Map<TelecomType, String> = emptyMap(),
	@DefaultValue("emptyList()")
	override val referralPeriods: List<ReferralPeriod> = emptyList(),
	@DefaultValue("false")
	override val referral: Boolean = false,
	override val properties: Set<EncryptedPropertyStub>? = null,
	override val encryptedSelf: Base64String? = null,
) : PatientHealthCareParty {
	// region PatientHealthCareParty-EncryptedPatientHealthCareParty

	// endregion
}
