package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.generation.RequireHashable
import kotlinx.serialization.Serializable
import kotlin.String

@RequireHashable
@Serializable
public data class CodeStub(
	override val id: String? = null,
	override val context: String? = null,
	override val type: String? = null,
	override val code: String? = null,
	override val version: String? = null,
	public val contextLabel: String? = null,
) : CodeIdentification<String?>
