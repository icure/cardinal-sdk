package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Map

@Serializable
public data class ExchangeDataMapCreationBatch(
	@DefaultValue("emptyMap()")
	public val batch: Map<AccessControlKeyHexString, Map<KeypairFingerprintV2String, Base64String>> =
		emptyMap(),
)
