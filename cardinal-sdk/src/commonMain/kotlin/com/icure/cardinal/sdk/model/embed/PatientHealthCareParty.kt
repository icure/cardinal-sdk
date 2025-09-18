package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

public sealed interface PatientHealthCareParty : Encryptable {
	public val type: PatientHealthCarePartyType?

	public val healthcarePartyId: String?

	public val sendFormats: Map<TelecomType, String>

	public val referralPeriods: List<ReferralPeriod>

	public val referral: Boolean

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedPatientHealthCareParty(
	override val type: PatientHealthCarePartyType? = null,
	override val healthcarePartyId: String? = null,
	@DefaultValue("emptyMap()")
	override val sendFormats: Map<TelecomType, String> = emptyMap(),
	@DefaultValue("emptyList()")
	override val referralPeriods: List<ReferralPeriod> = emptyList(),
	@DefaultValue("false")
	override val referral: Boolean = false,
	override val encryptedSelf: Base64String? = null,
) : PatientHealthCareParty

@Serializable
public data class EncryptedPatientHealthCareParty(
	override val type: PatientHealthCarePartyType? = null,
	override val healthcarePartyId: String? = null,
	@DefaultValue("emptyMap()")
	override val sendFormats: Map<TelecomType, String> = emptyMap(),
	@DefaultValue("emptyList()")
	override val referralPeriods: List<ReferralPeriod> = emptyList(),
	@DefaultValue("false")
	override val referral: Boolean = false,
	override val encryptedSelf: Base64String? = null,
) : PatientHealthCareParty
