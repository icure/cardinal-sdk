package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ExchangeData(
	override val id: String,
	override val rev: String? = null,
	public val delegator: String,
	public val `delegate`: String,
	public val exchangeKey: Map<KeypairFingerprintV2String, Base64String>,
	public val accessControlSecret: Map<KeypairFingerprintV2String, Base64String>,
	@param:DefaultValue("emptyMap()")
	public val delegatorSignature: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	public val sharedSignatureKey: Map<KeypairFingerprintV2String, Base64String>,
	public val sharedSignature: Base64String,
	override val deletionDate: Long? = null,
) : StoredDocument {
	// region ExchangeData-ExchangeData

	// endregion
}
