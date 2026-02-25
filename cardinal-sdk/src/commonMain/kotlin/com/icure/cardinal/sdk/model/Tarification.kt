package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.AppendixType
import com.icure.cardinal.sdk.model.base.CodeFlag
import com.icure.cardinal.sdk.model.base.CodeIdentification
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.LetterValue
import com.icure.cardinal.sdk.model.embed.Periodicity
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

@Serializable
public data class Tarification(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val label: Map<String, String>? = null,
	override val context: String? = null,
	override val type: String? = null,
	override val code: String? = null,
	override val version: String? = null,
	public val author: String? = null,
	@param:DefaultValue("emptySet()")
	public val regions: Set<String> = emptySet(),
	@param:DefaultValue("emptyList()")
	public val periodicity: List<Periodicity> = emptyList(),
	public val level: Int? = null,
	@param:DefaultValue("emptyList()")
	public val links: List<String> = emptyList(),
	@param:DefaultValue("emptyMap()")
	public val qualifiedLinks: Map<LinkQualification, List<String>> = emptyMap(),
	@param:DefaultValue("emptySet()")
	public val flags: Set<CodeFlag> = emptySet(),
	@param:DefaultValue("emptyMap()")
	public val searchTerms: Map<String, Set<String>> = emptyMap(),
	public val `data`: String? = null,
	@param:DefaultValue("emptyMap()")
	public val appendices: Map<AppendixType, String> = emptyMap(),
	@param:DefaultValue("false")
	public val disabled: Boolean = false,
	@param:DefaultValue("emptySet()")
	public val valorisations: Set<DecryptedValorisation> = emptySet(),
	@param:DefaultValue("emptyMap()")
	public val category: Map<String, String> = emptyMap(),
	public val consultationCode: Boolean? = null,
	public val hasRelatedCode: Boolean? = null,
	public val needsPrescriber: Boolean? = null,
	@param:DefaultValue("emptySet()")
	public val relatedCodes: Set<String> = emptySet(),
	@SerialName("nGroup")
	public val ngroup: String? = null,
	@param:DefaultValue("emptyList()")
	public val letterValues: List<LetterValue> = emptyList(),
) : StoredDocument, CodeIdentification<String>
