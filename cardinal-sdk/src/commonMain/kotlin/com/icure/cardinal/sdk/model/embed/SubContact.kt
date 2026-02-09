package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.Int

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface SubContact : Encryptable, ICureDocument<String?> {
	override val id: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	public val descr: String?

	public val protocol: String?

	public val formId: String?

	public val planOfActionId: String?

	public val healthElementId: String?

	public val services: List<ServiceLink>

	override val encryptedSelf: Base64String?
	// region SubContact-SubContact

	// endregion
}

@Serializable
data class DecryptedSubContact(
	override val id: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val descr: String? = null,
	override val protocol: String? = null,
	override val formId: String? = null,
	override val planOfActionId: String? = null,
	override val healthElementId: String? = null,
	@param:DefaultValue("emptyList()")
	override val services: List<ServiceLink> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : SubContact {
	// region SubContact-DecryptedSubContact

	// endregion
}

@Serializable
data class EncryptedSubContact(
	override val id: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val descr: String? = null,
	override val protocol: String? = null,
	override val formId: String? = null,
	override val planOfActionId: String? = null,
	override val healthElementId: String? = null,
	@param:DefaultValue("emptyList()")
	override val services: List<ServiceLink> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : SubContact {
	// region SubContact-EncryptedSubContact

	// endregion
}
