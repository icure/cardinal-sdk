// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.conflicts

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
data class ConflictResolutionResult<E : StoredDocument>(
	public val document: E,
	@param:DefaultValue("emptyList()")
	public val remainingConflicts: List<String> = emptyList(),
) {
	// region ConflictResolutionResult-ConflictResolutionResult

	// endregion
}
