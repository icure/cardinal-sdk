// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable

/**
 * DTO that pairs a crypto actor stub with its data owner type, used for identifying data owners
 * and their cryptographic metadata.
 * /
 */
@Serializable
data class CryptoActorStubWithType(
	/**
	 * The type of data owner (healthcare party, device, or patient).
	 */
	public val type: DataOwnerType,
	/**
	 * The cryptographic actor stub containing encryption keys and related metadata.
	 */
	public val stub: CryptoActorStub,
) {
	// region CryptoActorStubWithType-CryptoActorStubWithType

	// endregion
}
