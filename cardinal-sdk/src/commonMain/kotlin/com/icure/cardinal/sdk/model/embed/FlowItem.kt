// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

/**
 * Represents a flow item in a waiting room or patient flow management system, tracking reception,
 * processing, and cancellation of patient visits including location and contact details.
 * /
 */
@Serializable
data class FlowItem(
	/**
	 * The unique identifier of this flow item.
	 */
	public val id: String? = null,
	/**
	 * The title or summary of the flow item.
	 */
	public val title: String? = null,
	/**
	 * A comment associated with the flow item.
	 */
	public val comment: String? = null,
	/**
	 * The timestamp (unix epoch in ms) when the patient was received.
	 */
	public val receptionDate: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when processing started.
	 */
	public val processingDate: Long? = null,
	/**
	 * The identifier of the person processing this flow item.
	 */
	public val processer: String? = null,
	/**
	 * The timestamp (unix epoch in ms) when this flow item was cancelled.
	 */
	public val cancellationDate: Long? = null,
	/**
	 * The identifier of the person who cancelled this flow item.
	 */
	public val canceller: String? = null,
	/**
	 * The reason for cancellation.
	 */
	public val cancellationReason: String? = null,
	/**
	 * Additional notes about the cancellation.
	 */
	public val cancellationNote: String? = null,
	/**
	 * The current status of the flow item.
	 */
	public val status: String? = null,
	/**
	 * Whether this flow item represents a home visit.
	 */
	public val homeVisit: Boolean? = null,
	/**
	 * The municipality for the visit location.
	 */
	public val municipality: String? = null,
	/**
	 * The town for the visit location.
	 */
	public val town: String? = null,
	/**
	 * The postal code for the visit location.
	 */
	public val zipCode: String? = null,
	/**
	 * The street name for the visit location.
	 */
	public val street: String? = null,
	/**
	 * The building name for the visit location.
	 */
	public val building: String? = null,
	/**
	 * The building number for the visit location.
	 */
	public val buildingNumber: String? = null,
	/**
	 * The doorbell name at the visit location.
	 */
	public val doorbellName: String? = null,
	/**
	 * The floor at the visit location.
	 */
	public val floor: String? = null,
	/**
	 * The letter box identifier at the visit location.
	 */
	public val letterBox: String? = null,
	/**
	 * Operational notes.
	 */
	public val notesOps: String? = null,
	/**
	 * Contact notes.
	 */
	public val notesContact: String? = null,
	/**
	 * The latitude coordinate of the visit location.
	 */
	public val latitude: String? = null,
	/**
	 * The longitude coordinate of the visit location.
	 */
	public val longitude: String? = null,
	/**
	 * The type of flow item.
	 */
	public val type: String? = null,
	/**
	 * Whether this is an emergency visit.
	 */
	public val emergency: Boolean? = null,
	/**
	 * The phone number of the patient.
	 */
	public val phoneNumber: String? = null,
	/**
	 * The identifier of the patient.
	 */
	public val patientId: String? = null,
	/**
	 * The last name of the patient.
	 */
	public val patientLastName: String? = null,
	/**
	 * The first name of the patient.
	 */
	public val patientFirstName: String? = null,
	/**
	 * A description of the flow item.
	 */
	public val description: String? = null,
	/**
	 * The intervention code associated with the flow item.
	 */
	public val interventionCode: String? = null,
) {
	// region FlowItem-FlowItem

	// endregion
}
