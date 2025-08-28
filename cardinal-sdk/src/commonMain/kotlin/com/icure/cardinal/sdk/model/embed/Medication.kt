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
public data class Medication(
	public val compoundPrescription: String? = null,
	public val substanceProduct: Substanceproduct? = null,
	public val medicinalProduct: Medicinalproduct? = null,
	public val numberOfPackages: Int? = null,
	public val batch: String? = null,
	public val expirationDate: Long? = null,
	public val instructionForPatient: String? = null,
	public val instructionForReimbursement: String? = null,
	public val commentForDelivery: String? = null,
	public val drugRoute: String? = null,
	public val temporality: String? = null,
	public val frequency: CodeStub? = null,
	public val reimbursementReason: CodeStub? = null,
	public val substitutionAllowed: Boolean? = null,
	public val beginMoment: Long? = null,
	public val endMoment: Long? = null,
	public val deliveryMoment: Long? = null,
	public val endExecutionMoment: Long? = null,
	public val duration: Duration? = null,
	public val renewal: Renewal? = null,
	public val knownUsage: Boolean? = null,
	public val regimen: List<RegimenItem>? = null,
	public val posology: String? = null,
	public val agreements: Map<String, ParagraphAgreement>? = null,
	public val medicationSchemeIdOnSafe: String? = null,
	public val medicationSchemeSafeVersion: Int? = null,
	public val medicationSchemeTimeStampOnSafe: Long? = null,
	public val medicationSchemeDocumentId: String? = null,
	public val safeIdName: String? = null,
	public val idOnSafes: String? = null,
	public val timestampOnSafe: Long? = null,
	public val changeValidated: Boolean? = null,
	public val newSafeMedication: Boolean? = null,
	public val medicationUse: String? = null,
	public val beginCondition: String? = null,
	public val endCondition: String? = null,
	public val origin: String? = null,
	public val medicationChanged: Boolean? = null,
	public val posologyChanged: Boolean? = null,
	public val suspension: List<Suspension>? = null,
	public val prescriptionRID: String? = null,
	public val status: Int? = null,
)
