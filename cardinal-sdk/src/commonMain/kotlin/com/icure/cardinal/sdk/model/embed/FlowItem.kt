package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

@Serializable
public data class FlowItem(
	public val id: String? = null,
	public val title: String? = null,
	public val comment: String? = null,
	public val receptionDate: Long? = null,
	public val processingDate: Long? = null,
	public val processer: String? = null,
	public val cancellationDate: Long? = null,
	public val canceller: String? = null,
	public val cancellationReason: String? = null,
	public val cancellationNote: String? = null,
	public val status: String? = null,
	public val homeVisit: Boolean? = null,
	public val municipality: String? = null,
	public val town: String? = null,
	public val zipCode: String? = null,
	public val street: String? = null,
	public val building: String? = null,
	public val buildingNumber: String? = null,
	public val doorbellName: String? = null,
	public val floor: String? = null,
	public val letterBox: String? = null,
	public val notesOps: String? = null,
	public val notesContact: String? = null,
	public val latitude: String? = null,
	public val longitude: String? = null,
	public val type: String? = null,
	public val emergency: Boolean? = null,
	public val phoneNumber: String? = null,
	public val patientId: String? = null,
	public val patientLastName: String? = null,
	public val patientFirstName: String? = null,
	public val description: String? = null,
	public val interventionCode: String? = null,
)
