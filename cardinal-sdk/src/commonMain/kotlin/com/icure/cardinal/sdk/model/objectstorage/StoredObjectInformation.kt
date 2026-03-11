package com.icure.cardinal.sdk.model.objectstorage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public sealed interface StoredObjectInformation {
	/**
	 *
	 *  The object is fully stored and available.
	 *  @param md5HashHexString hex string representation of the md5 hash of the content.
	 */
	@Serializable
	@SerialName("Available")
	public data class Available(
		public val md5HashHexString: String,
	) : StoredObjectInformation

	/**
	 *
	 *  The object is currently getting stored.
	 *  @param nextByte the next expected byte of the object content (all bytes up until the previous
	 * have already been stored).
	 *  @param md5HashHexString md5 hash of the expected hash of the full content as an hex string.
	 */
	@Serializable
	@SerialName("Storing")
	public data class Storing(
		public val nextByte: Long,
		public val md5HashHexString: String?,
	) : StoredObjectInformation

	@Serializable
	@SerialName("NotStored")
	public data object NotStored : StoredObjectInformation
}
