package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class Annotation(
	override val id: String,
	public val author: String? = null,
	public val created: Long? = null,
	public val modified: Long? = null,
	public val text: String? = null,
	@DefaultValue("emptyMap()")
	public val markdown: Map<String, String> = emptyMap(),
	public val location: String? = null,
	public val confidential: Boolean? = null,
	@DefaultValue("emptySet()")
	public val tags: Set<CodeStub> = emptySet(),
	public val encryptedSelf: String? = null,
) : Identifiable<String>
