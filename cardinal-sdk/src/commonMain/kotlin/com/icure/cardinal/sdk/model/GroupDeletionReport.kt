// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  DTO representing one item handled by a group hard deletion.
 */
@Serializable
data class GroupDeletionReport(
	/**
	 * The type of the deleted resource.
	 */
	public val type: String,
	/**
	 * The unique identifier of the deleted resource.
	 */
	public val id: String,
	/**
	 * The server on which the resource was deleted.
	 */
	public val server: String,
	/**
	 * What happened to the resource.
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.GroupDeletionReport.Status.Deleted")
	public val status: Status = Status.Deleted,
	/**
	 * Details on a [Status.FAILED] resource.
	 */
	public val message: String? = null,
) {
	@Serializable
	public enum class Status(
		internal val dtoSerialName: String,
	) {
		@SerialName("DELETED")
		Deleted("DELETED"),

		@SerialName("ABSENT")
		Absent("ABSENT"),

		@SerialName("FAILED")
		Failed("FAILED"),
	}
	// region GroupDeletionReport-GroupDeletionReport

	// endregion
}
