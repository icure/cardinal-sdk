// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * A date picker field in a form template.
 * /
 */
@SerialName("date-picker")
@Serializable
data class DatePicker(
	override val `field`: String,
	override val shortLabel: String? = null,
	override val rows: Int? = null,
	override val columns: Int? = null,
	override val grows: Boolean? = null,
	override val multiline: Boolean? = null,
	override val schema: String? = null,
	override val tags: List<String>? = null,
	override val codifications: List<String>? = null,
	override val options: Map<String, String>? = null,
	override val labels: Map<String, String>? = null,
	override val `value`: String? = null,
	override val unit: String? = null,
	override val required: Boolean? = null,
	override val hideCondition: String? = null,
	override val now: Boolean? = null,
	override val translate: Boolean? = null,
) : Field {
	// region DatePicker-DatePicker

	// endregion
}
