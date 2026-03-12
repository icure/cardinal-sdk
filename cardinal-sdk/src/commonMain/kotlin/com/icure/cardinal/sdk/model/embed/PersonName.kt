package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * Represents name information for a person, following FHIR HumanName conventions. Includes family
 * name,
 * given names, prefixes, suffixes, and a validity period.
 * /
 */
@Serializable
public data class PersonName(
	/**
	 * Family name (often called 'Surname').
	 */
	public val lastName: String? = null,
	/**
	 * Given names (not always 'first'), including middle names, in the correct order for presentation.
	 */
	@param:DefaultValue("emptyList()")
	public val firstNames: List<String> = emptyList(),
	/**
	 * Starting date of the period when the name is valid (fuzzy date, YYYYMMDD).
	 */
	public val start: Long? = null,
	/**
	 * Ending date of the period when the name is valid (fuzzy date, YYYYMMDD).
	 */
	public val end: Long? = null,
	/**
	 * Parts that come before the name, in the correct order for presentation.
	 */
	@param:DefaultValue("emptyList()")
	public val prefix: List<String> = emptyList(),
	/**
	 * Parts that come after the name, in the correct order for presentation.
	 */
	@param:DefaultValue("emptyList()")
	public val suffix: List<String> = emptyList(),
	/**
	 * Text representation of the full name.
	 */
	public val text: String? = null,
	/**
	 * The use of this name (usual, official, temp, etc.).
	 */
	public val use: PersonNameUse? = null,
)
