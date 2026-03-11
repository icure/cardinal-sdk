package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeIdentification
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a medical code from a terminology system (e.g., ICD, SNOMED). The code id is composed
 * of
 * type|code|version and must be unique.
 * /
 */
@Serializable
public data class Code(
	/**
	 * The Id of the code, formatted as type|code|version. Must be unique.
	 */
	override val id: String,
	/**
	 * The revision of the code in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The context in which this code is used when embedded.
	 */
	override val context: String? = null,
	/**
	 * The code type (e.g., ICD). The type + version + code combination must be unique.
	 */
	override val type: String? = null,
	/**
	 * The code value (e.g., I06.2). Local codes are encoded as LOCAL:SLLOCALFROMMYSOFT.
	 */
	override val code: String? = null,
	/**
	 * The version of the code (e.g., 10). Must be lexicographically searchable.
	 */
	override val version: String? = null,
	/**
	 * The human-readable label for the code, mapped by language (e.g., {en: "...", fr: "..."}).
	 */
	public val label: Map<String, String> = emptyMap(),
	/**
	 * The id of the author of this code.
	 */
	public val author: String? = null,
	/**
	 * The geographic regions where this code is applicable (e.g., be, fr).
	 */
	@param:DefaultValue("emptySet()")
	public val regions: Set<String> = emptySet(),
	/**
	 * Links towards related codes (corresponds to approximate links in qualifiedLinks).
	 */
	@param:DefaultValue("emptySet()")
	public val links: Set<String> = emptySet(),
	/**
	 * Qualified links towards related codes.
	 */
	@param:DefaultValue("emptyMap()")
	public val qualifiedLinks: Map<String, List<String>> = emptyMap(),
	/**
	 * Extra search terms indexed by language.
	 */
	@param:DefaultValue("emptyMap()")
	public val searchTerms: Map<String, Set<String>> = emptyMap(),
	/**
	 * Whether this code is disabled.
	 */
	@param:DefaultValue("false")
	public val disabled: Boolean = false,
) : StoredDocument, CodeIdentification<String>
