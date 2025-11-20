package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class MedicalLocation(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	override val name: String? = null,
	public val description: String? = null,
	public val responsible: String? = null,
	public val guardPost: Boolean? = null,
	public val cbe: String? = null,
	public val bic: String? = null,
	public val bankAccount: String? = null,
	public val nihii: String? = null,
	public val ssin: String? = null,
	public val address: DecryptedAddress? = null,
	@DefaultValue("emptySet()")
	public val agendaIds: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	public val options: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	public val publicInformations: Map<String, String> = emptyMap(),
) : StoredDocument, Named
