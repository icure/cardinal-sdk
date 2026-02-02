package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ExchangeDataMapCreationBatch(
	@param:DefaultValue("emptyMap()")
	public val batch: Map<AccessControlKeyHexString, Map<KeypairFingerprintV2String, Base64String>> =
		emptyMap(),
) {
    // region ExchangeDataMapCreationBatch-ExchangeDataMapCreationBatch

    // endregion
}
