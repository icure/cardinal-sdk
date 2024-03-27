package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifiable
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Annotation(
	override val id: String,
	public val author: String? = null,
	public val created: Long? = null,
	public val modified: Long? = null,
	public val text: String? = null,
	public val markdown: Map<String, String> = emptyMap(),
	public val location: String? = null,
	public val confidential: Boolean? = null,
	public val tags: Set<CodeStub> = emptySet(),
	public val encryptedSelf: String? = null,
) : Identifiable<String> {
	// region Annotation-Annotation

	// endregion
}
