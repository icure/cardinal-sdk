// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.generation.RequireHashable
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.Deprecated
import kotlin.collections.Map

/**
 * A lightweight reference to a code from a codification system, used as a stub in entities that
 * reference codes
 * without embedding the full code definition. The id is typically formatted as type|code|version.
 * /
 */
@RequireHashable
@Serializable
data class CodeStub(
	/**
	 * The unique identifier, formatted as type|code|version.
	 */
	override val id: String? = null,
	/**
	 * The context where this code is used when embedded in another entity.
	 */
	override val context: String? = null,
	/**
	 * The codification system type (e.g. ICD, ICPC-2).
	 */
	override val type: String? = null,
	/**
	 * The code value within the codification system.
	 */
	override val code: String? = null,
	/**
	 * The version of the codification system.
	 */
	override val version: String? = null,
	/**
	 * A human-readable label for the context.
	 */
	public val contextLabel: String? = null,
) : CodeIdentification<String?> {
	// region CodeStub-CodeStub

	// endregion
}
