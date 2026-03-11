package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable

/**
 * DTO that pairs a crypto actor stub with its data owner type, used for identifying data owners
 * and their cryptographic metadata.
 * /
 */
@Serializable
public data class CryptoActorStubWithType(
	/**
	 * The type of data owner (healthcare party, device, or patient).
	 */
	public val type: DataOwnerType,
	/**
	 * The cryptographic actor stub containing encryption keys and related metadata.
	 */
	public val stub: CryptoActorStub,
)
