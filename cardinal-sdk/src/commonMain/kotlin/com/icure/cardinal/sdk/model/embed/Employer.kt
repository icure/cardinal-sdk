package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.Named
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class Employer(
	override val name: String? = null,
	public val addresse: DecryptedAddress? = null,
) : Named
