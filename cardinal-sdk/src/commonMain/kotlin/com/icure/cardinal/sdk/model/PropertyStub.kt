package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.model.embed.TypedValue
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Deprecated
import kotlin.Long
import kotlin.String

public sealed interface PropertyStub : Encryptable {
	public val id: String?

	public val type: PropertyTypeStub?

	public val typedValue: TypedValue?

	@Deprecated("Remove from list instead")
	public val deletionDate: Long?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedPropertyStub(
	override val id: String? = null,
	override val type: PropertyTypeStub? = null,
	override val typedValue: DecryptedTypedValue? = null,
	@Deprecated("Remove from list instead")
	override val deletionDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
) : PropertyStub

@Serializable
public data class EncryptedPropertyStub(
	override val id: String? = null,
	override val type: PropertyTypeStub? = null,
	override val typedValue: EncryptedTypedValue? = null,
	@Deprecated("Remove from list instead")
	override val deletionDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
) : PropertyStub
