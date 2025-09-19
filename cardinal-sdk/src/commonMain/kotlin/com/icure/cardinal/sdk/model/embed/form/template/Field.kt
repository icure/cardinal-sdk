package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

@Serializable
public sealed interface Field : StructureElement {
	public val `field`: String

	public val shortLabel: String?

	public val rows: Int?

	public val columns: Int?

	public val grows: Boolean?

	public val schema: String?

	public val tags: List<String>?

	public val codifications: List<String>?

	public val options: Map<String, String>?

	public val hideCondition: String?

	public val required: Boolean?

	public val multiline: Boolean?

	public val `value`: String?

	public val labels: Map<String, String>?

	public val unit: String?

	public val now: Boolean?

	public val translate: Boolean?
}
