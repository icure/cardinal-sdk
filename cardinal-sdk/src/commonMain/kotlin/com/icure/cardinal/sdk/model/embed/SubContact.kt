// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Extendable
import com.icure.cardinal.sdk.model.base.HasMedicalLocation
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

sealed interface SubContact :
	Encryptable,
	ICureDocument<String?>,
	Extendable,
	HasMedicalLocation {
	override val id: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val endOfLife: Long?

	public val descr: String?

	public val protocol: String?

	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val status: Int?

	public val formId: String?

	public val planOfActionId: String?

	public val healthElementId: String?

	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val classificationId: String?

	public val services: List<ServiceLink>

	override val encryptedSelf: Base64String?

	override val extensions: JsonObject?
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
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val endOfLife: Long? = null,
	override val descr: String? = null,
	override val protocol: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val status: Int? = null,
	override val formId: String? = null,
	override val planOfActionId: String? = null,
	override val healthElementId: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val classificationId: String? = null,
	@param:DefaultValue("emptyList()")
	override val services: List<ServiceLink> = emptyList(),
	override val encryptedSelf: Base64String? = null,
	override val extensions: JsonObject? = null,
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
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val endOfLife: Long? = null,
	override val descr: String? = null,
	override val protocol: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val status: Int? = null,
	override val formId: String? = null,
	override val planOfActionId: String? = null,
	override val healthElementId: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val classificationId: String? = null,
	@param:DefaultValue("emptyList()")
	override val services: List<ServiceLink> = emptyList(),
	override val encryptedSelf: Base64String? = null,
	override val extensions: JsonObject? = null,
) : SubContact {
	// region SubContact-EncryptedSubContact

	// endregion
}
