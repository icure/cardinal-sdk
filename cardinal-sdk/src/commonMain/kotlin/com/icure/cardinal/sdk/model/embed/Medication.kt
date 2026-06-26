// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Boolean
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
	public val stockLocation: DecryptedAddress? = null,
) {
	// region Medication-Medication

	// endregion
}
