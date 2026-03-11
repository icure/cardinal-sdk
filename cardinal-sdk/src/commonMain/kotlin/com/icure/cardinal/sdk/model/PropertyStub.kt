// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.model.embed.TypedValue
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.Deprecated
import kotlin.Long

/**
 * Lightweight stub representation of a property, used when the full stored property is not needed.
 * /
 */

sealed interface PropertyStub : Encryptable {
	/**
	 * The unique identifier of the property stub.
	 */
	public val id: String?

	/**
	 * The type stub definition of this property.
	 */
	public val type: PropertyTypeStub?

	/**
	 * The typed value held by this property.
	 */
	public val typedValue: TypedValue?

	/**
	 * The encrypted content of this property, encoded as a Base64 string.
	 */
	override val encryptedSelf: Base64String?
	// region PropertyStub-PropertyStub

	// endregion
}

/**
 * Lightweight stub representation of a property, used when the full stored property is not needed.
 * /
 */
@Serializable
data class DecryptedPropertyStub(
	/**
	 * The unique identifier of the property stub.
	 */
	override val id: String? = null,
	/**
	 * The type stub definition of this property.
	 */
	override val type: PropertyTypeStub? = null,
	/**
	 * The typed value held by this property.
	 */
	override val typedValue: DecryptedTypedValue? = null,
	/**
	 * The encrypted content of this property, encoded as a Base64 string.
	 */
	override val encryptedSelf: Base64String? = null,
) : PropertyStub {
	// region PropertyStub-DecryptedPropertyStub

	// endregion
}

/**
 * Lightweight stub representation of a property, used when the full stored property is not needed.
 * /
 */
@Serializable
data class EncryptedPropertyStub(
	/**
	 * The unique identifier of the property stub.
	 */
	override val id: String? = null,
	/**
	 * The type stub definition of this property.
	 */
	override val type: PropertyTypeStub? = null,
	/**
	 * The typed value held by this property.
	 */
	override val typedValue: EncryptedTypedValue? = null,
	/**
	 * The encrypted content of this property, encoded as a Base64 string.
	 */
	override val encryptedSelf: Base64String? = null,
) : PropertyStub {
	// region PropertyStub-EncryptedPropertyStub

	// endregion
}
