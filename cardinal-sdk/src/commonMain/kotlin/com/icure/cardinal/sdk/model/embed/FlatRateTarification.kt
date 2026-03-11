// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Represents a flat rate tarification used in medical house contracts, linking a code to its
 * valorisations.
 * /
 */

sealed interface FlatRateTarification : Encryptable {
	/**
	 * The tarification code.
	 */
	public val code: String?

	/**
	 * The type of flat rate (physician, physiotherapist, nurse, or ptd).
	 */
	public val flatRateType: FlatRateType?

	/**
	 * Localized labels for this tarification, keyed by language code.
	 */
	public val label: Map<String, String>?

	/**
	 * The list of valorisations associated with this tarification.
	 */
	public val valorisations: List<Valorisation>

	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String?
	// region FlatRateTarification-FlatRateTarification

	// endregion
}

/**
 * Represents a flat rate tarification used in medical house contracts, linking a code to its
 * valorisations.
 * /
 */
@Serializable
data class DecryptedFlatRateTarification(
	/**
	 * The tarification code.
	 */
	override val code: String? = null,
	/**
	 * The type of flat rate (physician, physiotherapist, nurse, or ptd).
	 */
	override val flatRateType: FlatRateType? = null,
	/**
	 * Localized labels for this tarification, keyed by language code.
	 */
	override val label: Map<String, String>? = null,
	/**
	 * The list of valorisations associated with this tarification.
	 */
	@param:DefaultValue("emptyList()")
	override val valorisations: List<DecryptedValorisation> = emptyList(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : FlatRateTarification {
	// region FlatRateTarification-DecryptedFlatRateTarification

	// endregion
}

/**
 * Represents a flat rate tarification used in medical house contracts, linking a code to its
 * valorisations.
 * /
 */
@Serializable
data class EncryptedFlatRateTarification(
	/**
	 * The tarification code.
	 */
	override val code: String? = null,
	/**
	 * The type of flat rate (physician, physiotherapist, nurse, or ptd).
	 */
	override val flatRateType: FlatRateType? = null,
	/**
	 * Localized labels for this tarification, keyed by language code.
	 */
	override val label: Map<String, String>? = null,
	/**
	 * The list of valorisations associated with this tarification.
	 */
	@param:DefaultValue("emptyList()")
	override val valorisations: List<EncryptedValorisation> = emptyList(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : FlatRateTarification {
	// region FlatRateTarification-EncryptedFlatRateTarification

	// endregion
}
