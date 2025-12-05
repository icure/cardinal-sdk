package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.generation.RequireHashable
import kotlinx.serialization.Serializable
import kotlin.Deprecated
import kotlin.String
import kotlin.collections.Map

@RequireHashable
@Serializable
public data class CodeStub(
	override val id: String? = null,
	override val context: String? = null,
	override val type: String? = null,
	override val code: String? = null,
	override val version: String? = null,
	public val contextLabel: String? = null,
	@Deprecated("label shouldn't be included in code stub but only in full codes")
	override val label: Map<String, String>? = null,
) : CodeIdentification<String?>
