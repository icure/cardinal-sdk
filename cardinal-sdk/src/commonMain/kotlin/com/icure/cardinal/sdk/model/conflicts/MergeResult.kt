// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.conflicts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
sealed interface MergeResult {
	@Serializable
	@SerialName("Success")
	public data class Success(
		public val id: String,
		public val rev: String,
	) : MergeResult

	@Serializable
	@SerialName("PartialSuccess")
	public data class PartialSuccess(
		public val id: String,
		public val rev: String,
	) : MergeResult

	@Serializable
	@SerialName("Failure")
	public data class Failure(
		public val id: String,
	) : MergeResult

	// region MergeResult-MergeResult


	// endregion
}
