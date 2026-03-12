package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.model.embed.TypedValue
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * DTO representing a stored property with a type and typed value. Properties are used to
 * attach configurable key-value data to entities.
 * /
 */
public sealed interface Property : StoredDocument, Encryptable {
	/**
	 * The unique identifier of the property.
	 */
	override val id: String

	/**
	 * The revision identifier for optimistic locking.
	 */
	override val rev: String?

	/**
	 * The soft-delete timestamp in epoch milliseconds.
	 */
	override val deletionDate: Long?

	/**
	 * The type definition of this property.
	 */
	public val type: PropertyType?

	/**
	 * The typed value held by this property.
	 */
	public val typedValue: TypedValue?

	/**
	 * The encrypted content of this property, encoded as a Base64 string.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * DTO representing a stored property with a type and typed value. Properties are used to
 * attach configurable key-value data to entities.
 * /
 */
@Serializable
public data class DecryptedProperty(
	/**
	 * The unique identifier of the property.
	 */
	override val id: String,
	/**
	 * The revision identifier for optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The soft-delete timestamp in epoch milliseconds.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The type definition of this property.
	 */
	override val type: PropertyType? = null,
	/**
	 * The typed value held by this property.
	 */
	override val typedValue: DecryptedTypedValue? = null,
	/**
	 * The encrypted content of this property, encoded as a Base64 string.
	 */
	override val encryptedSelf: Base64String? = null,
) : Property

/**
 * DTO representing a stored property with a type and typed value. Properties are used to
 * attach configurable key-value data to entities.
 * /
 */
@Serializable
public data class EncryptedProperty(
	/**
	 * The unique identifier of the property.
	 */
	override val id: String,
	/**
	 * The revision identifier for optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The soft-delete timestamp in epoch milliseconds.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The type definition of this property.
	 */
	override val type: PropertyType? = null,
	/**
	 * The typed value held by this property.
	 */
	override val typedValue: EncryptedTypedValue? = null,
	/**
	 * The encrypted content of this property, encoded as a Base64 string.
	 */
	override val encryptedSelf: Base64String? = null,
) : Property
