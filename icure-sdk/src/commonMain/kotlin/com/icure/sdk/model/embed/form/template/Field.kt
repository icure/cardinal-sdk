package com.icure.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface Field : StructureElement {
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
    // region Field-Field

    // endregion
}
