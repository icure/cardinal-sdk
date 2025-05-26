package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByDataOwnerPatientOpeningDate")
@Serializable
data class HealthElementByDataOwnerPatientOpeningDate(
	override val desc: String? = null,
	public val healthcarePartyId: String,
	@DefaultValue("emptySet()")
	public val patientSecretForeignKeys: Set<String> = emptySet(),
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	@DefaultValue("false")
	public val descending: Boolean = false,
) : AbstractFilter<HealthElement> {
	public val dtoSerialName: String
	// region HealthElementByDataOwnerPatientOpeningDate-HealthElementByDataOwnerPatientOpeningDate

	// endregion
}
