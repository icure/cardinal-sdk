package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable

@Serializable
public data class CryptoActorStubWithType(
	public val type: DataOwnerType,
	public val stub: CryptoActorStub,
)
