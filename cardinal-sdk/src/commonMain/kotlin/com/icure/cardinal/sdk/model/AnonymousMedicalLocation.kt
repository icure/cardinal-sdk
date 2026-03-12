package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

/**
 * DTO representing a medical location with only publicly accessible information, stripped of
 * sensitive data.
 * /
 */
@Serializable
public data class AnonymousMedicalLocation(
	/**
	 * The unique identifier of the medical location.
	 */
	public val id: String,
	/**
	 * A map of publicly available information about the medical location, keyed by information type.
	 */
	@param:DefaultValue("emptyMap()")
	public val publicInformations: Map<String, String> = emptyMap(),
)
