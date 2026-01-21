package com.icure.cardinal.sdk.model.filter.classification

import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ClassificationByDataOwnerPatientCreatedDateFilter")
@Serializable
data class ClassificationByDataOwnerPatientCreatedDateFilter(
	dataOwnerId: String,
	startDate: Long?,
	endDate: Long?,
	secretForeignKeys: Set<String>,
	descending: Boolean?,
	desc: String? = null,
) : AbstractFilter<Classification> {
	// region ClassificationByDataOwnerPatientCreatedDateFilter-ClassificationByDataOwnerPatientCreatedDateFilter

	// endregion
}
