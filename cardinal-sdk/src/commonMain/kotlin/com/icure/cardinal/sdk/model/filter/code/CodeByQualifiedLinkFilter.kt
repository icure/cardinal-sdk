package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CodeByQualifiedLinkFilter")
@Serializable
data class CodeByQualifiedLinkFilter(
	linkType: String,
	linkedId: String? = null,
	desc: String? = null,
) : AbstractFilter<Code> {
	// region CodeByQualifiedLinkFilter-CodeByQualifiedLinkFilter

	// endregion
}
