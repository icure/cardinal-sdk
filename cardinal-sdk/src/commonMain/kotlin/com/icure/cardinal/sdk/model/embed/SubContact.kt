package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

public sealed interface SubContact : Encryptable, ICureDocument<String?> {
	override val id: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	public val descr: String?

	public val protocol: String?

	public val status: Int?

	public val formId: String?

	public val planOfActionId: String?

	public val healthElementId: String?

	public val classificationId: String?

	public val services: List<ServiceLink>

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedSubContact(
	override val id: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val descr: String? = null,
	override val protocol: String? = null,
	override val status: Int? = null,
	override val formId: String? = null,
	override val planOfActionId: String? = null,
	override val healthElementId: String? = null,
	override val classificationId: String? = null,
	@DefaultValue("emptyList()")
	override val services: List<ServiceLink> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : SubContact

@Serializable
public data class EncryptedSubContact(
	override val id: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val descr: String? = null,
	override val protocol: String? = null,
	override val status: Int? = null,
	override val formId: String? = null,
	override val planOfActionId: String? = null,
	override val healthElementId: String? = null,
	override val classificationId: String? = null,
	@DefaultValue("emptyList()")
	override val services: List<ServiceLink> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : SubContact
