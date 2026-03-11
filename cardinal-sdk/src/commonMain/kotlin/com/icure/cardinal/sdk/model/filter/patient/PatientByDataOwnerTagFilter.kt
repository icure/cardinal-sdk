package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches patients by data owner and tag.
 * /
 */
@SerialName("PatientByDataOwnerTagFilter")
@Serializable
public data class PatientByDataOwnerTagFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The type of the tag to match.
	 */
	public val tagType: String,
	/**
	 * The tag code value to match.
	 */
	public val tagCode: String? = null,
) : AbstractFilter<Patient>
