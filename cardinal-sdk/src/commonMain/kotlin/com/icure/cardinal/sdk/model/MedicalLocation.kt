// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a medical location such as a clinic, office, or hospital ward where healthcare
 * services are provided.
 * /
 */
@Serializable
data class MedicalLocation(
	/**
	 * The unique identifier of the medical location.
	 */
	override val id: String,
	/**
	 * The revision of the medical location in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The name of the medical location.
	 */
	override val name: String? = null,
	/**
	 * A description of the medical location.
	 */
	public val description: String? = null,
	/**
	 * The id of the healthcare party responsible for this medical location.
	 */
	public val responsible: String? = null,
	/**
	 * Whether this medical location is a guard post.
	 */
	public val guardPost: Boolean? = null,
	/**
	 * The CBE (Crossroads Bank for Enterprises) number of the medical location.
	 */
	public val cbe: String? = null,
	/**
	 * The Bank Identifier Code (BIC/SWIFT) of the medical location.
	 */
	public val bic: String? = null,
	/**
	 * The bank account number (IBAN) of the medical location.
	 */
	public val bankAccount: String? = null,
	/**
	 * The NIHII number of the medical location.
	 */
	public val nihii: String? = null,
	/**
	 * The social security inscription number associated with the medical location.
	 */
	public val ssin: String? = null,
	/**
	 * The address of the medical location.
	 */
	public val address: DecryptedAddress? = null,
	/**
	 * The set of agenda ids linked to this medical location.
	 */
	@param:DefaultValue("emptySet()")
	public val agendaIds: Set<String> = emptySet(),
	/**
	 * Additional options for the medical location.
	 */
	@param:DefaultValue("emptyMap()")
	public val options: Map<String, String> = emptyMap(),
	/**
	 * Public information about the medical location, in multiple languages.
	 */
	@param:DefaultValue("emptyMap()")
	public val publicInformations: Map<String, String> = emptyMap(),
) : StoredDocument, Named {
	// region MedicalLocation-MedicalLocation

	// endregion
}
