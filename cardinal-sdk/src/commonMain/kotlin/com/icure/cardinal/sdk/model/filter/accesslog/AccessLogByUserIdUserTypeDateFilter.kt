package com.icure.cardinal.sdk.model.filter.accesslog

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.time.Instant
import com.icure.cardinal.sdk.serialization.InstantSerializer

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AccessLogByUserIdUserTypeDateFilter")
@Serializable
data class AccessLogByUserIdUserTypeDateFilter(
	userId: String,
	accessType: String?,
	startDate: Instant?,
	descending: Boolean?,
	desc: String? = null,
) : AbstractFilter<AccessLog> {
	// region AccessLogByUserIdUserTypeDateFilter-AccessLogByUserIdUserTypeDateFilter

	// endregion
}
