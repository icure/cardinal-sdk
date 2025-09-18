package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class ExchangeDataMap(
	override val id: String,
	override val rev: String? = null,
	@DefaultValue("emptyMap()")
	public val encryptedExchangeDataIds: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	override val deletionDate: Long? = null,
) : StoredDocument
