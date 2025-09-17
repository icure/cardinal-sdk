package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class AppointmentTypeAndPlace(
	public val calendarItemTypeId: String,
	public val name: String? = null,
	public val color: String? = null,
	@DefaultValue("0")
	public val duration: Int = 0,
	@DefaultValue("emptyMap()")
	public val subjectByLanguage: Map<String, String>? = emptyMap(),
	public val placeId: String? = null,
	public val address: DecryptedAddress? = null,
	@DefaultValue("true")
	public val acceptsNewPatients: Boolean = true,
)
