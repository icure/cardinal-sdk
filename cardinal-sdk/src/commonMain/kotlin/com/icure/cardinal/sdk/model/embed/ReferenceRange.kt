// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 *
 *  Represents a reference range for a measurement, including bounds, applicable age range, tags,
 * codes, and notes.
 */
@Serializable
data class ReferenceRange(
	/**
	 * The lower bound of the reference range.
	 */
	public val low: Double? = null,
	/**
	 * The upper bound of the reference range.
	 */
	public val high: Double? = null,
	/**
	 * A string representation of the reference range.
	 */
	public val stringValue: String? = null,
	/**
	 * Tags associated with this reference range.
	 */
	@param:DefaultValue("emptyList()")
	public val tags: List<CodeStub> = emptyList(),
	/**
	 * Codes associated with this reference range.
	 */
	@param:DefaultValue("emptyList()")
	public val codes: List<CodeStub> = emptyList(),
	/**
	 * Annotations providing additional context.
	 */
	@param:DefaultValue("emptyList()")
	public val notes: List<Annotation> = emptyList(),
	/**
	 * The age range to which this reference range applies.
	 */
	public val age: Range? = null,
) {
	// region ReferenceRange-ReferenceRange

	// endregion
}
