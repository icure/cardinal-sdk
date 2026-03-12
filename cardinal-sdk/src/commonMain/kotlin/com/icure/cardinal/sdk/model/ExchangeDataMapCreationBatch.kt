package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Map

@Serializable
public data class ExchangeDataMapCreationBatch(
	/**
	 *
	 *  Each entry of this map can be used to create a new ExchangeDataMap. Each key is the hex-encoded
	 * access control
	 *  key while the value is another map that associated the encrypted ExchangeData id to the
	 * fingerprint
	 *  of the public key used to encrypt it.
	 */
	@param:DefaultValue("emptyMap()")
	public val batch: Map<AccessControlKeyHexString, Map<KeypairFingerprintV2String, Base64String>> =
		emptyMap(),
)
