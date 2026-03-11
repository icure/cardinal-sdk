package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 *
 *  DTO representing an appointment type along with its associated place information.
 */
@Serializable
public data class AppointmentTypeAndPlace(
	/**
	 * The unique identifier of the calendar item type for this appointment.
	 */
	public val calendarItemTypeId: String,
	/**
	 * The display name of the appointment type.
	 */
	public val name: String? = null,
	/**
	 * The color code associated with this appointment type, in hex format (e.g. "#123456").
	 */
	public val color: String? = null,
	/**
	 * The default duration of this appointment type in minutes.
	 */
	@param:DefaultValue("0")
	public val duration: Int = 0,
	/**
	 * A map of appointment subjects keyed by language code.
	 */
	@param:DefaultValue("emptyMap()")
	public val subjectByLanguage: Map<String, String>? = emptyMap(),
	/**
	 * The unique identifier of the place where this appointment type is offered.
	 */
	public val placeId: String? = null,
	/**
	 * The address of the place where this appointment type is offered.
	 */
	public val address: DecryptedAddress? = null,
	/**
	 * Whether this appointment type accepts new patients.
	 */
	@param:DefaultValue("true")
	public val acceptsNewPatients: Boolean = true,
)
