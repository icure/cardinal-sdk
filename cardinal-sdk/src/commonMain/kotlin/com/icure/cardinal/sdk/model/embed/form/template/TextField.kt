package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * A text input field in a form template.
 * /
 */
@SerialName("textfield")
@Serializable
public data class TextField(
	/**
	 * The field identifier.
	 */
	override val `field`: String,
	/**
	 * A short label for the field.
	 */
	override val shortLabel: String? = null,
	/**
	 * The number of rows for display.
	 */
	override val rows: Int? = null,
	/**
	 * The number of columns for display.
	 */
	override val columns: Int? = null,
	/**
	 * Whether the field grows dynamically.
	 */
	override val grows: Boolean? = null,
	/**
	 * Whether the field supports multiline input.
	 */
	override val multiline: Boolean? = null,
	/**
	 * The schema reference for validation.
	 */
	override val schema: String? = null,
	/**
	 * Tags associated with this field.
	 */
	override val tags: List<String>? = null,
	/**
	 * Codification references for this field.
	 */
	override val codifications: List<String>? = null,
	/**
	 * Additional options as key-value pairs.
	 */
	override val options: Map<String, String>? = null,
	/**
	 * Localized labels keyed by language code.
	 */
	override val labels: Map<String, String>? = null,
	/**
	 * The default value.
	 */
	override val `value`: String? = null,
	/**
	 * The unit of measurement.
	 */
	override val unit: String? = null,
	/**
	 * Whether the field is required.
	 */
	override val required: Boolean? = null,
	/**
	 * A condition expression for hiding the field.
	 */
	override val hideCondition: String? = null,
	/**
	 * Whether to default to the current date/time.
	 */
	override val now: Boolean? = null,
	/**
	 * Whether the field value should be translated.
	 */
	override val translate: Boolean? = null,
) : Field
