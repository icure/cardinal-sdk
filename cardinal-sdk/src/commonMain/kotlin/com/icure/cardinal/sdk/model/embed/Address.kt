package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasCodes
import com.icure.cardinal.sdk.model.base.HasTags
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

public sealed interface Address : Encryptable, HasTags, HasCodes {
	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	public val identifier: List<Identifier>

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
}

@Serializable
public data class DecryptedAddress(
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
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
) : Address

@Serializable
public data class EncryptedAddress(
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
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
) : Address
