package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class Insurance(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	@DefaultValue("emptyMap()")
	public val name: Map<String, String> = emptyMap(),
	@DefaultValue("false")
	public val privateInsurance: Boolean = false,
	@DefaultValue("false")
	public val hospitalisationInsurance: Boolean = false,
	@DefaultValue("false")
	public val ambulatoryInsurance: Boolean = false,
	public val code: String? = null,
	public val agreementNumber: String? = null,
	public val parent: String? = null,
	public val address: DecryptedAddress,
) : StoredDocument
