package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents an agreement on a specific paragraph of a regulation, including approval status,
 * validity period, quantities, and any refusal justification.
 * /
 */
@Serializable
public data class ParagraphAgreement(
	/**
	 * The timestamp (unix epoch in ms) of the agreement.
	 */
	public val timestamp: Long? = null,
	/**
	 * The paragraph reference.
	 */
	public val paragraph: String? = null,
	/**
	 * Whether the agreement was accepted.
	 */
	public val accepted: Boolean? = null,
	/**
	 * Whether the patient is currently in treatment.
	 */
	public val inTreatment: Boolean? = null,
	/**
	 * Whether the agreement was canceled.
	 */
	public val canceled: Boolean? = null,
	/**
	 * The care provider reference for this agreement.
	 */
	public val careProviderReference: String? = null,
	/**
	 * The decision reference.
	 */
	public val decisionReference: String? = null,
	/**
	 * The start date of the agreement period.
	 */
	public val start: Long? = null,
	/**
	 * The end date of the agreement period.
	 */
	public val end: Long? = null,
	/**
	 * The date of cancellation.
	 */
	public val cancelationDate: Long? = null,
	/**
	 * The quantity value of the agreement.
	 */
	public val quantityValue: Double? = null,
	/**
	 * The unit of the quantity.
	 */
	public val quantityUnit: String? = null,
	/**
	 * The IO request reference.
	 */
	public val ioRequestReference: String? = null,
	/**
	 * The type of response received.
	 */
	public val responseType: String? = null,
	/**
	 * Localized justification for refusal, keyed by language code.
	 */
	public val refusalJustification: Map<String, String>? = null,
	/**
	 * The set of verse numbers covered by this agreement.
	 */
	public val verses: Set<Long>? = null,
	/**
	 * The type of coverage.
	 */
	public val coverageType: String? = null,
	/**
	 * The number of units.
	 */
	public val unitNumber: Double? = null,
	/**
	 * The strength value.
	 */
	public val strength: Double? = null,
	/**
	 * The unit of strength.
	 */
	public val strengthUnit: String? = null,
	/**
	 * The list of agreement appendices.
	 */
	public val agreementAppendices: List<AgreementAppendix>? = null,
	/**
	 * The identifier of the associated document.
	 */
	public val documentId: String? = null,
)
