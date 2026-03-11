// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Text node with attribution that can be attached to a medical record. Used by healthcare parties
 * to add side notes,
 * for example to flag a faulty thermometer after taking a temperature.
 * /
 */
@Serializable
data class Annotation(
	/**
	 * The Id of the Annotation. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The identifier of the author of this annotation.
	 */
	public val author: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of this note, filled automatically if missing.
	 */
	public val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this note, filled automatically
	 * if missing.
	 */
	public val modified: Long? = null,
	/**
	 * Text contained in the note, written as markdown. Deprecated in favor of [markdown].
	 */
	public val text: String? = null,
	/**
	 * Localized text contained in the note, written as markdown. Keys should respect ISO 639-1.
	 */
	@param:DefaultValue("emptyMap()")
	public val markdown: Map<String, String> = emptyMap(),
	/**
	 * Defines to which part of the corresponding information the note is related to.
	 */
	public val location: String? = null,
	/**
	 * Whether this annotation is confidential.
	 */
	public val confidential: Boolean? = null,
	/**
	 * Tags associated with this annotation.
	 */
	@param:DefaultValue("emptySet()")
	public val tags: Set<CodeStub> = emptySet(),
	/**
	 * The encrypted content of this annotation.
	 */
	public val encryptedSelf: String? = null,
) : Identifiable<String> {
	// region Annotation-Annotation

	// endregion
}
