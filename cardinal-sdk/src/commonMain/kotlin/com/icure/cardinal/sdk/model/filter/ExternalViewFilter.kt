package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.utils.ExternalFilterKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ExternalViewFilter")
@Serializable
data class ExternalViewFilter(
	desc: String? = null,
	view: String,
	partition: String,
	entityQualifiedName: String,
	startKey: ExternalFilterKey?,
	endKey: ExternalFilterKey?,
) : AbstractFilter<Identifiable<String>> {
	// region ExternalViewFilter-ExternalViewFilter

	// endregion
}
