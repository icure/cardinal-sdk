// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.AppendixType
import com.icure.cardinal.sdk.model.base.CodeFlag
import com.icure.cardinal.sdk.model.base.CodeIdentification
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.LetterValue
import com.icure.cardinal.sdk.model.embed.Periodicity
import com.icure.cardinal.sdk.model.embed.PricingDomain
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a tarification code used for billing and invoicing healthcare services. Tarifications
 * define
 * the pricing and conditions for medical acts and are identified by a combination of type, code,
 * and version.
 * /
 */
@Serializable
data class Tarification(
	/**
	 * The unique identifier of the tarification, formatted as type|code|version.
	 */
	override val id: String,
	/**
	 * The revision of the tarification in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The label of the tarification in different languages.
	 */
	public val label: Map<String, String>? = null,
	/**
	 * The context where this tarification is used when embedded.
	 */
	override val context: String? = null,
	/**
	 * The type of the tarification (e.g., ICD). Type + version + code combination must be unique.
	 */
	override val type: String? = null,
	/**
	 * The code of the tarification (e.g., I06.2).
	 */
	override val code: String? = null,
	/**
	 * The version of the tarification. Must be lexicographically searchable.
	 */
	override val version: String? = null,
	/**
	 * The pricing domain for this tarification (ambulatory, hospital, or both).
	 */
	public val domain: PricingDomain? = null,
	/**
	 * The author of the tarification.
	 */
	public val author: String? = null,
	/**
	 * The regions where this tarification applies (e.g., be, fr).
	 */
	@param:DefaultValue("emptySet()")
	public val regions: Set<String> = emptySet(),
	/**
	 * The periodicity rules for this tarification.
	 */
	@param:DefaultValue("emptyList()")
	public val periodicity: List<Periodicity> = emptyList(),
	/**
	 * The level of the tarification (0 = system, 1 = optional/user-created).
	 */
	public val level: Int? = null,
	/**
	 * Links towards related codes.
	 */
	@param:DefaultValue("emptyList()")
	public val links: List<String> = emptyList(),
	/**
	 * Qualified links towards related codes.
	 */
	@param:DefaultValue("emptyMap()")
	public val qualifiedLinks: Map<LinkQualification, List<String>> = emptyMap(),
	/**
	 * Flags for the tarification (e.g., female only).
	 */
	@param:DefaultValue("emptySet()")
	public val flags: Set<CodeFlag> = emptySet(),
	/**
	 * Extra search terms per language.
	 */
	@param:DefaultValue("emptyMap()")
	public val searchTerms: Map<String, Set<String>> = emptyMap(),
	/**
	 * Additional data associated with the tarification.
	 */
	public val `data`: String? = null,
	/**
	 * Map of appendix types to their content.
	 */
	@param:DefaultValue("emptyMap()")
	public val appendices: Map<AppendixType, String> = emptyMap(),
	/**
	 * Whether this tarification is disabled.
	 */
	@param:DefaultValue("false")
	public val disabled: Boolean = false,
	/**
	 * The set of valorisations (pricing) for this tarification.
	 */
	@param:DefaultValue("emptySet()")
	public val valorisations: Set<DecryptedValorisation> = emptySet(),
	/**
	 * The category of the tarification in different languages.
	 */
	@param:DefaultValue("emptyMap()")
	public val category: Map<String, String> = emptyMap(),
	/**
	 * Whether this is a consultation code.
	 */
	public val consultationCode: Boolean? = null,
	/**
	 * Whether this tarification has a related code.
	 */
	public val hasRelatedCode: Boolean? = null,
	/**
	 * Whether this tarification needs a prescriber.
	 */
	public val needsPrescriber: Boolean? = null,
	/**
	 * The set of related tarification codes.
	 */
	@param:DefaultValue("emptySet()")
	public val relatedCodes: Set<String> = emptySet(),
	/**
	 * The nGroup identifier for this tarification.
	 */
	@SerialName("nGroup")
	public val ngroup: String? = null,
	/**
	 * The list of letter values for this tarification.
	 */
	@param:DefaultValue("emptyList()")
	public val letterValues: List<LetterValue> = emptyList(),
) : StoredDocument, CodeIdentification<String> {
	// region Tarification-Tarification

	// endregion
}
