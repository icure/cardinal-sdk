package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AppointmentTypeAndPlace(
	public val calendarItemTypeId: String,
	public val name: String? = null,
	public val color: String? = null,
	public val duration: Int,
	public val subjectByLanguage: Map<String, String>? = null,
	public val placeId: String? = null,
	public val address: DecryptedAddress? = null,
	@DefaultValue("false")
	public val acceptsNewPatients: Boolean = false,
) {
	// region AppointmentTypeAndPlace-AppointmentTypeAndPlace

	// endregion
}
