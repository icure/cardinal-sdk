package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Represents the financial valorisation of a flat rate tarification, including validity period and
 * amount breakdown.
 * /
 */
public sealed interface Valorisation : Encryptable {
	/**
	 * The start of the validity period (yyyyMMdd).
	 */
	public val startOfValidity: Long?

	/**
	 * The end of the validity period (yyyyMMdd).
	 */
	public val endOfValidity: Long?

	/**
	 * A predicate expression for conditional valorisation.
	 */
	public val predicate: String?

	/**
	 * A list of reference integers.
	 */
	public val reference: List<Int>?

	/**
	 * The total amount (reimbursement + doctor supplement + intervention).
	 */
	public val totalAmount: Double?

	/**
	 * The reimbursement amount.
	 */
	public val reimbursement: Double?

	/**
	 * The patient intervention amount.
	 */
	public val patientIntervention: Double?

	/**
	 * The doctor supplement amount.
	 */
	public val doctorSupplement: Double?

	/**
	 * The VAT amount.
	 */
	public val vat: Double?

	/**
	 * Localized labels for this valorisation, keyed by language code.
	 */
	public val label: Map<String, String>?

	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * Represents the financial valorisation of a flat rate tarification, including validity period and
 * amount breakdown.
 * /
 */
@Serializable
public data class DecryptedValorisation(
	/**
	 * The start of the validity period (yyyyMMdd).
	 */
	override val startOfValidity: Long? = null,
	/**
	 * The end of the validity period (yyyyMMdd).
	 */
	override val endOfValidity: Long? = null,
	/**
	 * A predicate expression for conditional valorisation.
	 */
	override val predicate: String? = null,
	/**
	 * A list of reference integers.
	 */
	override val reference: List<Int>? = null,
	/**
	 * The total amount (reimbursement + doctor supplement + intervention).
	 */
	override val totalAmount: Double? = null,
	/**
	 * The reimbursement amount.
	 */
	override val reimbursement: Double? = null,
	/**
	 * The patient intervention amount.
	 */
	override val patientIntervention: Double? = null,
	/**
	 * The doctor supplement amount.
	 */
	override val doctorSupplement: Double? = null,
	/**
	 * The VAT amount.
	 */
	override val vat: Double? = null,
	/**
	 * Localized labels for this valorisation, keyed by language code.
	 */
	@param:DefaultValue("emptyMap()")
	override val label: Map<String, String>? = emptyMap(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : Valorisation

/**
 * Represents the financial valorisation of a flat rate tarification, including validity period and
 * amount breakdown.
 * /
 */
@Serializable
public data class EncryptedValorisation(
	/**
	 * The start of the validity period (yyyyMMdd).
	 */
	override val startOfValidity: Long? = null,
	/**
	 * The end of the validity period (yyyyMMdd).
	 */
	override val endOfValidity: Long? = null,
	/**
	 * A predicate expression for conditional valorisation.
	 */
	override val predicate: String? = null,
	/**
	 * A list of reference integers.
	 */
	override val reference: List<Int>? = null,
	/**
	 * The total amount (reimbursement + doctor supplement + intervention).
	 */
	override val totalAmount: Double? = null,
	/**
	 * The reimbursement amount.
	 */
	override val reimbursement: Double? = null,
	/**
	 * The patient intervention amount.
	 */
	override val patientIntervention: Double? = null,
	/**
	 * The doctor supplement amount.
	 */
	override val doctorSupplement: Double? = null,
	/**
	 * The VAT amount.
	 */
	override val vat: Double? = null,
	/**
	 * Localized labels for this valorisation, keyed by language code.
	 */
	@param:DefaultValue("emptyMap()")
	override val label: Map<String, String>? = emptyMap(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : Valorisation
