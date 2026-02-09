package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Insurance(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	@param:DefaultValue("emptyMap()")
	public val name: Map<String, String> = emptyMap(),
	@param:DefaultValue("false")
	public val privateInsurance: Boolean = false,
	@param:DefaultValue("false")
	public val hospitalisationInsurance: Boolean = false,
	@param:DefaultValue("false")
	public val ambulatoryInsurance: Boolean = false,
	public val code: String? = null,
	public val agreementNumber: String? = null,
	public val parent: String? = null,
	public val address: DecryptedAddress,
) : StoredDocument {
	// region Insurance-Insurance

	// endregion
}
