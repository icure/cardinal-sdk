package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Address : Encryptable {
	public val addressType: AddressType?

	public val descr: String?

	public val street: String?

	public val houseNumber: String?

	public val postboxNumber: String?

	public val postalCode: String?

	public val city: String?

	public val state: String?

	public val country: String?

	public val note: String?

	public val notes: List<Annotation>

	public val telecoms: List<Telecom>

	override val encryptedSelf: Base64String?
  // region Address-Address

  // endregion
}

@Serializable
data class DecryptedAddress(
	override val addressType: AddressType? = null,
	override val descr: String? = null,
	override val street: String? = null,
	override val houseNumber: String? = null,
	override val postboxNumber: String? = null,
	override val postalCode: String? = null,
	override val city: String? = null,
	override val state: String? = null,
	override val country: String? = null,
	override val note: String? = null,
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("emptyList()")
	override val telecoms: List<DecryptedTelecom> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : Address {
	// region Address-DecryptedAddress

	// endregion
}

@Serializable
data class EncryptedAddress(
	override val addressType: AddressType? = null,
	override val descr: String? = null,
	override val street: String? = null,
	override val houseNumber: String? = null,
	override val postboxNumber: String? = null,
	override val postalCode: String? = null,
	override val city: String? = null,
	override val state: String? = null,
	override val country: String? = null,
	override val note: String? = null,
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("emptyList()")
	override val telecoms: List<EncryptedTelecom> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : Address {
	// region Address-EncryptedAddress

	// endregion
}
