package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Measure(
	public val `value`: Double? = null,
	public val ref: Double? = null,
	public val severity: Int? = null,
	public val severityCode: String? = null,
	public val evolution: Int? = null,
	public val unit: String? = null,
	public val unitCodes: Set<CodeStub>? = null,
	public val comment: String? = null,
	public val comparator: String? = null,
	public val sign: String? = null,
	@param:DefaultValue("emptyList()")
	public val referenceRanges: List<ReferenceRange> = emptyList(),
	public val valueWithPrecision: ValueWithPrecision? = null,
) {
	// region Measure-Measure

	// endregion
}
