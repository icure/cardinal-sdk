// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.dao

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String

@Serializable
sealed interface KeyComponent {
	public val `value`: Any?

	@Serializable
	@SerialName("int")
	public data class IntKeyComponent(
		override val `value`: Int?,
	) : KeyComponent

	@Serializable
	@SerialName("long")
	public data class LongKeyComponent(
		override val `value`: Long?,
	) : KeyComponent

	@Serializable
	@SerialName("double")
	public data class DoubleKeyComponent(
		override val `value`: Double?,
	) : KeyComponent

	@Serializable
	@SerialName("boolean")
	public data class BooleanKeyComponent(
		override val `value`: Boolean?,
	) : KeyComponent

	@Serializable
	@SerialName("string")
	public data class StringKeyComponent(
		override val `value`: String?,
	) : KeyComponent

	// region KeyComponent-KeyComponent


	// endregion
}
