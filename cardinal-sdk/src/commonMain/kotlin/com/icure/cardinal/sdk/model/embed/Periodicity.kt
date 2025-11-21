package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.generation.RequireHashable
import kotlinx.serialization.Serializable

@RequireHashable
@Serializable
public data class Periodicity(
	public val relatedCode: CodeStub? = null,
	public val relatedPeriodicity: CodeStub? = null,
)
