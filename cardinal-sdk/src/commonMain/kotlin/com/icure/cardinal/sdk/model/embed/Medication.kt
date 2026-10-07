// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

@Serializable
data class Medication(
	public val compoundPrescription: String? = null,
	public val substanceProduct: Substanceproduct? = null,
	public val medicinalProduct: Medicinalproduct? = null,
	public val numberOfPackages: Int? = null,
	public val batch: String? = null,
	/**
	 *
	 *  The expiration date of the medication. Format: yyyyMMdd
	 */
	public val expirationDate: Long? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val instructionForPatient: String? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val instructionForReimbursement: String? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val commentForDelivery: String? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val drugRoute: String? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val temporality: String? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val frequency: CodeStub? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val reimbursementReason: CodeStub? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val substitutionAllowed: Boolean? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val beginMoment: Long? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val endMoment: Long? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val deliveryMoment: Long? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val endExecutionMoment: Long? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val duration: Duration? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val renewal: Renewal? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val knownUsage: Boolean? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val regimen: List<RegimenItem>? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	public val posology: String? = null,
	/**
	 * The expiration date of the medication. Format: yyyyMMdd
	 * /
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val options: Map<String, DecryptedContent>? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val agreements: Map<String, ParagraphAgreement>? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val medicationSchemeIdOnSafe: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val medicationSchemeSafeVersion: Int? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val medicationSchemeTimeStampOnSafe: Long? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val medicationSchemeDocumentId: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val safeIdName: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val idOnSafes: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val timestampOnSafe: Long? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val changeValidated: Boolean? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val newSafeMedication: Boolean? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val medicationUse: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val beginCondition: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val endCondition: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val origin: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val medicationChanged: Boolean? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val posologyChanged: Boolean? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val suspension: List<Suspension>? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val prescriptionRID: String? = null,
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val status: Int? = null,
	public val stockLocation: DecryptedAddress? = null,
) {
	// region Medication-Medication

	// endregion
}
