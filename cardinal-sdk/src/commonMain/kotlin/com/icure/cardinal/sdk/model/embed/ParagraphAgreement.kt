package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class ParagraphAgreement(
	public val timestamp: Long? = null,
	public val paragraph: String? = null,
	public val accepted: Boolean? = null,
	public val inTreatment: Boolean? = null,
	public val canceled: Boolean? = null,
	public val careProviderReference: String? = null,
	public val decisionReference: String? = null,
	public val start: Long? = null,
	public val end: Long? = null,
	public val cancelationDate: Long? = null,
	public val quantityValue: Double? = null,
	public val quantityUnit: String? = null,
	public val ioRequestReference: String? = null,
	public val responseType: String? = null,
	public val refusalJustification: Map<String, String>? = null,
	public val verses: Set<Long>? = null,
	public val coverageType: String? = null,
	public val unitNumber: Double? = null,
	public val strength: Double? = null,
	public val strengthUnit: String? = null,
	public val agreementAppendices: List<AgreementAppendix>? = null,
	public val documentId: String? = null,
)
