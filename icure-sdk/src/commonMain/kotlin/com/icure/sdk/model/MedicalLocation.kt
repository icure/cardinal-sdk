package com.icure.sdk.model

import com.icure.sdk.model.base.Named
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Address
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class MedicalLocation(
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
	public val address: Address? = null,
	public val agendaIds: Set<String> = emptySet(),
	public val options: Map<String, String> = emptyMap(),
	public val publicInformations: Map<String, String> = emptyMap(),
) : StoredDocument, Named {
	// region MedicalLocation-MedicalLocation

	// endregion
}
