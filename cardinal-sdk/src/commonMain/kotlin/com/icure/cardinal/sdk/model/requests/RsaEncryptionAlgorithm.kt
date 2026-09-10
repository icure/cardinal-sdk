// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  An algorithm a public key of a data owner may be used with.
 *
 *  This is an enum rather than a "uses sha256" boolean so that a third scheme can be introduced
 * without a
 *  breaking change to the wire format.
 */
@Serializable
enum class RsaEncryptionAlgorithm(
	internal val dtoSerialName: String,
) {
	@SerialName("OaepWithSha1")
	OaepWithSha1("OaepWithSha1"),

	@SerialName("OaepWithSha256")
	OaepWithSha256("OaepWithSha256"),
}
